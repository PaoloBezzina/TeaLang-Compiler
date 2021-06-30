import lexer.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "sampleCode/teaTest2.txt";

        File file = new File(filePath);
        String program = "";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st = null;
        while (true) {
            try {
                if (!((st = br.readLine()) != null))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            program += (st + "\n");
        }

        System.out.println(program);

        // Lexer
        Lexer lex = new Lexer(program);
    }
}