package org.example.wiseSaying;

import java.util.ArrayList;

public class WiseSayingService {
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>(); // 창고 -> 홀 일과 무관, 그렇기 때문에 WiseSayingController -> WiseSayingService로 옮김
    private int lastId = 0;

    public WiseSaying findWiseSaying(int targetId) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                return wiseSaying;
            }
        }

        return null; // 자바에서 null은 객체가 없음 의미
    }

    public void updateWiseSaying(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
    }

    public void add(String content, String author) {
        int id = ++lastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
    }
}
