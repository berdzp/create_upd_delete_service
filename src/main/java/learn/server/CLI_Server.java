package learn.server;

import learn.controller.EmpoeeCL_Controller;
import learn.model.Emploee;
import learn.scan.CommandParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CLI_Server {

    private EmpoeeCL_Controller cl_controller;

    private CommandParser commandParser;

    private int port =8080;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public CLI_Server() throws IOException {
        cl_controller = new EmpoeeCL_Controller();
        commandParser = new CommandParser();
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {

        //Scanner scanner = new Scanner(System.in);
        System.out.println("server running on the port: " + port);
        while (true) {

            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String command = in.readLine();

            Method m = commandParser.getMethod(command);
            String response = "";
            if (m.equals(Method.GET)) {
                String getCommand = commandParser.getIdCommand(command);
                response = cl_controller.getEmploeeById(getCommand);
            } else if (m.equals(Method.PUT)) {
                Emploee emploee = commandParser.getEmploeeJson(command);
                response = cl_controller.addEmployee(emploee);
            }

            out.println(response);
            System.out.println(response);

        }
    }
}
