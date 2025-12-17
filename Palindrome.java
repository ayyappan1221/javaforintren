import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word or phrase:");
        String s = sc.nextLine();
        String clean = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                clean = clean + ch;
            }
        }
        clean = clean.toLowerCase();
        String rev = "";
        for (int i = clean.length() - 1; i >= 0; i--) {
            rev = rev + clean.charAt(i);
        }
        if (clean.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
        sc.close();
    }
}