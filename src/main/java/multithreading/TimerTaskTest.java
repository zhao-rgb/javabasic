package multithreading;

import util.FileUtil;

import javax.sound.midi.Soundbank;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhao
 * @className 二维码生成图
 * @Description TODO
 * @Date 2020/1/31
 * @Version 1.0
 **/
public class TimerTaskTest {

    public static Timer timer = null;

    public static void main(String[] args) throws InterruptedException{
        // 这里为用户线程，如果new Timer(true), 则是守护进程
        timer = new Timer();
        // 延迟1s执行，每隔3s执行一次
        timer.schedule(new DrawQrCodeThread(),1000,3000);
    }
}

class DrawQrCodeThread extends TimerTask{
    private static int index = 1;

    @Override
    public void run(){
        FileUtil.drawQrCode("https://github.com/zhao-rgb/javabasic","test" + index++ + ".jpg");
    }

}
