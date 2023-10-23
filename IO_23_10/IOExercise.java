package IO_23_10;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class IOExercise {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String input = sc.nextLine();
        System.out.println("You entered: " + input);
        System.out.println("Hello " + input);
        sc.close();

        System.out.println("***************");

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            int data;

            while ((data = fileReader.read()) != -1) {
                fileWriter.write(data);
            }

            fileReader.close();
            fileWriter.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while copying the file.");
        }

        System.out.println("***************");

        String sourceFileName = "source.txt";
        String destinationFileName = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFileName);
             FileOutputStream fos = new FileOutputStream(destinationFileName)) {
            int copy;
            while ((copy = fis.read()) != -1) {
                fos.write(copy);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while copying the file.");
        }

        System.out.println("***************");


        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

            System.out.println("***************");


        }


    }
}


