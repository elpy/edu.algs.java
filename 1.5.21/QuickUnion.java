import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class QuickUnion{

    private int[] Id;
    private int Count;
 
    public QuickUnion(int n){
		Count = n;
		Id = new int[n];
	
		for (int i = 0; i < n; i++)
		    Id[i] = i;
    }

    private int Find(int v){
		while(v != Id[v]){
		    v = Id[v];
		}
		
		return v;
    }

    public boolean IsConnected(int p, int q){
    	return Find(p) == Find(q);
    }

    public void Union(int p, int q){
		int pRoot = Find(p);
		int qRoot = Find(q);
	
		if (qRoot == pRoot)
		    return;
	
		Id[qRoot] = pRoot;
		Count--;
		
		return;
    }
    
    public int ComponentCount(){
    	return Count;
    }
    
    @Override
    public String toString(){
	    return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }
}
