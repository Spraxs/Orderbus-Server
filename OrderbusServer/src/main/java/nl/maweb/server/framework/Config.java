package com.spraxs.js.framework;

/**
 * Created by Spraxs
 * Date: 25-9-2018
 */

public final class Config {

    public static int IO_PACKET_THREAD_CORE_SIZE;
    public static String SERVER_IP;
    public static int SERVER_PORT;

    public static void load() {

        SERVER_IP = "127.0.0.1";
        SERVER_PORT = 25565;


        IO_PACKET_THREAD_CORE_SIZE = 2;
    }
}