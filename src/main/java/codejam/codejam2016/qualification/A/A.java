package codejam.codejam2016.qualification.A;

import java.io.*;
import java.nio.file.Paths;

public class A {

    public static void main(String[] in) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(Paths.get("A-large.in").toFile()));

        File fileOut = new File(A.class.getSimpleName() + ".out");
        fileOut.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        int numOfCases = Integer.parseInt(reader.readLine());
        for (int t = 0; t < numOfCases; t++) {
            Long n = Long.parseLong(reader.readLine());

            String outputLine = "Case #" + (t + 1) + ": " + result(n);
            System.out.println(outputLine);
            writer.write(outputLine + System.getProperty("line.separator"));
        }

        reader.close();
        writer.close();
    }


    static int seenNew = 0;

    private static String result(Long n) {
        boolean[] seen = new boolean[10];

        seenNew = 0;
        int i = 0;
        Long nn = null;
        while (!areAllTrue(seen)) {
            nn = n * ++i;

            nn.toString().chars().forEach(c -> {
                int digit = Integer.parseInt((char) c + "");

                if (!seen[digit]) {
                    seen[digit] = true;
                    seenNew = 0;
                } else {
                    seenNew++;
                }
            });

            if (seenNew > 1000) {
                return "INSOMNIA";
            }
        }

        return nn + "";
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) if (!b) return false;
        return true;
    }
}
