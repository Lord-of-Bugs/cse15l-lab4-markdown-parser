import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Paths.get("/Users/Muchan/Desktop/UCSD-2021-2022/CSE15L/cse15l-lab-reports/cse15l-lab4-markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("https://something.com", "some-thing.html");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

}