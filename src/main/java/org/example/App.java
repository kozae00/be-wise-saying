package org.example;

import org.example.wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private final WiseSayingController wiseSayingController;
    private final Scanner scanner;

    public App() {
        wiseSayingController = new WiseSayingController(scanner); // 생성자를 통해 final 값 변경
        scanner = new Scanner(System.in);
    }

    public void run() {

        wiseSayingController.add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니");
        wiseSayingController.add("현재를 사랑하라", "작자 미상");

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {

                // 종료할 때 설정값을 저장

                // 종료할 때 명언 데이터 백업

                // 종료할 때 자원 해제

                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {
                wiseSayingController.writeWiseSaying();
            } else if (command.equals("목록")) {
                wiseSayingController.printWiseSayingList();
            } else if (command.startsWith("삭제?id=")) {
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);
                wiseSayingController.deleteWiseSaying(id);
            } else if (command.startsWith("수정?id=")) {
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);
                wiseSayingController.updateWiseSaying(id);
            }
        }
    }



}
