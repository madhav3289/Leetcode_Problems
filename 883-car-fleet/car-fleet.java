// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n=position.length;
//         int [][] arr=new int[n][2];
//         for(int i=0;i<n;i++){
//             arr[i][0]=position[i];
//             arr[i][1]=speed[i];
//         }
//         Arrays.sort(arr,(a,b)->a[0]-b[0]);

//         Stack<int[]> st=new Stack<>();
//         for(int i=n-1;i>=0;i--){
//             if(st.isEmpty() || arr[i][1]<st.peek()[1]){

//                 // if current car is slower than the car in front of it,mit can never catch upto it 
//                 st.push(new int[]{arr[i][0],arr[i][1]});
//             }
//             else{
//                 int [] temp=st.peek();
//                 double curTime=(double)(target-arr[i][0])/arr[i][1];
//                 double prevTime=(double)(target-temp[0])/temp[1];
//                 if(curTime<=prevTime){  // it means they meets
//                     st.pop();
//                     // checking where they meets
//                     // equation to find intersection point(position)
//                     int interSect=(arr[i][1]*temp[0]-temp[1]*arr[i][0])/(arr[i][1]-temp[1]);
//                     st.push(new int[]{interSect,Math.min(arr[i][1],temp[1])});

//                 }
//                 else{
//                     st.push(new int[]{arr[i][0],arr[i][1]});
//                 }
//             }
//         }
//         return st.size();
//     }
// }
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