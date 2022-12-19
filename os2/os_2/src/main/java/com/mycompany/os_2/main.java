package com.mycompany.os_2;

import com.mycompany.os_2.data;
import com.mycompany.os_2.producer;
import com.mycompany.os_2.consumer;
import com.mycompany.os_2.data_Q;

public class main {
    
    data_Q dataQueue = new data_Q(8);
    
    producer Producer = new producer(dataQueue);
    Thread producerThread = new Thread(Producer);
    
    consumer Consumer = new consumer(dataQueue);
    Thread consumerThread = new Thread(Consumer);
    
    producerThread.start();
    consumerThread.start();
    

}
