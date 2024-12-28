# 명언 게시판 : Wise Saying

## Main 생성

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("== 명언 앱 ==");
        System.out.println("명령) 종료");
    }
}
```
## Class App 생성

Main에는 최대한 기능을 줄임.

```java
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
class App{
    public void run(){
        System.out.println("== 명언 앱 ==");
        System.out.println("명령) 종료");
    }
```

## Class App : 명언 등록

Scanner를 통해 값을 입력.

```java
package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App{
    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        System.out.print("명언 : ");
        scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.
        System.out.print("작가 : ");
        scanner.nextLine();
        System.out.println("1번 명언이 등록되었습니다.");
        System.out.println("명령) 종료");
    }
}
```
