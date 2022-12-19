package com.mycompany.os_2;
import com.mycompany.os_2.data;
import java.util.Collection;

public class consumer implements Runnable {
    private final data_Q dataQueue;
    private volatile boolean runFlag;

    public consumer(data_Q dataQueue) {
        this.dataQueue = dataQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        consume();
    }

    
    public void consume() {
    while (runFlag) {
        data data;
        if (dataQueue.isEmpty()) {
            try {
                dataQueue.waitOnEmpty();
            } catch (InterruptedException e) {
                break;
            }
        }
        if (!runFlag) {
            break;
        }
        data = dataQueue.remove();
        dataQueue.notifyAllForFull();
        System.out.print("consumed");
    }
}
    
    public void stop() {
    runFlag = false;
    dataQueue.notifyAllForEmpty();
}
    
}

