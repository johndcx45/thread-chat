package sockets.client;

import sockets.util.Reader;
import sockets.util.Writer;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private Reader reader;
    private Writer writer;

    public void start(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);

        reader = new Reader(clientSocket);
        writer = new Writer(clientSocket);

        new Thread(reader).start();
        new Thread(writer).start();
    }

    public void stop() throws IOException {
        writer.getOut().close();
        reader.getIn().close();
        clientSocket.close();
    }
}
