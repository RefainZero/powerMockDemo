package com.rongrong.powermock.spies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author rongrong
 * @version 1.0
 * @date 2019/12/4 22:45
 */
public class FileService {

    /**
     * 写入文件及数据操
     * @param text
     */
    public void writeData(String text){
        BufferedWriter bw = null;
        try {
            bw=new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/ronngrong.txt"));
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
