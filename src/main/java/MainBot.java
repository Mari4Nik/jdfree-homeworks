import java.util.Random;
import java.util.Scanner;

public class MainBot {
    static String word = "javalove";

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.println ("Выберете язык:\n 1 - Русский\n 2 - Английский\n Введите нужную цифру: ");
        int lang = input.nextInt ();

        System.out.println ("Загадай слово боту:");
        word = input.next ().toLowerCase ();

        // javalove --------
        System.out.println ("Бот приступил к отгадыванию...\n");
        int lengthWord = word.length ();
        String maskWord = "-".repeat (lengthWord);
        System.out.println (maskWord);

        // --------
        // a
        // -a-a----
        // o
        // -a-a-o--
        do {
            System.out.println ("Подбор буквы...");
            String charsEng = "abcdefghijklmnopqrstuvwxyz";
            String charsRu = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            String chars = lang == 1 ? charsRu : charsEng;
            Random rand = new Random ();
            int num = rand.nextInt ( chars.length ());
            char c = chars.charAt (num);
            //String ch = c;
            System.out.println ("Бот выбрал букву \"" + c + "\"\n");
            // char c = input.next().charAt(0);
            // a 2
            // w -1
            if (word.indexOf (c) >= 0) {
                System.out.println ("Найдено соответствие");
                for (char elem : word.toCharArray ()) {
                    if (elem == c) {
                        maskWord = replaceMaskLetter (c, maskWord);
                    }
                }
                System.out.println (maskWord);
            } else {
                System.out.println ("Соответствий не найдено\n");
                System.out.println (maskWord);
            }
        } while (maskWord.contains ("-"));
        System.out.println ();
        System.out.println ("Искомое слово: " + maskWord);
        System.out.println ("Бот победил, а ты как думал :)");
    }

    /*
    -a-a---- j
    ja-a----
     */
    public static String replaceMaskLetter(char c, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder ();
        for (int i = 0; i < word.length (); i++) {
            if (word.charAt (i) == c) {
                stringBuilder.append (c);
            } else if (maskWord.charAt (i) != '-') {
                stringBuilder.append (maskWord.charAt (i));
            } else {
                stringBuilder.append ("-");
            }
        }
        return stringBuilder.toString ();
    }
}
