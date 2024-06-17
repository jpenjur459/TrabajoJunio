import java.util.Arrays;
import java.util.Scanner;

public class Primitiva {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int veces  = entrada.nextInt();
        entrada.nextLine();
        for (int i = 0; i < veces ; i++) {

            String num1 = entrada.nextLine();
            String num2 = entrada.nextLine();

            if (num1.length() == 7 && num2.length() == 7) {
                boolean gana = true;
                for (int j = 0; j < 7; j++) {
                    char tiene = num1.charAt(j);
                    if (!num2.contains(String.valueOf(tiene))) {
                        gana = false;
                        break;
                    }
                }
                if (gana = true) {
                    System.out.println("GANA");
                } else {
                    System.out.println("PIERDE");
                }
            } else {
                System.out.println("numeros no validos");
            }
        }
    }
}