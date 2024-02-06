class LePlusLourd{
    public static int solve(int weight0,int weight1, int weight2){
       int heavy = Math.max(weight2,Math.max(weight1, weight0));

        if(heavy == weight0){
            return 0;
        }
        if(heavy == weight1){
            return 1;
        }
        if(heavy == weight2){
            return 2;
        }

return -1;
    }
}