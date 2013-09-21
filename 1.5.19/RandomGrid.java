import java.util.*;

public class RandomGrid{
	
	public static RandomBag<Connection> Generate(int n){
		RandomBag<Connection> bag = new RandomBag<Connection>();
		
		for (int i = 0; i != n; i++){
			for (int j = 0; j != n; j++){
				if ((i + 1) != n)
					bag.Add(new Connection(j * n + i, j * n + i + 1));
				
				if ((j + 1) != n)
					bag.Add(new Connection(j * n + i, (j + 1) * n + i));				
			}
		}

		return bag;		
	}
}