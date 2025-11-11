import java.util.Arrays;

public class Practice1 {
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2,3,3,3,4,4,4,4,5,6,7,8,8,8,8,8,9,9,10};
		if(nums == null||nums.length==0){
            System.out.println(0);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0||nums[i]!=nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }System.out.println(Arrays.toString(nums));
       System.out.println(count);
    }
}