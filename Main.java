import lexer.*;
import parser.*;
import visitor.XMLVisitor;
import visitor.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "sampleCode/teaTest6.txt";

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

        // System.out.println(program);

        // Lexer
        Lexer lexer = new Lexer(program);
        Token t = new Token();

        // Parser
        Parser parser = new Parser(lexer);
        ASTProgramNode progNode = parser.parse_program();

        // XML
        XMLVisitor xml = new XMLVisitor();
        xml.visit(progNode);
        xml.close();

        // Semantic Analysis
        SemanticAnalyser analyser = new SemanticAnalyser();
        analyser.visit(progNode);

        // Interpreter
        Interpreter interpreter = new Interpreter();
        interpreter.visit(progNode);
    }
}