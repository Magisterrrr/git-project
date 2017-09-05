package Chapter4.Prog2_case;

import java.util.Random;

public class Main {
    public static void main(String...args){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int c = random.nextInt(26)+'a';
            System.out.println((char)c+", "+c+": ");
            switch (c)
            {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("голосна");
                    break;
                case 'y':
                case 'w':
                    System.out.println("умовно голосна");
                    break;
                default:
                    System.out.println("приголосна");
            }
        }
    }
}
