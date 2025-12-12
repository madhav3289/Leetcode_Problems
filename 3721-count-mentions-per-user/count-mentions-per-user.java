class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int [] ment=new int[numberOfUsers];
        int [] off=new int[numberOfUsers];

        Collections.sort(events,(a,b)->{
            if(Integer.parseInt(a.get(1))==Integer.parseInt(b.get(1))){
                return b.get(0).compareTo(a.get(0));
            }
            return Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1));
        });

        for(int i=0;i<events.size();i++){
            if(events.get(i).get(0).equals("MESSAGE")){
                msgFunc(events.get(i),ment,off);
            }
            else if(events.get(i).get(0).equals("OFFLINE")){
                offlFunc(events.get(i),ment,off);
            }
        }
        return ment;
    }
    public static void offlFunc(List<String> event,int [] ment,int [] off){
        String [] s=event.get(2).split(" ");
        int t=Integer.parseInt(event.get(1));
        for(String temp:s){
            int idx=Integer.parseInt(temp);
            off[idx]=t;
        }
        return;
    }
    public static void msgFunc(List<String> event,int [] ment,int [] off){
        String [] s=event.get(2).split(" ");
        int t=Integer.parseInt(event.get(1));
        for(String temp:s){
            if(temp.equals("ALL")){
                for(int i=0;i<ment.length;i++){
                    ment[i]=ment[i]+1;
                }
            }
            else if(temp.equals("HERE")){
                for(int i=0;i<ment.length;i++){
                    if(off[i]==0){
                        ment[i]=ment[i]+1;
                    }
                    else if(off[i]+60<=t){
                        ment[i]+=1;
                        off[i]=0;
                    }
                }
            }
            else{
                int idx=Integer.parseInt(temp.substring(2));
                ment[idx]=ment[idx]+1;
            }
        }
        return;
    }
}