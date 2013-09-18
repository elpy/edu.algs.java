import java.util.*;

public class QuickFind extends IUnion{

    public QuickFind(int n){
        super(n);
    }

    @Override
    protected int Find(int s){
	    return Data[s];
    }

    @Override
    public void Union(int p, int q){
        int pRoot = Find(p);
        int qRoot = Find(q);

        if (qRoot == pRoot)
            return;

        for (int i = 0; i < Data.length; i++)
            if (Data[i] == pRoot)
                Data[i] = qRoot;
        
        Count--;
        
        return;
    }
}
