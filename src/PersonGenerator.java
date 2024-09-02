import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("Enter person details:");
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            
            // Adjusted the year of birth range to 1800 - 2100 for flexibility
            int yob = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 1000, 2100);

            String personRecord = id + " " + firstName + " " + lastName + " " + title + " " + yob;
            persons.add(personRecord);

            String response = SafeInput.getNonZeroLenString(scanner, "Do you want to add another person (yes/no)?").trim().toLowerCase();
            if (response.equals("no")) {
                done = true;
            }
        }

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save the data");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String person : persons) {
                writer.write(person);
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
