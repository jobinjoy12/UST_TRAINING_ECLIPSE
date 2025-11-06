
public class MobilePattern {
	public static void main(String[] args) {
		int[][] ar = {{1,1},{2,1},{3,1},{2,2},{3,5}};
		int length = 3;
		int no = 5 ;
		System.out.println(ar.length);
		System.out.println(ar[1][1]);
		if(ar.length == no) {
			for(int i=0;i<ar.length-1;i++) {
					int x1 = ar[i][0];
					int x2 = ar[i+1][0];
					int y1 = ar[i][1];
					int y2 = ar[i+1][1];
					if((Math.abs(x1-x2)<=1)&&(Math.abs(y1-y2)<=1)){
						System.out.println("valid");
					}else {System.out.println("invalid");}
				}
			}
		}}
		
	


