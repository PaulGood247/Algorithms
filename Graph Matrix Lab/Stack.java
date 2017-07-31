// StackTest.java
// Linked list implementation of Stack

class Stack {

	class Node {
        public int data;
        public Node next,prev;
		
		Node(){
			data = 0;
			next = prev =null;
		}
    } // End Node class.
    
	public Node head;
      
    Stack()
    { 
        head = null;
    }
        
    public void push(int data) {
        Node  NewNode = new Node();
		NewNode.data = data;
		Node current = head;
		NewNode.next = current;
		head = NewNode;
    }

    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public int pop(){
		Node current = head;
		head = current.next;
		return current.data;
    } 

    
    public boolean isEmpty(){
       return head == null;
    }
	
	
	public boolean isMember(char data){
		Node current = head;
		
		while(current!= null){
			if(current.data == data) return true ;
			current= current.next;
		}
		return false;
		
	}
	
	public String toString(){
		String result = new  String("");
		Node current = head;
		while (current != null) {
            result +=current.data + "\n";
			current=current.next;
        }
		return result;
	}

}//end class Stack