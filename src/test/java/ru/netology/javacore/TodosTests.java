package ru.netology.javacore;

import org.junit.jupiter.api.*;

public class TodosTests {

    Todos sut;

    @BeforeEach
    public void init() {
        System.out.println("RUN TEST");
        sut = new Todos();
    }

    @AfterEach
    public void finished() {
        System.out.println("END TEST");
    }

    @Test
    public void test_AddTask() {
        String task = "ADD";

        sut.addTask(task);

        boolean result = sut.getAllTasks().contains(task);

        Assertions.assertTrue(result);
    }

    @Test
    public void test_RemoveTask() {
        String task = "REMOVE";

        sut.removeTask(task);

        boolean result = sut.getAllTasks().contains(task);

        Assertions.assertFalse(result);
    }

    @Test
    public void test_GetAllTasks() {
        String expected = "ADD REMOVE";

        sut.addTask(expected);

        String result = sut.getAllTasks();

        Assertions.assertEquals(expected, result);
    }
}