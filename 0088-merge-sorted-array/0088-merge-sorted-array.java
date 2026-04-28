class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];

        int pointer1 = 0;
        int pointer2 = 0;
        int idx = 0;

        while (pointer1 < m && pointer2 < n) {
            if (nums1[pointer1] > nums2[pointer2])
                sorted[idx++] = nums2[pointer2++];
            else
                sorted[idx++] = nums1[pointer1++];
        }

        while (pointer1 < m) sorted[idx++] = nums1[pointer1++];

        while (pointer2 < n) sorted[idx++] = nums2[pointer2++];

        for (int i = 0; i < m + n; i++) nums1[i] = sorted[i];
    }
}