package learn;


import learn.server.CLI_Server;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        CLI_Server server = new CLI_Server();
        server.start();
    }
}
