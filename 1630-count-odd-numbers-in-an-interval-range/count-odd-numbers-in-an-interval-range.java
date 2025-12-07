class Solution {
    public int countOdds(int low, int high) {
        int count=0;
        if(low%2!=0){
            count++;
            low++;
        }
        if(high%2!=0){
            count++;
            high--;
        }
        count+=(high-low)/2;
        return count;
        // 4 10
        // 5,6,7,8,9

        // 4 9
        // 5,6,7,8


        // 5 10
        // 6,7,8,9


        // 5 9
        // 6,7,8
    }
}