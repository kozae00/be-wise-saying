package org.example.wiseSaying;

import java.util.ArrayList;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingMemRepository;

    public WiseSayingService(WiseSayingRepository wiseSayingMemRepository) {
        this.wiseSayingMemRepository = wiseSayingMemRepository;
    }

    public WiseSaying findById(int targetId) {
        return wiseSayingMemRepository.findById(targetId);
    }

    public void update(WiseSaying wiseSaying, String newContent, String newAuthor) {

        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingMemRepository.update(wiseSaying);
    }

    public WiseSaying add(String content, String author) {
        return wiseSayingMemRepository.add(content, author);
    }

    public ArrayList<WiseSaying> findAll() {
        return wiseSayingMemRepository.findAll();
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingMemRepository.remove(wiseSaying);
    }
}
