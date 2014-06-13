Bowling Impossible
==================

Le championnat du monde of the world 2014 de bowling commence dans 2h (à voir pour la durée) mais un bug de la matrice empêche le calcul des scores, votre mission si vous l’acceptez est de ré-implementer le moteur de calcul de score temporel avec les règles suivantes :

Règles du bowling : 
-------------------

   * Chaque partie compte 10 tours.
   * Chaque tour à 2 lancer par joueur sauf exception (Cf. la régle des bonus).
   * Si durant les deux essais, il ne parvient pas à faire tomber toutes les quilles, son score pour le tours est le nombre total de quilles abattues dans ses deux essais.
   * S'il fait tomber toutes les quilles en 2 coups, c'est ce qu'on appelle un "spare" et son score pour le tour est de dix, plus le nombre de quilles abattues sur son prochain lancer lors du prochain tour.
   * Si sur son premier essai du tour il renverse toutes les quilles, c'est ce qu'on appelle un «strike». Son tour est terminé, et son score pour le tour est dix plus le total des quilles abattues lors de ses deux prochaines lancer.
   * S'il obtient un « spare »  dans le dernier (dixième) tour, le lanceur à un lancer bonus.
   * S'il obtient un « strike»  dans le dernier (dixième) tour, le lanceur à deux lancer bonus
      * NB : Ces bonus sont comtabilisé avec le dixième tour. 
   * Si durant les lancer bonus toutes les quilles sont tomber, le processus ne se répète pas: le bonus sont uniquement utilisées pour calculer le score du dernier tour.
   * Le score du jeu est le total de l’ensemble des tours.

En entrée, vous aurez une chaine de 12 à 22 à caractères, les caractères peuvent être :
   * un nombre compris entre 1 et 9
   * un - qui indique qu’aucune quille n’est tombé.
   * un / qui représente un « spare »
   * un X représente un « strike » 

En sortie, vous devez fournir un nombre entier qui sera le total.

Voici quelques exemples :
   * "XXXXXXXXXXXX" (12 lancer : 12 strikes) = (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) + (10+10+10) = 300
   * "9-9-9-9-9-9-9-9-9-9-" (20 lancer : 10 lancer réussi et 10 coups foireux) = 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 = 90
   * "5/5/5/5/5/5/5/5/5/5/5" (21 lancer: 10 lancer réussi et 10 spare, et le bonus final) = (10+5) + (10+5) + (10+5) + (10+5) + (10+5) + (10+5) + (10+5) + (10+5) + (10+5) + (10+5) = 150

Afin de ne pas vous aventurer dans trop de complexité dès le départ nous vous proposons de commencer par écrit les tests dans l’ordre suivant :

   * --------------------
   * 11111121111111111111
   * -------/------------
   * ------4/------------
   * ------4/-----/------
   * --------X----------
   * ------XX----------
   * --------4/X--------
   * 5/5/5/5/5/5/5/5/5/5/5
   * XXXXXXXXXXX

Le comité du championnat du monde of the world 2014 de bowling compte sur vous ! Il ne reste plus qu’a vous souhaiter bonne chance …

