
import java.util.HashMap;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;

public class LSystem {

    private String axiome;
    private HashMap<Character, String> regles;
    private String expCourante;
    private int comptChar = 0;      //Compteur des caracteres dans l'axiome  
    private int comptExp = 0;      //Compteur des caracteres dans l'expression pour l'interpretation
    private String nouvelleExp = ""; //Pour pouvoir ajouter des regles a l'Expression 
    private ArrayList<Integer> nombreCharDerivation;
    private int comptCoul = 0;  //Compteur pour changer la couleur des derivations
    private int nbDeriv = 0;  //Nombre des derivations differentes 
    private Logo l = new Logo(350, 200, 90, Color.BLACK, Logo.PEN_DOWN, 20);

    public LSystem(String ax) {
        /* definition regle derivation */
        this.nombreCharDerivation = new ArrayList();

        this.regles = new HashMap<Character, String>();

        /**
         * **definition axiome***
         */
        //this.axiome = "X+Y";
        //this.axiome = "1[-0]+0";           //Exemple 1
        //this.axiome = "X+Y-X";             //Exemple 2
        //this.axiome = "a";                 //Exemple 3
        //this.axiome = "X";                  //Exemple 4
        this.axiome = ax;       //initialisation avec un parametre

        //Stocker les differentes regles
        // Exemple de base
        this.regles.put('X', "X+Y++Y-X--XX-Y+");
        this.regles.put('Y', "-X+YY++Y+X--X-Y");
        //Exemple 1        
        this.regles.put('0', "1[-0]+0");
        this.regles.put('1', "11");

        //Exemple 2
        //this.regles.put('X', "F-[[X]+X]+F[+FX]-X");
        //this.regles.put('F', "FF");
        //Exemple de base + Exp. 1 + Exp. 2
        this.regles.put('+', "+");
        this.regles.put('-', "-");
        this.regles.put('[', "[");
        this.regles.put(']', "]");

        //Exemple 3 
        this.regles.put('a', "agaddaga");
        this.regles.put('g', "g");
        this.regles.put('d', "d");

        //Exemple 4 
        //this.regles.put('X', "X-X+X+X-X");
        //Exemple 5
        this.regles.put('F', "FF+[+F-F-F]-[-F+F+F]");

        //Exemple 6
        //this.regles.put('F', "F[+F]F[-F]F"); 
        //Exemple 7
        //this.regles.put('X' ,"+YF-XFX-FY+");
        //this.regles.put('Y' ,"-XF+YFY+FX-");
        //this.regles.put('F' ,"F");
        //Exemple 8 
        //this.regles.put('X' ,"XFYFX-F-YFXFY+F+XFYFX");
        //this.regles.put('Y' ,"YFXFY+F+XFYFX-F-YFXFY");
        this.expCourante = this.axiome;

    }

    public String derivation() {

        //Comparer la longeur de l'expression au compteur des caracteres de l'expression deja comparé
        if (this.expCourante.length() > this.comptChar) {

            this.nouvelleExp += this.regles.get(this.expCourante.charAt(this.comptChar));
            this.comptChar++;  //apres change comparaison on augmente le compteur

            this.derivation();   //on lance la recursivite

        } else {
            //Mettre la derivation dans l'expression courante
            this.expCourante = this.nouvelleExp;
            System.out.println(this.expCourante);       //affichage de l'expression courante
            this.nombreCharDerivation.add(this.comptChar);

            this.comptChar = 0;     //remettre la valeur de comptChar a 0 a la fin complete de la derivation pour pourvoir refaire des derivations
            this.nouvelleExp = ""; // remettre l'expression a "" pour pouvoir refaire des interpretations

        }

        return this.expCourante;

    }

    public void resetExp() {
        this.expCourante = this.axiome;
    }

    public void interpretation() {
        // lire l'expression et interpreter les symboles...

        //Comparer la longeur de l'expression au compteur des caracteres de l'expression deja comparé
        if (this.expCourante.length() > this.comptExp) {
            switch (this.expCourante.charAt(this.comptExp)) {   //prendre le caractere a la position du compteur
                // EXEMPLE 2
                /*
                case 'X':
                    l.av();
                    break;
                case 'Y':
                    l.av();
                    break;
                 */

                case '+':
                    l.rotG(alea(20, 30));
                    break;
                case '-':
                    l.rotD(alea(20, 30));
                    break;

                // EXEMPLE 1+2
                case '[':
                    l.memo();
                    break;
                case ']':
                    l.recupMemo();
                    break;

                /* EXEMPLE 1
                case '0':
                    l.av();
                    break;
                case '1':
                    l.av();
                    break;
                 */
 /* 
                case '+':
                    l.rotG(90);
                    break;
                case '-':
                    l.rotD(90);
                    break;
                 */
                //Exemple 3 
                case 'a':
                    l.av();
                    break;
                case 'g':
                    l.rotD(-60);
                    break;
                case 'd':
                    l.rotG(-60);
                    break;

                //Exemple 4 
                /*case '+':
                    l.rotG(90);
                    break;
                case '-':
                    l.rotD(90);
                    break;
                 */
                //Exemple 5 + 6
                case 'F':
                    l.av();
                    break;

                //Exemple 7
                case '|':
                    l.rotD(180);
                    break;
                case 'X':
                    l.av();
                    break;
                case 'Y':
                    l.av();
                    break;

            }

            this.comptExp++; //augmenter le compteur des caracteres de l'expression deja traité
            this.comptCoul++;

            //Changer la couleur pour chaque derivations
            if (this.nbDeriv < this.nombreCharDerivation.size()) {
                if (comptCoul == this.nombreCharDerivation.get(nbDeriv)) {
                    l.setCouleurAlea(new Color((int) (Math.random() * 0x1000000))); //mettre une couleur aleatoire
                    this.nbDeriv++; //pour savoir sur quelle derivation on se trouve
                    this.comptCoul = 0; //remettre le compteur a 0 pour traiter les derivations suivantes
                }
            }
        

        this.interpretation(); //on lance la recursivite

    }

    
        else {
            //remettre la valeur de comptExp a 0 a la fin complete de l'interpretation pour pourvoir refaire des interpretations
            this.comptExp = 0;
    }
}

public int alea(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }

}
// Fractal
// axiome :"X"
// 'X'->"X+Y++Y-X--XX-Y+"
// 'Y'->"-X+YY++Y+X--X-Y"

// Plante
//  axiome ="X"
//  'X'->"F-[[X]+X]+F[+FX]-X"
//  'F'->"FF"
// Arbre
// axiome ="0"
// '0'->"1[-0]+0"
// '1'->,"11"
