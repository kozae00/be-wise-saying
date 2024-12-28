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
