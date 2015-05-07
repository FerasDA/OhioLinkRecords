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

    public static List<List<String>> listOfRecords(List<String> lines) {
        List<List<String>> lor = new ArrayList<List<String>>();
        List<String> oneRecord = new ArrayList<String>();

        int recCount = 0;
        for (int i = 0; i < lines.size(); i++) {
//            String line = lines.remove(i);
//            if (line.startsWith("Record")) {
//                recCount++;
//            }
//            if (recCount == 1) {
//                oneRecord.add(line);
//            }
        }
        lor.add(oneRecord);

        // System.out.println("ddd" + oneRecord.size());
        return lor;
    }

    public static List<String> parsedList(List<String> lines) {
        List<String> pl = new ArrayList<String>();

        for (int i = 0; i < lines.size(); i++) {
            String title = "";
            if (lines.get(i).startsWith("Record")) {
                pl.add(lines.get(i));
            } else if (lines.get(i).startsWith("AUTHOR")) {
                pl.add(lines.get(i));
            } else if (lines.get(i).startsWith("TITLE")) {
                title = lines.get(i);
                int j = i + 1;
                while (!lines.get(j).startsWith("IMPRINT")
                        && !lines.get(j).startsWith("EDITION")) {
                    title = title + lines.get(j) + " ";
                    j++;
                }
                pl.add(title);
            } else if (lines.get(i).startsWith("IMPRINT")) {
                pl.add(lines.get(i));
            } else if (lines.get(i).startsWith("OCLC")) {
                pl.add(lines.get(i));
            }
        }

        return pl;
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
         * the list of all lines
         */
        List<String> lines;
        /*
         * list of records
         */
        // List<List<String>> lor;
        List<String> pl;

        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));

            lines = allLines(inFile);
            System.out.println(lines.size());

//            lor = listOfRecords(lines);
//            System.out.println(lor.size());

            pl = parsedList(lines);
            System.out.println("ox " + pl.size());
            while (pl.size() > 0) {
                System.out.println(pl.remove(0));
            }

            inFile.close();
        } catch (IOException e) {
            System.err.println("Error oppening file");
            return;
        }

    }

}
