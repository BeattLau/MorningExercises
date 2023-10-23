package IO_23_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOExercise2 {
    public static void main(String[] args) {

        String fileName = "source.txt";

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int wordCount = 0;

            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }

            System.out.println("Total words in the file: " + wordCount);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error: File not found.");
        }
        System.out.println("***************");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string(or type exit to leave)");
        ArrayList<String> enteredStrings = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program");
                break;
            }
           enteredStrings.add(input);
        }
        System.out.println("Entered strings: ");
        for (String string : enteredStrings){
            System.out.println(string);
        }
        System.out.println("***************");

        String fileName2 = "source.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName2, true);

            String contentToAppend = "\n This is the new content to append to the source file.\n";

            fileWriter.write(contentToAppend);

            fileWriter.close();

            System.out.println("Content appended to the file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while appending to the file.");
        }
        System.out.println("***************");

    }
}



