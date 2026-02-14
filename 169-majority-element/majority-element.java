class Solution {
    public int majorityElement(int[] nums) {
        int king=nums[0];
		int count=1;
		
		for(int i=1; i<nums.length; i++) {
			if( king== nums[i]) {
				count++;
				
			}else {
				count--;
			}
			
			if(count==0) {
				king=nums[i];
				count=1;
			}
		}
		
		return king;
    }
}