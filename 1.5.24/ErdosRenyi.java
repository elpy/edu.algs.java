import java.util.*;

public class ErdosRenyi{
	
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
		
		int n = 10000;
		
		for (int i = 0; i != t; i++){
			Count(n * (int)Math.pow(2, i), new WeightedQuickUnion(n * (int)Math.pow(2, i)));		
		}
		
		for (int i = 0; i != t; i++){
			Count(n * (int)Math.pow(2, i), new WeightedQuickUnionWithCompression(n * (int)Math.pow(2, i)));		
		}
	}

	public static int Count(int n, IUnion worker){
		Random randomGenerator = new Random();
		int pairs = 0, p = 0, q = 0, components = n;
		System.out.printf("%s. N = %d. Complete: %2d%%", worker.getClass().toString(), n, 0);
		long ticks = System.currentTimeMillis();
		
		while(worker.Count() != 1){
			p = randomGenerator.nextInt(n);
			q = randomGenerator.nextInt(n);
			pairs++;
			
			if (!worker.IsConnected(p, q)){
				worker.Union(p, q);
				
				if (components != worker.Count()){
					components = worker.Count();
					System.out.printf("\b\b\b%2d%%", 100 * (n - components + 1) / n);
				}
			}
		}
			
		System.out.printf(". Pairs: %d. Elapsed time: %d ms.\n", pairs, System.currentTimeMillis() - ticks);
	
		return pairs;
	}
}