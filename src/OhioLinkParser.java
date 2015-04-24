import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OhioLinkParser {

//    /**
//     * Returns a list of List<String>'s which has all separated Records.
//     * 
//     * each List<String> is a record in oneRecord()
//     * 
//     * @param in
//     *            the in stream.
//     * @return the return value of the list.
//     * @throws IOException
//     *             IO exception.
//     */
//    private static List<List<String>> all(BufferedReader in) throws IOException {
//        assert in != null : "Violation of: in is not null";
//        assert in.ready() : "Violation of: in.is_open";
//
//        List<List<String>> allRecords = new ArrayList<List<String>>();
//
//        String line = in.readLine();
//        while (line != null) {
//            allRecords.add(oneRecord(line));
//            line = in.readLine();
//        }
//        return allRecords;
//    }
//
//    /**
//     * Returns a List<String> of one record.
//     * 
//     * each record contains (OCLC Number, Author, Title, Imprint)
//     * 
//     * @param line
//     *            the line from a record.
//     * 
//     * @return the return value of the list.
//     * @throws IOException
//     *             IO exception.
//     */
//    public static List<String> oneRecord(String line) {
//        List<String> l = new ArrayList<String>();
//
//        return l;
//    }

    public static List<String> allLines(BufferedReader in) throws IOException {
        assert in != null : "Violation of: in is not null";
        assert in.ready() : "Violation of: in.is_open";

        List<String> al = new ArrayList<String>();

        String line = in.readLine();
        while (line != null) {
            al.add(line);
            line = in.readLine();
        }

        return al;
    }

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
        /*
         * the list of all records
         */
        List<String> lines;

        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));

            lines = allLines(inFile);
            System.out.println(lines.size());

            inFile.close();
        } catch (IOException e) {
            System.err.println("Error oppening file");
            return;
        }

    }

}
