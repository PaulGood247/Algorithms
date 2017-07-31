class Queue {

    private class Node {
        int data;
        Node next;
		Node prev;
		
		Node(){
			data = 0;
			next = null;
			prev = null;
		}
    } // end Node 

    //Node z;
    Node head;
    Node tail;

     public Queue() {
        //z = new Node(); z.next = z;
        head = null;  tail = null;
    }


  public void display() {
    System.out.println("\nThe queue values are:\n");

    Node temp = head;
    while( temp != temp.next) {
        System.out.print( temp.data + "  ");
        temp = temp.next;
    }
    System.out.println("\n");
  }


  public void enQueue( int x) {
    Node temp = new Node();
    temp.data = x;
	

    if(head == null) {   // case of empty list
        head = temp;
		tail = temp;
    }else{    // case of list not empty
        tail.next = temp;
		temp.prev = tail;
		tail = temp;        // new node is now at the tail
	}
  }


  // assume the queue is non-empty when this method is called
  public int deQueue() {
	int x = head.data;
	head= head.next;
	return x;
   
  }


  public boolean isEmpty() {
    return head == null;
  }
  
  public boolean isMember(int x){
		Node temp = head;
		while(temp != null){
			if(temp.data == x) return true ;
			temp= temp.next;
		}
		return false;
		
		}

} // end of Queue class