import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileEncryptDecrypt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option: ");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();

        System.out.println("Enter the shift key (e.g., 3):");
        int key = scanner.nextInt();

        File inputFile = new File(filePath);
        StringBuilder content = new StringBuilder();

        try (Scanner fileReader = new Scanner(inputFile)) {
            while (fileReader.hasNextLine()) {
                content.append(fileReader.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        String result = (choice == 1) ?
                encrypt(content.toString(), key) :
                decrypt(content.toString(), key);

        String newFileName = (choice == 1) ?
                "encrypted_output.txt" :
                "decrypted_output.txt";

        try (FileWriter writer = new FileWriter(newFileName)) {
            writer.write(result);
            System.out.println("Output written to: " + newFileName);
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }

        scanner.close();
    }

/********Encryption and Dryption using Caesar Cipher encryption Algorithm********/

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encrypted.append((char) ((ch - base + shift) % 26 + base));
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}
