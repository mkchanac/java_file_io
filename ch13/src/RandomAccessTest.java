import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import static java.nio.file.StandardOpenOption.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class RandomAccessTest {
	public static void main(String[] args) {
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\Numbers.txt");
		String s = "XYZ";
		byte[] data = s.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);
		FileChannel fc = null;
		try {
			fc = (FileChannel)Files.newByteChannel(file, READ, WRITE);
			fc.position(0);
			while(out.hasRemaining()) {
				fc.write(out);
			}
			out.rewind();
			fc.position(22);
			while(out.hasRemaining()) {
				fc.write(out);
			}
			out.rewind();
			fc.position(12);
			while(out.hasRemaining()) {
				fc.write(out);
			}
			fc.close();
			
		} catch (Exception e) {
			System.out.println("Error Message: " + e);
		}
		
		
	}
}
