package com.hzq.car;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzq on 16/11/19.
 */
public class Flush {

    private static final CloseableHttpClient client = HttpClients.custom().build();
    private static Logger logger = LoggerFactory.getLogger(CarTest.class);

    private static void invoke(){
        Flush flush = new Flush();
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        HttpPost post = new HttpPost("http://zjszmus.com/Music/Prize/Submit?a_hm=13333333333");
        while(true){
            client.execute(post);
            System.out.println(1);
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
