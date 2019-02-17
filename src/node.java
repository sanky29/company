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
