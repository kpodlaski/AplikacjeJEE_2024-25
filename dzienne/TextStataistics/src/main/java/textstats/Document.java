package textstats;

import java.io.FileNotFoundException;

public interface Document {

    String getContent();
    String openDocument(String fileName) throws FileNotFoundException, FormatUnknownException;
}
