package IO_25_10;

import java.io.*;

public class WednesdayExercises {
    static void readFromAFile() throws IOException {
        FileReader fileReader = new FileReader("IO_25_10/input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    static void writeFromAFile(String sentence) throws IOException {
        FileWriter fileWriter = new FileWriter("IO_25_10/output.txt");
        fileWriter.write(sentence);
        fileWriter.close();
    }

    static void copyAFile(){
        try (FileInputStream fileInputStream = new FileInputStream("IO_25_10/source.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("IO_25_10/destination.txt")) {
            int copy;
            while ((copy = fileInputStream.read()) != -1) {
                fileOutputStream.write(copy);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while copying the file.");
        }
    }
    static void appendToFile(String filePath, String content) throws IOException {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(content);
            fileWriter.close();
        }

    static int calculateSumFromFile(String inputFilePath) throws IOException {
        FileReader fileReader = new FileReader(inputFilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            try {
                int number = Integer.parseInt(line);
                sum += number;
            } catch (NumberFormatException e) {
                System.err.println("Skipping non-integer line: " + line);
            }
        }

        bufferedReader.close();
        return sum;
    }

    static void writeSumToFile(String outputFilePath, int sum) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFilePath);
        fileWriter.write("Sum of numbers: " + sum);
        fileWriter.close();
    }
}





