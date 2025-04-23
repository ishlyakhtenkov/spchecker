import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javaprojects.spchecker.sp.SpLine;
import ru.javaprojects.spchecker.sp.SpReader;

import java.nio.file.Paths;
import java.util.List;

public class SpReaderTest {

    @Test
    void getSpDecimalNumber() {
        var spReader = new SpReader(Paths.get("src/test/resources/sp/АБВГ.468362.046.docx"));
        Assertions.assertEquals("АБВГ.468362.046", spReader.getSpDecimalNumber());
    }

    @Test
    void getDocuments() {
        var spReader = new SpReader(Paths.get("src/test/resources/sp/АБВГ.468362.046.docx"));
        Assertions.assertEquals(SpReaderTestData.spDocuments, spReader.getDocuments());
    }

    @Test
    void getDocumentsWhenSpHasNoDocuments() {
        var spReader = new SpReader(Paths.get("src/test/resources/sp/no_documents_sp.docx"));
        Assertions.assertEquals(List.of(), spReader.getDocuments());
    }

    @Test
    void checkSpLinesCorrect() throws NoSuchFieldException, IllegalAccessException {
        var spReader = new SpReader(Paths.get("src/test/resources/sp/АБВГ.301412.847.docx"));
        var linesField = spReader.getClass().getDeclaredField("lines");
        linesField.setAccessible(true);
        List<SpLine> lines = (List<SpLine>) linesField.get(spReader);
        Assertions.assertEquals(SpReaderTestData.spLines, lines);
    }
}
