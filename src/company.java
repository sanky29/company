	//import exception file
	import java.util.NoSuchElementException; 

	import java.util.Scanner;
	//import another exception file
	import java.lang.IllegalArgumentException;
	
	//import java input output file
	import java.io.*;

	import java.util.LinkedList;
	import java.util.Queue;
	
	public class company {
	//this is class for list of employee
		
		public class node<Type> {

			//the employee in the node
			private Type worker;
			
			//now define next worker on same level
			private node<Type> next;
			
			//now define the prev worker
			private node<Type> prev;
			
			//show the element 
			public Type show_element() {
				
				//just return the element
				return(worker);
			}
			
			//simillarly return next list
			public node<Type> show_next(){
				
				//show the next employee
				return(next);
			}
			
			//simillarly return prev list
				public node<Type> show_prev(){
					
					//show the next employee
					return(prev);
				}
				
			//now for changing next
			public void change_element(Type new_worker) {
				
				//just change present worker
				worker = new_worker;
			}
			
			//write function to change the next elements
			public void change_next(node<Type> new_next) {
				
				//just change the new element
				next = new_next;
			}
			
			//write function to change the prev elements
				public void change_prev(node<Type> new_prev) {
					
					//just change the new element
					prev = new_prev;
				}
			
			//make constructor
			public node (Type new_worker){
				
				//just define new element as element
				worker = new_worker;
				
				//and next to null
				next = null;
				
				//and prev to null
				prev = null;
			}
			public node (){
				
				//and next to null
				next = null;
				
				//and prev to null
				prev = null;
			}
		}
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
				
				
				//if no _0f_unem ==0 just change new elements as
			    if (no_of_unem ==0) {
			    	
			    	//change head
			    	under_employee_head = nemployee_head;
			    	
			    	//change tail
			    	under_employee_tail = nemployee_tail;
			    	
			    	//now change no of employee
			    	no_of_unem = no_of_new_employee;
			    }
			    else {
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
		}	
		//define node of tree
		//the tree is actually avl_ tree
		public class tnode<Type> {
			
			//also define the name of node
			private String name;
			
			//now the main thing the content
			private Type element; 
	
			//define the parent of tnode
			private tnode<Type> parent;
			
			//now define its height 
			private int arm;
			
			//also define the right child as
			private tnode<Type> right_child;
			
			//now define left child
			private tnode<Type> left_child;
			
			//just show the name
			public String show_name() {
				
				//just return the name
				return(name);
			}
			
			//write function to show parent
			public tnode<Type> show_parent() {
				
				//just return the show_parent
				return(parent);
			}
			
			//write function to show height
			public int show_arm() {
				
				//just return height
				return(arm);
			}
			
			//write function to show left parent
			public tnode<Type> show_left_child(){
				
				//just return show_left_node
				return(left_child);
			}
			
			//write function to show right parent
			public tnode<Type> show_right_child(){
					
				//just return show_left_node
				return(right_child);
			}
			
			//write function for changing parent
			public void change_parent(tnode<Type> new_parent) {
				
				//just change the parent
				parent = new_parent;
			}
			
			//write function for changing parent
			public void change_left_child(tnode<Type> new_left_child) {
					
				//just change the parent
				left_child = new_left_child;
			}
				
			//write function for changing parent
			public void change_right_child(tnode<Type> new_right_child) {
					
				//just change the parent
				right_child = new_right_child;
			}
			
			//write function to change height
			public void change_arm(int new_arm) {
				
				//just change height
				arm = new_arm;
			}
			
			//write function to show_employee
			public Type show_element() {
				
				//just return employee
				return(element);
			}
			
			//define constructor
			public tnode() {
				
				//set all variables to null
				arm = 0;
			    right_child = null;
			    parent = null;
			    left_child = null;
			    element = null;
			    name = null;
			}
			
			//define constructor with string input
			public tnode(String new_name, Type new_element) {
				
				//change name to this new thing
				name = new_name;
				
				//change element as
				element = new_element;				
			}
		}
		
	//define the binary search tree
	public class tree<Type> {

		//the variable that stores no_of_elements
		public int no_of_elements;
		
		//similarly define node as roo
		private tnode<Type> root;
		
		//now write function to search the name
		public tnode<Type> search_name(String name_node){
			
			//just go to root node
			tnode<Type> temporary = root;
			
			//direction variable
			int dir;
			
			//define dir_ or initiate it
			dir = name_node.compareTo(root.show_name());
			
			//just run while loop as
			//while left child is null or -1 
			while(dir != 0 && temporary != null ) {
				
				//change temporary according to dir_
				if (dir > 0) {
					
					//according to direction change the temporary
					//if dir = 1 go for right child
					temporary = temporary.show_right_child();
					
					
				}
				
				//else go for left child
				else {
					
					//go for left child
					temporary = temporary.show_left_child();
				}
				//now if temporary is null i will get null pointer exception
				//need to check temporary
				//now change direction as
				if (temporary != null) {
					
					//just change dir
					dir = name_node.compareTo(temporary.show_name());
				}
			}
			//just check for temporary and give answer
			if (temporary != null) {
				
				//just return the node
				return(temporary);
			}
			//else throw exception
			else {
				
				//just throw exception
				throw new NoSuchElementException("no such element found");
			}
		}
		//write function to add node and also balance the tree
		public void add_node(tnode<Type> new_node) {
			
			//let define new_name as name of new node
			String new_name = new_node.show_name();
			
			//define temporary node as
			tnode<Type> temporary = root;
			
			//just go close to the new_node
			//define direction integer as
			int dir = new_name.compareTo(temporary.show_name());
			
			//run while loop and reach to right child
			while((dir > 0 && temporary.show_right_child() != null) 
					|| (dir < 0 && temporary.show_left_child() != null)) {
				//change temporary according to dir_
				if (dir > 0) {
					//according to direction change the temporary
					//if dir = 1 go for right child
					temporary = temporary.show_right_child();
				}
				
				//else go for left child
				else {
					
					//go for left child
					temporary = temporary.show_left_child();
				
				}
				if (temporary != null) {
					
					//just change dir
					dir = new_name.compareTo(temporary.show_name());
				}
				
			}
			//now if dir_ = 0 then throw exception
			if (dir == 0) {
				
				//throw exception
				throw new IllegalArgumentException("the element already exist");		
			}
			//else if dir_ > 0 add node at right
			else if (dir > 0) {
				//for adding child just change the right node of temporary and parent of new_node
				temporary.change_right_child(new_node);
				
				//and parent of new node
				new_node.change_parent(temporary);
				
				no_of_elements++;
			}
			//else if dir_ < 0 add node at left
			else {
				//for adding child just change the right node of temporary and parent of new_node
				temporary.change_left_child(new_node);
				
				//and parent of new node
				new_node.change_parent(temporary);
				//increase no of element by one
				no_of_elements++;
			}
		}
		
		//delete element
		public void delete_node(String old_element) {
			
			//just search nearest one as
			tnode<Type> temporary = root;
		
			//run while loop
			//define direction variable
			int dir;
			
			//define dir_ or initiate it
			dir = old_element.compareTo(root.show_name());
					
			//just run while loop as
			//while left child is null or -1 
			while(dir != 0 && temporary != null ) {
						
				//change temporary according to dir_
				if (dir > 0) {
					
					//according to direction change the temporary
					//if dir = 1 go for right child
					temporary = temporary.show_right_child();
					
				
				}
				
				//else go for left child
				else {
					
					//go for left child
					temporary = temporary.show_left_child();
				}
				//now if temporary is null i will get null pointer exception
				//need to check temporary
				//now change direction as
				if (temporary != null) {
					
					//just change dir_
					dir = old_element.compareTo(temporary.show_name());
				}
			}
			
			//else throw exception
			if (temporary == null) {
				
				//just throw exception
				throw new NoSuchElementException("no such element found");
			}
			//what if temporary is root then
			if (temporary.show_parent() == null) {
				
				no_of_elements--;
				
				//just change root on following conditions
				if (temporary.show_right_child() == null) {
					
					//make left child as root
					root = temporary.show_left_child();
					
					//change root parent
					root.change_parent(null);
					
					
				}
				
				//just change root on following conditions
				if (temporary.show_left_child() == null) {
					
					//make left child as root
					root = temporary.show_right_child();
					
					//change root parent
					root.change_parent(null);
				}
				
				//else do in-order traversal and get the answer
				else {
					
					//do in order traversal
					tnode<Type> temp = temporary.show_right_child();
					
					//while tnode.leftchild != null do
					while(temp.show_left_child() != null) {
						
						//just change temp_ to left_child
						temp = temp.show_left_child();
					}
					//now replace temp child as root
					//but if it has right child then
					if (temp.show_right_child() != null) {
						
						//change right and left child of temp
						temp.change_left_child(temporary.show_left_child());
						
						//if temporary is parent of just grater element
						if (temp.show_parent() == temporary) {
							
							//change parent of root
							temp.change_parent(null);	
						
							root = temp;
						}
						else {
			
							//change child of parent
							temp.show_parent().change_left_child(temp.show_right_child());
					
							//also the parent of child
							temp.show_right_child().change_parent(temp.show_parent());
					
							//also the right
							temp.change_right_child(temporary.show_right_child());
					
							//change parent of root
							temp.change_parent(null);
							
							
							root = temp;
						}
				}
					//else just chane root
					else {
						
						//change right and left child of temp
						temp.change_left_child(root.show_left_child());
						
						//also the right
						temp.change_right_child(root.show_right_child());
						
						temp.show_parent().change_left_child(null);
						
						//change root
						root = temp;
						
						//change parent of root
						root.change_parent(null); 
					}
					
					temporary.show_right_child().change_parent(temp);
					temporary.show_left_child().change_parent(temp);
				}
			}
			
			
			//now need to use delete conditions
			else if (temporary.show_left_child() == null && temporary.show_right_child() == null) {
				
				no_of_elements--;
				
				//in this just change parent nodes child
				if (temporary.show_parent().show_left_child() == temporary) {
					
					//just get rid of left_child
					temporary.show_parent().change_left_child(null);
				}
				//else change right child
				else {
					
					//just change right child
					temporary.show_parent().change_right_child(null);
				}
			}
			//else if only right child is null then
			else if (temporary.show_right_child() == null) {
				
				no_of_elements--;
				
				//change parent of left child
				temporary.show_left_child().change_parent(temporary.show_parent());
				
				//just change parent of right child and child of parent
				//in this just change parent nodes child
				if (temporary.show_parent().show_left_child() == temporary) {
					
					//just get rid of left_child
					temporary.show_parent().change_left_child(temporary.show_left_child());
				}
				//else change right child
				else {
					
					//just change right child
					temporary.show_parent().change_right_child(temporary.show_left_child());
				}
			}
				//else if only right child is null then
				else if (temporary.show_left_child() == null) {
					
					no_of_elements--;
					
					//change parent of left child
					temporary.show_right_child().change_parent(temporary.show_parent());
					
					//just change parent of right child and child of parent
					//in this just change parent nodes child
					if (temporary.show_parent().show_left_child() == temporary) {
						
						//just get rid of left_child
						temporary.show_parent().change_left_child(temporary.show_right_child());
					}
					
					//else change right child
					else {
					
						//just change right child
						temporary.show_parent().change_right_child(temporary.show_right_child());
					}
				}
				//else do in oder traversal
				else {
				
					no_of_elements--;

					//do in order traversal
					tnode<Type> temp = temporary.show_right_child();
				
					//while tnode.leftchild != null do
					while(temp.show_left_child() != null) {
					
						//just change temp_ to left_child
						temp = temp.show_left_child();
					}
					//now replace temp child as root
					//but if it has right child then
					if (temp.show_right_child() == null ) {
					
						//change right and left child of temp
						temp.change_left_child(temporary.show_left_child());
					
						if (temp != temporary.show_right_child()) {//also the right
							temp.change_right_child(temporary.show_right_child());
							}
					
						//change parent of root
						temp.change_parent(temporary.show_parent());
					}
					else {
						//change right and left child of temp
						temp.change_left_child(temporary.show_left_child());
						
						if (temp.show_parent() == temporary) {
							
							//change parent of root
							temp.change_parent(temporary.show_parent());	
							
							temporary.show_left_child().change_parent(temp);
						
						}
						else {
			
							//change child of parent
							temp.show_parent().change_left_child(temp.show_right_child());
					
							//also the parent of child
							temp.show_right_child().change_parent(temp.show_parent());
					
							//also the right
							temp.change_right_child(temporary.show_right_child());
					
							//change parent of root
							temp.change_parent(temporary.show_parent());
							
							temporary.show_right_child().change_parent(temp);
							temporary.show_left_child().change_parent(temp);
						}
					}
				
					
					if(temporary.show_parent().show_left_child() == temporary) {
						
						temporary.show_parent().change_left_child(temp);
					}
					else {
						temporary.show_parent().change_right_child(temp);
					}
					//else just chane root
			
			}
		}
		
			//define constructor
		public tree() {
			root = null;
			no_of_elements = 0;
		}
		public tree(tnode<Type> x) {
			root = x;
			no_of_elements = 1;
		}
	}
	//define the tree of sorted elements 
	private tree<employee> tree;
	
	//define ceo employee
	private employee ceo;
	
	//maximum level in company
	int max_level;
	
	public void AddEmployee( String new_employee, String boss) {
		
		//find boss
		employee temp = tree.search_name(boss).show_element();
		
		//create new employee
		employee temp_new = new employee(new_employee, temp);
		
		//add employee to boss
		temp.add_aemployee(temp_new);
		
		//create new node of new employee
	    tnode<employee> temp_node = new tnode<employee>(new_employee,temp_new);
	    
	    //add it to tree
	    tree.add_node(temp_node);
	    
	    //change max_level
	    if (max_level < temp_new.show_level()) {
	    	max_level =  temp_new.show_level();
	    }
	}
	
	public void DeleteEmployee(String remove_employee, String serve ) {
		
		//find removal employee and another employee
		employee temp = tree.search_name(remove_employee).show_element();
		
		employee temp2 = tree.search_name(serve).show_element();
		
		//delete removal employee from boss
		temp.show_boss().delete_employee(temp);
		
		//add all employee of removal employee to another employee
		//change their boss to another
		if (temp.show_no() != 0) {
		node<employee> temp3 = temp.show_unem().show_next();
		
		while (temp3 != temp.show_unem_tail() ) {
			
			temp3.show_element().change_boss(temp2);
			
			temp3 = temp3.show_next();
		}
		//add all employee to another
		temp2.add_employees(temp.show_unem(), temp.show_unem_tail(), temp.show_no());
		//delete employee from tree
		tree.delete_node(remove_employee);
	}}
	
	public void LowestCommanBoss (String s1 , String s2) {
		
		//find both employee
		employee temp = tree.search_name(s1).show_element();
		employee temp2 = tree.search_name(s2).show_element();
		
		//if they are boss of each other then simple
		if (temp == temp2.show_boss()) {
			System.out.println(temp.show_name());
			}
		else if (temp2 == temp.show_boss()) {
			System.out.println(temp2.show_name());
		}
		
		//else traverse in tree to get same boss
		else {
				employee b1 = temp;
				employee b2 = temp2;
				while(b1 != b2) {
					
					//if both are at same level traverse both once
					//else one at high level should travel quick
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
		public void PrintEmployees () {
	         Queue<employee> x = new LinkedList<>();
	         x.add(ceo);
	         employee temp;
	         node<employee> temp2;
	         while(x.size() != 0) {
	        	 temp = x.remove();
	        	 System.out.println(temp.show_name());
	        	 temp2 = temp.show_unem();
	        	 if (temp.show_no() > 0) {
	        		 for (int i = 1 ; i<= temp.show_no(); i++) {
	        			 temp2 = temp2.show_next();
	        			 x.add(temp2.show_element());
	        		 }
	        	 }
	         }
	         
	}
	//define constructor
	public company(String c) {
		ceo = new employee(c);
		ceo.change_level(1); 
		tree = new tree<>(new tnode<employee>(c,ceo));
		max_level = 1;
		
	}
	public static void main (String args[]) {
		
		//take input name of file
		String name_of_file = args[0];
		
		
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
			
			//first no_of_operations
			temp_line = scan.nextLine();
			
			//now see the no_of_operations
			no_of_operations = Integer.valueOf(temp_line);
			
			//run for loop as
			for (int j = 1 ; j <= no_of_operations; j++) {
				
				//read the input
				temp_line = scan.nextLine();
				
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
				}
			
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
