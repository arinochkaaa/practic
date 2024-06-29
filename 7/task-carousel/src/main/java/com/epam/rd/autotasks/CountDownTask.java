package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int initialValue) {
        this.value = Math.max(0, initialValue);
    }

    @Override
    public void execute() {
        if (value > 0) {
            value--;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }

    public int getValue() {
        return value;
    }
}

