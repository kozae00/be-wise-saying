package org.example.wiseSaying;

import java.util.ArrayList;

public abstract class WiseSayingRepository {
    public abstract WiseSaying findById(int id);
    public abstract WiseSaying update(WiseSaying wiseSaying);
    public abstract WiseSaying add(String content, String author);
    public abstract void remove(WiseSaying wiseSaying);
    public abstract ArrayList<WiseSaying> findAll();
}
