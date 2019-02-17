import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class company {
        
	tree<employee> tree;
	
	employee ceo;
	
	int max_level;
	
	public void AddEmployee( String new_employee, String boss) {
		
		employee temp = tree.search_name(boss).show_element();
		
		employee temp_new = new employee(new_employee, temp);
		
		temp.add_aemployee(temp_new);
		
	    tnode<employee> temp_node = new tnode<employee>(new_employee,temp_new);
	    
	    tree.add_node(temp_node);
	    
	    if (max_level < temp_new.show_level()) {
	    	max_level =  temp_new.show_level();
	    }
	}
	
	public void DeleteEmployee(String remove_employee, String serve ) {
		
		employee temp = tree.search_name(remove_employee).show_element();
		
		employee temp2 = tree.search_name(serve).show_element();
		
		temp.show_boss().delete_employee(temp);
		
		node<employee> temp3 = temp.show_unem().show_next();
		
		while (temp3 != temp.show_unem_tail() ) {
			
			temp3.show_element().change_boss(temp2);
			
			temp3 = temp3.show_next();
		}
		
		temp2.add_employees(temp.show_unem(), temp.show_unem_tail(), temp.show_no());
		tree.delete_node(remove_employee);
	}
	
	public void LowestCommanBoss (String s1 , String s2) {
		employee temp = tree.search_name(s1).show_element();
		employee temp2 = tree.search_name(s2).show_element();
		if (temp == temp2.show_boss()) {
			System.out.println(temp.show_name());
			
		}
		else if (temp2 == temp.show_boss()) {
			System.out.println(temp2.show_name());
		}
		else {
				employee b1 = temp;
				employee b2 = temp2;
				while(b1 != b2) {
					if (b1.show_level() == b2.show_level()) {
						b1 = b1.show_boss();
						b2 = b2.show_boss();
					}
					else if (b1.show_level() > b2.show_level() ) {
						b1 = b1.show_boss();
					}
					else {
						b2 = b2.show_boss();	
					}
				}
				System.out.println(b1.show_name());
		}
	}
	public static void print_employees_ith(employee x, int i) {
		if (x.show_level() == i - 1 ) {
		     x.print_employee() ;
		}
		else if (x.show_level() >= i) {
			
		}
		else {
			if (x.show_no() != 0) {
				node<employee> temp = x.show_unem().show_next();
			for (int j =1 ; j <= x.show_no() ; j++) {
				print_employees_ith(temp.show_element(), i);
				temp = temp.show_next();
			}
			}
		}
		
	}
	public void PrintEmployees () {
		System.out.println(ceo.show_name());
		if (max_level > 1){
		for(int i = 2 ; i <= max_level; i++ ) {
			print_employees_ith(ceo , i);
		}}
		}
	
	public company(String c) {
		ceo = new employee(c);
		ceo.change_level(1); 
		tree = new tree<>(new tnode<employee>(c,ceo));
		max_level = 1;
		
	}
  public static void main (String args[]) {
		
		//take input name of file
		String name_of_file = "input.txt";
		
		
		try {
			//create input stream
			FileInputStream instream = new FileInputStream(name_of_file);
			
			//create scanner varaible for reading from file
			Scanner scan = new Scanner(instream);
			
			//define temprory variable
			String temp_line = scan.nextLine();
			
			//define no of operations
			Integer no_of_operations = Integer.valueOf(temp_line);
			
			//know the name of ceo
			//first name is name of ceo_ hence
			temp_line = scan.nextLine();
			
			//declare the new string array as
			//split at space
			String[] temp0_array = temp_line.split(" ", -1);
			
			//define company as
			company company = new company(temp0_array[1]);
			
			//add employee as
			company.AddEmployee(temp0_array[0], temp0_array[1]);
			
			//run for loop for this
			for(int i = 2 ; i <= no_of_operations - 1; i++ ) {
				
				//just read next line
				temp_line = scan.nextLine();
								
				//declare the new string array as
				//split at space
				String[] temp_array = temp_line.split(" ", -1);
				
				//just add employee 0 and 1
				company.AddEmployee(temp_array[0], temp_array[1]);
			}
			company.tree.search_name("Hrj4xq1_1_0_4").show_element().print_employee();
			company.DeleteEmployee("Hrj4xq1_1_0_4", "owcHTbN_1_0_1");
			System.out.println("now");
			company.tree.search_name("owcHTbN_1_0_1").show_element().print_employee();
			Scanner scan2 = new Scanner(System.in);
			//first no_of_operations
			temp_line = scan2.nextLine();
			
			
			//run for loop as
			while (temp_line !=  "stop") {
				
				//now define the array as
				String[] temp2_array = temp_line.split(" ", -1);
				
				//now switch on arg[0]
				switch(temp2_array[0]) {
				
					//for 0 we should add employee
					case "0":
					    //just add the employee
						company.AddEmployee(temp2_array[1], temp2_array[2]);
						break;
					
					//next type is 1	
					case "1":
						//just add the employee
						company.DeleteEmployee(temp2_array[1], temp2_array[2]);
						break;

					//the next one is 2
					case "2":
						//just show the common boss as
						company.LowestCommanBoss(temp2_array[1], temp2_array[2]);
						break;
						
					//for three just print tree	
					case "3":
						//just print tree
						company.PrintEmployees();
						break;
					
					default :
						break;
						
				}
				//read the input
				temp_line = scan2.nextLine();
			}
			//just close the scan object
			scan.close();
		}
		//define catch block to handle exception
		catch (FileNotFoundException e){
			
			//just print file not found
			System.out.println("File not found");
			
		}
				
	}
}


