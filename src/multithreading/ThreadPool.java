package multithreading;

import util.FileUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhao
 * @className ThreadPool
 * @Description TODO
 * @Date 2020/1/29
 * @Version 1.0
 **/
public class ThreadPool {
    public static void main(String[] args) {
        /**
         * 创建一个可重用、固定线程数的线程池
         */
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            // 将线程放入到线程池中
            pool.execute(new DownLoad());
        }
        // 关闭线程池
        pool.shutdown();
    }
}

class DownLoad implements Runnable {
    /**
     * 指定2张被下载图片
     */
    private String[] urlPaths = {"https://pic3.zhimg.com/80/v2-0262f200855e4f34d5fe0df839e0b06f_hd.jpg",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157688830886870.png"
    };

    @Override
    public void run() {
        for (int i = 0; i < urlPaths.length; i++) {
            synchronized (this) {
                FileUtil.downPicture(urlPaths[i]);
            }
        }
    }
}
