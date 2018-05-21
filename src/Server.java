import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String webAppPath;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public void start() throws IOException {

        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        try (BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            RequestHandler handler = new RequestHandler(socketReader, socketWriter, webAppPath);
            handler.handle();
        }
        //?? clientSocket.close();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;

    }


}
