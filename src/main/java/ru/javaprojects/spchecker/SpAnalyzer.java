package ru.javaprojects.spchecker;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SpAnalyzer {
    private static final int DECIMAL_NUMBERS_COLUMN_INDEX = Integer.parseInt(AppProperties.getProperty("decimal_numbers_column_index"));
    private static final List<String> REQUIRED_DEV_CODES = List.of(AppProperties.getProperty("required_dev_codes").split(","));

    private final XWPFDocument sp;

    public SpAnalyzer(Path spPath) {
        try (var fis = Files.newInputStream(spPath)) {
            sp = new XWPFDocument(fis);
            sp.close();
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    public List<String> getDecimalNumbers() {
        return sp.getTables().stream()
                .flatMap(table -> table.getRows().stream())
                .map(row -> row.getCell(DECIMAL_NUMBERS_COLUMN_INDEX))
                .map(cell -> cell.getText().trim())
                .filter(decimalNumber -> {
                    for (String requiredCode : REQUIRED_DEV_CODES) {
                        if (decimalNumber.startsWith(requiredCode)) return true;
                    }
                    return false;
                })
                .toList();
    }
}
