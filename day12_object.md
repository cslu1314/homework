# 今日作业的目标

> 熟悉匿名内部类和lambda表达式的使用，手敲一敲Object类的方法

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

待补充！

## 非编程题

> 简答题，以下简答

- 什么是功能接口
  - 功能接口中只能有一个方法吗
  
    ```
    不是，功能接口中只有一个必须要实现的抽象方法
    Java8中的默认方法和静态方法不需要子类实现,功能接口中可以允许有它们存在
    ```
  
  - 功能接口中只能有一个抽象方法吗
  
    ```
    不是,有些抽象方法在子类实现接口时不需要去实现
    例如，在java中,任何类都会继承Object,那么如果抽象方法是Object类当中已经存在实现的方法,那么就无须实现类去实现它,而是可以直接将Object类方法作为实现
    ```
  
- 描述一下运行时Class对象

  ```
  JVM在类加载一个类的同时,在堆上会自动生成该类的运行时类对象,也就是Class对象
  Class对象当中,包含了该类的所有类型信息(比如类名是啥,在哪个包,有哪些方法,有哪些变量等)
  一个类的类加载只有一次,同一个类型的运行时Class对象也只有一个，运行时类Class对象只有一个,而类的对象可以有无数个
  ```

- Object类是什么？

  ```
  Object类是所有类继承层次的祖先类，所有类（包括数组）都直接或者间接的继承自该类，都实现了该类的方法
  
  Object的成员方法：
    public final Class getClass()是了解java反射的前置知识点
    public String toString()
    public boolean equals(Object obj) 最重要的三个方法,是非常常用的
    public int hashCode()
    protected void finalize() 不重要,也没用,但是可以作为了解(GC和java垃圾回收缺点的方法)
    protected Object clone() 它不算是一个常用的方法,但是它又很重要,因为对象的克隆在有些时候是很重要的操作，并且clone方法比较复杂
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

- 敲一下lambda表达式的使用



### lambda表达式的练习

> lambda表达式的书写，除了注意格式外，最重要的是关注类型推断

- 提供以下6个功能接口，请用lambda表达式分别创建对象，调用test()方法
- 自由发挥lambda表达式的书写

```java 
//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}
```

```java
package work01;

import java.util.Scanner;

/**
 * @author zhchch
 * @date 2021/10/16 14:24
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("===========无返回值无参数的功能接口============");
        INoReturnNoParam iNoReturnNoParam = () -> System.out.println("hello lambda!");
        iNoReturnNoParam.test();
        INoReturnNoParam iNoReturnNoParam1 = System.out::println;
        iNoReturnNoParam1.test();

        System.out.println("============无返回值有一个参数的功能接口===========");
        INoReturnOneParam iNoReturnOneParam = a -> System.out.println(a);
        iNoReturnOneParam.test(1);
        INoReturnOneParam iNoReturnOneParam1 = System.out::println;
        iNoReturnOneParam1.test(2);

        System.out.println("============无返回值两个参数的功能接口============");
        INoReturnTwoParam iNoReturnTwoParam = (a, b) -> {
            System.out.println("hello lambda!");
            System.out.println(a + "+" + b + "=" + (a + b));
        };
        iNoReturnTwoParam.test(2, 3);
        INoReturnTwoParam iNoReturnTwoParam1 = Demo::noReturnTwoParam;
        iNoReturnTwoParam1.test(3, 5);

        System.out.println("==================有返回值无参数的功能接口=================");
        new Demo().testHasReturnNoParam(() -> {
            System.out.println("hello lambda, hasReturnNoParam");
            return -1;
        });
        new Demo().testHasReturnNoParam(new Demo()::hasReturnNoParam);

        System.out.println("==================有返回值一个参数的功能接口===============");
        IHasReturnOneParam iHasReturnOneParam = a -> {
            System.out.println("hello lambda, hasReturnOneParam");
            return a + 1;
        };
        int method = iHasReturnOneParam.method(8);
        System.out.println(method);
        System.out.println("==================有返回值两个参数的功能接口===============");
        new Demo().testHasReturnTwoParam(new Demo()::hasReturnTwoParam);
    }

    public static void noReturnTwoParam(int c, int d) {
        System.out.println("static: hello lambda!");
        System.out.println(c + "+" + d + "=" + (d + c));
    }

    private int hasReturnNoParam() {
        System.out.println("hasReturnNoParam");
        return 1;
    }

    public void testHasReturnNoParam(IHasReturnNoParam iHasReturnNoParam) {
        int test = iHasReturnNoParam.test();
        System.out.println(test);
    }

    public void testHasReturnTwoParam(IHasReturnTwoParam iHasReturnTwoParam) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("请输入第二个整数：");
        int b = Integer.parseInt(sc.nextLine());
        int test = iHasReturnTwoParam.test(a, b);
        System.out.println(test);
    }

    public int hasReturnTwoParam(int a, int b) {
        System.out.println("hello lambda, hasReturnTwoParam");
        return (a + b);
    }

}

//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}
```

```
输出结果：
===========无返回值无参数的功能接口============
hello lambda!

============无返回值有一个参数的功能接口===========
1
2
============无返回值两个参数的功能接口============
hello lambda!
2+3=5
static: hello lambda!
3+5=8
==================有返回值无参数的功能接口=================
hello lambda, hasReturnNoParam
-1
hasReturnNoParam
1
==================有返回值一个参数的功能接口===============
hello lambda, hasReturnOneParam
9
==================有返回值两个参数的功能接口===============
请输入第一个整数：
8
请输入第二个整数：
9
hello lambda, hasReturnTwoParam
17

Process finished with exit code 0
```

**今天先学会使用匿名内部类和lambda表达式，具体详细的有哪些用途，后面会碰到**

- 如果实在感兴趣想知道，你也可以自己搜一搜，Java**对象数组的排序**



### lambda表达式的练习

```
定义一个计算（compute）接口,接口中有加减乘除四个抽象方法。
然后使用匿名内部类去实现加减乘除并测试
```

上述功能，昨天已经实现了，今天考虑用lambda改进它，如下：

- 做完以上需求后，可以考虑用以下功能接口，实现一个计算器的工具类
- 在工具类中，只需要一个工具方法，就能够实现所有的计算功能

```Java
@FunctionalInterface
interface Compute {
    double compute(double a, double b);
}
```

提示：

```java 
//需要提供一个使用功能接口的方法完成需求
class ComputeTool {
    private ComputeTool() {
    }

    public static void calc(Compute com, double a, double b) {
        //...
    }
}
```

```java
package work02;

/**
 * @author zhchch
 * @date 2021/10/16 15:27
 */
public class ComputeTool {
    private ComputeTool() {
    }

    public static void calc(Compute com, double a, double b) {
        com.compute(a, b);
    }
}

class Demo {
    public static void main(String[] args) {
        ComputeTool.calc(new Computer()::sum, 3, 4);
        ComputeTool.calc(new Computer()::sub, 5, 6);
        ComputeTool.calc(new Computer()::mul, 7, 8);
        ComputeTool.calc(new Computer()::div, 9, 10);

    }
}

@FunctionalInterface
interface Compute {
    void compute(double a, double b);
}

class Computer {
    void sum(double a, double b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    void sub(double a, double b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    void mul(double a, double b) {
        System.out.println(a + " × " + b + " = " + (a * b));
    }

    void div(double a, double b) {
        System.out.println(a + " ÷ " + b + " = " + (a / b));
    }
}
```

```
输出结果：
3.0 + 4.0 = 7.0
5.0 - 6.0 = -1.0
7.0 × 8.0 = 56.0
9.0 ÷ 10.0 = 0.9

Process finished with exit code 0
```



### getClass()方法练习

> 定义两个类，然后分别创建对象，调用getClass方法
>
> 用“==”号比较它们的运行时Class对象是否相等，并说明原因
>
> 理解运行时类对象、类加载、类的对象的区别

```java
package work03;

/**
 * @author zhchch
 * @date 2021/10/16 15:42
 */
public class Demo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Class catClass = cat.getClass();
        Class dogClass = dog.getClass();
        System.out.println(catClass == dogClass);
    }
}
class Cat{}
class Dog{}
```

```
输出结果：
falsefalse

Process finished with exit code 0
```

```
运行时类Class对象只有一个,而类的对象可以有无数个
很多时候我们把类的运行时类对象,称之为"类对象"
而具体的类的对象,称之为"类的对象"

类加载的触发
       类加载它的触发机制是"懒加载",只有等到必须要类加载时JVM才会类加载一个类(不加载已经不行了)
       我们把一定会触发类加载的情况称之为"类加载的时机"
 类加载的时机:
       a.创建对象,会触发该类的类加载
       b.启动一个类的main方法,会触发该类的类加载
  在一次程序的运行过程中,不论什么情况触发了类加载,一个类的类加载都仅有一次
```



# <font color=red>周末了，好好休息一下吧，有对象就出去玩一玩，没有就new一个吧 </font>





### 四、预习问题

> 预习的题目仅为预习提供思路，不用表现在作业中

- 预习Object类的clone()方法，思考以下问题
  - Object类的API自己尝试敲一敲
- 预习String类的
  - 可以自己敲一敲String的常用API