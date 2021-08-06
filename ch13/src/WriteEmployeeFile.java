import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class WriteEmployeeFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\Employees.txt");
		String s = "";
		String delimiter = ",";
		int id;
		String name;
		double payRate;
		final int QUIT = 999;
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			System.out.println("Enter employee ID number >> ");
			id = input.nextInt();
			while (id != QUIT) {
				System.out.println("Enter name for employee #" + id + " > ");
				input.nextLine();
				name = input.nextLine();
				System.out.println("Enter pay rate >> ");
				payRate = input.nextDouble();
				s = id + delimiter + name + delimiter + payRate;
				writer.write(s, 0, s.length());
				writer.newLine();
				System.out.println("Enter next ID number or " + QUIT + " to quit >> ");
				id = input.nextInt();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Message: " + e);
		}
	}

}
