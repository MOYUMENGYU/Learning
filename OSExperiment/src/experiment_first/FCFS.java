package experiment_first;

import java.util.LinkedList;
import java.util.Queue;

public class FCFS<T extends CalRuntime> {
    Process<T> process;
    Queue<Process> queue=new LinkedList<>();
    public void schedule(Process<T> process){
        this.queue.offer(process);
    }
    public void runProgram(){
        while(!queue.isEmpty()){
            process=this.queue.poll();
            process.getProgram().run();
        }
    }
    public static void main(String[] args) {
        FCFS fcfs=new FCFS();
        for(int i=0;i<10;i++){
            fcfs.schedule(new Process(new Program()));
        }
        fcfs.runProgram();
    }
}
