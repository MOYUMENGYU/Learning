package experiment_first;

import java.util.*;

public class FCFS<T extends SetRuning> {
    Process<T> process;//当前实行进程
    Queue<Process> queue = new LinkedList<Process>();//就绪队列
    ArrayList<String> runInfo=new ArrayList<>();
    long arrive;//到达时间
    long start;
    /**
     * 调度
     * @param process
     */
    public void schedule(Process<T> process) {
        Random random=new Random();
        process.getPcb().setArriveTime(arrive);
        this.queue.offer(process);
        arrive+=random.nextInt(5);
    }

    public void runProgram() {
        while (!queue.isEmpty()) {
            process = this.queue.poll();
            PCB pcb=process.getPcb();
            String info=pcb.getId()+"            "+pcb.getArriveTime()+"           "+pcb.getRunTime()
                    +"            "+start+"       "+(pcb.getRunTime()+start);
            runInfo.add(info);
            process.getProgram().run();
            start+=process.getPcb().getRunTime();
        }
    }
    public void inof(){
        System.out.println("作业号"+"      "+"到达时间"+"     "+"运行时间"+"     "+"开始时间"+"     "+"完成时间");
        for(String s:runInfo){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        FCFS fcfs = new FCFS();
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            int i = random.nextInt(10);
            if (i % 2 == 0) {
                fcfs.schedule(new Process(new Program_first()));
            } else {
                fcfs.schedule(new Process(new Program_second()));
            }
        }
        fcfs.runProgram();
        fcfs.inof();
    }
}
