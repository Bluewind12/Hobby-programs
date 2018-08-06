import java.util.Random;

/**
 * Tokyo
 */
public class Tower {
    public static void main(String[] args) {
        String[] word = { "", "", "", "", "", "", "", "" };
        Random random = new Random();
        boolean frag = true;
        int num = 0;

        while (frag) {
            num++;
            int i = random.nextInt(8);
            String s = "";
            switch (i) {
            case 0:
                s = "と";
                break;
            case 1:
                s = "う";
                break;
            case 2:
                s = "き";
                break;
            case 3:
                s = "ょ";
                break;
            case 4:
                s = "う";
                break;
            case 5:
                s = "た";
                break;
            case 6:
                s = "わ";
                break;
            case 7:
                s = "ー";
                break;
            }
            word[7] = s;
            System.out.print(s);
            if (word[0].equals("と") && word[1].equals("う") && word[2].equals("き") && word[3].equals("ょ")
                    && word[4].equals("う") && word[5].equals("た") && word[6].equals("わ") && word[7].equals("ー")) {
                frag = false;
            } else {
                word[0] = word[1];
                word[1] = word[2];
                word[2] = word[3];
                word[3] = word[4];
                word[4] = word[5];
                word[5] = word[6];
                word[6] = word[7];
            }
        }
        System.out.println("\n" + num + "文字目で東京タワーが立ちました！");
    }
}