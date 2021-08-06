import java.nio.file.*;
import java.io.*;

public class ReadEmployeeFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\Employees.txt");
		String s = "";
		try{
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			s = reader.readLine();
			while (s!=null) {
				System.out.println(s);
				s = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Message: " + e);
		}

	}

}
