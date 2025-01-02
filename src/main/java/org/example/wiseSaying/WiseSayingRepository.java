package org.example.wiseSaying;

import java.util.ArrayList;

public interface WiseSayingRepository {
    WiseSaying findById(int id);
    void update(WiseSaying wiseSaying);
    WiseSaying add(String content, String author);
    void remove(WiseSaying wiseSaying);
    ArrayList<WiseSaying> findAll();
}
