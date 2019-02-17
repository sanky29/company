//define the employee as name with boss and under employee
public class employee {
	
	//define the name of employee
	private String name;
	
	//define the boss as follows
	private employee boss;
	
	//private level
	private int level;
	
	//define under_employee list
	private node<employee> under_employee_head;
	
	//now storing tail will also help me to directly add
	//all the elements to next boss
	private node<employee> under_employee_tail;
	
	//no_of under employee 
	private int no_of_unem;
	
	//show no_of_unem
	public int show_no() {
		
		//just return no
		return(no_of_unem);
	}
	
	//write function to return the above information
	//return the name of employee
	public String show_name() {
		
		//just return the name
		return(name);
	}
	//show_level
	public int show_level() {
		
		return(level);
	}
	//now return the boss
	public employee show_boss() {
		
		//just return the boss
		return(boss);
	}
	
	//similarly write function to return under employee
	public node<employee> show_unem(){
		
		//just return the node of employee
	    return(under_employee_head);
	}
	
	//similarly write function to return under employee
		public node<employee> show_unem_tail(){
			
			//just return the node of employee
		    return(under_employee_tail);
		}
	
	//similarly define function to change boss
	public void change_boss(employee new_boss) {
		
		//just change the boss
		boss = new_boss;
	}
	public void change_level(int x) {
		level = x;
	}
	//now if you wnat to add a employee then
	public void add_aemployee(employee new_employee) {
		
		//just create new node and add it to list of under employee
		node<employee> new_node = new node<>(new_employee);
		
		//now just change next of this node to under_employee
		new_node.change_next(under_employee_head.show_next());
		
		//now just change prev of this node to head
		new_node.change_prev(under_employee_head);
		
		//change pre of next elemeny
		under_employee_head.show_next().change_prev(new_node);
		
		//change new_node to under employee
		under_employee_head.change_next(new_node);
		
		new_employee.change_level(level + 1);
		
		//increase no of employee by one
		no_of_unem++;
	}
	
	//if we wnat to add bulk employee then
	//just take list head and tail input
	public void add_employees(node<employee> nemployee_head, node<employee> nemployee_tail, int no_of_new_employee) {
		
		
	
		//join head and tail of new_list and prev_list respectively
		//now prev_ of tail is some employee
		//we will change its next to head.next of new_employee list
		under_employee_tail.show_prev().change_next(nemployee_head.show_next());
		
		nemployee_head.show_next().change_prev(under_employee_tail);
		
		//also change tail as new tail
		under_employee_tail = nemployee_tail;
		
		//increase no_of_unem
		no_of_unem = no_of_unem + no_of_new_employee; 
		
	}
	
	//just just search for employee in the list
	public boolean search_employee(employee nemployee) {
		
		//check if list is empty or something
		if ( no_of_unem == 0 ) {
			
			//just throw false
			return(false);
		}
		
		//else just check for tail and then start the loop
		else if (under_employee_tail.show_prev().show_element() == nemployee) {
			
			//just retuen true
			return(true);
		}
		
		//else run loop
		else {
			
			//start counter i
			int i = 1;
			
			//check cureent node
			node<employee> current_employee = under_employee_head;
			
			//just run while loop
			//conditions are i <= n and we not have found nemployee yet
			while(i <= no_of_unem && current_employee.show_element() != nemployee) {
				
				//just change current_employee to next
				current_employee = current_employee.show_next();
				
				//and increase i by 1
				i++;
			}
			
			//now return true or false
			return(current_employee.show_element() == nemployee);
		}
	}
	
	//delete the employee as
	public void delete_employee(employee nemployee) {
		
		//just search for it and then delete
		//check if list is empty or something
		if ( no_of_unem == 0 ) {
			
			//just throw exception
			throw new IndexOutOfBoundsException("bad search");
		}
		
		//else just check for tail and then start the loop
		else if (under_employee_tail.show_prev().show_element() == nemployee) {
			
			//just change neaxt prev element
			under_employee_tail.show_prev().show_prev().change_next(under_employee_tail);
			
			//similarly chnage prev of tail
			under_employee_tail.change_prev(under_employee_tail.show_prev().show_prev());
			
			//decrease no of employee by one
			no_of_unem--;
		}
		
		//else run loop
		else {
			
			//start counter i
			int i = 1;
			
			//check cureent node
			node<employee> current_employee = under_employee_head;
			
			//just run while loop
			//conditions are i <= n and we not have found nemployee yet
			while(i <= no_of_unem && current_employee.show_element() != nemployee) {
				
				//just change current_employee to next
				current_employee = current_employee.show_next();
				
				//and increase i by 1
				i++;
			}
			
			//if we found element then delete
			if (current_employee.show_element() == nemployee) {
				
			
				//now just delete element
				//first change next of prev element
				current_employee.show_prev().change_next(current_employee.show_next());
			
				//now change prev of next element
				current_employee.show_next().change_prev(current_employee.show_prev());
				
				//decrease no of employee by one
				no_of_unem--;
			}
			//else throw error
			else {
				
				//trow error
				throw new IndexOutOfBoundsException("you have not found");
			}
		}

	}
	
	//just print the function
	public void print_employee() {
		
		//if len != 0 then proceed
		if (no_of_unem != 0) {
			
			//define current node as head
			node<employee> current_employee = under_employee_head;
			
			//just run while loop
			for (int i = 1 ; i <= no_of_unem; i++) {
				
				//just change current_employee to next
				current_employee = current_employee.show_next();
				
				//print the employee
				System.out.println(current_employee.show_element().name);
				
			}
		}

	}
	//define constructor as
	//if only name is given
	public employee(String name_of_employee) {
		
		//define the name of employee
		name = name_of_employee;
		
		//define the boss as null
		boss = null;
		
		//define under_employee list as null
		under_employee_head = new node<employee>();
		
		//now storing tail will also help me to directly add
		//all the elements to next boss
		under_employee_tail = new node<employee>();
		
		//no_of under employee 
		no_of_unem = 0;
		
		//change next of head
		under_employee_head.change_next(under_employee_tail);
		
		//similarly the back also
		under_employee_tail.change_prev(under_employee_head);
		
		level = 0;
		 
	}
	//define constructor as
	//if only name is given
	public employee(String name_of_employee, employee name_of_boss) {
		
		//define the name of employee
		name = name_of_employee;
		
		//define the boss as name_of_boss
		boss = name_of_boss;
		
		//define under_employee list as null
		under_employee_head = new node<employee>();
		
		//now storing tail will also help me to directly add
		//all the elements to next boss
		under_employee_tail = new node<employee>();
		
		//no_of under employee 
		no_of_unem = 0;
		
		//change next of head
		under_employee_head.change_next(under_employee_tail);
		
		//similarly the back also
		under_employee_tail.change_prev(under_employee_head);
		
		//level will be
		level = name_of_boss.show_level() + 1;
		 
	}
	public static void main(String args[]) {
		employee ceo = new employee("sanket");
		employee cto = new employee("shaify",ceo);
		ceo.add_aemployee(cto);
		ceo.add_aemployee(new employee("utkarsh" , ceo));
		ceo.add_aemployee(new employee("aryan" , ceo));
		System.out.println(ceo.show_no());
		cto.add_aemployee(new employee("gautam" , cto));
		
		System.out.println(ceo.search_employee(cto));
		ceo.print_employee();
		cto.print_employee();
	}
}	
