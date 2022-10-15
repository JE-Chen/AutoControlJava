package autocontroldriver.utils.socket;


import java.io.*;
import java.net.Socket;

public class ClientSocket extends Thread {
    private Socket sendCommandSocket;
    private PrintWriter printWriter;
    private String host;
    private int port;

    public ClientSocket(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.setDaemon(true);
    }


    public void closeClient() throws IOException {
        if (sendCommandSocket != null)
            sendCommandSocket.close();
        if (printWriter != null)
            printWriter.close();
    }

    public String sendData(String stringToPrint) {
        boolean retry = true;
        int retryCount = 5;
        while (retry && retryCount >= 0) {
            try {
                System.out.println("command is: " + stringToPrint);
                this.sendCommandSocket = new Socket(this.host, this.port);
                this.printWriter = new PrintWriter(this.sendCommandSocket.getOutputStream());
                this.printWriter.write(stringToPrint);
                this.printWriter.flush();
                retry = false;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.sendCommandSocket.getInputStream()));
                System.out.println(bufferedReader.readLine());
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.printf("Can't send %s will retry%n", stringToPrint);
                retryCount -= 1;
            }
        }
        return "";
    }
}

