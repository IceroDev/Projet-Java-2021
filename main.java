import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
public class main extends JFrame {
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
                System.out.println("***** Grille clear avec succès ! *****");
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
      // methode validation partie gagné par J1 arret jeu

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
      //  methode validation partie gagné par J2 arret joueur
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
    menu[0]=1;
    menu[1]=1;
    menu[2]=1;
    menu[3]=1;
    menu[4]=1;
    menu[5]=1;
    menu[6]=1;
    

    grille[3][0]=0;
    grille[3][1]=0;
    grille[3][2]=0;
    grille[3][3]=0;
    grille[3][4]=0;
    grille[3][5]=0;

    grille[4][0]=0;
    grille[4][1]=0;
    grille[4][2]=0;
    grille[4][3]=0;
    grille[4][4]=0;
    grille[4][5]=0;

    grille[5][0]=0;
    grille[5][1]=0;
    grille[5][2]=0;
    grille[5][3]=0;
    grille[5][4]=0;
    grille[5][5]=0;

    grille[6][0]=0;
    grille[6][1]=0;
    grille[6][2]=0;
    grille[6][3]=0;
    grille[6][4]=0;
    grille[6][5]=0;


    grille[0][0]=0;
    grille[0][1]=0;
    grille[0][2]=0;
    grille[0][3]=0;
    grille[0][4]=0;
    grille[0][5]=0;

    grille[1][0]=0;
    grille[1][1]=0;
    grille[1][2]=0;
    grille[1][3]=0;
    grille[1][4]=0;
    grille[1][5]=0;

    grille[2][0]=0;
    grille[2][1]=0;
    grille[2][2]=0;
    grille[2][3]=0;
    grille[2][4]=0;
    grille[2][5]=0;



  }

  public static void AffichageTab (){

    System.out.println("**** Grille du puissance 4 : ****");
    
    for (int j = 0; j < hauteur; j++) {
      for (int i = 0; i < largeur; i++) {
        System.out.print(" | " + menu[i] + " | ");
        System.out.print(" | " + grille[i][j] + " | ");
      }
      System.out.println();
    }
  }


}
