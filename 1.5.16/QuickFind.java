import java.util.*;

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

    private void Union(int p, int q){
	int pRoot = Find(p);
	int qRoot = Find(q);

	if (qRoot == pRoot)
	    return;

	for (int i = 0; i < Id.length; i++)
	    if (Id[i] == pRoot)
		Id[i] = qRoot;

	Count--;
    }
    
    @Override
    public String toString(){
	return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }


    //static

    public static void main(String[] args){
	QuickFind qf = new QuickFind(10);

	qf.Union(4, 5);	
	System.out.println(qf);
	qf.Union(6, 7);	
	System.out.println(qf);
	qf.Union(7, 8);	
	System.out.println(qf);
	qf.Union(5, 6);	
	System.out.println(qf);
	qf.Union(0, 1);	
	System.out.println(qf);
	qf.Union(1, 8);	
	System.out.println(qf);
    }
}
