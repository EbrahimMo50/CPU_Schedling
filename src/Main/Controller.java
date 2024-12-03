package Main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import GUIPack.GUI;

public class Controller {
    private int countProcess;
    private List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    private List<Process> processes = new ArrayList<Process>();

    public Controller(int countProcess){
        this.countProcess = countProcess;

        while(countProcess-- > 0){
            String name;
            int arrivalTime;
            int burstTime;
            int priority;
            int quantum;

            System.out.println("enter name");
            name = App.scanner.nextLine();
            System.out.println("enter arrival time");
            arrivalTime = Integer.parseInt(App.scanner.nextLine());
            System.out.println("enter burst time");
            burstTime = Integer.parseInt(App.scanner.nextLine());
            System.out.println("enter prio");
            priority = Integer.parseInt(App.scanner.nextLine());
            System.out.println("enter quantum");
            quantum = Integer.parseInt(App.scanner.nextLine());
            processes.add(new Process(name, arrivalTime, burstTime, priority, quantum));
            System.out.println("--process added succefully--\n");

        }
        displayMenu();
    }

    private void displayMenu(){
        boolean flag = true;
        while(flag){
            System.out.println(
                "\n" +
                "1- Priority scehdule \n" +
                "2- SJF \n" +
                "3- SRTF \n" +
                "4- FCAI \n" +
                "5- GUI for last schedule\n" +
                "6- Set Color For Process\n" + 
                "0- Exit"
            );
            int choice = App.scanner.nextInt();
            switch (choice) {
                case 1:
                    nonPrempSchedule(new PriorityComparator());
                    break;

                case 2:
                    nonPrempSchedule(new ShortestJobComparator());
                    break;

                case 3:
                    SRTF();
                    break;

                case 4:
                    FCAI();
                    break;

                case 5:
                    representInGUI();
                    break;

                case 6:
                    int r,g,b;
                    System.out.println("enter the rgb");
                    r = App.scanner.nextInt();
                    g = App.scanner.nextInt();
                    b = App.scanner.nextInt();

                    System.out.println("enter the id");
                    updateColor(App.scanner.nextInt(),r,g,b);
                    break;

                case 0:
                    flag = false;
                    break;
            
                default:
                    System.out.println("invalid choice try again\n");
                    break;
            }

        }
        App.scanner.close();
    }

    private void updateColor(int id, int r, int g, int b){
        processes.get(id).setColor(r, g, b);
    }

    public void nonPrempSchedule(Comparator<Process> Comparator){
        int currentTime = 1;
        Process currnetProcess = null;
        PriorityQueue<Process> allProcesses = new PriorityQueue<Process>(new ArivalTimeComparator());
        PriorityQueue<Process> queuedProcesses = new PriorityQueue<Process>(Comparator);
        result = new ArrayList<ArrayList<Integer>>(); //reassign to clear previous result
        
        for (Process process : processes) {
            allProcesses.add(process.clone());
        }
        
        for(int i = 0 ; processes.size() > i ; ++i){
            result.add(new ArrayList<>());
            result.get(i).add(processes.get(i).id);
        }

        while(queuedProcesses.size() != 0 || allProcesses.size() != 0 || currnetProcess != null){
            System.out.println("\n\n current time = " + currentTime);

            for(int i = 0 ; processes.size() > i;++i){
                result.get(i).add(0);
            }

            if(queuedProcesses.size() > 0)
                if(currnetProcess == null)
                    currnetProcess = queuedProcesses.poll();

            if(allProcesses.size() > 0)
                if(allProcesses.peek().arrivalTime == currentTime){
                    if(currnetProcess == null)
                        currnetProcess = allProcesses.poll();
                    else
                        queuedProcesses.add(allProcesses.poll());
            }

            if(currnetProcess != null){
                currnetProcess.burstTime--;
                System.out.println("current process executing is " + currnetProcess.name + " time left = " + currnetProcess.burstTime);
                result.get(currnetProcess.id).set(currentTime, 1);

                if(currnetProcess.burstTime == 0){
                    System.out.println("process " + currnetProcess.name + " finished executing");
                    currnetProcess = null;
                }
            }

            currentTime++;
        }
    }

    public void SRTF(){

    }

    public void FCAI(){

    }

    public void representInGUI(){
        new GUI(result,processes);
    }

}

// test1
// 1
// 6
// 0
// 0
// test1
// 2
// 3
// 0
// 0
// test1
// 15
// 4
// 5
// 0