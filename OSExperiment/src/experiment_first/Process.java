package experiment_first;

import java.util.Comparator;
import java.util.Date;
import java.util.Random;

/**
 * 进程
 * 运行程序进来，创建进程，初始化pcb
 */
public class Process<T extends SetRuning>{
    private PCB pcb;
    private T program;
    public Process(T program){
        this.program=program;
        pcb=new PCB();
        pcb.setId(pcb.getPid());
        pcb.setProgramName(this.program.getClass().getName());
        pcb.setCreatTime(new Date().getTime());
        pcb.setStatus("ready");
        Random random=new Random();
        pcb.setPriority(random.nextInt(20));
        pcb.setRunTime(this.program.getRuntime());
    }
    public PCB getPcb() {
        return pcb;
    }
    public void setPcb(PCB pcb) {
        this.pcb = pcb;
    }

    public T getProgram() {
        return program;
    }

    public void setProgram(T program) {
        this.program = program;
    }

}
