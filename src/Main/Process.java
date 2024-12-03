package Main;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
    public static int idCounter = 0;
    public int id;
    public String name;
    public int arrivalTime;
    public int burstTime;
    public int priority;
    public int quantum;     //fcai releated only
    public Color color;     //gui releated only

    public Process(String name, int arrivalTime, int burstTime, int priority, int quantum){
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.quantum = quantum;
        Random random = new Random();
        color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public void setColor(int r,int g, int b){
        this.color = new Color(r,g,b);
    }

    //test releated
    public static List<Process> generateRandomProcesses(int numProcesses) {
        Random random = new Random();
        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            String name = "Process " + (i + 1);
            int arrivalTime = random.nextInt(10);
            int burstTime = random.nextInt(10) + 1;
            int priority = random.nextInt(5) + 1;
            int quantum = random.nextInt(5) + 1;
            Process process = new Process(name, arrivalTime, burstTime, priority, quantum);
            process.setColor(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            processes.add(process);
        }

        return processes;
    }
}
