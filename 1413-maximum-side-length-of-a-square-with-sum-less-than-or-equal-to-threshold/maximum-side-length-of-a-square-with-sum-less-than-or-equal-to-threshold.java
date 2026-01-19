class Solution {
    public int finder(long prefix[][], int i, int j, int len, int threshold)
    {
        long sum= prefix[i+len][j+len] - prefix[i][j+len] - prefix[i+len][j] + prefix[i][j];
        if(sum <= threshold)
            return len;
        else
            return -1;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m= mat.length;
        int n= mat[0].length;
        long[][] prefix= new long[m+1][n+1];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                prefix[i+1][j+1]= mat[i][j] + prefix[i+1][j]+ prefix[i][j+1] - prefix[i][j];
            }
        }
        
        int longest= 0;
        int low= 1, high= Math.min(m,n);

        while(low<=high)
        {
            int mid= low+ (high-low)/2;
            boolean found= false;
            for(int i=0; i+mid<=m; i++)
            {
                for(int j=0; j+mid<=n; j++)
                {
                    int length= finder(prefix, i, j, mid, threshold);
                    if(length!=-1)
                    {
                        longest= Math.max(longest, length);
                        found= true;
                        break;
                    }
                }
                if(found)
                break;
            }
            if(found)
                low= mid+1;
            else
                high= mid-1;
        }
        return longest;
    }
}