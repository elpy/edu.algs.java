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
       	    	  
		System.out.printf("Connected: " + Count(n));
	}
	
	public static int Count(int n){
		QuickFind qf = new QuickFind(n);
		Random randomGenerator = new Random();
		int count = 0, p = 0, q = 0;
		
		for (int i = 0; i != n - 1; i++){
			p = randomGenerator.nextInt(n);
			q = randomGenerator.nextInt(n);
			
			if (!qf.IsConnected(p, q)){
				count++;
				qf.Union(p, q);
			}
		}
		
		return count;
	}
}