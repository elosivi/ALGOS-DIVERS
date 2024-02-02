import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.List;

class Player {

    public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        final String RIGHT = "RIGHT";
        final String LEFT = "LEFT";
        final String PICK = "PICK";
        final String PLACE = "PLACE";

        //objectif
        int[] targetBoxes = targetBoxes(boxes,boxInClaw);
        boolean isTargetBoxes = isTargetBoxes(boxes,targetBoxes);
        if(isTargetBoxes) return ""; // objectif atteint

        //check la situation
        boolean isLastCol = clawPos== boxes.length-1;
        boolean isBoxMissing = boxes[clawPos] < targetBoxes[clawPos];
        boolean isBoxToPickUp = boxes[clawPos] > targetBoxes[clawPos];
        boolean isMissingBoxesInARightCol = isMissingBoxesInARightCol(clawPos, boxes, targetBoxes);
        boolean isBoxesToPickUpInARightCol = isBoxesToPickUpInARightCol(clawPos, boxes, targetBoxes);

        //objectif non atteint => que dois faire le bras?
        //A t il une boxe chargée?

        if(boxInClaw){
            System.err.println("boxInClaw");

            //doit il poser la boxes?
            if(isBoxMissing){
                return PLACE;
            }

            //doit il se déplacer?
            if(!isLastCol && isMissingBoxesInARightCol){
                //à droite? si pas dernière colonne et qu'il manque des boxes à droite
                return RIGHT;
            }else{
                //à gauche, si der col ou qu'à droite aucune col n'a pas besoin de box
                return LEFT;
            }

        }else{
            System.err.println("NOT boxInClaw");

            //doit-il récupérer une boxe?
            if(isBoxToPickUp){
                return PICK;
            }

            //doit il se déplacer?
            if(!isLastCol && isBoxesToPickUpInARightCol){
                //à droite? si pas dernière colonne et qu'il y a des boxes en trop à droite
                return RIGHT;
            }else{
                //à gauche? si der col && col à droite aucune boxe à prendre
                return LEFT;
            }
        }
    }

    private static boolean isTargetBoxes(int[] boxes, int[] targetBoxes) {
        for(int i=0; i<boxes.length; i++){
            if(boxes[i] != targetBoxes[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] targetBoxes(int[] boxes, boolean boxInClaw) {
        int[] targetBoxes=new int[boxes.length];
        int total = boxInClaw?1:0;
        for(int col:boxes){
            total+=col;
        }
        int minByCol= total/boxes.length;
        int nbBoxesToDistribute = total%boxes.length;

        for(int i=0; i<boxes.length; i++){
            if (i<nbBoxesToDistribute){
                targetBoxes[i]=minByCol+1;
            }else{
                targetBoxes[i]=minByCol;
            }
        }
        return targetBoxes;
    }

    private static boolean isMissingBoxesInARightCol(int clawPos, int[] boxes, int[]targetBoxes){
        for(int i=clawPos+1; i<boxes.length; i++){
            if(boxes[i] < targetBoxes[i]){
                return true;
            }
        }
        return false;
    };

    private static boolean isBoxesToPickUpInARightCol(int clawPos, int[] boxes, int[]targetBoxes){
        for(int i=clawPos+1; i<boxes.length; i++){
            if(boxes[i] > targetBoxes[i]){
                return true;
            }
        }
        return false;
    };

}