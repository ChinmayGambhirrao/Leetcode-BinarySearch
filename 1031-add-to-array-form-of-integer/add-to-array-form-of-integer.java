class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = num.length - 1;

        while(i >= 0 || k > 0 || carry > 0) {
            int sum = carry;

            if(i >= 0) {
                sum += num[i];
                i--;
            }
            if(k > 0) {
                sum += k % 10;
                k /= 10;
            }
            result.add(sum % 10);
            carry = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }
}