package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean completeRequested = false;
    private boolean isCompleted = false;

    @Override
    public void execute() {
        if (completeRequested) {
            isCompleted = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isCompleted;
    }

    public void complete() {
        completeRequested = true;
    }
}
