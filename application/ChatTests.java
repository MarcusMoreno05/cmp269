package application;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class ChatTests {

    private static Thread serverThread;

    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> ChatServer.main(null));
        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
    }

    private Socket connectClient() throws IOException {
        return new Socket("127.0.0.1", ChatServer.PORT);
    }

    @Test
    void testUsernameHandshake() throws Exception {
        Socket client = connectClient();

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        // 1. Read the server prompt
        String prompt = reader.readLine();
        assertEquals("SERVER: Enter your username:", prompt);

        // 2. Send username
        writer.println("Marcus");

        // 3. Wait for the join broadcast
        String joinMsg = null;
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 2000 && joinMsg == null) {
            if (reader.ready()) {
                joinMsg = reader.readLine();
            }
        }

        assertNotNull(joinMsg, "Server never sent join message");
        assertEquals("SERVER: Marcus has joined the chat!", joinMsg);

        client.close();
    }

    @Test
    void testMessageBroadcast() throws Exception {
        Socket clientA = connectClient();
        BufferedReader readA = new BufferedReader(new InputStreamReader(clientA.getInputStream()));
        PrintWriter writeA = new PrintWriter(clientA.getOutputStream(), true);

        readA.readLine();
        writeA.println("Alice");
        readA.readLine();

        Socket clientB = connectClient();
        BufferedReader readB = new BufferedReader(new InputStreamReader(clientB.getInputStream()));
        PrintWriter writeB = new PrintWriter(clientB.getOutputStream(), true);

        readB.readLine();
        writeB.println("Bob");
        readA.readLine();
        readB.readLine();

        writeA.println("Hello world!");

        String msgA = readA.readLine();
        String msgB = readB.readLine();

        assertEquals("Alice: Hello world!", msgA);
        assertEquals("Alice: Hello world!", msgB);

        clientA.close();
        clientB.close();
    }

    @Test
    void testDisconnectBroadcast() throws Exception {
        Socket client = connectClient();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        reader.readLine();
        writer.println("TestUser");
        reader.readLine();

        client.close();

        Socket client2 = connectClient();
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter writer2 = new PrintWriter(client2.getOutputStream(), true);

        reader2.readLine();
        writer2.println("Observer");

        String joinMsg = null;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 2000 && joinMsg == null) {
            if (reader2.ready()) joinMsg = reader2.readLine();
        }

        assertNotNull(joinMsg);
        assertEquals("SERVER: Observer has joined the chat!", joinMsg);

        String disconnectMsg = null;
        start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 2000 && disconnectMsg == null) {
            if (reader2.ready()) disconnectMsg = reader2.readLine();
        }

        assertNotNull(disconnectMsg);
        assertEquals("SERVER: TestUser has left the chat!", disconnectMsg);

        client2.close();
    }
}