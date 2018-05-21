import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RequestHandler {

    private BufferedReader socketReader;
    private BufferedWriter socketWriter;
    private String webAppPath;

    RequestHandler(BufferedReader socketReader, BufferedWriter socketWriter, String webAppPath){
        this.socketReader = socketReader;
        this.socketWriter = socketWriter;
        this.webAppPath = webAppPath;
    }
    void handle() throws IOException {
        try {
            Request request = RequestParser.parseRequest(socketReader);
            ResourceReader resourceReader = new ResourceReader(webAppPath);
            String uri = request.getUri();
            String content = resourceReader.getContent(uri);
            ResponseWriter.writeSuccessResponse(content, socketWriter);
        } catch (IllegalArgumentException e) {
            ResponseWriter.writeBadRequestResponse(socketWriter);
        }  catch (FileNotFoundException e) {
            ResponseWriter.writeNotFoundResponse(socketWriter);
        } catch (IOException e) {
            e.printStackTrace();
            ResponseWriter.writeBadRequestResponse(socketWriter);
        }

    }
}
