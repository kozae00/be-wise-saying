package org.example;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();

        strings.add("칼룰루");
        strings.add("위루");
        strings.add("레란돞스키");

        // index로 지우는 법
        strings.remove(0);

        for(String s : strings) {
            System.out.println(s);
        }
        
        // 값을 지우는 법
        strings.remove("칼룰루");
        for(String s : strings) {
            System.out.println(s);
        }

        WiseSaying w1 = new WiseSaying(1, "헤으응", "괴물쥐");
        WiseSaying w2 = new WiseSaying(2, "혹덩이", "파카");

        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        wiseSayings.add(w1);
        wiseSayings.add(w2);

        wiseSayings.remove(w1);

        for(WiseSaying ws : wiseSayings) {
            System.out.println(ws.getContent());
            System.out.println(ws.getAuthor());
        }
    }
}
