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
        Path fileName = Paths.get("test-file.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("https://something.com", "some-thing.html");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks1() throws IOException {
        Path fileName = Paths.get("test-file2.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("https://google.com", "some-thing.html");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Paths.get("test-file3.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("more text here");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Paths.get("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Paths.get("test-file5.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("page.com");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks5() throws IOException {
        Path fileName = Paths.get("test-file6.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("page.com");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks6() throws IOException {
        Path fileName = Paths.get("test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetLinks7() throws IOException {
        Path fileName = Paths.get("test-file8.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("a link on the first line");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testGetLinks8() throws IOException {
        Path fileName = Paths.get("new-test-file.md");
        String content = Files.readString(fileName);
        List<String> expected = List.of("wikipedia.com", "this is a link", "this-is-another-link.com");
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertTrue(expected.equals(actual));
    }
}
