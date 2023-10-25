package IO_25_10;

import java.io.IOException;

import static IO_25_10.WednesdayExercises.*;

public class Main {
    public static void main(String[] args) {
        try {
            readFromAFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sentence = "This is the sentence I'm adding to the output.txt file.";
        try {
            writeFromAFile(sentence);
            System.out.println("Sentence was successfully written to output.txt file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        copyAFile();

        String sentenceAppend = "This is the sentence I'm appending to the destination.txt file.";
        try {
            appendToFile("IO_25_10/destination.txt", sentenceAppend);
            System.out.println("\n" + "Sentence was successfully appended to destination.txt file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            int sum = calculateSumFromFile("IO_25_10/input_numbers.txt");
            writeSumToFile("IO_25_10/output_sum.txt", sum);
            System.out.println("Sum of numbers written to output_sum.txt");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}
