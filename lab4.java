// Heap.cs
// Simple array based implementation of a Heap;

import java.util.*;

class Heap
{
    private int[] a;
    private int N;

    private static int hmax = 100;
    
    public Heap()
    {
        a = new int[hmax + 1];
        N = 0;
    }

    public Heap(int _hmax)
    {
        a = new int[_hmax + 1];
        N = 0;
    }


    public void insert(int x)
    {
        a[++N] = x;
        siftUp(N);
    }
  

    public void siftUp(int k)
    {
        int u;
		u=a[k];
		a[0]=Integer.MAX_VALUE;
		
		while(u> a[k/2])
		{
			a[k]=a[k/2];
			k=k/2;
		}
		a[k]=u;
    }

    
    public void display() 
    {
        System.out.println("Heap is ");

        for(int i = 1; i <= N/2; i = i * 2) {
            for(int j = 2*i; j < 4*i && j <= N; ++j)
			{
                System.out.print(" " + a[j]);
			}
            System.out.println("\n");
        }
    }

}

class lab4
{
    public static void main(String[] args)
    {
        Heap h = new Heap();


        int i, x;
        for (i = 0; i < 10; ++i)
        {
            x = (int) (Math.random()*99.0);
            System.out.println("\nInserting  "  + x);
            h.insert(x);
            h.display();
        }

        //x = h.remove();
        //System.out.println("\nRemoving {0} "+ x);
       // h.display();

        //System.in.read();
       
    }
}