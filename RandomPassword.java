import java.util.Scanner;
import java.util.Random;

public class RandomPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Enter password length:");
        int len = sc.nextInt();

        System.out.println("Include lowercase letters? (y/n):");
        char low = sc.next().charAt(0);

        System.out.println("Include uppercase letters? (y/n):");
        char up = sc.next().charAt(0);

        System.out.println("Include numbers? (y/n):");
        char num = sc.next().charAt(0);

        System.out.println("Include special characters? (y/n):");
        char sp = sc.next().charAt(0);

        String chars = "";

        if (low == 'y' || low == 'Y')
            chars = chars + "abcdefghijklmnopqrstuvwxyz";
        if (up == 'y' || up == 'Y')
            chars = chars + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (num == 'y' || num == 'Y')
            chars = chars + "0123456789";
        if (sp == 'y' || sp == 'Y')
            chars = chars + "@#$%&*!?";

        if (chars.length() == 0) {
            System.out.println("No character set selected!");
            sc.close();
            return;
        }

        String password = "";

        for (int i = 0; i < len; i++) {
            int index = r.nextInt(chars.length());
            password = password + chars.charAt(index);
        }

        System.out.println("Generated Password: " + password);

        sc.close();
    }
}
