import java.util.*;

public abstract class IUnion{
	protected int N;
	protected int[] Data;
	protected int Count;
	
	public IUnion(int n){
		Count = N = n;
		Data = new int[n];
		
		for (int i = 0; i < n; i++)
			Data[i] = i;
	}
	
	public final boolean IsConnected(int p, int q){
		return Find(p) == Find(q);
	}
	
	public final int Count(){
		return Count;
	}
	
    @Override
    public String toString(){
	    return "Array: " + Arrays.toString(Data) + "\nComponents: " + Count;
    }
	
	protected abstract int Find(int s);	
	
	public abstract void Union(int p, int q);
}