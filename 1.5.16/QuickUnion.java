import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class QuickUnion{

    private int[] Id;
    private int Count;
    private int Cost;

    public QuickUnion(int n){
		Count = n;
		Cost = 0;
		Id = new int[n];
	
		for (int i = 0; i < n; i++)
		    Id[i] = i;
    }

    private int Find(int v){
		while(v != Id[v]){
		    v = Id[v];
		    Cost += 2;
		}
		
		Cost++;
	
		return v;
    }

    public boolean IsConnected(int p, int q){
    	return Find(p) == Find(q);
    }

    private int Union(int p, int q){
    	Cost = 0;
		int pRoot = Find(p);
		int qRoot = Find(q);
	
		if (qRoot == pRoot)
		    return Cost;
	
		Id[qRoot] = pRoot;
		Cost++;
		Count--;
		
		return Cost;
    }
    
    @Override
    public String toString(){
    	return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }


    //static

    public static void main(String[] args){
    	EventQueue.invokeLater(new Runnable(){
    		public void run(){
    			int n = 100000;
    			float perPercent = n * 0.01f;

    			JFrame frame = new JFrame();
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setTitle("QuickFind");
	            frame.setSize(600, 600);

	            QuickUnion qf = new QuickUnion(n);
	            int totalCost = 0, cost = 0;

	            Chart chart = new Chart();

	            Random randomGenerator = new Random();
	            System.out.print("Complete: 00%");
	            for (int i = 0; i < n; i++){
	                cost = qf.Union(randomGenerator.nextInt(n), randomGenerator.nextInt(n));
	                chart.AddPoint(cost);
	                totalCost += cost;

	                if (i % perPercent == 0)
	                	System.out.printf("\b\b\b%02d%%", 100 * i / n);
	            }
	                
	            System.out.printf("\b\b\b100%%\nPainting..\n");

	            frame.add(chart);
	            frame.setVisible(true);
	        }
	    });
    }
}
