import javax.swing.*;

public class InvalidTextNumberInputException extends Exception {
    public InvalidTextNumberInputException(String message) {
        super(message);
    }
    public void showErrorMessage() {
        JOptionPane.showMessageDialog(null, getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
