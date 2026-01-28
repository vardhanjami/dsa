import java.util.HashMap;

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
        public static int Buckets(int arr[]){
            int l=0;
            int r=0;
            int maxlen=0;
            int k=2;
            HashMap<Integer,Integer> mpp =new HashMap<>();
            while(r<arr.length){
                mpp.put(arr[r], mpp.getOrDefault(arr[r],0)+1);
                if(mpp.size()>k){
                    mpp.put(arr[l],mpp.get(arr[l])-1);
                    if(mpp.get(arr[l])==0)
                        mpp.remove(arr[l]);
                l++;
                }
                if(mpp.size()<=k)
                    maxlen=Math.max(maxlen, r-l+1);
                r++;
            }
            return maxlen;
        }
        public static int distinctSubstring(String s,int k){
            int l=0;
            int r=0;
            int maxlen=0;
            int hash[]=new int[256];
            HashMap <Character,Integer> mpp= new HashMap<>();
            for(int i=0;i<256;i++){
                hash[i]=-1;
            }
            while(r<s.length()){
                mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0) + 1);
                if(mpp.size()>k){
                    hash[s.charAt(l)]--;
                    if(hash[s.charAt(l)]==0){
                        mpp.remove(s.charAt(l));
                    }
                    l=l+1;
                }
                if(mpp.size()<=2){
                    maxlen=Math.max(maxlen, r-l+1);
                }
                r++;
            }
            return maxlen;
        }
        public static int substringwithallchar(String s){
            int cnt=0;
            int[] lastseen={-1,-1,-1};
            for(int i=0;i<s.length();i++){
                lastseen[s.charAt(i)-'a']= i;
                if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                    cnt = cnt + (1 + Math.min(lastseen[0],
                        Math.min(lastseen[1], lastseen[2])));
                }
            }
            return cnt;
        }
        public static int countAtmost(int[] nums,int goal){
            int l=0;
            int r=0;
            int sum=0;
            int cnt=0;
            while(r<nums.length){
                sum+=nums[r];
                while(sum>goal){
                    sum-=nums[l];
                    l++;
                }
                cnt+=r-l+1;
                r=r+1;
            }
            return cnt;
        }
        public static int longrepcharrep(String s,int k){
            int l=0;
            int r=0;
            int maxf=0;
            int maxlen=0;
            int[] hash=new int[26];
            for(int i=0;i<26;i++){
                hash[i]=0;
            }
            while(r<s.length()){
                hash[s.charAt(r)-'A']++;
                maxf=Math.max(maxf,hash[s.charAt(r)-'A']);
                if((r-l+1)-maxf>k){
                    hash[s.charAt(l)-'A']--;
                    maxf=0;
                    l=l+1;
                }
                if((r-l+1)-maxf<=k){
                    maxlen=Math.max(maxlen,r-l+1);
                }
                r++;
            }
            return maxlen;
        }
        public static int nicesubarrays(int nums[],int k){
            int l=0;
            int r=0;
            int cnt=0;
            int sum=0;
            while(r<nums.length){
                sum=sum+(nums[r]%2);
                while(sum>k){
                    sum-=nums[l]%2;
                    l=l+1;
                }
                cnt=cnt+(r-l+1);
                r=r+1;
            }
            return cnt;
        }
        public static int subwithkdis(int nums[],int k){
            int l=0;
            int r=0;
            int cnt=0;
            HashMap <Integer,Integer> mpp= new HashMap<>();
            while(r<nums.length){
                mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
                while(mpp.size()>k){
                    mpp.put(nums[l],mpp.get(nums[l])-1);
                    if(mpp.get(nums[l])==0){
                        mpp.remove(nums[l]);
                    }
                    l=l+1;
                }
                cnt+=(r-l+1);
                r=r+1;
            }
            return cnt;
        }
        public static String minwinsubs(String s,String t){
            int n=s.length();
            int m=t.length();
            if(m>n) return "";
            int[] hash=new int[256];
            for(int i=0;i<m;i++){
                hash[t.charAt(i)]++;
            }
            int l=0;
            int r=0;
            int minlen= Integer.MAX_VALUE;
            int cnt=0;
            int sIndex=-1;
            while(r<n){
                if(hash[s.charAt(r)]>0){
                    cnt+=1;
                }
                hash[s.charAt(r)]--;
                while(cnt==m){
                    if((r-l+1)<minlen){
                        minlen=(r-l+1);
                        sIndex=l; 
                    }
                    hash[s.charAt(l)]++;
                    if(hash[s.charAt(l)]>0){
                        cnt=cnt-1;
                    }
                    l=l+1;   
                }
                r=r+1;
            }
            return sIndex==-1?"":s.substring(sIndex,(sIndex+minlen));
        }

    public static void main(String[] args) {
        String s="AKABCCVDHVSJBKKBADSGASC";
        String t="ABD";
        System.out.println("Minimum length window with substring: "+minwinsubs(s, t));
        // int nums[]={2,1,1,1,4,2,3,2,5};
        // int k=3;
        // System.out.println("Subarrays with k different integers: "+(subwithkdis(nums,k)-subwithkdis(nums,k-1)));
        // int[] nums={1,1,2,3,1,3,1};
        // int k=3;
        // System.out.println("Subarrays with k odd integers/ nice subarrays :"+(nicesubarrays(nums, k)-nicesubarrays(nums, k-1)));
        // // String s="AABABABA";
        // int k=2;
        // System.out.println("Longest repetiting Character with replacement: "+longrepcharrep(s, k));
        // int[] nums={1,0,0,1,0,1,0};
        // int goal=2;
        // System.out.println("Binary subarrays with sum 2 are: "+(countAtmost(nums, goal)-countAtmost(nums, goal-1)));
        //System.out.println("no of substrings containing all the three characters are :"+substringwithallchar("abca"));
        // String s="aabbbaacdeaaasseee";
        // int k=2;
        // System.out.println("Maxlength of the string is : "+distinctSubstring(s, k));
        
        // int arr[]={3,3,3,4,5,2,2,1,1,1,2,4,5};
        // System.out.println("Maxlength is: "+Buckets(arr));

        // int arr[]={1,1,1,0,0,0,1,1,1,1,0};
        // System.out.println("length is :"+maxOnes(arr, 2));
        // // String s="abcndsjdsd";
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
