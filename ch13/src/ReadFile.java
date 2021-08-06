import java.nio.file.*;
import java.io.*;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\Grades.txt");
		InputStream input = null;
		try {
			input = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String s = null;
			s = reader.readLine();
			System.out.println(s);
			input.close();
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
