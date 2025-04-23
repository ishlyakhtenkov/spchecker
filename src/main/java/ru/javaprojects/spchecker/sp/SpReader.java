package ru.javaprojects.spchecker.sp;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.javaprojects.spchecker.AppException;
import ru.javaprojects.spchecker.AppProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SpReader {
    private static final int FORMAT_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("format_column_index"));
    private static final int ZONE_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("zone_column_index"));
    private static final int POSITION_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("position_column_index"));
    private static final int DESIGNATION_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("designation_column_index"));
    private static final int NAME_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("name_column_index"));
    private static final int QUANTITY_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("quantity_column_index"));
    private static final int NOTE_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("note_column_index"));

    private final String spDecimalNumber;
    private final List<SpLine> lines;

    public SpReader(Path spPath) {
        spDecimalNumber = spPath.getFileName().toString().substring(0, spPath.getFileName().toString().lastIndexOf("."));
        try (var fis = Files.newInputStream(spPath); var sp = new XWPFDocument(fis)) {
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

    public String getSpDecimalNumber() {
        return spDecimalNumber;
    }

    public List<SpDocument> getDocuments() {
        return lines.stream()
                .filter(line -> !line.designation().isBlank())
                .map(line -> new SpDocument(line.designation(), line.name()))
                .toList();
    }
}
