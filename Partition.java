public class Partition {
    public static int[] partition(PartitionChecker pc, long[] a, int k){
        if(k==1){ //If k is 1 return the array itself with 0's
            int[] temp=new int[a.length];
            for(int i=0;i<a.length;i++){
                temp[i]=0;
            }
            return temp;
        }
        if(a.length<k){ //if a length is < k return null
            return null;
        }
       int sum=0;
       for (int i=0;i<a.length;i++){ // find the sum of the elements
           sum+=a[i];
       }
       if(sum%k!=0){  // if the sum cant be divided into k,return null
           return null;
       }
       int target=sum/k; // sum of each buckets elements
       long[] subsets= new long[k]; // array that saves the sum of each bucket
        boolean []isUsed = new boolean[a.length]; // array that saves if the elements are used


        // Initialize sum of each subset from 0
        for (int i = 0; i < k; i++){
            subsets[i] = 0;}

        // mark all elements as not used
        for (int i = 0; i < a.length; i++){
            isUsed[i] = false;}



        int[] res= new int[a.length];
        // call recursive method to check K-substitution condition
        return helper(pc,a, subsets, isUsed,
                target,k,0,res,0);



    }

    public static int[] helper(PartitionChecker pc,long[] a,long[] subsets,boolean[] isUsed,long target,int k,int curIdx,int[] res,int curSub) {
        if(pc.allEqual(subsets) && subsets[0]!=0){
            return res;
        }

        for(int i=curIdx;i<a.length;i++){

            if(subsets[curSub]==target){
                return helper(pc,a,subsets,isUsed,target,k-1,0,res,curSub+1);
            } else if(subsets[curSub]+a[i]<=target && !isUsed[i]) {
                subsets[curSub]+= a[i];
                res[i]=curSub;
                isUsed[i]=true;

                curIdx=i;
                if(helper(pc,a,subsets,isUsed,target,k,curIdx,res,curSub) != null){
                    return helper(pc,a,subsets,isUsed,target,k,curIdx,res,curSub);
                }
                isUsed[i]=false;
                subsets[curSub]-= a[i];
            }
        }

        return null;
    }

    }

