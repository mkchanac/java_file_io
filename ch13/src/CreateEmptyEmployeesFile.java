import java.nio.file.*;
import java.io.*;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;

public class CreateEmptyEmployeesFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\RandomEmployees.txt");
		String s = "000,       ,00.00" + System.getProperty("line.separator");
		byte[] data = s.getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(data);
		final int NUMERECS = 1000;
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			for (int count = 0 ; count < NUMERECS; count++) {
				writer.write(s,0,s.length());
			}
			writer.close();
			
		}catch (Exception e) {
			System.out.println("Error Message: " + e);
		}
	}

}
