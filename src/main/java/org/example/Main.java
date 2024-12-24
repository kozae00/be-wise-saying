package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    // 클래스에서 함수들이 공유해야 하는 변수 -> 인스턴스 변수
    int lastId = 0;
    int wiseSayingSize = 0;
    WiseSaying[] wiseSayingList = new WiseSaying[3];

    public void run() {

        Scanner scanner = new Scanner(System.in);
//        int lastId = 0;
//        int wiseSayingSize = 0;
//        WiseSaying[] wiseSayingList = new WiseSaying[3];

        // 테스트 명언 데이터 1
        WiseSaying wiseSayingTest = new WiseSaying();
        wiseSayingTest.id = ++lastId;
        wiseSayingTest.content = "99% 노력과 1% 영감.";
        wiseSayingTest.author = "에디슨";

        wiseSayingList[wiseSayingSize++] = wiseSayingTest;

        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if(command.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                // 명언, 작가 입력 값을 매개변수로 받아줘야한다.
                add(content, author);

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
            } else if(command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int i = 0; i < wiseSayingSize; i++) {
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                }
//                for(WiseSaying wiseSaying : wiseSayingList) {
//                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
            }
        }
    }

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

class WiseSaying {
    int id;
    String content;
    String author;
}