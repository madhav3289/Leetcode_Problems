class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(apple);
        Arrays.sort(capacity);
        int tAp=0;
        for(int num:apple){
            tAp+=num;
        }
        int tCap=0;
        for(int num:capacity){
            tCap+=num;
        }
        int len=capacity.length;
        int i=0;
        while(tCap>tAp){
            tCap-=capacity[i];
            i++;
            len--;
        }
        if(tCap<tAp){
            len++;
        }
        return len;
    }
}