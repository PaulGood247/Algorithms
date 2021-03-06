// Simple weighted graph representation 
// Uses an Adjacency Linked Lists, suitable for sparse graphs

import java.io.*;

class GraphLists {
    class Node {
        public int vert;
        public int wgt;
        public Node next;
    }
    
    // V = number of vertices
    // E = number of edges
    // adj[] is the adjacency lists array
    private int V, E;
    private Node[] adj; //array of linked lists
    private Node z; //mark the visited
    
    // used for traversing graph
    private int[] visited;
    private int id;
    
    
    // default constructor
    public GraphLists(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
        String splits = " +";  // multiple whitespace as delimiter
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
        // create sentinel node
        z = new Node(); 
        z.next = z;
        
        // create adjacency lists, initialised to sentinel node z
        visited = new int[V+1];
        adj = new Node[V+1];
        for(v = 1; v <= V; ++v)
           adj[v] = z;               
        
        // read the edges
        System.out.println("Reading edges from text file");
        
        // missing for loop here
		for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
            
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
            // write code to put edge into adjacency matrix     
            // missing code here
			
				Node n = new Node();
				n.vert = u;
	            n.wgt = wgt;
				n.next = adj[v];
				adj[v] = n;
				
				n.vert = v;
	            n.wgt = wgt;
				n.next = adj[u];
				adj[u] = n;
			
			//adj[u][v]=wgt;
			//adj[v][u]=wgt;
			
			//t.vert=v;
			//t.wgt=wgt;
        }
		//t.next=visited(v);
    }
   
    // convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
    
    // method to display the graph representation
    public void display() {
        int v;
        Node n;
        
        for(v=1; v<=V; ++v){
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            for(n = adj[v]; n != z; n = n.next) 
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");    
        }
        System.out.println("");
    }


   // method to initialise Depth First Traversal of Graph
    public void DF( int s) 
    {
        id = 0;
		for (int v =1; v <= V; ++v)
			visited[v]=0;
			dfVisit(0,s);
        
        
    }


    // Recursive Depth First Traversal for adjacency matrix
    private void dfVisit( int prev, int v)
    {
		visited[v] = ++id;
		System.out.println("Visited Vertex "+ toChar(v) + " along edge " + toChar(prev) + "-" + toChar(v));
		
		for(int u =1; u <= V; ++u)
			if(adj[u] !=null)
				if(visited[u] ==0)
					dfVisit(v,u);

    }
	
	
	public void BF( int s) 
    { 
		Queue q = new Queue();
		id = 0;
		for (int v =1; v <= V; ++v)
			visited[v]=0;
			q.enQueue(s);
			System.out.println("\nBreadth First");
			
			while(!q.isEmpty()){
				int v=q.deQueue();
				if(visited[v]== 0){
					visited[v] = ++id;
					System.out.print(toChar(v)+ " is connected to ");
					for(int u =1; u <= V; ++u){
						if((adj[u] !=null)&&(u!=v)){
							if(visited[u] ==0)
							q.enQueue(u);
							System.out.print(toChar(u)+ " ");
					}
				}
				System.out.println(" ");
			}
		}//end while
	}//end BF
	
	
	
	
	
	public void Iterative_DF( int s) 
    { 
		Stack stack  = new Stack();
		id = 0;
		for (int v =1; v <= V; ++v)
			visited[v]=0;
			stack.push(s);
			System.out.println("\nIterative Depth First");
			
			while(!stack.isEmpty()){
				int v=stack.pop();
				if(visited[v]== 0){
					visited[v] = ++id;
					System.out.print(toChar(v)+ " is connected to ");
					for(int u =1; u <= V; ++u){
						if((adj[u] !=null)&&(u!=v)){
							if(visited[u] ==0)
							stack.push(u);
							stack.push(u);
							System.out.print(toChar(u)+ " ");
					}
				}
				System.out.println(" ");
			}
		}//end while
	}//end Iterative_DF
	


    public static void main(String[] args) throws IOException
    {
        int s = 4;
        String fname = "wGraph3.txt";               

        GraphLists g = new GraphLists(fname);
       
        g.display();
        
        g.DF(s);
        g.BF(s);
		g.Iterative_DF(s);
    }

}

