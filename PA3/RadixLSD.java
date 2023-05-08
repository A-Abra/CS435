import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadixLSD {
    public static void main(String[] args) {
        String inputFile = "f.txt";
        String outputFile = "g.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Specify the input file (default = f.txt):");
        String userInput = scanner.nextLine();
        if (!userInput.isEmpty()) inputFile = userInput;

        System.out.print("Specify the output file (default = g.txt):");
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) outputFile = userInput;
        
        System.out.println("Reading file: " + inputFile);
        System.out.println("Writing file: " + outputFile);
        scanner.close();

        List<String> lines = new ArrayList<>();
        // kMaxLen=20 allows for padding of k=21
        int kMaxLen = 20;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                kMaxLen = Math.max(kMaxLen, line.length());
                //System.out.println(kMaxLen);
            }
        } catch (IOException e) { e.printStackTrace(); }

        char[][] S = new char[lines.size()][kMaxLen];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            line = String.format("%-" + kMaxLen + "s", line.trim());
            for (int j = 0; j < kMaxLen; j++) { S[i][j] = line.charAt(j); }
        }
    
        // Initialize the pointer array P with indices 0...n-1
        int n = S.length;
        int[] P = new int[n];
        for (int i = 0; i < n; i++) P[i] = i;
        // Sort the array and update array pointer P
        radixSort(S, P);
        // Output the sorted strings to text file
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (int i = 0; i < n; i++) { writer.println(new String(S[P[i]])); }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

    public static void radixSort(char[][] S, int[] P) {
        int n = S.length, k = S[0].length;
        int[] count = new int[128], start = new int[128];
    
        for (int j = k - 1; j >= 0; j--) {
            // Count the frequencies of the characters in column j
            Arrays.fill(count, 0);
            for (int i = 0; i < n; i++) {
                char ch = S[P[i]][j];
                count[ch]++;
            }
            // Compute the starting index of each character group
            start[0] = 0;
            for (int i = 1; i < 128; i++) { start[i] = start[i - 1] + count[i - 1]; }
            // Move the strings to their sorted positions based on column j
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                char ch = S[P[i]][j];
                next[start[ch]] = P[i];
                start[ch]++;
            }
            System.arraycopy(next, 0, P, 0, n);
        }
    }
}