package experiment_first;

import java.util.Date;

/**
 * 进程
 */
public class Process<T extends CalRuntime> {
    private PCB pcb;
    private T program;
    public Process(T program){
        this.program=program;
        pcb=new PCB();
        pcb.setProgramName(this.program.getClass().getName());
        pcb.setCreatTime(new Date().getTime());
        pcb.setStatus("ready");
        pcb.setPriority(1);
        pcb.setRunTime(program.getRuntime());
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

    public static void main(String[] args) {

    }
}
