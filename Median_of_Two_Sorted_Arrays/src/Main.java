class Solution {

	private int getValueByIndex(int[] nums, int index) {
		if (index < 0)
			return Integer.MIN_VALUE;
		if (index >= nums.length)
			return Integer.MAX_VALUE;
		return nums[index];
	}
	
	private double findMediumSortedArray(int[] nums) {
		// nums length can't be zero
		if (nums.length % 2 == 0) {
			return ((double)nums[nums.length / 2 - 1] + (double)nums[nums.length / 2]) / 2;
		} else {
			return (double)nums[nums.length / 2];
		}
	}
	
	private double findMedianSortedArraysCommon(int[] nums1, int[] nums2) {
    	// binary search, conditions are the length to take from nums1
    	int lengthFromNums1 = 0; // how many values to get from nums1 to form medium
    	int lengthFromNums2 = 0; // how many values to get from nums2 to form medium
    	int begin, end;          // for binary search
    	double retValue = 0.0;
    	int mediumPosition = (nums1.length + nums2.length) / 2 + (nums1.length + nums2.length) % 2;
    	// start binary search
    	begin = 0; end = nums1.length;
    	while (begin <= end) {
    		lengthFromNums1 = (begin + end) / 2;
    		lengthFromNums2 = mediumPosition - lengthFromNums1;
    		if (getValueByIndex(nums1, lengthFromNums1 - 1) > 
    		        getValueByIndex(nums2, lengthFromNums2)) {
    			end = lengthFromNums1 - 1;
    		} else if (getValueByIndex(nums2, lengthFromNums2 - 1) >
    				      getValueByIndex(nums1, lengthFromNums1)) {
    			begin = lengthFromNums1 + 1;
    		} else {
    			break;
    		}
    	}

    	if ((nums1.length + nums2.length) % 2 == 0) {
    		retValue = ((double)Math.max(getValueByIndex(nums1, lengthFromNums1 - 1), 
    	    							 getValueByIndex(nums2, lengthFromNums2 - 1)) +
    					(double)Math.min(getValueByIndex(nums1, lengthFromNums1),
    							         getValueByIndex(nums2, lengthFromNums2))) / 2;
    	} else {
    		retValue = Math.max(getValueByIndex(nums1, lengthFromNums1 - 1),
    				            getValueByIndex(nums2, lengthFromNums2 - 1));
    	}
    	return retValue;		
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	   	if (nums1.length + nums2.length == 0)
    		return 0.0;
    	// nums1 is always shorter or equal to nums2
    	if (nums1.length > nums2.length) {
    		int[] swap = nums1;
    		nums1 = nums2;
    		nums2 = swap;
    	}
    	// handle edge case if length of nums1 is 0, return medium of nums2 straight.
    	if (nums1.length == 0) {
    		return findMediumSortedArray(nums2);
    	} else {
    		return findMedianSortedArraysCommon(nums1, nums2);
    	}
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,3,5,7,9};
		int[] nums2 = {10,10,10,10};
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}

}
