import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("Enter product details:");
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description");
            double cost = SafeInput.getDouble(scanner, "Enter Product Cost");

            String productRecord = id + " " + name + " " + description + " " + cost;
            products.add(productRecord);

            String response = SafeInput.getNonZeroLenString(scanner, "Do you want to add another product (yes/no)?").trim().toLowerCase();
            if (response.equals("no")) {
                done = true;
            }
        }

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save the data");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
