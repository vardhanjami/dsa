import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;


public class ConstantWindow {
    public static int maxseq(int arr[],int k){
        int l=0;
        int r=k-1;
        int sum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        for(int i=l;i<arr.length;i++){
            while(r<arr.length-1){
                sum=sum-arr[l];
                l++;
                r++;
                sum=sum+arr[r];
                maxsum=Math.max(maxsum,sum);
            }
        }
        return maxsum;
        //System.out.println(maxsum);
    }
    public static int longsubarray(int arr[],int k){
        int sum=0;
        int maxlen=0;
        int l=0;
        int r=0;
        while(r<arr.length){
            sum=sum+arr[r];
            while(sum>k){
                sum=sum-arr[l];
                l=l+1;
            }
            if(sum<=k){
                maxlen=Math.max(maxlen,r-l+1);
                r=r+1;
            }
        }
        return maxlen;
    }
    public static int dice(int[] arr){
        int xsum=0;
        int ysum=0;
        int l=0;
        int r=0;
        int i=0;
        //for(int i=0;i<arr.length;i++){
        while(l<arr.length-1){
            if(arr[r]==6&&r<=3){
                xsum+=arr[i];
                r++;
                i++;
            }
            else if(l<arr.length-1){
                xsum+=arr[r];
                l=r+1;
                ysum+=arr[l];
            }            
            // if(l<arr.length)
            // // l=r+1;
            // ysum+=arr[r];
            // r++;
        }
        return (int) Math.abs(xsum-ysum);

    }
    public static int maxcards(int nums[], int k){
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        int n=nums.length;
        int rindex=n-1;

        for(int i=0;i<=k-1;i++){
            lsum=lsum+nums[i];
            maxsum=lsum;
        }
        for(int j=k-1;j>=0;j--){
            lsum=lsum-nums[j];
            rsum=rsum+nums[rindex];
            rindex=rindex-1;
            maxsum=Math.max(maxsum, lsum+rsum);
        }
        return maxsum;    }
        public static int longsubstring(String s){
            int l=0;
            int r=0;
            int maxlen=0;
            int n=s.length();
            //HashSet<Character> hash= new HashSet<>();
            int hash[]=new int[256];
            for(int i=0;i<256;i++){
                hash[i]=-1;
            }
            while(r<n){
                if(hash[s.charAt(r)]!=-1){
                    if(hash[s.charAt(r)]>=l){
                        l=hash[s.charAt(r)]+1;
                    }  
                }
                int len=r-l+1;
                maxlen =Math.max(maxlen,len);
                hash[s.charAt(r)]=r;
                r++;
            }
            return maxlen;
        }
        public static int maxOnes(int[] nums,int k){
            int l=0;
            int r=0;
            int maxlen=0;
            int zeros=0;
            while(r<nums.length){
                if(nums[r] == 0){
                    zeros++;
                }
                if(zeros>k){
                    if(nums[l]==0){
                        zeros--;
                    }
                    l++;
                }
                if(zeros<=k){
                    int len=r-l+1;
                    maxlen=Math.max(len, maxlen);
                }
                r++;
            }
            return maxlen;
        }
    public static void main(String[] args) {
        int arr[]={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(maxOnes(arr, 2));
        // String s="abcndsjdsd";
        // System.out.println(longsubstring(s));
        // int[] arr={6,7,3,1,8,2,4,8,1,9,2};
        // int k=4;
        // System.out.println(maxcards(arr, k));
        //int[] arr={-1,3,5,2,7,4,-2,4};
        // int k=4;
        // System.out.println(maxseq(arr,k));
        // int[] arr={2,2,4,2,1,2,1,3,3,8,3,2,7};
        // int k=13;
        // System.out.println(longsubarray(arr, k));
        // int[] arr={6,6,3,4};
        // System.out.println(dice(arr));
    }
    
}
