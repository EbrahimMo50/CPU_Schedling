package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import GUIPack.GUI;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //gui test
        // List<ArrayList<Integer>> result = new ArrayList<>();
        // result.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0,0, 0, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1,0, 0, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(2, 1, 0, 1,1, 1, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(3, 0, 1, 0,0, 1, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(4, 0, 1, 0,0, 1, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(5, 0, 1, 1,0, 0, 1, 1)));
        // result.add(new ArrayList<>(Arrays.asList(6, 0, 1, 0,1, 0, 1, 1)));
        // result.add(new ArrayList<>(Arrays.asList(7, 0, 1, 0,0, 1, 1, 0)));
        // result.add(new ArrayList<>(Arrays.asList(8, 0, 1, 0,0, 0, 1, 0)));
        //  new GUI(result, Process.generateRandomProcesses(9));
        System.out.println("enter number procesess");
        int numProcesses = Integer.parseInt(scanner.nextLine());
        new Controller(numProcesses);
        scanner.close();
        //System.out.println("hello world");
    }
}