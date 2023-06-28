package sockets.server;

import sockets.util.Reader;
import sockets.util.Writer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Reader reader;
    private Writer writer;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        System.out.println("Received a new connection!");

        reader = new Reader(clientSocket);
        writer = new Writer(clientSocket);

        new Thread(reader).start();
        new Thread(writer).start();
    }

    public void stop() throws IOException {
        clientSocket.close();
        serverSocket.close();
    }
}
