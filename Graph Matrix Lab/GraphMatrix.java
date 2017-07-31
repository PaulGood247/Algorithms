// Simple weighted graph representation 
// Uses an Adjacency Matrix, suitable for dense graphs
// Converted from C# some of which has been commented out

import java.io.*;

class GraphMatrix 
{
     //V = number of vertices
    // E = number of edges
    // adj[ ][ ] is the adjacency matrix
    private int V, E;
    private int[][] adj;
    
    // used for traversing graph
    private int[] visited;
    private int id;
   
    
    
    // default constructor
    public GraphMatrix(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;

        // StreamReader reader = new StreamReader(graphFile);
		FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	   
        // char[] splits = new char[] { ' ', ',', '\t'};     
        // string line = reader.ReadLine();
		// string[] parts = line.Split(splits, StringSplitOptions.RemoveEmptyEntries);
        
        String splits = " +";  // multiple whitespace as delimiter		   
		String line = reader.readLine();       
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
		
        // find out number of vertices and edges
        //V = int.Parse(parts[0]);
        //E = int.Parse(parts[1]);
        
		V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);

        // create adjacency matrix, initialised to 0's
        //adj = new int[V+1, V+1];
        adj = new int[V+1][V+1];        
        
        visited = new int[V+1];
        
       // read the edges
        System.out.println("Reading edges from text file");
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
			adj[u][v]=wgt; //there is weight from u to v
			adj[v][u]=wgt; // and there is also weight from v to u
			
			/*
				Node t = new Node (); t.vert = v; t.wgt = wgt; t.next = adj[v]; //xxx?; one more statement
			
			*/
       }	       
    }

	// convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
	
    // method to display the graph representation
    public void display() {
        int u,v;
        
        for(v=1; v<=V; ++v){
            System.out.print("\nadj[" + v + "] = ");
            for(u=1; u<=V; ++u) 
                System.out.print("  " + adj[u][v]);
        }    
        System.out.println("\n");
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
			if(adj[v][u] != 0)
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
						if((adj[u][v] >0)&&(u!=v)){
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
						if((adj[u][v] >0)&&(u!=v)){
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

        GraphMatrix g = new GraphMatrix(fname);
       
         g.display();
        
         g.DF(s);
        g.BF(s);
		g.Iterative_DF(s);
    }

}

