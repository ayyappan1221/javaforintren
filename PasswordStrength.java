import java.util.Scanner;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter password:");
        String pass = sc.nextLine();

        boolean upper = false, lower = false, number = false, special = false;

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                upper = true;
            else if (ch >= 'a' && ch <= 'z')
                lower = true;
            else if (ch >= '0' && ch <= '9')
                number = true;
            else
                special = true;
        }

        int score = 0;
        if (pass.length() >= 8)
            score++;
        if (upper)
            score++;
        if (lower)
            score++;
        if (number)
            score++;
        if (special)
            score++;

        System.out.println("Password Analysis:");
        System.out.println("Length >= 8: " + (pass.length() >= 8));
        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
        System.out.println("Number: " + number);
        System.out.println("Special Char: " + special);

        if (score == 5)
            System.out.println("Password Strength: STRONG");
        else if (score >= 3)
            System.out.println("Password Strength: MEDIUM");
        else
            System.out.println("Password Strength: WEAK");

        sc.close();
    }
}
