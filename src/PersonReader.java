import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                String line;
                System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println("=============================================================");
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 5) {
                        System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", parts[0], parts[1], parts[2], parts[3], parts[4]);
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File selection was canceled.");
        }
    }
}
