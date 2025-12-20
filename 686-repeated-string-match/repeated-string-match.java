class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp="";
        int count=0;
        while(temp.length()<b.length()){
            temp+=a;
            count++;
        }
        if(temp.contains(b)){
            return count;
        }
        temp+=a;
        return (temp.contains(b))?count+1:-1;
    }
}