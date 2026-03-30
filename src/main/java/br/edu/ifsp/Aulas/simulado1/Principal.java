package main.java.br.edu.ifsp.Aulas.simulado1;

public class Principal {

    void main() {

        UserAccount lucas = new UserAccount("lucaonarigao@gmail.com", "lucao");
        UserAccount alek = new UserAccount("alekaotiltadao@gmail.com", "alekao");

        lucas.acceptFollower(alek);
        alek.acceptFollower(lucas);

        lucas.publish("Meu nariz tem 10 metros");
        lucas.publish("teste");
        alek.publish("Eu tilto em joguinho online");

        System.out.println(alek.showTimeline());

        lucas.booPost(0);

        System.out.println(lucas.showMyPosts());

        lucas.delete(0);

        System.out.println(alek.showTimeline());

        System.out.println(lucas.showMyPosts());

        System.out.println(lucas.showMyFriends());

    }
}
