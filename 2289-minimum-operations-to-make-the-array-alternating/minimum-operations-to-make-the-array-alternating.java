class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> evenFreq=new HashMap<>();
        for(int i=0;i<n;i+=2){
            evenFreq.put(nums[i],evenFreq.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer,Integer> oddFreq=new HashMap<>();
        for(int i=1;i<n;i+=2){
            oddFreq.put(nums[i],oddFreq.getOrDefault(nums[i],0)+1);
        }
        int evenMax1=-1,evenMax2=-1,evenTotal=0;
        int evenCnt1=0,evenCnt2=0;
        for(int key:evenFreq.keySet()){
            int freq=evenFreq.get(key);
            if(evenCnt1<freq){
                evenCnt2=evenCnt1;
                evenMax2=evenMax1;
                evenCnt1=freq;
                evenMax1=key;
            }
            else if(freq>evenCnt2){
                evenCnt2=freq;
                evenMax2=key;
            }
            evenTotal+=freq;
        }
        int oddMax1=-1,oddMax2=-1,oddTotal=0;
        int oddCnt1=0,oddCnt2=0;
        for(int key:oddFreq.keySet()){
            int freq=oddFreq.get(key);
            if(oddCnt1<freq){
                oddCnt2=oddCnt1;
                oddMax2=oddMax1;
                oddCnt1=freq;
                oddMax1=key;
            }
            else if(freq>oddCnt2){
                oddCnt2=freq;
                oddMax2=key;
            }
            oddTotal+=freq;
        }
        if(evenMax1!=oddMax1){
            int totalSwap=(evenTotal-evenCnt1)+(oddTotal-oddCnt1);
            return totalSwap;
        }
        else{
            if(evenMax2==-1 && oddMax2==-1){
                return Math.min(evenCnt1,oddCnt1);
            }
            int totalSwap=Integer.MAX_VALUE;
            if(oddMax2!=-1){
                totalSwap=Math.min(totalSwap,(evenTotal-evenCnt1)+(oddTotal-oddCnt2));
            }
            if(evenMax2!=-1){
                totalSwap=Math.min(totalSwap,(evenTotal-evenCnt2)+(oddTotal-oddCnt1));
            }            
            return totalSwap;
        }
    }
}