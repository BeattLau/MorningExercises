package IO_24_10;

import java.io.*;

public class Exercises {
    public static void main(String[] args) {
        try {
            fileInputStream(); //Exercise 1
        } catch (FileNotFoundException e) { // Exercise 2
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
        readBinaryFile(); //Exercise 3
        copyBinaryFile(); //Exercise 4
        printCSVFile();   //Exercise 5
        readLargeTextFile(); //Exercise 7
    }

    static void fileInputStream() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("input.txt");
            int x;
            while ((x = fis.read()) != -1) {
                System.out.print((char) x);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    static void readBinaryFile() {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/laurabeattie/IdeaProjects/MorningExercises/IO_24_10/image.jpg")) {
            int data;
            int count = 0;

            while ((data = fileInputStream.read()) != -1) {
                String hex = Integer.toHexString(data);

                if (hex.length() < 2) {
                    hex = "0" + hex;
                }

                System.out.print(hex + " ");
                count++;

                if (count % 16 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void copyBinaryFile() {


        try (FileInputStream fileInputStream = new FileInputStream("/Users/laurabeattie/IdeaProjects/MorningExercises/IO_24_10/image.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/laurabeattie/IdeaProjects/MorningExercises/IO_24_10/copy_image.jpg")) {

            int data;
            byte[] buffer = new byte[1024];

            while ((data = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        static void printCSVFile() {

            try (FileInputStream fileInputStream = new FileInputStream("/Users/laurabeattie/IdeaProjects/MorningExercises/IO_24_10/data.csv");
                 BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    for (String value : values) {
                        System.out.print(value + "\t\t");
                    }
                    System.out.println();
                }
            } catch (IOException e) {  //6
                e.printStackTrace();
            }

        }

        static void readLargeTextFile(){
            String fileName = "/Users/laurabeattie/IdeaProjects/MorningExercises/IO_24_10/large_data.txt";
            int bufferSize = 4096;

            try {
                long startTime = System.currentTimeMillis();
                char[] buffer = new char[bufferSize];
                int bytesRead;
                int totalBytesRead = 0;

                try (FileReader fileReader = new FileReader(fileName);
                     BufferedReader reader = new BufferedReader(fileReader, bufferSize)) {
                    while ((bytesRead = reader.read(buffer)) != -1) {

                        System.out.print(new String(buffer, 0, bytesRead));
                        totalBytesRead += bytesRead;
                    }
                }

                long endTime = System.currentTimeMillis(); //Exercise 8
                long elapsedTime = endTime - startTime;

                System.out.println("Total bytes read: " + totalBytesRead + " bytes");
                System.out.println("Buffer size: " + bufferSize + " bytes");
                System.out.println("Time taken: " + elapsedTime + " milliseconds");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}





