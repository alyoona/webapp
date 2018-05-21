import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RequestParser {

    public static Request parseRequest(BufferedReader reader) throws IOException {
        Request request = new Request();
        String firstLine = reader.readLine();
        injectUriANdMethod(request, firstLine);
        injectHeaders(request, reader);
        return request;
    }

    public static void injectUriANdMethod(Request request, String line) {
        String[] array = line.split(" ");
        request.setUri(array[1]);
        try {
            request.setMethod(HttpMethod.getByName(array[0]));
        } catch (Exception e) {
            throw new RuntimeException("It is not a http method: " + array[0]);
        }
    }

    public static void injectHeaders(Request request, BufferedReader reader) throws IOException {
        String line;
        Map<String, String> map = new HashMap<>();
        while ((line = reader.readLine()) != null ) {
            String[] array = line.split(": ");
            map.put(array[0], array[1]);
        }
        request.setHeaders(map);
    }

}
