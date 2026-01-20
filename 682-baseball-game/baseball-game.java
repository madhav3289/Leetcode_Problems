class Solution {
    public int calPoints(String[] opr) {
        int n=opr.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String op=opr[i];
            int len=list.size();
            if(op.equals("+")){
                int sum=list.get(len-1)+list.get(len-2);
                list.add(sum);
            }
            else if(op.equals("D")){
                int mul=2*list.get(len-1);
                list.add(mul);
            }
            else if(op.equals("C")){
                list.remove(len-1);
            }
            else{
                list.add(Integer.parseInt(op));
            }
        }
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
}