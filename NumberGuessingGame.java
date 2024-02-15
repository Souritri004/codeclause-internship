import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        
        Random random = new Random();
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");
        
        while (true) {
            String input = JOptionPane.showInputDialog("Enter a number between " + lowerBound + " and " + upperBound + ":");
            
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Thank you for playing. Your score: " + score);
                break;
            }
            
            int guessedNumber = Integer.parseInt(input);
            
            if (guessedNumber == generatedNumber) {
                score += maxAttempts;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number. Your score: " + score);
                generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            } else if (guessedNumber < generatedNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
                maxAttempts--;
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
                maxAttempts--;
            }
            
            if (maxAttempts <= 0) {
                JOptionPane.showMessageDialog(null, "Game over! The number was " + generatedNumber + ". Your score: " + score);
                generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                maxAttempts = 10;
            }
        }
    }
}
