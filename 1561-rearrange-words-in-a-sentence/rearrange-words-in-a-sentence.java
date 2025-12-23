class Solution {
    public String arrangeWords(String text) {
        String [] arr=text.split("\\s+");
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            StringBuilder temp=new StringBuilder();
            temp.append(arr[i]);
            // if(Character.isUpperCase(temp.charAt(0)){
            //     temp.setCharAt(0,)
            // }
            temp.setCharAt(0,Character.toLowerCase(temp.charAt(0)));
            if(i==0){
                temp.setCharAt(0,Character.toUpperCase(temp.charAt(0)));
            }
            sb.append(temp);
            sb.append(' ');
        }
        String res=sb.toString();
        return res.substring(0,res.length()-1);
    }
}