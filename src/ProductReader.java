import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                String line;
                System.out.printf("%-10s %-20s %-40s %-10s\n", "ID", "Name", "Description", "Cost");
                System.out.println("================================================================================");
                while ((line = reader.readLine()) != null) {
                    // Use \\s+ to split on any whitespace (spaces, tabs, etc.)
                    String[] parts = line.trim().split("\\s+", 4);
                    if (parts.length == 4) {
                        System.out.printf("%-10s %-20s %-40s %-10s\n", parts[0], parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println("Invalid line format: " + line);
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
