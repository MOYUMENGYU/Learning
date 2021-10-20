package experiment_first;

import java.util.Random;

/**
 * 运行程序
 */
public class Program implements CalRuntime {
    private long time;
    private Random random=new Random();
    public Program(){
        time=random.nextInt(5000);
    }
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(getClass().getName()+"正在运行"+i);
        }
    }
    @Override
    public long getRuntime() {
        return time;
    }
    @Override
    public void setRuntime(long time) {
        this.time=time;
    }
}
