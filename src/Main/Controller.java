package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GUIPack.GUI;

public class Controller {
    private int countProcess;
    private List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    private List<Process> processes = new ArrayList<Process>();

    public Controller(int countProcess){
        this.countProcess = countProcess;
        while(countProcess-- > 0){
            Scanner scanner = new Scanner(System.in);
            String name;
            int arrivalTime;
            int burstTime;
            int priority;
            int quantum;

            System.out.println("enter name");
            name = scanner.nextLine();
            System.out.println("enter arrival time");
            arrivalTime = Integer.parseInt(scanner.nextLine());
            System.out.println("enter burst time");
            burstTime = Integer.parseInt(scanner.nextLine());
            System.out.println("enter prio");
            priority = Integer.parseInt(scanner.nextLine());
            System.out.println("enter quantum");
            quantum = Integer.parseInt(scanner.nextLine());
            processes.add(new Process(name, arrivalTime, burstTime, priority, quantum));
            System.out.println("--process added succefully--\n");

            scanner.close();
        }
    }

    private void menu(){

    }
    
    public void prioritySchdule(){

    }

    public void SJF(){

    }

    public void SRTF(){

    }

    public void FCAI(){

    }

    public void representInGUI(){
        new GUI(result,processes);
    }
}
