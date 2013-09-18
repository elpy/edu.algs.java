import java.util.*;

public class QuickUnion extends IUnion{

    public QuickUnion(int n){
		super(n);
    }

    @Override
    protected int Find(int s){
		while(s != Data[s])
		    s = Data[s];
		
		return s;
    }

    @Override
    public void Union(int p, int q){
		int pRoot = Find(p);
		int qRoot = Find(q);
	
		if (qRoot == pRoot)
		    return;
	
		Data[pRoot] = qRoot;
		Count--;
		
		return;
    }
}
