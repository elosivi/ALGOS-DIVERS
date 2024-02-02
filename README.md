# ALGOS-DIVERS
ALGOS DIVERS pour tests ou training
___

## CLOSEST ZERO

A partir d'une liste de double (positifs et négatifs) il faut retourner la valeur qui est la +proche de zéro.
Si deux valeurs sont equidistantes de 0, on retournera la valeur positive.
ex : -2 et 2 on retourne 2.

___

## ROBOT REMISE A NIVEAU
Un jeu avec un bras robotisé qui doit repartir les boxes de manière équitable dans chaque rangée.

**La méthode solve prend en paramètre** 
*la position actuelle du bras: int clawPos, 
*le nombre de boxes par rangée: int[] boxes, 
*si le bras a actuellement une boxe ou pas: boolean boxInClaw) {

**La méthode retourne** un string qui représente l'action qu'on demande au bras
*RIGHT
*LEFT
*PICK
*PLACE
*""

S'il n'est pas possible de répartir uniformément les boites sur chaque colonne, les boxes en "trop" devront être positionnées sur les colonnes de gauche.

___
