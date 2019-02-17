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
	//now write function 
	//each node will contail an heigth also
	public static void main(String args[]) {
		
		System.out.println("w".compareTo("z"));
	}
}
