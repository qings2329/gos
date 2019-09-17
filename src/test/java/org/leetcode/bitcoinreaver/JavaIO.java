package org.leetcode.bitcoinreaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;

public class JavaIO {

    public static void main(String[] args) {
        try {
            JavaIO javaIO = new JavaIO();
            ClassLoader classLoader = javaIO.getClass().getClassLoader();
            URL fileUrl = classLoader.getResource("log4j.properties");
            String filePath = fileUrl.getFile();
            System.out.println(filePath);
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\n***********************************************\n");

            // 随机读
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
            randomAccessFile.seek(2);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = randomAccessFile.read(buff)) > 0) {
                //打印读取的内容,并将字节转为字符串输入
                System.out.println(new String(buff, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
