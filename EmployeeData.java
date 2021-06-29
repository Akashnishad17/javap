import java.io.*;
import java.util.*;

class EmployeeData{

	public static class Employee{
		int id;
		String name;
		boolean isMale;

		public Employee(int id, String name, boolean isMale)
		{
			this.id = id;
			this.name = name;
			this.isMale = isMale;
		}
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String s;

		HashSet<Integer> ids = new HashSet<>();

		HashSet<Employee> set = new HashSet<>();

		boolean improper = false;

		while((s = br.readLine()) != null)
		{
			String[] data = s.split(",");

			int id = Integer.parseInt(data[0]);
			String name = data[1];
			boolean isMale = data[2].equals("true");

			if(ids.contains(id))
			{
				improper = true;
				break;
			}

			Employee e = new Employee(id, name, isMale);
			set.add(e);
			ids.add(id);
		}

		if(improper)
		{
			System.out.print("Error");
		}
		else
		{
			for(Employee e : set)
				System.out.println(e.id+","+e.name+","+e.isMale);
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}