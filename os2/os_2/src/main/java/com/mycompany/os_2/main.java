package com.mycompany.os_2;

import com.mycompany.os_2.data;
import com.mycompany.os_2.producer;
import com.mycompany.os_2.consumer;
import com.mycompany.os_2.data_Q;

public class main {
    public static void main (String args[]) throws InterruptedException{
        data_Q dataQueue = new data_Q(4);
        
                producer producing_line = new producer(dataQueue);
                for(int i = 0; i < 2; i++) {
                    Thread producerThread = new Thread(producing_line);
                    producerThread.start();
                }
    
                consumer targeted_product = new consumer(dataQueue);
                for(int i = 0; i < 4; i++) {
                    Thread consumerThread = new Thread(targeted_product);
                    consumerThread.start();
                }
        
    }
}
