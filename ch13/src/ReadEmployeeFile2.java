import java.nio.file.*;
import java.io.*;

public class ReadEmployeeFile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path file = Paths.get("C:\\Users\\unite\\Desktop\\Douglas College\\2. 2021 Summer\\CSIS2175 Adv Integrated Software Dev (java)\\Week12\\Employees.txt");
		String s = "";
		String[] array = new String[3];
		String delimiter = ",";
		int id;
		String name;
		double payRate;
		double gross;
		double total = 0;
		final double HRS_IN_WEEK = 40;
		
		try{
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			s = reader.readLine();
			while (s!=null) {
				array = s.split(delimiter);
				id = Integer.parseInt(array[0]);
				name = array[1];
				payRate = Double.parseDouble(array[2]);
				gross = payRate * HRS_IN_WEEK;
				total += gross;
				System.out.println("ID#" + id + "	" + name  + "	$" + payRate + "	$" + gross);
				s = reader.readLine();
			}
			reader.close();
			System.out.println("  Total gross payroll is $" + total);
		} catch (Exception e) {
			System.out.println("Message: " + e);
		}

	}

}
