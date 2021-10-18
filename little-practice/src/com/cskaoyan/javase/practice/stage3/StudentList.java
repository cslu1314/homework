package com.cskaoyan.javase.practice.stage3;

/**
 * @author zhchch
 * @date 2021/10/14 9:05
 */
public class StudentList {
    private Student[] studList;
    private static int count = 0;

    //私有化无参构造，禁止使用无参构造造成学生数组未初始化
    private StudentList() {
    }

    public StudentList(int stuNums) {
        this.studList = new Student[stuNums];
    }

    //新增学生
    public boolean insertStudent(Student student) {
        for (int i = 0; i < studList.length; i++) {
            if (null == studList[i]) {
                studList[i] = student;
                //新增学生后，学生总数加1
                StudentList.count++;
                return true;
            }
        }
        return false;
    }

    //根据学号删除学生
    public boolean deleteStudent(int targetId) {
        for (int i = 0; i < studList.length; i++) {
            if (null == studList[i]) {
                continue;
                //新增学生后，学生总数加1
            }
            if (studList[i].getStuId() == targetId) {
                studList[i] = null;
                StudentList.count--;
                return true;
            }
        }
        return false;
    }

    //根据学号更改学生信息
    public boolean updateStudent(int targetStuId, Student updateStu) {
        int targetIndex = getIndex(targetStuId);
        if (-1 == targetIndex) {
            return false;
        }
        studList[targetIndex] = updateStu;
        return true;
    }

    //查找某个学生
    public Student retrieveStudent(int targetStuId) {
        //先查看targetStuId是否存在
        int targetIndex = getIndex(targetStuId);
        if (-1 == targetIndex) {
            //学号不存在
            return null;
        }
        return studList[targetIndex];
    }

    //通过传入的学号查找下标返回 -1 表示该学号在学生数组中不存在
    private int getIndex(int targetStuId) {
        int index = -1;
        for (int i = 0; i < studList.length; i++) {
            Student student = studList[i];
            if (null != student && student.getStuId() == targetStuId) {
                index = i;
                break;
            }
        }
        return index;
    }


    //返回学生列表
    //不会返回null
    public Student[] getAllStudent() {
        if (null == studList || 0 == studList.length) {
            return new Student[0];
        }
        Student[] returnStudList = new Student[StudentList.count];
        int j = 0;
        for (int i = 0; i < studList.length; i++) {
            if (null != studList[i]) {
                returnStudList[j] = studList[i];
                j++;
            }
        }
        return returnStudList;
    }

    //判断学号在数组中是否已经存在，true表示学号在数组中不存在
    //false表示学号在数组中已经存在
    public boolean judgeStuIdLegal(int targetStuId) {
        for (int i = 0; i < studList.length; i++) {
            if (null == studList[i]) {
                continue;
            }
            if (targetStuId == studList[i].getStuId()) {
                return false;
            }
        }
        return true;
    }

    //查找数组中是否存在对应的学号   ture表示存在  false表示不存在
    public boolean judgeStuIdExist(int targetStuId) {
        for (int i = 0; i < studList.length; i++) {
            if (null == studList[i]) {
                continue;
            }
            if (targetStuId == studList[i].getStuId()) {
                return true;
            }
        }
        return false;
    }
}
