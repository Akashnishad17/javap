import java.util.HashSet;
import java.util.Scanner;

class InvalidInputException extends Exception {
    
}

class Employee {
   
   private int id = 0;
   private String name = null;
   private boolean male = true;
    
    Employee(int id, String name,  boolean male) {
       super();
       this.id = id;
       this.name = name;
       this.male = male;
   }
     
   @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ",  male=" + male + "]";
    }   
    
    @Override
    public int hashCode() {
        return id;
    }
       
   
}

public class Test {
    
    /*
    * Validate the input and create Employee object
    * If any of the given input is not valid throw InvalidInputException();
    */

    public static HashSet<Integer> ids = new HashSet<>();

    public staitc Employee createEmployee(String record) throws Exception{
        
        String[] data = record.split(",");

        int id = -1;
        String name = null; 
        boolean isMale = false;

        try{
          int id = Integer.parseInt(data[0]);
          String name = data[1];
          boolean isMale = data[2].contains("true");

          employee = new Employee(id, name, male);
        }catch(Exception e){
          throw new InvalidInputException();
        }

        if(ids.contains(id) || data.length != 3)
          throw new InvalidInputException();

        ids.add(id);

        return return employee;        
    }
    
    public static void main(String[] str) {
        
        //Input is expected as comma separated values for Employee object like id(int), name (String),isMale(boolean)"
        // 1,John,true
        Scanner scan = new Scanner(System.in);
        
        HashSet<Employee> employeeSet = new HashSet<>();
        
        /Process each line and create Employee object using the "createEmployee" method add in employeeSet/
        while (true) {
            try {
                if(scan.hasNext())
                {
                  Sting record = scan.nextLine();
                  Employee employee = createEmployee(record);
                  employeeSet.add(employee);
                }
                else
                  break;

            }catch(Exception e) {
                System.out.println(e.getClass().getName());
                System.exit(0);
            }
         
        }
        
        //Don't delete or modify this print statement
        System.out.println("Employees info : "+ employeeSet);
   
    }

}