package ru.netology.javacore;

import java.util.*;

public class Todos {

    private List<String> todos;

    public Todos() {
        this.todos = new ArrayList<>();
    }

    public void addTask(String task) {
        todos.add(task);
    }

    public void removeTask(String task) {
        if (todos.contains(task)) {
            todos.remove(task);
        }
    }

    public String getAllTasks() {
        Collections.sort(todos);
        StringBuilder sb = new StringBuilder();
        for (String stringTask : todos) {
            sb.append(stringTask);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}