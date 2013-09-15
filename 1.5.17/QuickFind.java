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

    public void Union(int p, int q){
        int pRoot = Find(p);
        int qRoot = Find(q);

        if (qRoot == pRoot)
            return;

        for (int i = 0; i < Id.length; i++)
            if (Id[i] == pRoot){
                Id[i] = qRoot;
            }

        Count--;

        return;
    }
    
    @Override
    public String toString(){
	    return "Array: " + Arrays.toString(Id) + "\nCount: " + Count;
    }
}
