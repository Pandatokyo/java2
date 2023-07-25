package ru.gb.javachat.server;

import java.io.IOException;

public class ServerLauncher {
    public static void main(String [] args) throws IOException {
        new ChatServer().run();
    }
}
