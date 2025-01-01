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

## Class App : command(1)

command를 생성해, "등록"을 입력했을 때   
작가, 명언 입력란이 나오도록 한다. 
 

```java
        System.out.print("명언 : ");
        scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

        System.out.print("작가 : ");
        scanner.nextLine();
            if(command.equals("등록")) { // String일 때, '==' 가 아닌 .equals() 사용
                System.out.print("명언 : ");
                scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.

        System.out.println("1번 명언이 등록되었습니다.");
        System.out.println("명령) 종료");
                System.out.print("작가 : ");
                scanner.nextLine();
                System.out.println("1번 명언이 등록되었습니다.");
            }
            // System.out.println("명령) 종료");
        }
```

## Class App : command(2)

command에서 종료 기능을 추가한다. 
"종료"를 입력했을 때, break문을 통해 반복문을 탈출

```java
if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            }
            else if(command.equals("등록")) { // String일 때, '==' 가 아닌 .equals() 사용

```

## Class Quote
명언(content)와 작가(author)를 저장할 class를 생성
그와 동시에 HashMap를 통해 명언과 작가를 묶음

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
@@ -16,6 +18,7 @@ public void run(){

        System.out.println("== 명언 앱 ==");
        int lastNo = 1;
        Map<Integer, Quote> map = new HashMap<>();

        while(true) {
            System.out.print("명령) ");
@@ -27,16 +30,39 @@ public void run(){
            }

            else if(command.equals("등록")) { // String일 때, '==' 가 아닌 .equals() 사용
                System.out.print("명언 : ");
                scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.
                String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.

                System.out.print("작가 : ");
                scanner.nextLine();
                String author = scanner.nextLine();
                map.put(lastNo, new Quote(content, author)); // 데이터 저장

                System.out.println(lastNo + "번 명언이 등록되었습니다.");
                lastNo++;
            }
            // System.out.println("명령) 종료");
            else if(command.equals("목록")) {
                System.out.println("\n번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int no : map.keySet()) {
                    Quote quote = map.get(no);
                    System.out.printf("%d / %s / %s%n", no, quote.author, quote.content);
                }
                System.out.println();
            }
        }
    }
}
class Quote {
    String content;
    String author;
    public Quote(String content, String author) {
        this.content = content;
        this.author = author;
    }
}
```

