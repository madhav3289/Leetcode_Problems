class NumArray {
    static int [] segTree;
    static int n;
    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updateTree(index,val,0,0,n-1);
    }
    
    public int sumRange(int left, int right) {
        return rangeQuery(left,right,0,0,n-1);
    }

    public static int rangeQuery(int st,int ed,int i,int left,int right){
        if(left>ed || right<st){
            return 0;
        }
        if(left>=st && right<=ed){
            return segTree[i];
        }
        int mid=left+(right-left)/2;
        return rangeQuery(st,ed,2*i+1,left,mid)+rangeQuery(st,ed,2*i+2,mid+1,right);
    }

    public static void buildTree(int i,int left,int right,int [] nums){
        if(left==right){
            segTree[i]=nums[left];
            return;
        }
        int mid=left+(right-left)/2;
        buildTree(2*i+1,left,mid,nums);
        buildTree(2*i+2,mid+1,right,nums);

        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }

    public static void updateTree(int index,int val,int i,int left,int right){
        if(left==right){
            segTree[i]=val;
            return;
        }
        int mid=left+(right-left)/2;
        if(index<=mid){
            updateTree(index,val,2*i+1,left,mid); 
        }
        else{
            updateTree(index,val,2*i+2,mid+1,right);
        }

        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */