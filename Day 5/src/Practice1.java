public class Practice1 {
	public static void main(String[] args) {
		int[] ar ={ 3, 5, 6, 6, 6, 6, 7, 7, 2, 1, 8};
		int length = 0 ;
		int ind = 0 ;
		int count = 1 ;
		for(int i=0 ; i<(ar.length-1) ; i++) {
				if(ar[i] == ar[i+1]) {
					count++;
					if(length<count) {
						length = count;
						ind = ((i+1)-count)+1;
					}
				}else{count = 1;}
			}System.out.println(count);
			System.out.println(length);
			System.out.println(ind);
			}
			
		}
	


