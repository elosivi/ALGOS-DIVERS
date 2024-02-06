
import java.util.HashMap;
import java.util.Map;

/**
 * Vous fabriquez des jouets en bois dans votre atelier de menuiserie
 * Chaque puzzle est un quadrillage, sur lequel sont posés des blocs en bois. Ces blocs doivent être sortis
 * du jeu, l'un après l'autre, sans entrer en collision. Vous devez déterminer l'ordre de sortie.
 *
 *  Chaque bloc est numéroté par une valeur entre 0 et 9. Lorsque vous indiquez le numéro d'un bloc, celui
 * ci sera déplacé vers la droite jusqu'à sortir du jeu.
 *
 * la méthode solve(width, height, nbBlocks, grid) est exécutée à chaque tour de jeu et doit renvoyer le numéro du prochain bloc à déplacer
 *
 * seul grid est mis a jour à chaque tour.
 * Le paramètre grid représente la situation actuelle du puzzle. Chacun de ses caractères peut prendre
 * l'une des valeurs suivantes :
 *  . (un point) : une case vide. X : un mur. Ils sont placés sur la première et la dernière ligne, ainsi qu'au
 * premier caractère de chaque ligne, afin de montrer que la seule sortie possible est par la droite. Vous ne
 * pouvez pas déplacer ces murs. un entier entre 0 et nb_blocks-1 : une case occupée par un bloc. Un
 * même numéro peut être présent plusieurs fois dans la grille, représentant un seul bloc qui s'étend sur
 *  plusieurs cases. Toutes les cases ayant un même numéro de bloc sont placées sur une même ligne et
 * sont connexes (elles ne sont jamais séparées en plusieurs groupes isolés)
 *
 * Conditions de victoire
 *  Tous les blocs sont sortis du jeu.
 *  (Il y a toujours au moins un ordre possible.)
 *
 *  TESTE OK
 */
public class puzzleToRight {
    public static int solve(int width, int height, int nbBlocks, String[] grid) {
        //compter les block et retourner -1 si le jeu est terminé

        int blockCount=0;
        int block=0;
        //System.out.println("la grille pour ce tour:");
        for(String line : grid){
           // System.out.println(line);
            for(char cell: line.toCharArray()){
                if( Character.isDigit(cell)){
                    if( block != Character.getNumericValue(cell)){ // ne pas compter les block qui font plusieurs cellules
                        block = Character.getNumericValue(cell);
                        blockCount++;
                    };
                }
            }
        }
        System.out.println("nb de block à sortir:" + blockCount);
        if(blockCount == 0){
            System.out.println("tous les blocks sont sortis");
            return -1;
        }

        // Il reste des blocks à déplacer
        for(String line : grid){
            //regarder le dernier charactère de chaque ligne
            for(int i=(line.length()-1);i>0;i--){
                //si un chiffre on le retourne
                char charToEvaluate = line.charAt(i);
                if(Character.isDigit(charToEvaluate)){
                    int blockToMove =  Character.getNumericValue(charToEvaluate);
                    // on verifie qu'il n' y ai aucun obstacle à droite et on le retourne
                    boolean isAnX=false;
                    for(int y=i+1;y<line.length();y++){
                        char nextChar = line.charAt(y);
                        if(nextChar == 'X' ){
                            isAnX = true;
                        }
                    }
                    if (!isAnX){
                        System.out.println(blockToMove +" to the right");
                        return blockToMove;
                    };
                }
                // automatiquement si c'est un X ou un . je ne retourne rien
                // et repars dans la boucle sur le caractère d'avant
                // jusqu'au charactère 1 puisque dans tous les cas le caractère 0 =X

            }
                }

        return 0;
    }

    public static void main(String[] args) {
        int width = 5;
        int height = 6;
        int nbBlocks = 8;
        String[] grid = {
                "XXXXX",
                "X..12",
                "X..34",
                "X5556",
                "X.78.",
                "XXXXX"
        };
        int nextBlock = solve(width, height, nbBlocks, grid);
        System.out.println("Prochain bloc à déplacer : " + nextBlock);
    }
}
