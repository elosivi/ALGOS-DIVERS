class Closest0 {

    static double[] ts = { 7,-10,13,8,4,-7.2,-12,-3.7,3.5,-9.6,6.5,-.7,-6.2,7 };
    static double[] ts2 = { 7,-10,13,8,4,-7.2,-12,-3.7,3.5,-9.6,6.5,-6.2,7,-3.5 };
    static double[] ts3 = {  };
    static double[] ts4 = { 7,-10,0,8,4,-7.2,-12,-3.7,3.5,-9.6,6.5,-6.2,7,-3.5 };

    public static void testClosest(){
       double result =  closestToZero(ts);
    }

    // SOLUTION CODING GAME
    private static double closestToZero(double[] ts){

        if( ts.length == 0){
            return 0;
        }

        double closest = ts[0];
        for( int i = 1; i< ts.length; i++){
            double closestAbsolue = Math.abs(closest);
            double numberToCompareAbsolu = Math.abs(ts[i]);

            closest =  numberToCompareAbsolu == closestAbsolue ? (Math.max(ts[i], closest)) : (numberToCompareAbsolu < closestAbsolue ? ts[i] : closest);

        }
        System.out.println("Result: "+ closest);
        return closest;
    }
}

