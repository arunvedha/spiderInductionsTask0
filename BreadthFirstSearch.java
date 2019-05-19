import java.io.* ;
import java.util.* ;
import java.util.stream.IntStream;
import java.util.Scanner;
class Graph
{
    
    private int vertices, l, s;
	private LinkedList<Integer> adj[]; //adj is array of linked lists. 
	Graph(int v)
	{
	    vertices = v;
		adj = new LinkedList[vertices];
		IntStream.rangeClosed(0, vertices-1).forEach(i -> adj[i] = new LinkedList()); //Initialises adj[i] from i = 0 to vertices-1
	}
	public void edge(int e1, int e2)
	{
		adj[e1-1].add(e2-1); /*adj[i] is the linked list of elements which are connected to element i+1
		                      eg. adj[0] is the linked list of elements to which element 1 is linked.*/
	}
	public void search(int start)
	{
		s = start-1; //Since index starts from zero we use start-1 as index
		boolean visited[] = new boolean[vertices];
		visited[s] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s); //queue is queue of elements connected to element start
		while(queue.size() > 0)
		{
			s = queue.poll(); //Pop first element in queue and mark it visited
			visited[s] = true;
			System.out.print((s+1)+ " ");//print s+1, because s index representing start and white space after s+1
			Iterator<Integer> ltr = adj[s].listIterator();
			while(ltr.hasNext()) 
			{
			    l = ltr.next(); //Move to next element and repeat the same
				if(!visited[l])
				{
				 queue.add(l);
				 visited[l] = true;
				}
			}
		}
	}
};
class BFS
{
	public static void main(String args[]){
	int n, a = -2, b = -2, s;
	Scanner sr = new Scanner(System.in);
	System.out.println("Note: This code works only for elements starting from 1 to n where n is an integer");
	System.out.println("Enter number of vertices: ");
	n = sr.nextInt();
	Graph g = new Graph(n);
	System.out.println("Enter the pair of elements which are connected in the order of connection eg. if 2 is connected to 1 enter '1 2'");
	try{
	do
	{
		a = sr.nextInt();
		b = sr.nextInt();
		if(a != -1 && b != -1)
		{
		g.edge(a, b);
		System.out.println("Enter the next pair of elements: (-1 -1 to stop)");
		}
		else break;
	}
	while(a != -1 && b != -1);
	System.out.println("Enter element from which search has to be started");
	System.out.println("Output: ");
	g.search(sr.nextInt());
	}
	catch(InputMismatchException ime)
	{
		System.out.println("Input mismatch");
		System.out.println("Note: This code works only for elements starting from 1 to n where n is an integer");
	}
	catch(Exception e)
	{
		System.out.println("Unknown exception");
		System.out.println("Note: This code works only for elements starting from 1 to n where n is an integer");
	}

	}
}
