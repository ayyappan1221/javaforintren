import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Encrypt File");
        System.out.println("2. Decrypt File");
        System.out.println("Choose option:");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter input file path:");
        String inputFile = sc.nextLine();

        System.out.println("Enter output file path:");
        String outputFile = sc.nextLine();

        int key = 3; // encryption key

        try {
            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(outputFile);

            int ch;
            while ((ch = fr.read()) != -1) {
                if (choice == 1)
                    fw.write(ch + key); // Encrypt
                else if (choice == 2)
                    fw.write(ch - key); // Decrypt
            }

            fr.close();
            fw.close();

            if (choice == 1)
                System.out.println("File encrypted successfully!");
            else if (choice == 2)
                System.out.println("File decrypted successfully!");
            else
                System.out.println("Invalid choice!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}
