package impératif;

public class AppProgImp {
	
/////// Q1 - Nombre diviseur d'un autre 
	
/* On utilise l'opérateur de congruence pour tester le reste de la division euclidienne de nb par divider.
si le reste est nul, alors c'est un diviseur*/
    public static boolean estDiviseur (int nb, int divider) {
        if (nb % divider == 0) {
            return true;
        } else {
            return false;
        }
    }
    
/////// Q2 - Plus grand des 3 nombres
    
    public static int compareTroisNb (int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }
    
/////// Q3 - Convertir et affiche une durée donnée
    
/* on part d'une durée en secondes, si on en a plus de 3600 
alors on observe les heures sinon si on en a plus de 60 on regarde les minutes*/

    public static String conversionHms(int d) {
        int t = d;
        int h = 0;
        int m = 0;
        int s = 0;
    
        if (t>3600) {
            h = (t - t % 3600) / 3600; // h prends la valeur du nombre d'heure dans la durée.
            t = t - h * 3600; // on enleve ces heures après les avoir converti en secondes
        }
        if (t>60) {
            m = (t - t % 60) / 60; // m prend la valeur du nombre de minutes restant
            t = t - m * 60; // on enleve ces minutes après les avoir converti en secondes
        }
        s = t; // t restant correspond aux secondes restantes
        return String.valueOf(d)+
            " vaut " + String.valueOf(h)+
            ":" + String.valueOf(m) + 
            ":" + String.valueOf(s);
    }

/////// Q4 - Salaire employé en fonction du grade et de l'ancienneté (If)
    
/* on utilise des if imbriqués pour tester les conditions pour chaque cas de g on teste tous les cas de a*/

    public static int calculSalaire1 (String g, Integer a) { 
    	int i = 0;
    	if (g=="C") { 
    		if (a == 1) { 
    			i = 15; 
    		} else if (a == 2) {
    			i= 17; 
    		} else {
    		    i= 19;
    		} 
    	} else if (g == "I") {
    		if (a == 1) {
    			i= 23;
    		} else if (a == 2) {
    			i= 25; 
    		} else {
    			i=27; 
    		}
    	} else {
            if (a == 1) {
    			i = 35; 
        	} else if (a == 2) {
        		i= 40; 
        	} else {
        		i= 45; 
            }
    	}
    return i*125; 		
    }
    
/////// Q5 - Salaire employé en fonction du grade et de l'ancienneté (Switch)
    
/* de la même manière avec un menu switch */

    public static int calculSalaire2 (String g, Integer a) {
    	int i = 0; 
    	switch (g) {
	    	case "Concepteur":
	        switch (a) {
	            case 1:
	                i = 15;
	                break;
	            case 2:
	                i = 17;
	                break;
	            case 3:
                    i = 19;
                default:
                    break;
	        }
    	}
        switch (g) {
	    	case "Ingénieur" :
	    	switch (a) {
	            case 1:
	                i = 125;
	                break;
	            case 2:
	                i = 27;
	                break;
	            case 3:
	                i = 29;
	            default:
	                break;
	        }
         }
	     switch (g) {	 
	        case "Sénior": 
	        switch (a) {
	            case 1:
	                i = 35;
	                break;
	            case 2:
	                i = 40;
	                break;
	            case 3:
	                i = 45;
	            default:
	                break;
	            }
            }
    return i*125; 
}  
    /////// mélange de if et switch
    /* public static int calculSalaire3(String g, Integer a) {  
        int i = 0;
        if (g == "C") {
            switch (a) {
                case 1:
                    i = 15;
                    break;
                case 2:
                    i = 17;
                    break;
                case 3:
                    i = 19;
                default:
                    break;
            }
        } else if (g == "I") {
            switch (a) {
                case 1:
                    i = 125;
                    break;
                case 2:
                    i = 27;
                    break;
                case 3:
                    i = 29;
                default:
                    break;
            }
        } else {
            switch (a) {
                case 1:
                    i = 35;
                    break;
                case 2:
                    i = 40;
                    break;
                case 3:
                    i = 45;
                default:
                    break;
            }
        }
        return i*125;
    } */
    
/////// Q6 - Nombres pairs 
    
    public static String sommePairs (int début, int fin) {
        int d = début;
        int f = fin;
        int i = 0;
        int sumFor = 0; // correspondra à la boucle for
        int sumWhile = 0; // correspondra à la boucle while
        int sumDoWhile = 0; // correspondra à la boucle Do while
    
        if (début > fin) {
            d = début; // on s'assure que d correspond à la plus petite valeur (robustesse)
            f = fin;
        }
        ///////////// FOR
        if (d % 2 == 0) {
           for (i = d; i <= f; i += 2) {
                sumFor += i;
            }
        } else {
            for (i = d + 1; i <= f; i += 2) {
                sumFor += i;
            }
        }
        ////////////// WHILE
        if (d % 2 == 0) {
            i = d;
        } else {
            i = d+1;
        }
        while (i <= f) {
            if (i % 2 == 0) {
                sumWhile += i;
            }
            i += 2;
        } 
        /////////////// Do While
        if (d % 2 == 0) {
            i = d;
        } else {
            i = d+1;
        }
        do {if (i % 2 == 0) {
                sumDoWhile += i;
                i+=2;
            }
        } while (i <= f);
        
        return "For :\n "+String.valueOf(sumFor)+
        " \nWhile :\n "+String.valueOf(sumWhile)+
        " \nWhile ... Do :\n "+String.valueOf(sumDoWhile);
    }
    
/////// Q7 - Permet de déterminer la validité d'un nombre au sens de l'algorithme de Luhn
    
    public static boolean cbValid (int arr[]) {
        boolean estValide = false;
        int sum = 0;
        int tab[] = arr;
        
        /* première boucle for on parcour de l'avant dernière valeur du tableau en incrémentant de moins deux 
        pour ne multiplier par deux qu'un nombre sur deux */
        for (int i = arr.length - 2; i >= 0; i-=2) {
            tab[i] *= 2;
            if (tab[i] > 9) {
                tab[i] -= 9;
            }
            sum += tab[i];
        }
        /* deuxième boucle for pour sommer tous les chiffres restants */
        for (int i = arr.length - 1; i >= 0; i-=2) {
            sum += tab[i];
        }
        // on regarde si la somme est divisible par 10
        if (sum % 10 == 0) {
            estValide = true;
        }
        return estValide;
    }
    
/////// Q8 - Nombre parfait 
    
    public static String nbParfaits (int début, int fin) {
    	int d = début;
        int f = fin;
        int dividerSum = 0;
        String s = "";
    
        if (début > fin) { /*comme dans la fonction précédente, on s'assure que d correspond à la plus petite valeur*/
            d = fin;
            f = début;
        }
        // boucles for imbriuées pour tester tous les diviseurs potentiels j d'un nombre i
        for (int i = d; i <= f; i++) {
        	dividerSum = 0; 
            /* on initialise la somme à chaque itération de la première boucle pour ne pas fausser les sommes des 
            diviseurs de i avec des valeurs stockées à l'itération précédente*/
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) { // si j divise i alors on l'ajoute à la somme des diviseurs
                    dividerSum += j;
                }
            }
            if (i == dividerSum / 2) { // si la moitié de la somme des diviseurs de i est égale à i on a un nombre parfait
            	s += String.valueOf(i) + " "; // on l'ajoute dans la chaîne que l'on va retourner
            }
        }
        if (f < 6) {// condition ppour retourner une string sensée si f<6;
            return "il n'existe pas de nombres parfaits inférieur à 6"; 
        } else if (s == "") { // si il n'y a pas de nombres parfaits compris dans l'intervalle (<=> s == "")
            return "il n'y a pas de nombres parfaits dans cet intervalle";
        } else {// si il y abien des nombres parfaits dans l'ensemble
            return s +"sont les nombres parfaits compris entre " + String.valueOf(d) + " et " + String.valueOf(f);
        }
    }
    
/////// Q9 - Situation candidat à une élection 
    
    public static String election (double tab[]) {
        String res = ""; // résultat
        double pgv = 0;   // pgv= plus grande valeur 
            
        for (int i = 0; i < 4; i ++) {
            if (tab[i] > pgv) {
                pgv = tab[i]; // on détermine la plus grande valeur dans le tableau
            }
        }
        if (tab[0] > 0.5) { // si le candidat à plus de 50% des voix, il est élu
            res = "Le premier candidat est élu";
        }  else if (tab[0] > 0.125 && pgv <= 0.5) { // si le candidat à plus de 12.5 % et qu'aucun autre candidat à la majorité, second tour
            res = "Le premier candidat passe au second tour";
            if (tab[0] == pgv) {
                res += " en ballotage favorable"; // Si il est au second tour avec le plus de voix
            } else {
                res += " en ballotage défavorable"; // si il est au second tour sans avoir le plus de voix
            }
        } else if (pgv > 0.5 && tab[0] < 0.5 || tab[0] < 0.125) { 
            /* si la plus grande valeur est >50% et le candidat ne 
            les a pas ou si le candidat n'a pas obtenu plus de 12.5% */
            res = "Le candidat est éliminé"; 
        }
        return res += " avec " + String.valueOf(tab[0] * 100) + "% des voix";
    }

     public static void main (String[] args) {
///////Zone de test
    	 
/////// Q1
    	 System.out.println("\nQuestion 1 :\n");
         System.out.println(estDiviseur(16, 2));
         
/////// Q2
    	 System.out.println("\nQuestion 2 :\n");
         System.out.println(compareTroisNb(3, 16, 9));
         
/////// Q3
    	 System.out.println("\nQuestion 3 :\n");
         System.out.println(conversionHms(16788675));
         
/////// Q4 // le résultat est le même que Q5
    	 System.out.println("\nQuestion 4 :\n");
    	 System.out.println(calculSalaire1("C", 2));
    	 
/////// Q5 // le résultat est le même que Q4
    	 System.out.println("\nQuestion 5 :\n");
         System.out.println(calculSalaire2("Concepteur",2));
         
/////// Q6 // on affiche les trois sommes ce qui permet de les comparer
    	 System.out.println("\nQuestion 6 :\n");
         System.out.println(sommePairs(1, 25));
         
/////// Q7
         int[] tab = {1, 5, 1}; 
    	 System.out.println("\nQuestion 7 :\n");
         System.out.println(cbValid(tab));
         
/////// Q8 // les test montrent que la suite correspond
    	 System.out.println("\nQuestion 8 :\n");
         System.out.println(nbParfaits(1,30));
         System.out.println(nbParfaits(1,290));
         System.out.println(nbParfaits(1,20000));
         System.out.println(nbParfaits(0,3));
         System.out.println(nbParfaits(7,17));         
         
/////// Q9 On teste tous les cas possible avec le cas ou le candidat atteint 50% pile des voix
         double tab2[] = {0.5,0.1,0.3,0.1};
         double tab3[] = {0.1,0.2,0.4,0.3};
         double tab4[] = {0.6,0.2,0.1,0.1};
         double tab5[] = {0.129,0.071,0.4,0.4};
         double tab6[] = {0.3,0.6,0.05,0.05};
    	 System.out.println("\nQuestion 9 :\n");
         System.out.println(election(tab2));
         System.out.println(election(tab3));
         System.out.println(election(tab4));
         System.out.println(election(tab5));
         System.out.println(election(tab6));
    }
}