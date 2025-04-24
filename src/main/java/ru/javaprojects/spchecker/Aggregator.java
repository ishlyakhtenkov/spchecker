package ru.javaprojects.spchecker;

import ru.javaprojects.spchecker.sp.SpDocument;
import ru.javaprojects.spchecker.sp.SpReader;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Aggregator {
    private final Map<SpDocument, Document> documents = new HashMap<>();

    public void handleSpecifications(List<Path> spPaths) {
        spPaths.forEach(spPath -> {
            System.out.println("Aggregator handles SP: " + spPath.getFileName());
            var spReader = new SpReader(spPath);
            spReader.getDocuments()
                    .forEach(spDocument -> {
                        var document = documents.get(spDocument);
                        if (document == null) {
                            documents.put(spDocument, new Document(spDocument.decimalNumber(), spDocument.name(),
                                    new TreeSet<>(Set.of(spReader.getSpDecimalNumber()))));
                        } else {
                            document.applicability().add(spReader.getSpDecimalNumber());
                        }
                    });
        });
    }

    public List<Document> getDocuments() {
        return documents.values().stream()
                .sorted(Comparator.comparing(Document::decimalNumber))
                .collect(Collectors.toList());
    }

    public List<Document> getDocumentsWithNameDifferences() {
        var nameDiffDocuments = new HashSet<Document>();
        Map<String, Document> decimalNumbers = new HashMap<>();
        documents.values().forEach(document -> {
            var alreadyProcessedDoc = decimalNumbers.get(document.decimalNumber());
            if (alreadyProcessedDoc == null) {
                decimalNumbers.put(document.decimalNumber(), document);
            } else {
                nameDiffDocuments.add(alreadyProcessedDoc);
                nameDiffDocuments.add(document);
            }
        });
        return nameDiffDocuments.stream()
                .sorted(Comparator.comparing(Document::decimalNumber).thenComparing(Document::name))
                .toList();
    }
}
