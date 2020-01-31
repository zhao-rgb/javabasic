package IO;

import java.io.*;

/**
 * @author zhao
 * @className Copy
 * @Description TODO
 * @Date 2020/1/14
 * @Version 1.0
 **/
public class Copy {
    public static void main(String[] args) throws IOException {
        //复制文本——创建缓冲字符流
        BufferedReader br = new BufferedReader(new FileReader("D:/工具/123.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/工具/125.txt"));
        String content = "";
        String line;
        while((line = br.readLine())!=null) {
            content += line;
        }
        bw.write(content);
        bw.close();
        br.close();
    }
}
