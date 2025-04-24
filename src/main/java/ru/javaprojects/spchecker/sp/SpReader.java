package ru.javaprojects.spchecker.sp;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.javaprojects.spchecker.AppException;
import ru.javaprojects.spchecker.AppProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpReader {
    private static final int FORMAT_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("format_column_index"));
    private static final int ZONE_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("zone_column_index"));
    private static final int POSITION_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("position_column_index"));
    private static final int DESIGNATION_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("designation_column_index"));
    private static final int NAME_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("name_column_index"));
    private static final int QUANTITY_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("quantity_column_index"));
    private static final int NOTE_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("note_column_index"));
    private static final boolean ADD_SP_NAME_TO_DOCS = Boolean.parseBoolean(AppProperties.getProperty("add_sp_name_to_docs"));

    private final String spDecimalNumber;
    private final String spName;
    private final List<SpLine> lines;

    public SpReader(Path spPath) {
        spDecimalNumber = spPath.getFileName().toString().substring(0, spPath.getFileName().toString().lastIndexOf("."));
        try (var fis = Files.newInputStream(spPath); var sp = new XWPFDocument(fis)) {
            spName = findSpName(sp);
            lines = sp.getTables().stream()
                    .flatMap(table -> table.getRows().stream())
                    .map(row -> new SpLine.Builder()
                            .format(row.getCell(FORMAT_COLUMN_INDEX).getText())
                            .zone(row.getCell(ZONE_COLUMN_INDEX).getText())
                            .position(row.getCell(POSITION_COLUMN_INDEX).getText())
                            .designation(row.getCell(DESIGNATION_COLUMN_INDEX).getText())
                            .name(row.getCell(NAME_COLUMN_INDEX).getText())
                            .quantity(row.getCell(QUANTITY_COLUMN_INDEX).getText())
                            .note(row.getCell(NOTE_COLUMN_INDEX).getText())
                            .build())
                    .toList();
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    private String findSpName(XWPFDocument sp) {
        int mainInscriptionFooterIndex = -1;
        var footers = sp.getFooterList();
        for (int i = 0; i < footers.size(); i++) {
            if (footers.get(i).getText().contains("Разраб.")) {
                mainInscriptionFooterIndex = i;
                break;
            }
        }
        if (mainInscriptionFooterIndex == -1) {
            throw new AppException("Not found main inscription footer in SP: " + spDecimalNumber);
        }
        var spNameParagraphs = sp.getFooterList().get(mainInscriptionFooterIndex).getTables().getFirst().getRows().get(5)
                .getCell(4).getParagraphs();
        var spName = new StringBuilder();
        for (var paragraph : spNameParagraphs) {
            spName.append(paragraph.getText()).append(" ");
        }
        return spName.toString().trim();
    }

    public String getSpDecimalNumber() {
        return spDecimalNumber;
    }

    public String getSpName() {
        return spName;
    }

    public List<SpDocument> getDocuments() {
        List<SpDocument> documents = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            SpLine line = lines.get(i);
            if (!line.designation().isBlank()) {
                String decimalNumber = line.designation().trim();
                var name = new StringBuilder();
                if (ADD_SP_NAME_TO_DOCS && decimalNumber.startsWith(spDecimalNumber)) {
                    name.append(spName).append(" ");
                }
                name.append(line.name().trim());
                boolean nameCompleted = false;
                int lineIndex = i;
                while (lineIndex < (lines.size() - 1) && !nameCompleted) {
                    SpLine belowLine = lines.get(++lineIndex);
                    if (belowLine.designation().isBlank() && !belowLine.name().isBlank()) {
                        name.append(" ").append(belowLine.name().trim());
                    } else {
                        nameCompleted = true;
                    }
                }
                documents.add(new SpDocument(decimalNumber, name.toString()));
            }
        }
        return documents;
    }
}
