package excersice_3;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;




public class App {
	public static void main(String[] args) {

		try (
	            Scanner fileScanner = new Scanner(new File("students.txt"));
	            PrintWriter writer = new PrintWriter("grades_report.txt")
	        ) {

	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine().trim();
	                String[] parts = line.split("\\s+");
	                String name = parts[0];

	                try {
	                    int score1 = Integer.parseInt(parts[1]);
	                    int score2 = Integer.parseInt(parts[2]);
	                    int score3 = Integer.parseInt(parts[3]);

	                    double average = (score1 + score2 + score3) / 3.0;

	                    writer.println("Student: " + name + " Average: " + average);

	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid for " + name + " skipping line: " + line);
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Error: Could not process files.");
	            e.printStackTrace();
	        } finally {
	            System.out.println("Processing Complete");
	        }
	    }

}


