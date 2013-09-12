import java.util.*;

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
	while(v != Id[v])
	    v = Id[v];

	return v;
    }

    public boolean IsConnected(int p, int q){
	return Find(p) == Find(q);
    }

    private void Union(int p, int q){
	int pRoot = Find(p);
	int qRoot = Find(q);

	if (qRoot == pRoot)
	    return;

	Id[qRoot] = pRoot;
	Count--;
    }
    
    @Override
    public String toString(){
	return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }


    //static

    public static void main(String[] args){
	QuickUnion qu = new QuickUnion(10);

	qu.Union(4, 5);	
	System.out.println(qu);
	qu.Union(6, 7);	
	System.out.println(qu);
	qu.Union(7, 8);	
	System.out.println(qu);
	qu.Union(5, 6);	
	System.out.println(qu);
	qu.Union(0, 1);	
	System.out.println(qu);
	qu.Union(1, 8);	
	System.out.println(qu);
    }
}
