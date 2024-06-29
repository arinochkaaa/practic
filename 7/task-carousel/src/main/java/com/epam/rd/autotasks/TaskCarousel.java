package com.epam.rd.autotasks;

import java.util.LinkedList;
import java.util.Queue;

public class TaskCarousel {
    private final int capacity;
    private final Queue<Task> tasks;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new LinkedList<>();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isFull() {
        return tasks.size() >= capacity;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        return tasks.offer(task);
    }

    public boolean execute() {
        if (tasks.isEmpty()) {
            return false;
        }

        Task currentTask = tasks.poll();
        if (currentTask != null) {
            currentTask.execute();
            if (!currentTask.isFinished()) {
                tasks.offer(currentTask);
            }
            return true;
        }
        return false;
    }
}

