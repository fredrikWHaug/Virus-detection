
import java.util.Random;
import java.io.PrintWriter;

public class RandomGeneFileCreator {
    public static void main(String[] args) {

        String[] dnaList = new String[4];
        dnaList[0] = "A";
        dnaList[1] = "C";
        dnaList[2] = "G";
        dnaList[3] = "T";

        Random random = new Random();

        for (int i = 1; i <= 3; i ++) {
            try {
                PrintWriter pW = new PrintWriter("file" + i + ".csv");

                for (int j = 0; j < 3; j ++) {
                    for (int k = 0; k < 3; k ++) {
                        int index = random.nextInt(4);
                        pW.print(dnaList[index]);
                    }
                    pW.print("\n");
                }
                pW.close();
            } catch (Exception e) {
                System.out.println("Error");
                System.exit(1);
            }
        }

    }
}
