package com.cskaoyan.javase.practice.stage2;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级学生个数：");

        StudentsManagementSystem studentsManagementSystem = new StudentsManagementSystem(Integer.parseInt(sc.next()));
        studentsManagementSystem.start();
    }
}

class StudentsManagementSystem {
    String[] students;
    int stuCount;

    public StudentsManagementSystem() {
    }

    public StudentsManagementSystem(int stuCount) {
        this.stuCount = stuCount;
        this.students = new String[stuCount];
    }

    public void printSystemMenu() {
        System.out.println("-----------王道学生管理系统------------");
        System.out.println("            1.学生列表");
        System.out.println("            2.增加学生");
        System.out.println("            3.删除学生");
        System.out.println("            4.修改学生");
        System.out.println("            5.查询学生");
        System.out.println("            6.退出系统");
    }

    public void printStuList() {
        System.out.println("===============学生列表start===============");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i]);
            }
        }
        System.out.println("===============学生列表end=================");
    }

    //插入学生
    public void insertStudent(String stu) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = stu;
                System.out.println("插入成功！");
                return;
            }
        }
        System.out.println("学生列表已满！插入失败！");
    }


    //删除学生
    public void deleteStudent(String stu) {
        for (int i = 0; i < students.length; i++) {
            if (stu.equals(students[i])) {
                students[i] = null;
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("学生列表中不存在该学生！删除失败！");
    }

    //修改学生信息
    public void updateStudent(String stu) {
        for (int i = 0; i < students.length; i++) {
            if (stu.equals(students[i])) {
                System.out.println("请输入新的学生姓名：");

                students[i] = new Scanner(System.in).next();
                System.out.println("修改成功！");
                return;
            }
        }
        System.out.println("学生列表中不存在该学生！修改失败！");
    }

    //查找学生信息
    public int searchStudent(String stu) {
        for (int i = 0; i < students.length; i++) {
            if (stu.equals(students[i])) {
                return i;
            }
        }
        System.out.println("学生列表中不存在该学生！");
        return -1;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int select;
        boolean flag = true;
        while (flag) {
            printSystemMenu();
            System.out.println("请选择功能（1-6）：");
            select = Integer.parseInt(sc.next());
            switch (select) {
                case 1:
                    printStuList();
                    break;
                case 2:
                    System.out.println("请输入学生姓名：");
                    insertStudent(sc.next());
                    break;
                case 3:
                    System.out.println("请输入学生姓名：");
                    deleteStudent(sc.next());
                    break;
                case 4:
                    System.out.println("请输入学生姓名：");
                    updateStudent(sc.next());
                    break;
                case 5:
                    System.out.println("请输入学生姓名：");
                    int i = searchStudent(sc.next());
                    if (-1 != i) {
                        System.out.println("该学生的下表是；" + i);
                    }
                    break;
                case 6:
                    System.out.println("确认退出吗（1/2）");
                    int input = Integer.parseInt(sc.next());
                    if (input == 1) {
                        System.out.println("感谢使用本系统！");
                        flag = false;
                    }
                    break;
            }
        }
    }
}

