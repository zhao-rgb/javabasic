import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className random
 * @Description TODO
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class random {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            int temp = (int) (Math.random() * 100);
            list.add(temp);
        }
        File file = new File("D:/random.txt");
        if (!file.exists()) {
            System.out.println("未找到");
            file.createNewFile();
            System.out.println("创建成功！");
        } else {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(list));
            fileWriter.close();
            System.out.println("写入成功！");
        }

    }
}
