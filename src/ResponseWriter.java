import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    static void  writeSuccessResponse(String content, BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("Content-Type: text/html; charset=utf-8");
        writer.write("\r\n\r\n");
        writer.write(content);
    }
    static void writeBadRequestResponse(BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("\r\n\r\n");
        writer.write("500. Internal server error.");

    }
    static void writeNotFoundResponse(BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("\r\n\r\n");
        writer.write("404. Method not supported.");
    }

}
