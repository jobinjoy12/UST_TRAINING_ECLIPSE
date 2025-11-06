import java.util.* ;
public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ar = new int[N];
		int n = sc.nextInt();
		for(int i =0;i<N;i++) {
			ar[i] = sc.nextInt();
		}
		System.out.println(ar);
		int[] ars = Arrays.copyOf(ar, N);
		Arrays.sort(ars);
		Set<Integer> seta = new HashSet<>();
		for(int j=0;j<n;j++) {
			seta.add(ars[j]);
		}
		System.out.println(seta);
		for(int k =0 ; k<N ; k++) {
			if(seta.contains(ar[k])) {
				System.out.print(ar[k]);
			}
		}
		sc.close();
		
	}

}
