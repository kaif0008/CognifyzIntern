import java.util.Scanner;

public class PasswordStrengthCheckerWithFeedback {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        int score = 0;
        StringBuilder feedback = new StringBuilder();

        if (password.length() >= 8) {
            score++;
        } else {
            feedback.append("- Password should be at least 8 characters long.\n");
        }

        if (password.matches(".*[a-z].*")) {
            score++;
        } else {
            feedback.append("- Add at least one lowercase letter.\n");
        }

        if (password.matches(".*[A-Z].*")) {
            score++;
        } else {
            feedback.append("- Add at least one uppercase letter.\n");
        }

        if (password.matches(".*[0-9].*")) {
            score++;
        } else {
            feedback.append("- Add at least one digit.\n");
        }

        if (password.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};:'\"\\\\|,.<>/?].*")) {
            score++;
        } else {
            feedback.append("- Add at least one special character (e.g., !, @, #, etc.).\n");
        }

        System.out.println("\nPassword Strength: ");
        switch (score) {
            case 5:
                System.out.println("Very Strong");
                break;
            case 4:
                System.out.println("Strong");
                break;
            case 3:
                System.out.println("Moderate");
                break;
            case 2:
                System.out.println("Weak");
                break;
            default:
                System.out.println("Very Weak");
        }

        if (score < 5) {
            System.out.println("\nSuggestions to improve your password:");
            System.out.println(feedback.toString());
        }

        scanner.close();
    }
}
