package bai3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyQueue {
    public static Queue<String> queue = new LinkedList<>();
    public static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ \n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát \n");
            System.out.println("nhap lua chon");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("nhập tên phụ huynh vao hàng chờ");
                    queue.add(scanner.nextLine());
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("không có phụ huynh tiếp theo ");
                    } else {
                        System.out.println("phụ huynh tiếp theo là : " + queue.poll());
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

