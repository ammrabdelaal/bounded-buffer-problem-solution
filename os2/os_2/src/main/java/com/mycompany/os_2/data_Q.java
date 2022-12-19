package com.mycompany.os_2;

import com.mycompany.os_2.data;
import java.util.LinkedList;
import java.util.Queue;
public class data_Q {

    private final Queue<data> queue = new LinkedList<>();
    private  int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();
    
    data_Q(int maxSize) {
        this.maxSize = maxSize;
    }
    
    boolean isFull(){
        int Size = queue.size();
        if ( Size == maxSize ){
            return true; }
        else{
        return false; }
    }
    
        boolean isEmpty(){
        boolean response = queue.isEmpty();    
        if (response ){
            return true; }
        else{
        return false; }
    }
    
    
public void waitOnFull() throws InterruptedException {
    synchronized (FULL_QUEUE) {
        FULL_QUEUE.wait();
    }}

public void notifyAllForFull() {
    synchronized (FULL_QUEUE) {
        FULL_QUEUE.notifyAll();
    }}

public void waitOnEmpty() throws InterruptedException {
    synchronized (EMPTY_QUEUE) {
        EMPTY_QUEUE.wait();
    }}

public void notifyAllForEmpty() {
    synchronized (EMPTY_QUEUE) {
        EMPTY_QUEUE.notify();
    }
}

public void add(data message) {
    synchronized (queue) {
        queue.add(message);
    }}

public data remove() {
    synchronized (queue) {
        return queue.poll();
    }}


}

