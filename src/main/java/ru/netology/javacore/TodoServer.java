package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    static class JsonTask {
        String type;
        String task;
    }

    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String jsonFromClient = in.readLine();

                    JsonTask jsonTask = new Gson().fromJson(jsonFromClient, JsonTask.class);

                    if (jsonTask.type.equals("ADD")) {
                        todos.addTask(jsonTask.task);
                    }

                    if (jsonTask.type.equals("REMOVE")) {
                        todos.removeTask(jsonTask.task);
                    }

                    out.println(todos.getAllTasks());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}