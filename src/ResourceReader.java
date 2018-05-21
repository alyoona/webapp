import java.io.*;

public class ResourceReader {

    private String webAppPath;

    ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    String getContent(String uri) {
        String path = webAppPath + System.lineSeparator() + uri;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = fileReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading a file: " + path);
        }
      return builder.toString();
    }



}
