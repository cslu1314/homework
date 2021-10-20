# 今日作业的目标

> String类的常见API要记忆会使用
>
> 理解自然排序，会用lambda表达式对对象数组进行自然排序

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

- 手打可变字符串StringBuffer的API，顺带也可以学习一下StringBuilder

## 非编程题

> 简答题，以下简答

- 自己总结一下StringBuffer和StringBuilder的区别（经典面试题）

  ```
  String 类中使用 final 关键字修饰字符数组来保存字符串，private final char value[]，所以String 对象是不可变的
  StringBuilder 与 StringBuffer 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder 中也是使用字符数组保存字符串char[]value 但是没有用 final 关键字修饰，所以这两种对象都是可变的
  String 中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder 是 StringBuilder 与 StringBuffer 的公共父类，定义了一些字符串的基本操作，如 expandCapacity、append、insert、indexOf 等公共方法。StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的
  每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险！
  
  对于三者使用的总结：
  
  操作少量的数据: 适用 String
  单线程操作字符串缓冲区下操作大量数据: 适用 StringBuilder
  多线程操作字符串缓冲区下操作大量数据: 适用 StringBuffer
  ```

- 为什么String是不可变字符串？而StringBuffer和StringBuilder是可变的？

  ```
  String 类中使用 final 关键字修饰字符数组来保存字符串，private final char value[]，所以String 对象是不可变的
  
  StringBuilder 与 StringBuffer 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder 中也是使用字符数组保存字符串char[]value 但是没有用 final 关键字修饰，所以这两种对象都是可变的
  
  
  注：在 Java 9 之后，String 、StringBuilder 与 StringBuffer 的实现改用 byte 数组存储字符串 private final byte[] value
  ```

- 为什么频繁拼接字符串不推荐使用“+”号

  ```
  使用"+"对 String 类型进行拼接的时候，会创建一个String对象和原来的String对象进行拼接来生成一个新的String 对象，然后将指针指向新的 String 对象
  频繁拼接字符串，就会频繁创建对象，需要花费时间和占用内存
  
  而使用StringBuilder、StringBuffer对 String 类型进行拼接的时候，是对StringBuilder、StringBuffer对象本身进行操作，而不是生成新的对象并改变对象引用
  ```

  

- 异常的本质是什么？

  ```
  程序在运行期间出现了不正常情况，导致JVM终止程序执行，并在控制台打印异常信息。异常的主要作用是描述程序运行出错时产生的问题。（异常描述程序出了什么问题，在哪里产生的问题，为什么产生这个问题）
  
   Java异常机制的本质是,当程序出现错误时,令程序安全退出的机制。 异常处理，就是指程序在出现问题是依然可以正确执行完毕。 
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

### 自然排序练习

```
编写一个Cat类
成员变量：int age，String name，double price
按以下要求进行自然排序：
1，直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序
2，利用Comparator接口，用 匿名内部类和lambda分别对Cat数组进行自然排序
   1，按照price的大到小排序
   2，name的长短排序，name越长对象越大
   3，综合age，name，price进行排序，要求用lambda表达式指向一个方法。
		排序的规则是age越小对象越小，age相同比较name长短，name越短对象越小，name长度也相等，比较price，price越大对象越小
```

```java
package work01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhchch
 * @date 2021/10/19 18:39
 */
public class Demo {
    public static void main(String[] args) {
        Cat cat1 = new Cat(12, "花花11111111", 99.9);
        Cat cat2 = new Cat(4, "小白2222", 10.9);
        Cat cat3 = new Cat(9, "小黑3333333", 42.9);
        Cat cat4 = new Cat(5, "小蓝4", 56.9);
        Cat cat5 = new Cat(16, "小绿5555555555555", 19.9);
        Cat cat6 = new Cat(16, "小红红6666666666666666", 59.9);
        Cat cat7 = new Cat(42, "小青77777777777777777777", 89.9);
        Cat cat8 = new Cat(5, "叮当8", 119.9);
        Cat cat9 = new Cat(9, "喵喵99999", 69.9);
        Cat cat10 = new Cat(12, "嘻嘻10101010", 79.9);

        Cat[] cats = {cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10};

        System.out.println("########################################猫数组原始数据#######################################");
        System.out.println(Arrays.toString(cats));
        System.out.println("############################################################################################\n");


        System.out.println("===============一、直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序===============");
        Arrays.sort(cats);
        System.out.println(Arrays.toString(cats));


        System.out.println("============二、利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序===============");

        System.out.println("--------------------------2.1利用Comparator接口，按照price从大到小排序----------------------");
        Arrays.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        System.out.println(Arrays.toString(cats));

        System.out.println("--------------------------2.2利用lambda表达式，按照name长短排序，长name排在前面--------------");
        Arrays.sort(cats, (c1, c2) -> c2.getName().length() - c1.getName().length());
        System.out.println(Arrays.toString(cats));

        System.out.println("--------------------------2.2综合age，name，price进行排序，要求用lambda表达式指向一个方法--------------");
        Arrays.sort(cats,Demo::sortByAgeNamePrice);
        System.out.println(Arrays.toString(cats));

    }


    //排序的规则是age越小对象越小，age相同比较name长短，name越短对象越小，name长度也相等，比较price，price越大对象越小
    public static int sortByAgeNamePrice(Cat cat1, Cat cat2) {
        if (cat1.getAge() != cat2.getAge()) {
            return cat1.getAge() - cat2.getAge();
        }
        if(cat1.getName().length()!= cat2.getName().length()){
            return cat1.getName().length() - cat2.getName().length();
        }
        return Double.compare(cat2.getPrice(), cat1.getPrice());
    }
}


class Cat implements Comparable {
    private int age;
    private String name;
    private double price;

    public Cat() {
    }

    public Cat(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    //实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序
    @Override
    public int compareTo(Object o) {
        Cat cat = (Cat) o;
        return this.getAge() - cat.getAge();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

```
输出结果：
########################################猫数组原始数据#######################################
[Cat{age=12, name='花花11111111', price=99.9}
, Cat{age=4, name='小白2222', price=10.9}
, Cat{age=9, name='小黑3333333', price=42.9}
, Cat{age=5, name='小蓝4', price=56.9}
, Cat{age=16, name='小绿5555555555555', price=19.9}
, Cat{age=16, name='小红红6666666666666666', price=59.9}
, Cat{age=42, name='小青77777777777777777777', price=89.9}
, Cat{age=5, name='叮当8', price=119.9}
, Cat{age=9, name='喵喵99999', price=69.9}
, Cat{age=12, name='嘻嘻10101010', price=79.9}
]
############################################################################################

===============一、直接实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序===============
[Cat{age=4, name='小白2222', price=10.9}
, Cat{age=5, name='小蓝4', price=56.9}
, Cat{age=5, name='叮当8', price=119.9}
, Cat{age=9, name='小黑3333333', price=42.9}
, Cat{age=9, name='喵喵99999', price=69.9}
, Cat{age=12, name='花花11111111', price=99.9}
, Cat{age=12, name='嘻嘻10101010', price=79.9}
, Cat{age=16, name='小绿5555555555555', price=19.9}
, Cat{age=16, name='小红红6666666666666666', price=59.9}
, Cat{age=42, name='小青77777777777777777777', price=89.9}
]
============二、利用Comparator接口，用匿名内部类和lambda分别对Cat数组进行自然排序===============
--------------------------2.1利用Comparator接口，按照price从大到小排序----------------------
[Cat{age=5, name='叮当8', price=119.9}
, Cat{age=12, name='花花11111111', price=99.9}
, Cat{age=42, name='小青77777777777777777777', price=89.9}
, Cat{age=12, name='嘻嘻10101010', price=79.9}
, Cat{age=9, name='喵喵99999', price=69.9}
, Cat{age=16, name='小红红6666666666666666', price=59.9}
, Cat{age=5, name='小蓝4', price=56.9}
, Cat{age=9, name='小黑3333333', price=42.9}
, Cat{age=16, name='小绿5555555555555', price=19.9}
, Cat{age=4, name='小白2222', price=10.9}
]
--------------------------2.2利用lambda表达式，按照name长短排序，长name排在前面--------------
[Cat{age=42, name='小青77777777777777777777', price=89.9}
, Cat{age=16, name='小红红6666666666666666', price=59.9}
, Cat{age=16, name='小绿5555555555555', price=19.9}
, Cat{age=12, name='花花11111111', price=99.9}
, Cat{age=12, name='嘻嘻10101010', price=79.9}
, Cat{age=9, name='小黑3333333', price=42.9}
, Cat{age=9, name='喵喵99999', price=69.9}
, Cat{age=4, name='小白2222', price=10.9}
, Cat{age=5, name='叮当8', price=119.9}
, Cat{age=5, name='小蓝4', price=56.9}
]
--------------------------2.2综合age，name，price进行排序，要求用lambda表达式指向一个方法--------------
[Cat{age=4, name='小白2222', price=10.9}
, Cat{age=5, name='叮当8', price=119.9}
, Cat{age=5, name='小蓝4', price=56.9}
, Cat{age=9, name='喵喵99999', price=69.9}
, Cat{age=9, name='小黑3333333', price=42.9}
, Cat{age=12, name='花花11111111', price=99.9}
, Cat{age=12, name='嘻嘻10101010', price=79.9}
, Cat{age=16, name='小绿5555555555555', price=19.9}
, Cat{age=16, name='小红红6666666666666666', price=59.9}
, Cat{age=42, name='小青77777777777777777777', price=89.9}
]

Process finished with exit code 0
```



### 日期类练习

> 自学一下Date日期类，完成练习

```
制作一个工具类，算一下你来到这个世界多少天?
```

```java
package work02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author zhchch
 * @date 2021/10/19 19:24
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        while (true) {
            int daysOfYou = CalcDays.getDaysOfYou();

            if (daysOfYou == -1) {
                System.out.println("你输入的是未来的时间，你将会在未来出生:)");
            } else {
                System.out.println("你已经出生了" + daysOfYou + "天");
            }
            System.out.println();
        }
    }
}

class CalcDays {
    private static Scanner sc = new Scanner(System.in);

    private CalcDays() {
    }

    public static int getDaysOfYou() throws ParseException {
        System.out.println("请输入你的出生日期，格式是yyyy.MM.dd:");
        String birthday = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        //使用sdf把你输入的字符串转换成Date对象(即你的出生日期)
        Date parseBirthday = sdf.parse(birthday);
        //当前Date
        Date currentDate = new Date();

        //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
        long currentDateTime = currentDate.getTime();
        long parseBirthdayTime = parseBirthday.getTime();
        //时间差
        long seconds = currentDateTime - parseBirthdayTime;
        if (seconds < 0) {
            return -1;
        }
        return (int) (seconds / 1000 / 60 / 60 / 24);
    }
}
```

```
输出结果：

请输入你的出生日期，格式是yyyy.MM.dd:
2022.1.1
你输入的是未来的时间，你将会在未来出生:)

请输入你的出生日期，格式是yyyy.MM.dd:
2021.10.18
你已经出生了1天

请输入你的出生日期，格式是yyyy.MM.dd:
2021.10.19
你已经出生了0天

请输入你的出生日期，格式是yyyy.MM.dd:
2021.10.20
你输入的是未来的时间，你将会在未来出生:)

请输入你的出生日期，格式是yyyy.MM.dd:
2021.1.1
你已经出生了291天
```



### 对象不可变性理解

> 结合String的不可变性，以Integer包装类为例，理解包装类的不可变性
>
> 课考虑查看源码，看一看包装类怎么存放它们基本数据类型的数值的

 答：包装类的底层是通过一个final修饰的变量来存放数据(`private final int value`)，所以每一个包装类对象也具有不可变性，
  当修改它的值时，就创建了一个新的对象，让原来的包装类的引用指向这个新对象，而原来的对象没有发生变化



- 结合Java的值传递，当方法传入String或者包装类对象时
  
  - 请问方法能否改变它们的取值（内容）
  
    答：方法不能改变它们的值，见以下程序

```java
package work03;

/**
 * @author zhchch
 * @date 2021/10/19 19:54
 */
public class Demo {
    public static void main(String[] args) {
        Integer value = new Integer("1");
        System.out.println("value = " + value);
        System.out.println("-----------调用changeWrapClass(value)：----------");
        changeWrapClass(value);
        System.out.println("--------after调用changeWrapClass(value)：-------");
        System.out.println("value = " + value);
    }

    public static Integer changeWrapClass(Integer value) {
        value = value + 2;
        System.out.println("value = " + value);
        return value;
    }
}
```

```
输出结果：
value = 1
-----------调用changeWrapClass(value)：----------
value = 3
--------after调用changeWrapClass(value)：-------
value = 1

Process finished with exit code 0
```



### 小项目阶段5

```
根据阶段5文档，完成设计
```



## 预习问题

> 预习的题目仅为预习提供思路，不用表现在作业中

- 预习File类，思考如下问题
  - File类是什么？它就代表一个真实存在的文件吗？