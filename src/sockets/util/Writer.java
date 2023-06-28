package sockets.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Writer implements Runnable {
    private PrintWriter out;

    public Writer(Socket socket) {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String line = "";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            line = scanner.nextLine();

            out.println(line);
        }
    }

    public PrintWriter getOut() {
        return out;
    }
}
