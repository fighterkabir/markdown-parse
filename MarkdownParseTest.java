import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest { 

    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinksOne() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinksThree() throws IOException {
        Path fileName = Path.of("test3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinksFour() throws IOException {
        Path fileName = Path.of("test4.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // ArrayList<String> expected = new ArrayList<String>();
        assertEquals("", links);
    }

    @Test
    public void testGetLinksFive() throws IOException {
        Path fileName = Path.of("test5.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // ArrayList<String> expected = new ArrayList<String>();
        assertEquals("", links);
    }

    @Test
    public void testGetLinksSix() throws IOException {
        Path fileName = Path.of("test6.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("page.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinksSeven() throws IOException {
        Path fileName = Path.of("test7.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinksFail2t() throws IOException {
        Path fileName = Path.of("fail2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        // ArrayList<String> expected = new ArrayList<String>();
        assertEquals("", links);
    }

    @Test
    public void testGetLinksEmpty() throws IOException {
        Path fileName = Path.of("empty.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        // expected.add("[]");
        assertEquals(expected, links);
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("testfileLabsnip1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("url.com", "google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("testfileLabsnip2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "b.com", "a.com", "example.com"), links);
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("testfileLabsnip3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://www.twitter.com", 
            "https://ucsd-cse15l-w22.github.io/", 
                "github.com", "https://cse.ucsd.edu/"), links);
    }
}
