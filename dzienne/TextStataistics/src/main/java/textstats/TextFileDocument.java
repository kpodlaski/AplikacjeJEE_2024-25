package textstats;

import java.io.*;

public class TextFileDocument implements Document{

    String content = null;
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String openDocument(String fileName) throws FileNotFoundException, FormatUnknownException {
        File file = new File(fileName);
        try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        content ="";
        String line = reader.readLine();
            while (line != null) {
                content += line + "\n";
                line = reader.readLine();
            }
            reader.close();
        }
        catch (FileNotFoundException exception){
            throw exception;
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        }
        return content;
    }
}
