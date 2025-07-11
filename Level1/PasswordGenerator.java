import java.util.*;
public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter desired password length: ");
        int length = sc.nextInt();
        sc.nextLine();
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = sc.nextLine().equalsIgnoreCase("y");
        sc.close();
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/";
        StringBuilder characterPool = new StringBuilder();
        if (includeLowercase) characterPool.append(lowercase);
        if (includeUppercase) characterPool.append(uppercase);
        if (includeNumbers) characterPool.append(numbers);
        if (includeSpecial) characterPool.append(special);
        if (characterPool.length() == 0) {
            System.out.println("You must select at least one character type!");
            return;
        }
        Random rand = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        System.out.println("Generated Password: " + password);
    }
}
