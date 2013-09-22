
public class Client{
	public static void main(String[] args){		
		
		if (args.length == 0){
			System.out.println("Use command line to enter T. \nLeaving.");
			return;
		}
       	    	  
		int t = 0; 
       	    	  
		try{
			t = (int)Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid argument: " + args[0]);
			return;
		}
		
		int n = 10;
		int nodes; 		
		
		for (int i = 0; i < t; i++){
			n *= 2;
			nodes = n * n;	
			
			Test(n, nodes, new QuickFind(nodes));		
		}
		
		n = 10;
		
		for (int i = 0; i < t; i++){
			n *= 2;
			nodes = n * n;	
			
			Test(n, nodes, new QuickUnion(nodes));		
		}
		
		return;
	}	
	
	public static int Test(int n, int nodes, IUnion worker){
		RandomBag<Connection> connections = RandomGrid.Generate(n);
		int pairs = 0, components = nodes;
		
		System.out.printf("%s. N = %d. Nodes: %d. Complete: %2d%%", worker.getClass().toString(), n, nodes, 0);
		long ticks = System.currentTimeMillis();

		for(Connection con : connections){
			if (!worker.IsConnected(con.GetQ(), con.GetP()))
				worker.Union(con.GetQ(), con.GetP());
			
			pairs++;
				
			if (components != worker.Count()){
				components = worker.Count();
				System.out.printf("\b\b\b%2d%%", 100 * (nodes - components + 1) / nodes);
			}
				
			if (worker.Count() == 1)
				break;
		}
		
		System.out.printf(". Pairs: %d. Elapsed time: %d ms.\n", pairs, System.currentTimeMillis() - ticks);
		
		return pairs;
	}
	
}