import java.util.Random;
import java.util.Scanner;

/**
 * OchinB
 */
public class WordEnd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] word = scan.nextLine().split("");
        String[] inword = new String[word.length];
        Random random = new Random();
        boolean frag = true;
        int check = 0;
        int num = 0;
        for (int i = 0; i < inword.length; i++) {
            inword[i] = "";
        }
        System.out.println(word.length + ":Word");
        System.out.println(inword.length + ":InWord");
        while (frag) {
            num++;
            int i = random.nextInt(word.length);
            String s = word[i];
            inword[inword.length - 1] = s;
            System.out.print(s);
            check = 0;

            for (int k = 0; k < word.length; k++) {
                // System.out.println(k + ":IN:" + inword[k]);
                // System.out.println(k + ":CH:" + word[k]);
                if (inword[k].equals(word[k])) {
                    check++;
                }
            }

            if (check == word.length) {
                frag = false;
            } else {
                for (int k = 0; k < inword.length - 1; k++) {
                    inword[k] = inword[k + 1];
                }
            }
        }
        System.out.println("\n" + num + "•¶Žš–Ú‚ÅŠ®¬I‚â‚Á‚½‚ËI");
    }
}