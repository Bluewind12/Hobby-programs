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
                s = "��";
                break;
            case 1:
                s = "��";
                break;
            case 2:
                s = "��";
                break;
            case 3:
                s = "��";
                break;
            case 4:
                s = "��";
                break;
            case 5:
                s = "��";
                break;
            case 6:
                s = "��";
                break;
            case 7:
                s = "�[";
                break;
            }
            word[7] = s;
            System.out.print(s);
            if (word[0].equals("��") && word[1].equals("��") && word[2].equals("��") && word[3].equals("��")
                    && word[4].equals("��") && word[5].equals("��") && word[6].equals("��") && word[7].equals("�[")) {
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
        System.out.println("\n" + num + "�����ڂœ����^���[�������܂����I");
    }
}