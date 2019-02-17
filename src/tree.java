//import exception file
import java.util.NoSuchElementException; 

import java.util.Scanner;
//import another exception file
import java.lang.IllegalArgumentException;

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
					
				
					
					if (temp.show_parent() == temporary) {
						
						//change parent of root
						temp.change_parent(null);	
					
						root = temp;
						temporary.show_right_child().change_parent(temp);
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
						temp.change_parent(null);
						
						temporary.show_right_child().change_parent(temp);
						temporary.show_left_child().change_parent(temp);
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
				
					//also the right
					temp.change_right_child(temporary.show_right_child());
				
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
	
	public void print_tree() {
		
		int dir = -1;
		tnode<Type> temp = root;
		tnode<Type> tempp = root.show_parent();
		int i = no_of_elements;
		while(i > 0) {
			switch(dir) {
			
			case -1:
				if (temp.show_left_child() == null) {
					dir = 0;
					}
				else {
					tempp = temp;
					temp = temp.show_left_child();
				}
				break;
			case 0:
				System.out.println(temp.show_name());
				dir = 1;
				i--;
			
				break;
			case 1:
				if (temp.show_right_child() != null) {
					tempp = temp;
					temp = temp.show_right_child();
					dir = -1;
				}
				else if( tempp != null) {
					dir = 2;
				}
				break;
			case 2:
				if (tempp == null) {
					tempp = temp; 
					temp = temp.show_right_child();
					dir = -1;
				}
				else if (tempp.show_right_child() == temp) {
					temp = tempp;
					tempp = temp.show_parent();
				}
				else {
					temp = tempp;
					tempp = temp.show_parent();
					dir = 0;
				}
			}
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
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		employee x = new employee("s");
		tnode<employee> y = new tnode<>("s",x);
		tree<employee> tree = new tree<>(y);
	    String t = scan.nextLine();
		while (t.compareTo("stop") != 0) {
			
			switch(t){
				
			case "add":
				t = scan.nextLine();
				tree.add_node(new tnode<employee>(t, new employee(t)));
					break;
					
			case "delete":
				t = scan.nextLine();
				tree.delete_node(t);
				break;
					
			case "search":
				t = scan.nextLine();
				System.out.println(tree.search_name(t).show_element().show_name());
				break;
			case "no":
				System.out.println(tree.no_of_elements);
				break;
			case "p":
				tree.print_tree();
				break;
			default :
				break;
					
			}
			t = scan.nextLine();
		}
		scan.close();
	}
}	
