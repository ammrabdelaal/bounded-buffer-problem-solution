package com.mycompany.os_2;
import com.mycompany.os_2.data;
import java.util.Collection;

public class producer implements Runnable {
    private final data_Q dataQueue;
    private volatile boolean runFlag;

    public producer(data_Q dataQueue) {
        this.dataQueue = dataQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        produce();
    }
    
public void produce() {
    while (runFlag) {
        data data = generateMessage();
        while (dataQueue.isFull()) {
            try {
                dataQueue.waitOnFull();
            } catch (InterruptedException e) {
                break;
            }
        }
        if (!runFlag) {
            break;
        }
        dataQueue.add(data);
        dataQueue.notifyAllForEmpty();
        System.out.print("produced");
    }
}

public void stop() {
    runFlag = false;
    dataQueue.notifyAllForFull();
}

    public  data  generateMessage() {
        data D = new data();
        return D;
    }

}

