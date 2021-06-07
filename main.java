import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
public class main{
  static Scanner saisie;
  private static int[][] grille;
  private static int[] menu;
  public static final int largeur = 7;
  public static final int hauteur = 6;
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
  public static void main(String[] args) {
    Scanner saisie = new Scanner(System.in);

    init();
    AffichageTab();




    // tour de jeu
    int tour = 0;
    String choix2;
    int choix = 0;
    int jeton = 0;

    do {
      // Joueur 1
      //    choixColonne();
      do {
          jeton = 1;
            System.out.print("Joueur 1, faites votre choix de colonne : ");
            choix = saisie.nextInt();
            if(choix ==0){
                for(int i = 0 ; i < grille.length ; i++){
                    for(int j = 0 ; j < grille[i].length ; j++){
                        grille[i][j] = 0;
                    }
                }
                clrscr();
                System.out.println("*********** Grille clear avec succès ***********");
                AffichageTab();
            }
            else if(choix > 7 || choix < 1)
            {
              System.out.println("Vous avez loupé la grille, recommencez.");
            }
            //verifie si la colonne n'est pas pleine

            else if(grille[choix-1][0]==0)
            {
              //nouvelle valeur dans la grille
              grille [choix-1][selectionHauteur(choix)] = jeton;
              clrscr();
              AffichageTab();

            }
            else
            {
              System.out.println("La colonne choisi est pleine, recommencez.");
            }
        } while ( (choix>7 || choix<1) || grille[choix-1][0]!=0);
      // Joueur 2
      // choixColonne();
      do {
            jeton = 2;
            System.out.print("Joueur 2, faites votre choix de colonne : ");
            choix = saisie.nextInt();
            
            if(choix ==0){
                for(int i = 0 ; i < grille.length ; i++){
                    for(int j = 0 ; j < grille[i].length ; j++){
                        grille[i][j] = 0;
                    }
                }
                clrscr();
                System.out.println("***** Grille clear avec succès ! *****");
                AffichageTab();
            }
            else if(choix > 7 || choix < 1){
              System.out.println("Vous avez louper la grille, recommencez.");
            }
            //verifie si la colonne n'est pas pleine

            else if(grille[choix-1][0]==0){
              grille [choix-1][selectionHauteur(choix)] = jeton;
              clrscr();
              AffichageTab();
            }
            else {
              System.out.println("La colonne choisi est pleine, recommencez.");
            }
      } while (choix>7 || choix<1 || grille[choix-1][0]!=0);
      tour++;
    } while (tour <= 21);

    System.out.println("égalité");
  }



  public static int selectionHauteur(int choix) {

    int i = 5;

    while (i>= 0) {
      if (grille[choix-1][i] == 0){

        return i;
      }
      i--;
    }
    return i;

  }

  public static void init() {

    grille = new int[largeur][hauteur];
    menu = new int[largeur];
    
    for (int j = 0; j < hauteur; j++) {
      for (int i = 0; i < largeur; i++) {
        grille[i][j] = 0;
        menu[i] = i+1;
      }
    }

  }

  public static void AffichageTab (){
    System.out.println(
    "***************** Puissance 4 ******************\n"+
    "************** Tapez 0 pour clear **************\n"+
    "\n■ : Joueur 1\n● : Joueur 2\n◌ : Case vide\n"+
    "\n************************************************\n"+
    "************************************************"
    );
    for (int i = 0; i < largeur; i++) {
        System.out.print(" | " + menu[i] + " | ");
      }
      
      System.out.println("\n");
    for (int j = 0; j < hauteur; j++) {
      for (int i = 0; i < largeur; i++) {
        int val = grille[i][j];
        String marqueur;
        if(val == 1){
            marqueur = "■";
        }else if(val == 2){
            marqueur = "●";
        }else{
            marqueur = "◌";
        }
        System.out.print(" | " + marqueur + " | ");
      }
      System.out.println();
    }
    System.out.println("************************************************");
  }
}
