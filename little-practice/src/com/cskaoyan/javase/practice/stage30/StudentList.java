package com.cskaoyan.javase.practice.stage30;

/**
 * @author zhchch
 * @date 2021/10/18 22:57
 */
public class StudentList {
    private Student[] studs;
    private static int count = 0;

    public StudentList(int studentNum) {
        this.studs = new Student[studentNum];
    }

    //学生学号在数组中是否存在
    public boolean ifStudentIdExist(int stuId) {
        for (Student stud : studs) {
            if (stud == null) {
                continue;
            }
            if (stud.getStuId() == stuId) {
//                System.out.println("学生的Id已经存在！");
                return true;
            }
        }
        return false;
    }


    //增
    public boolean insertStudent(Student student) {
        if (ifStudentIdExist(student.getStuId())) {
            System.out.println("学生学号已存在！");
            return false;
        }

        if (StudentList.count >= studs.length) {
            System.out.println("学生数组已满！");
            return false;
        }

        for (int i = 0; i < studs.length; i++) {
            if (null == studs[i]) {
                studs[i] = student;
                System.out.println("添加学生成功！");
                StudentList.count++;
                return true;
            }
        }
        return false;
    }

    //删
    public boolean deleteStudent(int stuId) {
        if (!ifStudentIdExist(stuId)) {
            System.out.println("学生学号在数组中不存在！");
            return false;
        }
        for (int i = 0; i < studs.length; i++) {
            if (null == studs[i] || studs[i].getStuId() != stuId) {
                continue;
            }
            studs[i] = null;
            StudentList.count--;
            System.out.println("删除成功");
            break;
        }
        return true;
    }

    //改
    public boolean updateStudent(int stuId, Student student) {
        if (!ifStudentIdExist(stuId)) {
            System.out.println("学生学号在数组中不存在！");
            return false;
        }
        if (student.getStuId() != stuId) {
            for (int i = 0; i < studs.length; i++) {
                if (null == studs[i]) {
                    continue;
                }
                if (student.getStuId() == studs[i].getStuId()) {
                    System.out.println("不可以把学生学号修改成其他学生的学号");
                    return false;
                }
            }
        }
        for (int i = 0; i < studs.length; i++) {
            if (null == studs[i] || studs[i].getStuId() != stuId) {
                continue;
            }
            studs[i] = student;
            System.out.println("修改成功");
            break;
        }
        return true;
    }

    //查
    public Student searchStudent(int stuId) {
        if (!ifStudentIdExist(stuId)) {
            System.out.println("学生学号在数组中不存在！");
            return null;
        }
        for (int i = 0; i < studs.length; i++) {
            if (null == studs[i] || studs[i].getStuId() != stuId) {
                continue;
            }
            return studs[i];
        }
        return null;
    }

    public Student[] getAllStudent() {
        Student[] students = new Student[StudentList.count];
        int j = 0;
        for (int i = 0; i < studs.length; i++) {
            if (null == studs[i]) {
                continue;
            }
            students[j] = studs[i];
            j++;
        }
        return students;
    }
}
