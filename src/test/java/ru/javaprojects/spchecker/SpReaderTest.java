package ru.javaprojects.spchecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javaprojects.spchecker.sp.SpLine;
import ru.javaprojects.spchecker.sp.SpReader;

import java.util.List;

import static ru.javaprojects.spchecker.SpReaderTestData.*;
public class SpReaderTest {

    @Test
    void getSpDecimalNumber() {
        var spReader = new SpReader(ABVG_468362_046_SP_PATH);
        Assertions.assertEquals(ABVG_468362_046_SP_DECIMAL_NUMBER, spReader.getSpDecimalNumber());
    }

    @Test
    void getSpName() {
        var spReader = new SpReader(ABVG_468362_046_SP_PATH);
        Assertions.assertEquals(ABVG_468362_046_SP_NAME, spReader.getSpName());
        spReader = new SpReader(ABVG_301412_847_SP_PATH);
        Assertions.assertEquals(ABVG_301412_847_SP_NAME, spReader.getSpName());
        spReader = new SpReader(ABVG_301412_849_SP_PATH);
        Assertions.assertEquals(ABVG_301412_849_SP_NAME, spReader.getSpName());
    }

    @Test
    void getDocuments() {
        var spReader = new SpReader(ABVG_468362_046_SP_PATH);
        Assertions.assertEquals(SpReaderTestData.spDocuments, spReader.getDocuments());
    }

    @Test
    void getDocumentsWhenSpHasNoDocuments() {
        var spReader = new SpReader(NO_DOCUMENTS_SP_PATH);
        Assertions.assertEquals(List.of(), spReader.getDocuments());
    }

    @Test
    @SuppressWarnings("unchecked")
    void checkSpLinesCorrect() throws NoSuchFieldException, IllegalAccessException {
        var spReader = new SpReader(ABVG_301412_847_SP_PATH);
        var linesField = spReader.getClass().getDeclaredField("lines");
        linesField.setAccessible(true);
        var lines = (List<SpLine>) linesField.get(spReader);
        Assertions.assertEquals(spLines, lines);
    }
}
