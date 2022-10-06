package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private int value = 1;
    private boolean completed;
    @Override
    public void execute() {
        if(completed){
            value = 0;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }

    public void complete() {
        completed = true;
    }
}
