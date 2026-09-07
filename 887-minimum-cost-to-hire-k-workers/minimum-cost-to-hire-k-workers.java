class Solution {

    // Optimised
    //     >> TC : O()

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=wage.length;
        double minWage=Double.MAX_VALUE;

        double [][] wrRatio=new double[n][2];
        for(int i=0;i<n;i++){
            wrRatio[i][0]=(double)wage[i]/quality[i];
            wrRatio[i][1]=quality[i];
        }

        Arrays.sort(wrRatio,(a,b)->Double.compare(a[0],b[0]));

        double cSum=0;

        PriorityQueue<Double> pq=new PriorityQueue<>((a,b)->Double.compare(b,a));
        for(int i=0;i<k;i++){
            cSum+=wrRatio[i][1];
            pq.add(wrRatio[i][1]);
        }

        double mgR=wrRatio[k-1][0];
        minWage=cSum*mgR;

        for(int i=k;i<n;i++){

            mgR=wrRatio[i][0];
            
            cSum+=wrRatio[i][1];
            pq.add(wrRatio[i][1]);

            if(pq.size()>k){
                cSum-=pq.poll();
            }

            minWage=Math.min(minWage,cSum*mgR);
        }
        return minWage;
    }
}


// Better Brute Force
//      >> TC : O(n*(n+klogk))


// public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//     int n=wage.length;
//     double minWage=Double.MAX_VALUE;

//     double [][] wrRatio=new double[n][2];
//     for(int i=0;i<n;i++){
//         wrRatio[i][0]=(double)wage[i]/quality[i];
//         wrRatio[i][1]=quality[i];
//     }

//     Arrays.sort(wrRatio,(a,b)->Double.compare(a[0],b[0]));

//     for(int i=k-1;i<n;i++){

//         double mgR=wrRatio[i][0];

//         ArrayList<Double> wages=new ArrayList<>();

//         for(int j=0;j<=i;j++){
//             double wgW=mgR*wrRatio[j][1];
//             wages.add(wgW);
//         }

//         PriorityQueue<Double> pq=new PriorityQueue<>((a,b)->Double.compare(b,a));
//         double curWage=0;
//         for(double wg:wages){
//             curWage+=wg;
//             pq.add(wg);
//         }
//         minWage=Math.min(minWage,curWage);
//     }
//     return minWage;
// }


// Brute Force
//      >> TC : O(n*(n+klogk))


// public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//     int n=wage.length;

//     double minWage=Double.MAX_VALUE;
    
//     for(int i=0;i<n;i++){

//         double mgR=(double)wage[i]/quality[i];

//         ArrayList<Double> wages=new ArrayList<>();

//         for(int j=0;j<n;j++){
//             double wgW=mgR*quality[j];

//             if(wgW>=wage[j]){
//                 wages.add(wgW);
//             }
//         }

//         if(wages.size()<k){
//             continue;
//         }

//         PriorityQueue<Double> pq=new PriorityQueue<>((a,b)->Double.compare(b,a));
//         double curWage=0;
//         for(double wg:wages){
//             curWage+=wg;
//             pq.add(wg);

//             if(pq.size()>k){
//                 curWage-=pq.poll();
//             }
//         }

//         minWage=Math.min(minWage,curWage);
//     }
//     return minWage;
// }