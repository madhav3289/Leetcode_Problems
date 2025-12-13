class Solution {
    public List<String> validateCoupons(String[] code, String[] line, boolean[] isActive) {
        int n=code.length;
        List<String[]> temp=new ArrayList<>();
        Map<String,Integer> order=Map.of(
            "electronics",0,
            "grocery",1,
            "pharmacy",2,
            "restaurant",3
        );
        for(int i=0;i<n;i++){
            boolean isValid=true;
            String s=code[i];
            if(s==null || s.isEmpty()){
                continue;
            }
            for(int j=0;j<s.length();j++){
                char ch=s.charAt(j);
                if(!(Character.isLetterOrDigit(ch) || ch=='_')){
                    isValid=false;
                    break;
                }  
            }
            if(isValid && isActive[i] && order.containsKey(line[i])){
                temp.add(new String[]{line[i],code[i]});
            }
        }
        temp.sort((a,b)->{
            int num=Integer.compare(order.get(a[0]),order.get(b[0]));
            if(num!=0){
                return num;
            }
            return a[1].compareTo(b[1]);
        });
        List<String> res=new ArrayList<>();
        for(String [] s:temp){
            res.add(s[1]);
        }
        return res;
    }
}