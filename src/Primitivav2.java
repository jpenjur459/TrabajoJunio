import java.util.*;

public class Primitivav2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int veces  = entrada.nextInt();
        entrada.nextLine();
        for (int i = 0; i < veces ; i++) {

            String num1 = entrada.nextLine();
            String num2 = entrada.nextLine();
            //char[] premio = num1.toCharArray();
            //char[] boleto = num2.toCharArray();

            String[] premio = num1.split("");

            String[] boleto = num2.split("");


            List<String> listPremio = Arrays.asList(premio);
            List<String> listBoleto = Arrays.asList(boleto);

            Collections.sort(listPremio);
            Collections.sort(listBoleto);

            boolean gana = true;
            for (int j = 0; j < listPremio.size(); j++) {
                if (!listBoleto.contains(listPremio.get(j))) {
                    gana = false;
                    break;
                }
            }


            if (gana = true) {
                System.out.println("GANA");
            } else {
                System.out.println("PIERDE");
            }

        }
    }
}