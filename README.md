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

## ArrayList -> HashMap

ArrayList는 size가 고정되어 잘 사용하지 않는다.

```java
public class Main {
    public static void main(String[] args) {
@@ -19,12 +17,10 @@ public void run(){
        System.out.println("== 명언 앱 ==");
        int lastNo = 1;
        String content;
        // String [] contentList = new String[5]; // ArrayList를 사용하면, size가 고정값이라 사용하기가 힘듬.
        String author;
        // String [] authorList = new String[5];
        WiseSaying wiseSaying = new WiseSaying();

        Map<Integer, Quote> map = new HashMap<>();
        // WiseSaying 리스트 선언
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        while(true) {
            System.out.print("명령) ");
@@ -44,22 +40,26 @@ else if(command.equals("등록")) { // String일 때, '==' 가 아닌 .equals()
                author = scanner.nextLine();

                // wiseSaying으로 content, author, id 모음
                wiseSaying.id = lastNo++;
                wiseSaying.content = content;
                wiseSaying.author = author;
                map.put(lastNo, new Quote(content, author)); // 데이터 저장
                WiseSaying wiseSaying = new WiseSaying(lastNo, content, author);
                wiseSayingList.add(wiseSaying);

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo)); // .formatted(); 포맷 지정. %를 붙여 문자열에 사용하면 그 위치에 변수의 값을 형식화하여 대입

                // lasNot 증가
                lastNo++;
            }

            else if(command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int no : map.keySet()) {
                    Quote quote = map.get(no);
                    System.out.printf("%d / %s / %s%n".formatted(no, quote.author, quote.content));
                // 내림차순 정렬
                List<WiseSaying> sortedList = new ArrayList<>(wiseSayingList);
                Collections.reverse(sortedList);
                // 리스트를 순회하며 출력
                for (WiseSaying wiseSaying : sortedList) {
                    System.out.printf("%d / %s / %s%n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
                }
                System.out.println();
            }
@@ -68,18 +68,14 @@ else if(command.equals("목록")) {
    }
}

class Quote {
class WiseSaying{
    int id; // 해당 명언의 id
    String content;
    String author;

    public Quote(String content, String author) {
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}
class WiseSaying{
    int id; // 해당 명언의 id
    String content;
    String author;
}
```

## Method 추가

Method를 추가해 코드에 가독성을 키운다.

```java
// method 추가. method를 추가할 때에는 class 안에.
// run()에 있는 변수들을 사용할 수 없으니, 인스턴스 변수로 변경
public void add(String content, String author) {
WiseSaying wiseSaying = new WiseSaying();
wiseSaying.id = ++lastId;
wiseSaying.content = content;
wiseSaying.author = author;
wiseSayingList[wiseSayingSize++] = wiseSaying;
}
}

```
