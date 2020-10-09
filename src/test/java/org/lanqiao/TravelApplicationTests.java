package org.lanqiao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootTest
class TravelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testIO() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Devlop\\travel\\mytext\\北京八达岭.txt"));
        String line = null;
        String content = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
            content += line +"\n";
        }
        System.out.println("**********");
        System.out.println("content:"+content.length());
        br.close();
    }
}
