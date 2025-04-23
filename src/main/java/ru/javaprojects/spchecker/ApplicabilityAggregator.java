package ru.javaprojects.spchecker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class ApplicabilityAggregator {
    private final Map<String, Set<String>> applicabilities = new TreeMap<>();

    public void addSpecifications(Path spsPath) {
        try (Stream<Path> spPaths = Files.list(spsPath)) {
            spPaths.filter(spPath -> {
                        var supportedFiles = List.of(AppProperties.getProperty("supported_sp_files").split(","));
                        for (var supportedFile : supportedFiles) {
                            if (spPath.toString().endsWith("." + supportedFile)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(spPath -> {
                        var spAnalyzer = new SpAnalyzer(spPath);
                        List<String> decimalNumbers = spAnalyzer.getDecimalNumbers();
                        decimalNumbers.forEach(decimalNumber ->
                                addApplicability(decimalNumber, spPath.getFileName().toString()
                                        .substring(0, spPath.getFileName().toString().lastIndexOf("."))));
                    });
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    public void addApplicability(String decimalNumber, String applicability) {
        Set<String> applicabilitiesSet = applicabilities.get(decimalNumber);
        if (applicabilitiesSet == null) {
            applicabilities.put(decimalNumber, new HashSet<>(Set.of(applicability)));
        } else {
            applicabilitiesSet.add(applicability);
        }
    }

    public void printReport(Path reportPath) {
        List<String> lines = applicabilities.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .toList();
        try {
            Files.createDirectories(reportPath.getParent());
            Files.write(reportPath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
