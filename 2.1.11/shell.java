import java.util.*;

public class shell{

    public static void main(String[] argc){
        System.out.println("Its Shell sorting");

	Integer[] a = new Integer[] { 15, 11, 51, 5, 45, 4, 134, 318, 4, 38, 43, 84, 6, 7, 99, 23 };
	sort(a);

	System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
	List<Integer> hSequence = new ArrayList<Integer>();
	hSequence.add(h);

        while (h < N/3) {
	    h = 3*h + 1;
	    hSequence.add(h);
	}

	Integer[] arr = hSequence.toArray(new Integer[hSequence.size()]);

	for(int s = hSequence.size() - 1; s >= 0; s--){
            for (int i = arr[s]; i < N; i++) {
                for (int j = i; j >= arr[s] && less(a[j], a[j-arr[s]]); j -= arr[s]) {
                    exch(a, j, j - arr[s]);
                }
            }
	}
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
