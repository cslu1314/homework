# 今日作业的目标

> 今日的需要自己总结、复习一下前面的知识，理解属性隐藏和方法覆盖

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

自行测试方法的重写中，子类方法的要求（使用@Override注解测试重写语法是否正确）

## 非编程题

> 以下简答题，请回答

- 简答1：方法覆盖的条件
  - 问题1: 哪些方法是无法发生方法覆盖?
  
    ```
    private修饰的方法
    静态方法
    构造方法
    ```
  
    
  
  - 问题2: 方法覆盖时子类的方法返回值并不要求完全一致而是兼容,请测试后详细描述。
  
    ```
    在返回值为引用数据类型时，子类方法的返回值可以是父类方法返回值的子类或者和父类方法的返回值类型相同
    在返回值为基本数据类型时，子类方法的返回值必须和父类方法的返回值类型相同
    ```
  
    
- 简单2：总结一下对象名点访问成员（变量和方法）的机制
  
  - 分为访问范围、检索机制、访问结果三个角度
  
    ```
    访问范围：编译类型是什么类型，就访问那些对象和方法
    检索机制：引用类型→父类→object类，还没找到就报错
    访问结果：使用什么引用接收，返回的就是什么里面的结果
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

### 敲一遍老师上课的代码

> 根据老师在每一个Demo类注释的头部写的问题，逐一敲一遍老师的代码
>
> 尤其是那些不知道该怎么下手做作业的同学，一定要认真敲一遍老师代码

- 使用一下快捷键生成子类重写方法



### 读程序题

> 不同的代码块的执行时机不同，构造器永远最后执行

- 读程序，然后分析过程和结果，提供必要的文字说明

```Java
public class Test {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}
class Base{
    static {
        System.out.println("base 静态代码块");
    }
    {
        System.out.println("base 构造代码块");
    }
    public Base(){
        System.out.println("base无参构造");
    }
}
class Sub extends Base{
    static {
        System.out.println("sub 静态代码块");
    }
    {
        System.out.println("sub 构造代码块");
    }
    public Sub(){
        //super()
        System.out.println("sub 无参构造");
    }
}
```

```
输出结果为：
base 静态代码块
sub 静态代码块
base 构造代码块
base无参构造
sub 构造代码块
sub 无参构造

先从main方法开始执行，对Test类进行类加载；
需要创建Sub的对象，对Sub进行类加载，
发现有继承的父类Base，于是进行Base的类加载，
执行base 静态代码块，
执行sub 静态代码块，
Sub的构造方法隐式初始化，需要先调用父类的构造代码块、无参构造，
接着执行Sub构造代码块与Sub无参构造完成对Sub对象的创建
```



### 读程序题

> 成员变量中有创建对象，它也是一个成员变量，和int a = 10;没有本质区别

- 读程序，然后分析过程和结果，提供必要的文字说明

```Java
public class Obj3 extends Obj1 {
    Obj2 ob2 = new Obj2();
    public Obj3(){
        System.out.println("obj3");
    }
    public static void main(String[] args) {
        Obj3 obj3 = new Obj3();
    }
}
class Obj1 {
    Obj2 ob2 = new Obj2();
    public Obj1() {
        System.out.println("Obj1");
    }
}
class Obj2 {
    public Obj2() {
        System.out.println("obj2");
    }
}
```

```
输出结果是：
obj2
Obj1
obj2
obj3

说明：程序先从main方法执行，Obj3继承Obj1，因此Obj1的类加载在前，Obj3在后；Obj3的无参构造器自动调用Obj1的构造器，在这个初始化过程
中，首先要执行Obj1的成员变量的显式初始化，于是触发Obj2的类加载和Obj2构造方法的执行来完成创建Obj2对象，控制台输出字符串obj2；然后执行Obj1的无参构造方法，完成obj1对象的创建，控制台输出字符串obj1；然后Obj3中的成员变量进行初始化，创建obj2对象，调用Obj2的无参构造方法，控制台输出obj2，最后执行obj3的无参构造器，控制台输出字符串obj3
```



### 练习继承中的构造器使用

> 使用alt + insert快速生成快捷键
>
> 有了继承的父类后，alt+insert快捷键快速创建构造方法第一步会让你选择父类构造器（也就是super(参数)）
>
> 随后才是选择子类自身的成员变量，生成子类构造器

```
给出三个层级的继承关系
顶层父类Grandfather，Father继承Grandfather，Son继承Father
成员变量：
Grandfather：gA,a
Father：fA,a
Son：sA,a

成员方法：
Grandfather：testGrand,test
Father：testFather,test
Son：testSon,test

使用快捷键在Son中生成不同的构造方法，调用不同的父类构造器（需要先生成父类相应的构造器）
随后使用多种方式创建Son对象（思考有几种），理解对象名访问成员的机制，理解属性隐藏和方法覆盖
```

```java
package _extends;

/**
 * @author zhchch
 * @date 2021/10/13 22:54
 */
public class Test {
    public static void main(String[] args) {
        Son son1 = new Son();
        Son son2 = new Son(1);
        Son son3 = new Son(1, 2);
        Son son4 = new Son(1, 2, 3);
        Son son5 = new Son(1, 2, 3, 4);
        Son son6 = new Son(1, 2, 3, 4, 5);
        Son son7 = new Son(1, 2, 3, 4, 5, 6);
    }
}

class GrandFather {
    int gA;
    int a;

    public GrandFather() {
    }

    public GrandFather(int gA, int a) {
        this.gA = gA;
        this.a = a;
    }

    public void testGrand() {
        System.out.println("testGrand");
    }

    public void test() {
        System.out.println("test");
    }
}

class Father extends GrandFather {
    int fA;
    int a;

    public Father() {
        super();
    }

    public Father(int gA, int a) {
        super(gA, a);
    }

    public Father(int gA, int a, int fA, int a1) {
        super(gA, a);
        this.fA = fA;
        this.a = a1;
    }

    public void testSon() {
        System.out.println("testGrand");
    }

    public void test() {
        System.out.println("test");
    }
}

class Son extends Father {
    int testSon, test;

    public Son() {
        super();
    }

    public Son(int testSon) {
        super();
        this.testSon = testSon;
    }

    public Son(int testSon, int test) {
        this.testSon = testSon;
        this.test = test;
    }

    public Son(int gA, int a, int test) {
        super(gA, a);
        this.test = test;
    }

    public Son(int gA, int a, int testSon, int test) {
        super(gA, a);
        this.testSon = testSon;
        this.test = test;
    }

    public Son(int gA, int a, int fA, int a1, int testSon) {
        super(gA, a, fA, a1);
        this.testSon = testSon;
    }

    public Son(int gA, int a, int fA, int a1, int testSon, int test) {
        super(gA, a, fA, a1);
        this.testSon = testSon;
        this.test = test;
    }
    
    public void testSon() {
        System.out.println("testGrand");
    }

    public void test() {
        System.out.println("test");
    }
}
```



### 完成阶段三

> 详见文档



### 四、预习问题

> 预习的题目仅为预习提供思路，不用表现在作业中

- 预习final、多态、接口和抽象类（明天这些知识能够讲完，可以参考思维导图进行预习）