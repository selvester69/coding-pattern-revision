public class P5 {

    public int majority(int[]arr){
        if(arr.length<0) return 0;

        int count=1;
        int cand = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==cand){count++;}
            else{
                count--;
                if(count==0){
                    cand = arr[i];
                    count=1;
                }
            }
        }

        return count;
    }
}
