package experiment_first;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

/**
 * 进程控制块
 */
public class PCB {
    static int pid;//pcb id 唯一标识
    private int id;
    private String programName;//程序运行名称
    private String  status;//运行状态
    private int priority;//优先级
    private long creatTime;//创建时间
    private long runTime;//运行时间
    private long arriveTime;
    private long startTime;

    public PCB(){
        pid++;
    }
    public int getPid(){
        return pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setArriveTime(long arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }
}
