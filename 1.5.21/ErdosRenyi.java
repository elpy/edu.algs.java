import java.util.*;

public class ErdosRenyi{
	
	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Use command line to enter N. \nLeaving.");
			return;
		}
       	    	  
		int n = 0; 
       	    	  
		try{
			n = (int)Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid argument: " + args[0]);
			return;
		}

		System.out.printf("\nPairs: %d\n", Count(n));
		System.out.printf("1/2 N lnN = %f\n", 0.5 * n * Math.log(n));
	}
	
	public static int Count(int n){
		QuickUnion qf = new QuickUnion(n);
		Random randomGenerator = new Random();
		int pairs = 0, p = 0, q = 0, components = n;
		
		System.out.printf("Complete: %2d%%", 0);
		while(qf.ComponentCount() != 1){
			p = randomGenerator.nextInt(n);
			q = randomGenerator.nextInt(n);
			pairs++;
			
			if (!qf.IsConnected(p, q)){
				qf.Union(p, q);
				
				if (components != qf.ComponentCount()){
					components = qf.ComponentCount();
					System.out.printf("\b\b\b%2d%%", 100 * (n - components + 1) / n);
				}
			}
		}
		
		return pairs;
	}
}