import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OhioLinkParser {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
         * Asks the user for the name of the input file and for the name of the
         * output file to be saved.
         */
        System.out.println("Enter the name of the input file "
                + "\"ex: data/NameOfFile.txt\": ");
        String inFileName = in.nextLine();
        System.out.println("Enter the name of the output file "
                + "\"ex: data/NameOfFile.txt\": ");
        String outFileName = in.nextLine();
        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));

            inFile.close();
        } catch (IOException e) {
            System.err.println("Error oppening file");
            return;
        }

    }

}
