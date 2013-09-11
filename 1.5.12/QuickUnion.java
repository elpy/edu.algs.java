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

    private void Compress(int root, int p, int q){
	int t;

	while(root != Id[p]){
	    t = p;
	    p = Id[p];
	    Id[t] = root;
	}

	while(root != Id[q]){
	    t = q;
	    q = Id[q];
	    Id[t] = root;
	}
    }

    public boolean IsConnected(int p, int q){
	return Find(p) == Find(q);
    }

    private void Union(int p, int q){
	int pRoot = Find(p);
	int qRoot = Find(q);

	if (qRoot == pRoot)
	    return;

	//Union: * <- *
	Id[qRoot] = pRoot;
	Count--;
	Compress(pRoot, p, q);
    }
    
    @Override
    public String toString(){
	return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }


    //static

    public static void main(String[] args){


	Worse();
    }

    public static void Worse(){
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