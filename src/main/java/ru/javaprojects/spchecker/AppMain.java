package ru.javaprojects.spchecker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        Path spDir = Paths.get(args.length != 0 ? args[0] : AppProperties.getProperty("sp_dir_default"));
        if (!Files.isDirectory(spDir)) {
            throw new AppException("Specifications directory has not been found");
        }
        var supportedSpFiles = List.of(AppProperties.getProperty("supported_sp_files").split(","));
        List<Path> spPaths;
        try (var spPathsStream = Files.list(spDir)) {
            spPaths = spPathsStream
                    .filter(spPath -> supportedSpFiles.contains(spPath.toString()
                            .substring(spPath.toString().lastIndexOf('.') + 1)))
                    .toList();
        } catch (IOException e) {
            throw new AppException(e);
        }
        var aggregator = new Aggregator();
        aggregator.handleSpecifications(spPaths);
        printDocuments(aggregator.getDocuments(), spDir.resolve("report.txt"));
    }

    private static void printDocuments(List<Document> documents, Path reportPath) {
        List<String> lines = documents.stream()
                .map(document -> document.decimalNumber() + "\t" + document.name() + "\t" + document.applicability())
                .toList();
        try {
            Files.write(reportPath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
