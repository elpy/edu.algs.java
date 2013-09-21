import java.util.*;

public class WeightedQuickUnion extends IUnion{
    private int[] Height;    

    public WeightedQuickUnion(int n) {
        super(n);
        Height = new int[n];
        for(int i = 0; i < Data.length; i++)
        	Height[i] = 1;
    }

    @Override
    public int Find(int p) {       
		while (p != Data[p])
	            p = Data[p];

        return p;
    }

    @Override
    public void Union(int p, int q) {
        final int i = Find(p);
        final int j = Find(q);

        if (i == j) 
        	return;

	    if (Height[i] < Height[j]) {
		    Data[i] = j; Height[j] += Height[i];
	    }
	    else {
	    	Data[j] = i; Height[i] += Height[j];
	    }

        Count--;
    }
}

