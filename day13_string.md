# 今日作业的目标

> 掌握对对象进行克隆，理解深度克隆的原理，理解String对象不可变性以及常量池

**完成作业后，需要将md文件转换成PDF格式，并命名为当天的课程名+下划线+自己的名字！压缩后提交！**

- 可以通过查看共享目录下，课程资料中**dayXx_Xxx**就是课程名
- 下划线不要弄错了，不能是空格或者横杠
- 下划线后跟自己的名字，不要在名字后面添一些乱七八糟的东西，如pdf后缀名
- 必须压缩后提交，压缩格式不限，rar、7z等等都可以
- 以上格式满足后，就可以提交作业了

```
提交作业的网址（局域网内网网站）：
	http://192.168.2.100:8080/upload/java/..th
链接最后的“..th”表示班级的期数，比如你是Java28期学生，这里就填入28th

一般来说，打开这个网站对浏览器种类没有特别的要求，仅建议不要直接使用微信自带浏览器
需要注意的是，如果多次重复提交某一天的作业，必须保持名字不同
	建议在“课程名+下划线+自己的名字”的后面加上2，3...之类的数字以示区分
```



## 操作题

> 操作题，无需表现在作业答案中，自己琢磨和练习即可

- 尝试写一个Student类，然后定义一些私有成员变量
  - 然后快速生成所有的方法
  
  - 练习使用alt+insert快捷键
  
    ```java
    package work01;
    
    import java.util.Objects;
    
    /**
     * @author zhchch
     * @date 2021/10/18 19:22
     */
    public class Demo {
        public static void main(String[] args) {
    
        }
    }
    
    class Student {
        int age;
        String name;
        String gender;
    
        public Student() {
        }
    
        public Student(int age, String name, String gender) {
            this.age = age;
            this.name = name;
            this.gender = gender;
        }
    
        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return getAge() == student.getAge() &&
                    Objects.equals(getName(), student.getName()) &&
                    Objects.equals(getGender(), student.getGender());
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(getAge(), getName(), getGender());
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getGender() {
            return gender;
        }
    
        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    ```
  
    

## 非编程题

> 简答题，以下简答

- 尝试解释String对象不可变，字符串常量池的概念

  ```
  一旦创建了 String 对象，那它的值就无法改变了
  String类中用于存放字符的数组是被声明为final的，因此只能赋值一次，不可再更改指向
  ```

- 深度克隆的步骤

  ```
  深度克隆是在浅克隆基础上完成
  a.将引用指向的对象，再克隆一份
  b.然后让克隆后的引用指向它
  ```

  

## 编程题

编程题的答题要求：

```
编程题，需要先编写代码，执行调试完毕后
将代码以代码块（CTRL+A贴入整个Java文件内容，而不是一个main方法）的格式贴入md文件
并附上执行结果图片
```

**如何在Typora中插入代码块？**

1. 可以直接从idea复制代码，然后粘贴进md文档，Typora会自动转换成代码块的格式
2. 可以在md文档空白处中右键，然后插入代码块，再把代码复制进来（熟练了可以使用快捷键）
3. 代码块右下角可以选择语言，建议直接填入Java（这样做会有颜色标记关键字）

**如何在Typora中插入图片？**

1. 可以使用微信/QQ/windows/Snipaste截图等截图工具截图到计算机粘贴板，然后直接粘贴到md文档中
2. 可以在md文档空白处中右键，然后插入图像，自己选择本地图片的路径（可以用，但不推荐）

---



### 敲一遍老师上课的代码

> 根据老师在每一个Demo类注释的头部写的问题，逐一敲一遍老师的代码
>
> 尤其是那些不知道该怎么下手做作业的同学，一定要认真敲一遍老师代码

- **敲一下Object类的API**
- **敲一下Object类的API**



### equals方法

```
定义一个Animal类
成员变量：
	int age,String name,double price
手写它的equals方法，比较getClass和instanceof的区别
```

```java
package work02;

import java.util.Objects;

/**
 * @author zhchch
 * @date 2021/10/18 19:36
 */
public class Animal {
    int age;
    String name;
    double price;

    public Animal() {
    }

    public Animal(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    //重写equals方法之instanceof
//    @Override
//    public boolean equals(Object obj) {
//        //1.满足自反性,自己和自己比,返回true
//        if (this == obj) return true;

//        //2.排他性
//        //instanceof
//        if (!(obj instanceof Animal)) {
//            return false;
//        }

//        // 3.对称性,一致性,传递性只需要按照成员变量的取值判断对象相等就自动满足
//        Animal animal = (Animal) obj;
//        if (this.age != animal.age
//                || !this.name.equals(animal.name)
//                || Double.compare(this.price, animal.price) != 0) {
//            return false;
//        }

//        return true;
//    }


    //重写equals方法之getClass
    @Override
    public boolean equals(Object obj) {
        //1.满足自反性,自己和自己比,返回true
        if (this == obj) return true;

        //2.排他性
        //getClass
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // 3.对称性,一致性,传递性只需要按照成员变量的取值判断对象相等就自动满足
        Animal animal = (Animal) obj;
        if (this.age != animal.age
                || !this.name.equals(animal.name)
                || Double.compare(this.price, animal.price) != 0) {
            return false;
        }

        return true;
    }
}
```

```
getClass和instanceof的区别:
getClass比较两个引用的类型,它是比较苛刻的,只有在完全是同一个类型时才会返回true

引用 instanceof 类名  表示判断引用所指向的对象的具体类型是否是后面类名的对象或者子类对象,如果是就返回true,如果不是就返回false.如果引用指向null,不管类名写什么都返回false
当使用instanceof判断引用类型时,条件比较宽松,可以允许传入子类对象
```



### 深度克隆练习

> String也是引用数据类型，它需要深度克隆吗？

String对象不可变,所以无需再进行深度克隆,可以直接克隆

```
分别定义以下类：
教师类Teacher
属性：int age;String name;Student stu
学生类Student
属性：int age；String name；Star s
明星类Star
属性：int age，String name

尝试完成Teacher对象的深度克隆，并写代码进行测试
```

```java
package work03;

/**
 * @author zhchch
 * @date 2021/10/18 20:11
 */
public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher(30, "张三", new Student(18, "李四", new Star(11, "王五")));
        System.out.println(teacher);
        Teacher cloneTeacher = teacher.clone();
        System.out.println(cloneTeacher);
        System.out.println("===========================================================================================");
        System.out.println(teacher == cloneTeacher);
        System.out.println(teacher.stu == cloneTeacher.stu);
        System.out.println(teacher.stu.s == cloneTeacher.stu.s);
    }
}

class Teacher implements Cloneable {
    int age;
    String name;
    Student stu;

    public Teacher() {
    }

    public Teacher(int age, String name, Student stu) {
        this.age = age;
        this.name = name;
        this.stu = stu;
    }

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        //1.深度克隆是在浅克隆基础上完成，先使用原来的Teacher clone出一个cloneTeacher
        Teacher cloneTeacher = (Teacher) super.clone();
        //2.再使用cloneTeacher中的stu克隆一份cloneStudent对象
        Student cloneStudent = cloneTeacher.stu.clone();
        //3.将克隆的cloneTeacher对象含有cloneStudent对象，而不是stu
        cloneTeacher.stu = cloneStudent;
        //4.返回cloneTeacher
        return cloneTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", stu=" + stu +
                '}';
    }
}

class Student implements Cloneable {
    int age;
    String name;
    Star s;

    public Student() {
    }

    public Student(int age, String name, Star s) {
        this.age = age;
        this.name = name;
        this.s = s;
    }


    @Override
    protected Student clone() throws CloneNotSupportedException {
        //1.深度克隆是在浅克隆基础上完成，先使用student clone出一份cloneStudent
        Student cloneStudent = (Student) super.clone();
        //2.克隆一份Star对象
        Star cloneStar = this.s.clone();
        //3.将克隆的cloneStudent对象含有cloneStar对象，而不是this.s
        cloneStudent.s = cloneStar;
        return cloneStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", s=" + s +
                '}';
    }
}

class Star implements Cloneable {
    int age;
    String name;

    public Star() {
    }

    public Star(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Star clone() throws CloneNotSupportedException {
        //浅clone即可,因为它是别人含有的对象，且它没有引用对象
        return (Star) super.clone();
    }

    @Override
    public String toString() {
        return "Star{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```

```
运行结果：
Teacher{age=30, name='张三', stu=Student{age=18, name='李四', s=Star{age=11, name='王五'}}}
Teacher{age=30, name='张三', stu=Student{age=18, name='李四', s=Star{age=11, name='王五'}}}
===========================================================================================
false
false
false

Process finished with exit code 0
```



### 字符串的练习

```
统计大串中小串出现的次数

举例：
在字符串”woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”
中java出现了5次
提示：可以考虑使用indexOf方法，仅考虑本题举出的字符串，无需复杂考虑
```

```java
package work04;

/**
 * @author zhchch
 * @date 2021/10/18 20:44
 */
public class Demo {
    public static void main(String[] args) {
        String str = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        System.out.println(getNumOfJavaInBigStr(str,"java"));
    }

    public static int getNumOfJavaInBigStr(String BigStr, String smallStr) {
        int count = 0, index = 0;
        boolean flag = true;
        while (flag) {
            //int indexOf(String str,int fromIndex) 这个方法从大字符串的index下标开始查询小字符串 并返回查找到小字符串的最小下标 如果没找到返回-1
            if (-1 != BigStr.indexOf(smallStr, index)) {
                count++;
                //下一次查找的起始下标
                index = BigStr.indexOf(smallStr, index) + 1;
                continue;
            }
            //没有找到则终止循环
            flag = false;
        }
        return count;
    }
}
```

```
输出结果：

5

Process finished with exit code 0
```



### 小项目阶段4

```
根据阶段4文档，完成代码
```



## 预习问题

> 预习的题目仅为预习提供思路，不用表现在作业中

- 预习自然排序和异常，思考如下问题
  - 自然排序牵扯到lambda表达式的使用，可以率先看一下
  - 异常是什么？异常的本质是什么？