package org.lanqiao.util;


import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
public class SaveTxt{

//    private  String filePath = "/root/articles/"+ UUID.randomUUID()+".txt";

//    字符串存文本
    public String saveAsFileWriter(String content) {
        String filePath = "/root/articles/"+ UUID.randomUUID()+".txt";
        FileWriter fwriter = null;
        try {
            //追加文件夹
            File file = new File("/root/articles/");
            if(!file.exists()){
                file.mkdirs();
            }
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, true);
            fwriter.write(content);
//            filePath = filePath.replaceAll("/root/","/upload/");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        filePath = filePath.replaceAll("/root/","/upload/");
        return filePath;
    }
//    文本转字符串
    public String turnFileTxt(String path){
       String content = "";
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            path = path.replaceAll("/upload/","/root/");
            String pathname = path; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if(line == null){
                    content = content + "";
                }else{
                    content = content + line ;
                }
//                System.out.println(content);
            }}
        catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}
