# 今日作业的目标

> 理解异常类的本质，能够自己自定义异常，熟悉File类，会使用常见的API

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

- **手打一遍File API，从创建File对象到调用方法都试一试**

```java
/* 文件操作相关API练习
        File file = new File("F:\\TestDirectory");
        System.out.println(file.exists());

        new Demo().deleteFile(file);

        File file = new File("F:\\TestDirectory\\2.mp3\\hello");
        System.out.println(file.createNewFile());

        File file1 = new File("F:\\TestDirectory\\2.mp3\\a\\b");
        System.out.println(file1.mkdirs());

        File file1 = new File("F:\\TestDirectory\\2.mp3\\a");
        System.out.println(file1.delete());

        File file1 = new File("F:\\TestDirectory\\2.mp3\\a");
        System.out.println(file1.isDirectory());

        File file1 = new File("F:\\TestDirectory\\1.jpg");
        System.out.println(file1.isFile());

        File file1 = new File("F:\\TestDirectory\\1.jpg");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());


        for (int i = 0; i < list.length; i++) {
            String s = list[i];
            System.out.println(s);
        }

        File[] files = file1.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            System.out.println(file.getName() + "   " + file.getPath());
        }
*/
```



## 非编程题

> 简答题，以下简答

- 总结一下final、finally、finalize的区别

```
final修饰类的时，表明该类不能被其他类所继承
final修饰方法，把方法锁定，以防止继承类对其进行更改
final成员变量表示常量，只能被赋值一次，赋值后其值不再改变：final修饰一个基本数据类型时，表示该基本数据类型的值一旦在初始化后便不能发生变化；如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了
函数的参数类型声明为final时，说明该参数是只读型的。即你可以读取使用该参数，但是无法改变该参数的值

finally关键字不能单独使用,必须配合try..catch或者配合try..代码块使用
try..catch之后使用finally代码块,如果catch代码块捕获异常,那么catch代码块会先于finally代码块执行，如果没有异常,finally代码块也会执行
所以finally在try..catch任何执行的情况下都会被执行,根据它的这种一定执行的特点,所以java程序员经常把释放资源的代码放入finally代码块中,这样能够确保释放资源代码一定被执行,资源一定会被释放

finalize()是在java.lang.Object里定义的，也就是说每一个对象都有这么个方法。这个方法在gc启动，该对象被回收的时候被调用。一个对象的finalize()方法只会被调用一次，而且finalize()被调用不意味着gc会立即回收该对象
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

### 异常练习题

> Scanner进行键盘录入时，非常容易产生异常，那么就有必要进行处理

```
我们在进行键盘录入字符串操作时，有时需要把一个字符串转换成int类型。但如果输入的字符串并不是一个数字时，显然是不能转换成功的，而是会抛出一个异常。
	要求：
		处理该异常，让程序不会报错终止，而是让用户重新输入，直到输入正确的数字为止
```

```java
package work01;

import java.util.Scanner;

/**
 * @author zhchch
 * @date 2021/10/20 15:11
 */
public class Demo {
    public static void main(String[] args) {
        int anInt = ScannerUtil.getInt();
        System.out.println("你刚才输入的数字是：" + anInt);
    }

}

class ScannerUtil {
    private static Scanner sc = new Scanner(System.in);

    private ScannerUtil() {
    }

    public static int getInt() {
        int value;

        while (true) {
            System.out.println("请输入一个整数：");
            try {
                value = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入有误，请重新输入！");
                continue;
            }
            break;
        }
        return value;
    }

}
```

```
请输入一个整数：
q
输入有误，请重新输入！
请输入一个整数：
dfa
输入有误，请重新输入！
请输入一个整数：
123
你刚才输入的数字是：123

Process finished with exit code 0
```



### 自定义异常练习题

> 异常类只是描述异常的信息，但是什么时候产生异常，怎么处理异常和异常类本身没有关系

```
分别自定义编译时异常和运行时异常，在方法中抛出异常，main方法中调用该方法，并处理相应的异常
```

```java
package work02;

/**
 * @author zhchch
 * @date 2021/10/20 15:20
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();

        System.out.println("start");

        try {
            demo.test();
        } catch (OneException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------");

        try {
            demo.test1();
        } catch (OneRuntimeException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

    public void test() throws OneException {
        throw new OneException();
    }

    public void test1() {
        throw new OneRuntimeException();
    }
}

//自定义编译时异常
class OneException extends Exception {
    public OneException() {
    }

    public OneException(String message) {
        super(message);
    }
}

//自定义运行时异常
class OneRuntimeException extends RuntimeException {
    public OneRuntimeException() {
    }


    public OneRuntimeException(String message) {
        super(message);
    }
}
```

```
运行结果：
start
------------------------
end
work02.OneException
	at work02.Demo.test(Demo.java:30)
	at work02.Demo.main(Demo.java:14)
work02.OneRuntimeException
	at work02.Demo.test1(Demo.java:34)
	at work02.Demo.main(Demo.java:21)

Process finished with exit code 0
```



---



**我会在作业中附带一个目录，大家可以把该目录放进非系统盘中，完成下列File练习操作，注意不要乱来~**

### File练习题



```
File练习题
递归删除目录(delete方法有风险,一定要慎重考虑使用)

     目录结构为如下(尽量不要在c盘中测试，建议在其它盘中创建文件目录做练习)
     firstLevel目录中，包含一个secondLevel目录和a1.txt和b1.java文件
     secondLevel目录中包含dir1和dir2两个目录，和a2.txt和b2.java文件
     dir1目录中包含a3.txt和b3.java文件
     dir2目录是一个空目录
     要求删除firstLevel目录

  思路：
  - 获取目录的下的所有File对象（包括文件和文件夹）
  - 判断，如果是一个空目录或者file对象不是一个目录而是文件
    - 直接删除
  - 程序执行到这里，那么一定是一个目录，且不是空目录
    - 继续遍历获取该目录下的所有文件、文件夹
    - 如果这个file对象仍然是一个目录，递归删除该目录（可以判空目录，也可以不判）
    - 如果这个file对象是文件，直接删除
  - 最后不要忘记删除已经是空目录的当前目录

  先看思路，逐步求解
  实在不懂，看参考答案
```

**整体上：**

​		**递归的出口： 删除空目录和文件**

​		**递归的递归体：目录下还有目录就需要进入删除**

```java
package work03;

import java.io.File;
import java.io.IOException;

/**
 * @author zhchch
 * @date 2021/10/20 15:48
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        File files = new File("F:\\新建文件夹\\TestDirectory");

        //此方法使用之前需要看清文件路径！
        new Demo().deleteFile(files);
        
    }

    public void deleteFile(File file) {
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            file.delete();
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if (file1.isFile()) {
                file1.delete();
            } else {
                deleteFile(file1);
            }
        }
        file.delete();
    }
}
```



### File练习题

> 带过滤器的listFiles方法练习

```
自己做一个目录，里面放些一下文件，文件夹
用带过滤器的listFiles方法进行筛选
条件一：仅留下文件夹名包括a的文件夹
条件二：仅留下.txt结尾的文本文件
条件三：仅留下以a开头的文件
```

```java
package work04;

import java.io.File;
import java.io.FileFilter;


/**
 * @author zhchch
 * @date 2021/10/20 16:56
 */
public class Demo {
    public static void main(String[] args) {
        File files = new File("F:\\新建文件夹\\TestDirectory");
        File[] files2 = files.listFiles();
        System.out.println("----------------------文件中含有的内容-------------------");
        for (File file : files2) {
            System.out.println(file.getName());
        }

        System.out.println("------------仅留下文件夹名包括a的文件夹--------------------");
        //传入FileFilter的实现类MyFilter的对象
        File[] files1 = files.listFiles(new MyFilter());
        for (int i = 0; i < files1.length; i++) {
            System.out.println(files1[i].getName());
        }

        System.out.println("---------------仅留下.txt结尾的文本文件------------------");
        //使用匿名内部类
        File[] txts = files.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt") && pathname.isFile();
            }
        });
        for (int i = 0; i < txts.length; i++) {
            System.out.println(txts[i].getName());
        }


        System.out.println("---------------仅留下以a开头的文件-----------------------");
        //使用lambda表达式
        File[] as = files.listFiles(f -> f.isFile() && f.getName().startsWith("a"));
        for (File a : as) {
            System.out.println(a.getName());
        }

    }


}

class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() && pathname.getName().contains("a");
    }
}
```

```
运行结果：
----------------------文件中含有的内容-------------------
1
1.avi
1.jpg
1.txt
2.mp3
3.mp4
666.txt
a
a.txt
aaa
aaa.txt
Beyond - 不再犹豫.mp3
Beyond - 光辉岁月.mp3
まじ娘 - 心做し.mp3
みかん箱,Foxtail-Grass Studio - 云流れ.mp3
奥特曼
学习变身成为奥特曼
学习资料
学习资料.mp4
学习资料2.mp4
学习隐私.txt
------------仅留下文件夹名包括a的文件夹--------------------
1.avi
a
---------------仅留下.txt结尾的文本文件------------------
666.txt
a.txt
aaa.txt
学习隐私.txt
---------------仅留下以a开头的文件-----------------------
a.txt
aaa
aaa.txt

Process finished with exit code 0
```



## 预习

**预习景天老师放在共享目录的I/O课件，马上就要进入JavaSE高级阶段的学习了~**