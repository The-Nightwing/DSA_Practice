public class path {

    public static int numpaths(int[][] arr,int r,int c){

        if(r==1 || c==1){
            return 1;
        }

        return numpaths(arr,r,c-1)+numpaths(arr,r-1,c);
    }


    public static void main(String[] args) {
        int a[][] = new int[][]{{1,2},{4,5}};

        System.out.println(numpaths(a,a.length,a[0].length));
    }
    
}