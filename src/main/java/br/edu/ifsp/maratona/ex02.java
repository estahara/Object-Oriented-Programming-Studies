import java.util.Scanner;

public class ex02 {

    public static void main(String[] args) {
        ex02 ex = new ex02();
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            System.out.println("N");
            return;
        }

        String input = scanner.nextLine();

        String result = ex.compute(input);

        if (result == null)
            System.out.println("N");
        else
            System.out.println(result);
    }

    String compute(String s) {

        if (s == null || s.length() == 0 || s.length() > 50)
            return null;

        String vogais = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                    (c < 'a' || c > 'z'))
                return null;

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vogais += c;
        }

        if (vogais.length() == 0)
            return null;

        int left = 0;
        int right = vogais.length() - 1;

        while (left < right) {
            if (vogais.charAt(left) != vogais.charAt(right))
                return "N";
            left++;
            right--;
        }

        return "S";
    }
}