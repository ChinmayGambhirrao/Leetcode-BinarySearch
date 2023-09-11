class Solution {
    public double solve(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int onLeft = (totalLen - 1) / 2; //number of element to the left of median m1
        int start = 0;
        int end = nums1.length > onLeft ? onLeft : nums1.length - 1;
        //perform binary search in nums1 to find m1
        while (start <= end) {
            int mid = (start + end) / 2; //index of current element 'e'
            boolean moveLeft = false; //to adjust binary search pointers later
            int leftIdx = onLeft - mid - 1; //index of largest element in nums2 which is smaller than the current element 'e'
            if (leftIdx >= nums2.length) {
                //current element 'e' is smaller than m1, need to move to the right
                moveLeft = false;
            }
            else if (
            (leftIdx == -1 || nums2[leftIdx] <= nums1[mid]) &&
            (leftIdx == (nums2.length - 1) || nums2[leftIdx + 1] >= nums1[mid])) {
                //current element 'e' is median 'm1' return the answer;
                if ((totalLen & 1) == 1) //odd length
                    return Double.valueOf(nums1[mid]);
                else {
                    //find 'm2' (element to the right of 'm1')
                    int el1 = (leftIdx + 1) < nums2.length ? nums2[leftIdx + 1] : Integer.MAX_VALUE; //smallest element greater than 'e' in nums2
                    int el2 = (mid + 1) < nums1.length ? nums1[mid + 1] : Integer.MAX_VALUE; //smallest element greater than 'e' in nums1
                    //m2 = Math.min(el1, el2)
                    return (nums1[mid] + Math.min(el1, el2)) / 2.0;
                }
            } else if (leftIdx == - 1 || nums2[leftIdx] < nums1[mid]) {
                //current element 'e' is greater than m1, need to move to the left
                moveLeft = true;
            }
            
            if (moveLeft)
                if (end == mid)
                    break;
                else
                    end = mid;
            else
                start = mid + 1;
        }

        //Median 'm1' not found in 'nums1', it must be in 'nums2'.
        //Search for 'm1' in 'nums2' and return answer
        return solve(nums2, nums1);
    }
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        return solve(a1, a2);
    }
}