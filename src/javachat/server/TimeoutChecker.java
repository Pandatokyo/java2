package ru.gb.javachat.server;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.gb.javachat.Command;

public class TimeoutChecker {
    private static final TimeoutChecker timeoutChecker = new TimeoutChecker();
    private static final Map<ClientHandler, Long> nonAuthorizedSockets = new HashMap<>();
    private final static long TIME_LIMIT = 10 * 1000;

    private TimeoutChecker() {
        AtomicBoolean authorizedTime = new AtomicBoolean(true);
        new Thread(() -> {
            while (authorizedTime.get()) {
                nonAuthorizedSockets.forEach(((client, aLong) -> {
                    if ((System.currentTimeMillis() - aLong) > TIME_LIMIT) {
                        client.sendMessage(Command.AUTHERROR, "Время на авторизацию истекло");
                        authorizedTime.set(false);
                    }
                }));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void set(ClientHandler client) {
        nonAuthorizedSockets.put(client, System.currentTimeMillis());
    }

    public static void unset(ClientHandler client) {
        nonAuthorizedSockets.remove(client);
    }
}