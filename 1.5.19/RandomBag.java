import java.util.*;

public class RandomBag<Item> implements Iterable<Item> {
	
	private List<Item> Data;
	
	public RandomBag(){
		Data = new ArrayList<Item>();
	}
	
	public boolean IsEmpty(){
		return Data.size() == 0;
	}
	
	public int Size(){
		return Data.size();
	}
	
	public void Add(Item item){
		Data.add(item);
	}
	
	public Iterator<Item> iterator(){
		Collections.shuffle(Data);		
		return Data.iterator();
	}
}