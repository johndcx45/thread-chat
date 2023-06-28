package sockets.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader implements Runnable {
    private BufferedReader in;

    public Reader(Socket socket) {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String line = "";

        while(true) {
            try {
                line = in.readLine();

                System.out.println(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BufferedReader getIn() {
        return in;
    }
}
