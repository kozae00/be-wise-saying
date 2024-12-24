package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private int lastId = 0;
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        add("99% 노력과 1% 영감", "에디슨");
        add("너를 사랑해라.", "작자 미상");
        
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if(command.equals("등록")) {
                writeWiseSaying();

            } else if(command.equals("목록")) {
                printWiseSayingList();
            }
        }
    }

    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        
        // reversed() 내림차순으로 정렬
        for(WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    private void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        add(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
    }

    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList.add(wiseSaying);
    }

}
