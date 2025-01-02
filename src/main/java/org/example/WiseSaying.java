package org.example;

public class WiseSaying {
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

    public void setContent(String content) {
        this.content = content;
    } // private 값을 들고 올 수 있도록 설계.

    public void setAuthor(String author) {
        this.author = author;
    } // alrt + insert 키를 동시에 사용해 setter 생성

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