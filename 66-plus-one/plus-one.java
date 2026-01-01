class Solution {
    public int[] plusOne(int[] arr) {
        int n=arr.length;
        List<Integer> res=new ArrayList<>();
        int rem=1;
        for(int i=n-1;i>=0;i--){
            int sum=arr[i]+rem;
            if(sum>9){
                res.add(sum%10);
                rem=sum/10;
            }
            else{
                res.add(sum);
                rem=0;
            }
        }
        if(rem>0){
            res.add(rem);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray(); 
    }
}