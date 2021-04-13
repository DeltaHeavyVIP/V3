package record;

import java.io.FileWriter;
import java.io.IOException;

public class Record {

    public static void record(String fileOrConsole, double answer, int n) {
        if (fileOrConsole.equals("console")) {
            System.out.println("+-------------------------+");
            System.out.printf("|%-12s|%-12s|\n",
                    "S", "N");
            System.out.println("|------------+------------|");
            System.out.printf("|%-12.3f|%-12d|\n",
                    answer, n);
            System.out.println("+-------------------------+");
        } else {
            String answer_text = "+-------------------------+\n";
            answer_text += String.format("|%-12s|%-12s|\n",
                    "S", "N");
            answer_text += String.format("|------------+------------|\n");
            answer_text += String.format("|%-12.3f|%-12d|\n",
                    answer, n);
            answer_text += "+-------------------------+\n";
            try (FileWriter writer = new FileWriter("src/main/resources/output", false)) {
                writer.write(answer_text);
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
