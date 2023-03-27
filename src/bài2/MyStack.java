package bài2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static Stack<String> stack = new Stack<>();
    public  static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    input();
                    break;
                case 2:
                    reverse();
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
                    }
            }
        }


    private static void reverse() {

        for (int i = 0; i <= stack.size()+1; i++) {
            System.out.print(stack.pop()+" ");
        }


    }

    private static void input() {
        System.out.println("nhập câu ");
        String string = scanner.nextLine();
        String arrString[] = string.split(" ");
        for (int i = 0; i < arrString.length; i++) {
            stack.push(arrString[i]);
        }
    }

}
