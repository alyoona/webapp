import java.io.*;

public class ResourceReader {

    private String webAppPath;

    ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    String getContent(String uri) {
        String path = webAppPath + "\\" + uri;
        //String path = webAppPath + System.lineSeparator() + uri;
        //java.io.FileNotFoundException: webapp\r\nhome.html (Синтаксическая ошибка в имени файла, имени папки или метке тома)
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = fileReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");

            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading a file: " + path);
        }
      return builder.toString();
    }



}
