class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double [][] arr=new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->Double.compare(a[0],b[0]));

        Stack<Double> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            double time=(target-arr[i][0])/arr[i][1];
            if(st.isEmpty() || time>st.peek()){
                st.push(time);
            }
        }
        return st.size();
    }
}