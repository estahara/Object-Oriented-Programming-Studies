package main.java.br.edu.ifsp.Aulas.simulado1;

import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount user;

    public Post(UserAccount user, String quote) {
        this.user = user;
        this.quote = quote;
        this.date = LocalDate.now();
        this.claps = 0;
        this.boos = 0;
    }

    public void Post(UserAccount user, String quote) {
        this.user = user;
        this.quote = quote;
        this.date = LocalDate.now();
        this.claps = 0;
        this.boos = 0;
    }

    public String show() {
        return "<" + date + "> <" + user.getUserName() + "> says <" +
                quote + "> | Claps: <" + claps + "> | Boos: <" + boos + ">";
    }

    public void clap() {
        claps++;
    }

    public void boo() {
        boos++;
    }

}
