class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int diff=Math.abs(arr[i]-arr[i+1]);
            mini=Math.min(mini,diff);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff=Math.abs(arr[i]-arr[i+1]);
            if(diff==mini){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
}