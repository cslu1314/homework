package com.cskaoyan.javase.practice.stage30;

import java.util.Scanner;

/**
 * @author zhchch
 * @date 2021/10/14 19:36
 */
public class Demo {
    private StudentList studentList;

    public Demo() {
        studentList = new StudentList(5);
        Student s1 = new Student(1, "张三", "男", "Java36th", 20, "18888888888");
        Student s2 = new Student(2, "李四", "女", "Java36th", 28, "17777777777");
        //调用方法 加进数组中
        studentList.insertStudent(s1);
        studentList.insertStudent(s2);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
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
                    //学生列表
                    consoleGetAllStudent();
                    break;
                case 2:
                    //插入学生
                    consoleInsertStudent();
                    break;
                case 3:
                    //删除学生
                    consoleDeleteStudent();
                    break;
                case 4:
                    //修改学生信息
                    consoleUpdateStudent();
                    break;
                case 5:
                    //查询学生信息
                    consoleRetrieveStudent();
                    break;
                case 6:
                    System.out.println("确认退出吗（1/2）");
                    int input = ScannerUtils.getFlagByScanner();
                    if (input == 1) {
                        System.out.println("感谢使用本系统！");
                        flag = false;
                        break;
                    }
                    System.out.println("欢迎继续使用本系统！");
                    break;
            }
        }
    }

    private void consoleGetAllStudent() {
        System.out.println("==================学生列表==================");
        Student[] allStudent = studentList.getAllStudent();
        if (null == allStudent || 0 == allStudent.length) {
            return;
        }
        System.out.println("学号\t姓名\t性别\t年级\t\t\t年龄\t\t电话号码");
        for (int i = 0; i < allStudent.length; i++) {
            allStudent[i].printStudent();
        }
    }

    private void consoleInsertStudent() {
        System.out.println("===================增加学生===================");
        Student studentInstanceByScanner = ScannerUtils.getOneStudentInstance();
        if (studentList.insertStudent(studentInstanceByScanner)) {
            return;
        }
        System.out.println("增加学生失败！");
    }

    private void consoleDeleteStudent() {
        System.out.println("===================删除学生===================");
        int stuId = ScannerUtils.getStuIdByScanner();
        if (studentList.deleteStudent(stuId)) {
            return;
        }
        System.out.println("删除学生失败！");
    }

    private void consoleUpdateStudent() {
        System.out.println("===================修改学生===================");
        int targetStuId = ScannerUtils.getStuIdByScanner();
        if (!studentList.ifStudentIdExist(targetStuId)) {
            System.out.println("学生的Id在数组中不存在！");
            return;
        }
        System.out.println("请输入要把该学生修改成的学生信息：");
        Student student = ScannerUtils.getOneStudentInstance();
        if (studentList.updateStudent(targetStuId, student)) {
            System.out.println("学生信息修改成功!");
            return;
        }

    }


    private void consoleRetrieveStudent() {
        System.out.println("===================查询学生===================");
        int targetStuId = ScannerUtils.getStuIdByScanner();
        Student targetStudent = studentList.searchStudent(targetStuId);
        if (targetStudent == null) {
            System.out.println("未查找到该学号的学生!");
            return;
        }
        System.out.println("学号\t姓名\t性别\t\t年级\t\t年龄\t\t电话号码");
        targetStudent.printStudent();
    }

    public void printSystemMenu() {
        System.out.println("-------------王道学生管理系统------------");
        System.out.println("             1.学生列表");
        System.out.println("             2.增加学生");
        System.out.println("             3.删除学生");
        System.out.println("             4.修改学生");
        System.out.println("             5.查询学生");
        System.out.println("             6.退出系统");
    }
}
