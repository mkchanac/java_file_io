import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class CreateEmployeesRandomFile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Path file = Paths.get(
				"C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\RandomEmployees.txt");
		String s = "000,       ,00.00" + System.getProperty("line.separator");
		final int RECSIZE = s.length();
		FileChannel fc = null;
		String delimiter = ",";
		String idString;
		int id;
		String name;
		String payRate;
		final String QUIT = "999";
		try {
			fc = (FileChannel) Files.newByteChannel(file, READ, WRITE);
			System.out.println("Enter employee ID number >> ");
			idString = input.nextLine();
			while (!(idString.equals(QUIT))) {
				id = Integer.parseInt(idString);
				System.out.println("Enter name for employee#" + id + " >> ");
				name = input.nextLine();
				System.out.println("Enter pay rate >> ");
				payRate = input.nextLine();
				s = idString + delimiter + name + delimiter + payRate + System.getProperty("line.separator");
				byte[] data = s.getBytes();
				ByteBuffer buffer = ByteBuffer.wrap(data);
				fc.position(id * RECSIZE);
				fc.write(buffer);
				System.out.println("Enter next ID number or " + QUIT + " to quit >> ");
				idString = input.nextLine();
			}
			fc.close();
		} catch (Exception e) {
			System.out.println("Error Message: " + e);
		}
	}
}
