import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class ReadEmployeesRandomly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\RandomEmployees.txt");
		String s = "000,       ,00.00" + System.getProperty("line.separator");
		final int RECSIZE = s.length();
		byte[] data = s.getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(data);
		FileChannel fc = null;
		String idString;
		int id;
		final String QUIT = "999";
		try {
			fc = (FileChannel)Files.newByteChannel(file, READ,WRITE);
			System.out.println("Enter employee ID number or " + QUIT + " to quit >> ");
			idString = keyboard.nextLine();
			while(!idString.equals(QUIT)) {
				id = Integer.parseInt(idString);
				buffer = ByteBuffer.wrap(data);
				fc.position(id * RECSIZE);
				fc.read(buffer);
				s = new String(data);
				System.out.println("ID #" + id + " " + s);
				System.out.println("Enter employee ID number or " + QUIT + " to quit >> ");
				idString = keyboard.nextLine();
			}
			fc.close();
		} catch(Exception e) {
			System.out.println("Error Message: " + e);
		}
	}

}
