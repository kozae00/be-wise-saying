package org.example;

class WiseSaying {
    // 인스턴스 변수들은 디폴트로 private
    private int id;
    private String content;
    private String author;

    // 생성자 도입으로 코드 간결화
    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content  = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}