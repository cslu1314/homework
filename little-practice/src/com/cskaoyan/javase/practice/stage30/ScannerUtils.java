package com.cskaoyan.javase.practice.stage30;

import java.util.Scanner;

/**
 * @author zhchch
 * @date 2021/10/18 23:07
 */
public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static Student getOneStudentInstance() {
        System.out.println("请输入要录入的学生的学号：");
        int stuId = Integer.parseInt(sc.nextLine());
        System.out.print("请输入要录入学生的姓名：");
        String name = sc.nextLine();
        System.out.print("请输入要录入学生的性别：");
        String gender = sc.nextLine();
        System.out.print("请输入要录入学生的班级：");
        String grade = sc.nextLine();
        System.out.print("请输入要录入学生的年龄：");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("请输入要录入学生的手机号：");
        String phoneNum = sc.nextLine();
        return new Student(stuId, name, gender, grade, age, phoneNum);
    }

    public static int getStuIdByScanner() {
        System.out.println("请输入要操作的学生学号：");
        return Integer.parseInt(sc.nextLine());
    }

    public static int getMenuByScanner() {
        return Integer.parseInt(sc.nextLine());
    }

    public static int getFlagByScanner() {
        return Integer.parseInt(sc.nextLine());
    }
}
