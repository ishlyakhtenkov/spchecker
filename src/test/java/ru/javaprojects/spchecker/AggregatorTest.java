package ru.javaprojects.spchecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javaprojects.spchecker.sp.SpDocument;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static ru.javaprojects.spchecker.AggregatorTestData.documents;
import static ru.javaprojects.spchecker.SpReaderTestData.*;

public class AggregatorTest {

    @Test
    void getDocuments() {
        var aggregator = new Aggregator();
        List<Path> spPaths = List.of(ABVG_301412_847_SP_PATH, ABVG_301412_849_SP_PATH, ABVG_468362_046_SP_PATH);
        aggregator.handleSpecifications(spPaths);
        Assertions.assertEquals(documents, aggregator.getDocuments());
    }

    @Test
    @SuppressWarnings("unchecked")
    void handleSpecifications() throws NoSuchFieldException, IllegalAccessException {
        var aggregator = new Aggregator();
        List<Path> spPaths = List.of(ABVG_301412_847_SP_PATH, ABVG_301412_849_SP_PATH, ABVG_468362_046_SP_PATH);
        aggregator.handleSpecifications(spPaths);
        var documentsField = aggregator.getClass().getDeclaredField("documents");
        documentsField.setAccessible(true);
        var documents = (Map<SpDocument, Document>) documentsField.get(aggregator);
        Assertions.assertEquals(AggregatorTestData.aggregatedDocuments, documents);
    }
}
