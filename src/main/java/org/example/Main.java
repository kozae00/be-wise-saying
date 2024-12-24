package org.example;

import java.util.HashMap;
import java.util.Map;
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
        int lastNo = 1;
        String content;
        // String [] contentList = new String[5]; // ArrayList를 사용하면, size가 고정값이라 사용하기가 힘듬.
        String author;
        // String [] authorList = new String[5];
        WiseSaying wiseSaying = new WiseSaying();

        Map<Integer, Quote> map = new HashMap<>();

        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            }

            else if(command.equals("등록")) { // String일 때, '==' 가 아닌 .equals() 사용

                System.out.print("명언 : ");
                content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기. 엔터를 입력해야 입력이 완료됨.

                System.out.print("작가 : ");
                author = scanner.nextLine();

                // wiseSaying으로 content, author, id 모음
                wiseSaying.id = lastNo++;
                wiseSaying.content = content;
                wiseSaying.author = author;

                map.put(lastNo, new Quote(content, author)); // 데이터 저장

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo)); // .formatted(); 포맷 지정. %를 붙여 문자열에 사용하면 그 위치에 변수의 값을 형식화하여 대입

            }

            else if(command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int no : map.keySet()) {
                    Quote quote = map.get(no);
                    System.out.printf("%d / %s / %s%n".formatted(no, quote.author, quote.content));
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

class WiseSaying{
    int id; // 해당 명언의 id
    String content;
    String author;
}