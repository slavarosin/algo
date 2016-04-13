package codejam.codejam2016.qualification.B;

import codejam.codejam2016.qualification.A.A;

import java.io.*;
import java.nio.file.Paths;

public class B {
    public static void main(String[] in) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(Paths.get("B-large.in").toFile()));

        File fileOut = new File(A.class.getSimpleName() + ".out");
        fileOut.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        int numOfCases = Integer.parseInt(reader.readLine());
        for (int t = 0; t < numOfCases; t++) {
            String s = reader.readLine();

            String outputLine = "Case #" + (t + 1) + ": " + result(s);
            System.out.println(outputLine);
            writer.write(outputLine + System.getProperty("line.separator"));
        }

        reader.close();
        writer.close();
    }

    private static int result(String s) {
        if (s.length() == 1) {
            return (s.charAt(0) == '+') ? 0 : 1;
        }

        int n = 0;
        int f;
        while ((f = flip(s)) < s.length()) {
            String d = "+";
            if (s.charAt(0) == '+') {
                d = "-";
            }

            s = new String(new char[f]).replace("\0", d) + s.substring(f);

//            System.out.println("f= " + f);
//            System.out.println("=> " + s);
            n++;
        }

        if (s.charAt(0) == '-') {
            n++;
        }

        return n;
    }

    private static int flip(String s) {
        char last = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
//            System.out.println(last + " ? " + s.charAt(i));
            if (last == s.charAt(i)) {
                last = s.charAt(i);
                continue;
            }

            return i;
        }

        return s.length();
    }
}
