package textstats;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TextFileDocumentTest {

    TextFileDocument testTatget;
    @BeforeEach
    void setUp() {
        testTatget = new TextFileDocument();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getContent() {
    }

    @Test
    void openDocumentThatNotExist() throws FileNotFoundException,
            FormatUnknownException {
        String filename = "pchla_szachrajka.txt";
        assertThrows(FileNotFoundException.class, () ->{
            testTatget.openDocument(filename);
        } );
    }
    String baseTestPath = "./target/test-classes/";
    @Test()
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void openDocumentWithSuccess() throws FormatUnknownException, FileNotFoundException {
//        File dir = new File("./");
//        System.out.println(dir.getAbsolutePath());
//        for (File f: dir.listFiles()){
//            System.out.println(f.getName());
//        }
        String filename = baseTestPath+"wierszyk.txt";
        String resp = testTatget.openDocument(filename);
        assertNotNull(resp);
        assertTrue(resp.length()>0);
        assertNotNull(testTatget.getContent());
        assertEquals(resp.length(),testTatget.getContent().length());
        //Oczekujemy 52 znaki, 50 literek + 2x \n
        assertEquals(52,testTatget.getContent().length());

    }
}