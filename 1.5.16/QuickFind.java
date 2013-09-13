import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class QuickFind{

    private int[] Id;

    private int Count;

    public QuickFind(int n){
	Count = n;
	Id = new int[n];

	for (int i = 0; i < n; i++)
	    Id[i] = i;
    }

    private int Find(int v){
	return Id[v];
    }

    public boolean IsConnected(int p, int q){
	return Find(p) == Find(q);
    }

    private int Union(int p, int q){
	int pRoot = Find(p);
	int qRoot = Find(q);
	int cost = 2;

	if (qRoot == pRoot)
	    return cost;

	for (int i = 0; i < Id.length; i++)
	    if (Id[i] == pRoot){
		Id[i] = qRoot;
		cost += 2;
	    } 
	    else cost++;

	Count--;

	return cost;
    }
    
    @Override
    public String toString(){
	return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }


    //static

    public static void main(String[] args){
	EventQueue.invokeLater(new Runnable(){
		public void run(){
		    JFrame frame = new JFrame();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setTitle("QuickFind");
		    frame.setSize(800, 600);

		    QuickFind qf = new QuickFind(10);
		    int totalCost = 0, cost = 0;
		    
		    Chart chart = new Chart();
		    
		    cost = qf.Union(4, 5);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    cost = qf.Union(6, 7);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    cost = qf.Union(7, 8);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    cost = qf.Union(5, 6);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    cost = qf.Union(0, 1);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    cost = qf.Union(1, 8);
		    chart.AddPoint(cost);
		    totalCost += cost;

		    frame.add(chart);
		    frame.setVisible(true);
		}
	});
    }
}
