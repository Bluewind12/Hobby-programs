import java.util.Random;

public class KIES {
    public static void main(String[] args) {
        String[] word = { "", "", "", ""};
        Random random = new Random();
        boolean frag = true;
        int num = 0;

        while (frag) {
            num++;
            int i = random.nextInt(4);
            String s = "";
            switch (i) {
            case 0:
                s = "K";
                break;
            case 1:
                s = "I";
                break;
            case 2:
                s = "E";
                break;
            case 3:
                s = "S";
                break;

            }
            word[3] = s;
            System.out.print(s);
            if (word[0].equals("K") && word[1].equals("I") && word[2].equals("E") && word[3].equals("S")) {
                frag = false;
            } else {
                word[0] = word[1];
                word[1] = word[2];
                word[2] = word[3];
            }
        }
        System.out.println("\n" + num + "ï∂éöñ⁄Ç≈KIESÇ…ì¸âÔÇµÇ‹ÇµÇΩÇ‚Ç¡ÇΩÇÀÅI");
    }
}