import java.util.*;

public class shell{

    public static void main(String[] argc){
        System.out.println("Its Shell sorting");
	Random gen = new Random();

	for(int q = 2; q != 7; q++){
	    List<Double> data = new ArrayList<Double>();

	    long l = (long)Math.pow(10,q);
	    System.out.printf("array size = %d\n", l);
            for (long i =0; i != l; i++){
                data.add(gen.nextDouble());
	    }

	    Double[] arr = data.toArray(new Double[data.size()]);
	    sort(arr);
	}
    }

    public static void sort(Comparable[] a) {
        long N = a.length;
        int h = 1;
	long c = 0;

        while (h < N/3) 
	    h = 3*h + 1; 

        while (h >= 1) {

            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
		    if (less(a[j], a[j-h]))
                    	exch(a, j, j-h);

		    c++;
                }
            }

	    System.out.println(c/N);
            h /= 3;
	    c = 0;
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
