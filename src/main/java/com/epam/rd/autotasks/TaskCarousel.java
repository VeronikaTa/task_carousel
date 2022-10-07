package com.epam.rd.autotasks;

import java.util.LinkedList;

public class TaskCarousel {

    private final int capacity;

    LinkedList<Task> carousel = new LinkedList<>();
    private int previous;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        previous = -1;
    }

    public boolean addTask(Task task) {
        if(task == null){
            return false;
        }
        if(isFull()){
            return false;
        }
        if(task.isFinished()){
            return false;
        }
        if(carousel.size() > 1) {
            for (int i = 0; i < carousel.size(); i++) {
                if (carousel.get(i).isFinished()) {
                    carousel.remove(carousel.get(i));
                }
            }
        }
        carousel.add(task);
        return true;
    }

    public boolean execute() {
        if(isEmpty()){
            return false;
        }
        if(carousel.size() == 1){
           carousel.get(0).execute();
        return true;
        }

      boolean elementFound = false;
        while(!elementFound){
            for(int i = 0; i < carousel.size(); i++){
                    if(i == carousel.size()-1 && carousel.get(i).isFinished()){
                        previous = -1;
                        continue;
                    }
                    if(!carousel.get(i).isFinished()){
                         if(i > previous){
                            carousel.get(i).execute();
                            previous = i != carousel.size()-1 ? i : -1;
                            elementFound = true;
                            break;
                        }
                    }
            }
        }
                return true;
        }

    public boolean isFull() {
        if(carousel.size() < capacity){
            return false;
        }
        boolean isFull = false;
        for(int i = 0; i < carousel.size(); i++){
            if(carousel.get((i)) == null){
                isFull = false;
                break;
            }
            else{
                if(carousel.get(i).isFinished()){
                    isFull = false;
                    break;
                }
                else{
                    isFull = true;
                }
            }
        }
       return isFull;
    }

    public boolean isEmpty() {
        if(carousel.isEmpty()){
            return true;
        }
        boolean isEmpty = false;
        for(int i = 0; i < carousel.size(); i++){
            if (carousel.get(i) == null){
                isEmpty = true;
            }
            else {
                if (carousel.get(i).isFinished()) {
                    isEmpty = true;
                }
                else{
                    isEmpty = false;
                    break;
                }
        }
        }
        return isEmpty;
    }

}

