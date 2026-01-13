class Solution {
    public double separateSquares(int[][] squares) {
        int n=squares.length;
        double lo=Integer.MAX_VALUE;
        double hi=Integer.MIN_VALUE;
        double totalArea=0;
        for(int [] square:squares){
            int x=square[0];
            int y=square[1];
            int len=square[2];
            totalArea+=((double)len*len);
            lo=Math.min((double)y,lo);
            hi=Math.max((double)y+len,hi);
        }
        while(hi-lo>1e-5){
            double mid=lo+(hi-lo)/2;
            if(isEqual(squares,totalArea,mid)){
                hi=mid;
            }
            else{
                lo=mid;
            }
        }
        return hi;
    }
    public static boolean isEqual(int [][] squares,double totalArea,double mid){
        double bottomArea=0;
        for(int [] square:squares){
            int y=square[1];
            int len=square[2];

            double topY=y+len;
            double botY=y;

            if(mid>topY){
                bottomArea+=((double)len*len);
            }
            else if(mid>botY){
                bottomArea+=((double)len*(mid-botY));
            }
        }
        return bottomArea>=(totalArea)/2.0;
    }
}