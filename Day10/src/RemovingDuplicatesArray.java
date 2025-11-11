import java.util.Arrays;

public class RemovingDuplicatesArray {
	public static void main(String[] args) {
	int[] arr = {1,1,2,2,2,2,3,3,4,5,5,6,6,7,7,7,8,9};
	int num = 0;
	int count = 0;
	for(int i =0;i<arr.length-1;i++)
	{	
		num = arr[i];
		for(int j =i+1;j<arr.length-1;j++) {
			if(num == arr[j]) {
				arr[j]=0;
			}
		}
		
	}System.out.println(Arrays.toString(arr));
	for(int i =0;i<arr.length;i++) {
		if(arr[i]!=0) {
			count++;
		}
	}System.out.println(count);
	int index = 0;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]!=0) {
			arr[index++]=arr[i];
		}
	}System.out.println(Arrays.toString(arr));
	while(index<arr.length) {
		arr[index]=0;
		index++;
	}System.out.println(Arrays.toString(arr));
	}

	
}