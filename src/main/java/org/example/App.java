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
            } else if(command.startsWith("삭제?id=")) { // contains("삭제?id=") : 문자열 "삭제?id="이 포함된 모든 문자 추출. // startsWith : "삭제?id="로 시작하는 문자 추출
                deleteWiseSaying();
            }
        }
    }

    private void deleteWiseSaying() {
        System.out.println("삭제");
        // wiseSayingList.remove(); // 명언의 번호와 배열의 index가 아무 상관이 없다...

        // 1. 아이디가 1인 명언의 index를 얻는다.
        // 2. 아이디가 1인 명언의 명언의(=참조) 값을 얻는다. // 값으로 얻으면 사용할 수 있는 범용성 증가
        for(WiseSaying wiseSaying : wiseSayingList) {
            if(wiseSaying.getId() == 1) {
                wiseSayingList.remove(wiseSaying);
                break;
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
