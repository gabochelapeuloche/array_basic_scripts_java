package impératif;

public class AppTableau {
    	
/////// Q 10 - Initialiser tableau 
	
    public static int[] initTab (int min, int max, int nb_elmt) {
        int arr[] = new int [nb_elmt] ; // déclare et alloue de la mémoire à un nouveau tableau
        
        for (int i=0; i<nb_elmt; i++) { 
            /* boucle for pour parcourir le tableau et affecter une valeur aléatoire (module Math, méthode random)
            en utilisant un formule pour que le résultat soit compris entre les bornes et entier*/
            arr[i]= (int) Math.floor((Math.random() * (max - min + 1)) + min);
        }
        return arr;
    }

/////// Q 11 - Tableau d'entier

    public static String affTab (int tab[]) {
        String s = "["; // on ajoute un crochet pur le rendu final
        // parcour le tableau (for loop) et ajoute chaque valeur à s.
        for (int i = 0; i < tab.length - 1; i ++) {
            s += String.valueOf(tab[i]) + ", ";
        }
        s += String.valueOf(tab[tab.length - 1]) + "]"; // pour enlever la dernière virgule 
        return s;
    }

/////// Q 12 - Copie exacte d'un tableau 

    public static int[] copyArr (int tab[]) {
        //méthode 1
        int[] copie = (int[]) tab.clone(); // pour copier un tableau
        return copie;
        
        //méthode 2
        /*
        int[] copieFor = new int [tab.length];
        for (int i = 0; i < copieFor.length; i ++) {
            copieFor[i] = tab[i]
        }
        return copieFor;
        */ 
    }

/////// Q 13 - Nombre spécifique présent dans le tableau 

    public static boolean testExistance (int tab[], int a) {
        boolean isIn = false;

        for (int i = 0; i < tab.length; i ++) {
            if (tab[i] == a) {
                isIn = true;
            }
        }
        return isIn;
    }

/////// Q 14 - Nombre d'occurences d'un nombre donné dans le tableau 

    public static int occurency (int tab[], int n) {
        int counter = 0;

        for (int i = 0; i <tab.length; i ++) {
            if (tab[i] == n) {
                counter += 1;
            }
        }
        return counter;
    }

/////// Q 15 - Plus grande valeur du tableau 

    // troisème paramètre poir sélectionner si min ou max
    public static int minMax (int tab[], int n, boolean isMax) {
        n = tab[0]; /* on initialise n avec la première valeur 
        du tableau évite de rencontrer que des valeurs plus petites ou plus grandes, permet i>0*/
        for (int i = 1; i<tab.length; i++) {
            if (isMax == true) {
                if (n < tab[i]) {
                    n = tab[i];
                }
            } else {
                if (n > tab[i]) {
                    n = tab[i];
                }
            }
        }
        return n;
    }

/////// Q 16 - Moyenne et Ecart-type 

    public static String moyenneEcartType (int tab[]) {
        // Moyenne 
        int sum = 0;
        double moyenne = 0;
        double variance = 0;
        
        for (int i = 0; i < tab.length; i++) {
            sum += tab[i];
        }
        moyenne = sum / tab.length;
        sum = 0;
        
        // Ecart-type
        for (int i = 0; i <tab.length; i++) {
            sum += Math.pow((tab[i] - moyenne), 2);
        }
        variance = sum/tab.length;
        
        return "la Moyenne du tableau est " + String.valueOf(moyenne) + " et son Ecart-type est " + String.valueOf(Math.sqrt(variance));
    }

/////// Q 17 - Test tri croissant

    public static boolean verifOrdre (int tab[]) {
        boolean bool = true;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i+1]) {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        return bool;
    }

/////// Q 18 - Tri par insertion, sélection, bulle

	public static void triInsertion (int tab[]) {
		int t; // variable pour stocker temporairement une valeur
		
		for (int i = 1; i < tab.length; i++) {
			t = tab[i]; // stocke la valeur observée
			int j = i;
			while (j > 0 && tab[j-1] > t) { // tant que j positif et valeur précédente > à valeur suivante
				tab[j] = tab[j-1];
				j = j-1;
			}
            tab[j] = t; // on inverse
		}
	}
	
	public static void triSelect(int tab[]) {
        int t;

		for (int i = 0; i<tab.length - 1; i++) {
            int min = i;
            for (int j = i+1; j<tab.length; j++) {
                if (tab[j] < tab[min]) {
                    min = j;
                }
            }
            t = tab[min];
            tab[min] = tab[i];
            tab[i] = t; // on inverse
        }
	}
	
	public static void triBulle (int tab[]) {
		int t;
        for (int i=0; i<tab.length - 1; i++) { // boucles for imbriquées pour parcourir dans deux sens
            for (int j=tab.length - 1; j>=i+1; j--) {
                if (tab[j-1] > tab[j]) {
                    t = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = t; // on inverse
                }
            }
        }
	}

/////// Q 19 - factorielle récursive et pgcd récurcif
	
	public static int factorielle (int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorielle (n-1);
		}
	}
	
	public static int pgcd (int a, int b) {
		if (a==b) {
			return a;
		} else {
			if (a>b) {
				return pgcd(a-b, b);
			} else {
				return pgcd (a, b-a);
			}
		}
	}
	
/////// Q 20 - triangle de pascal récursif
	
	public static int pascoual (int n, int p) {
		if (n >= p) {
            if (n == p || p == 1) {
                return 1;
            } else {
                return pascoual(p-1, n-1) + pascoual(p, n-1);
            }
        } else {
            return 0;
        }
	}
	
/////// Q 21 - tri fusion
	
public static void triFusion(int tab[]) { // surcharge
        if (tab.length>0) {
            triFusion(tab,0,tab.length-1);
        }
    }

    private static void triFusion(int tab[],int d,int f) {
        /*if (d < f) { // test robustesse
            int t = d;
            d = f;
            f = t;
        }*/
        if (d!=f) {// test robustesse
            int mid=(f+d)/2;
            triFusion(tab,d,mid);
            triFusion(tab,mid+1,f);
            fusion(tab,d,mid,f);
        }
    }

    private static void fusion(int tab[],int d1,int f1,int f2) {
        int d2=f1+1;
        int tab1[]=new int[f1-d1+1];//recopie les éléments du début de tab dans un nouveau tableau tab1
        int count1=d1; // counters
        int count2=d2;

        for(int i=d1;i<=f1;i++) {
            tab1[i-d1]=tab[i];
        }
        
        for(int i=d1;i<=f2;i++) {        
            if (count1==d2) {//tous les éléments de tab1 ont été utilisés
                break; //éléments classés
            } else if (count2==(f2+1)) {//tous les éléments de tab ont été utilisés
                tab[i]=tab1[count1-d1]; //ajoute les éléments restants de tab1
                count1++;
            } else if (tab1[count1-d1]<tab[count2]) {
                tab[i]=tab1[count1-d1]; //ajoute un élément de tab1
                count1++;
            } else {
                tab[i]=tab[count2]; //ajoute un élément de tab
                count2++;
            }
        }
    }
	
/////// Q 22 - test de rapidité des tris

    public static String fatsest (int itérations, int nbElt) {
        long count1 = 0; // Sommes des délais d'exécutions
        long count2 = 0;
        long count3 = 0;
        long count4 = 0;
        int i = 0;
        long t0;
        long t1;

        // on va sommer le délais d'exécution de chaque bloc en sommant les différences entre t1 et t0
        while (i < itérations) {
            int[] arr = initTab(0, 10, nbElt); //chaque tour nouveau tableau généré

            t0 = System.currentTimeMillis();// t0
            triBulle(arr);                  // exécution du tri
            t1 = System.currentTimeMillis();// t1
            count1 += (t1 - t0);            // on ajoute le temps mesuré aux précédents
            // On répete pour chaque type de tri
            t0 = System.currentTimeMillis();
            triInsertion(arr);
            t1 = System.currentTimeMillis();
            count2 += (t1 - t0);

            t0 = System.currentTimeMillis();
            triSelect(arr);
            t1 = System.currentTimeMillis();
            count3 += (t1 - t0);

            t0 = System.currentTimeMillis();
            triFusion(arr);
            t1 = System.currentTimeMillis();
            count4 += (t1 - t0);

            i++;
        }

        // on veut afficher la plus petite valeur pour déterminer le tri le plus rapide
        long arrS[] = {count1, count2, count3, count4};
        String arrSt[] = {"BULLE","INSERTION","SELECT","FUSION"};
        long ppv = arrS[0]; // pour l'affichage du résultat : plus grande valeur
        int j = 0; // pour en conserver l'indice

        for (i = 0; i < 4; i ++) {
            if (arrS[i] < ppv) {
                ppv = arrS[i];
                j = i; // on détermine la plus petite valeur dans le tableau
            }
        }

        return "Pour " + String.valueOf(itérations) + " itérations : \n" +
            "1 - Tri Bulle : " + String.valueOf(count1) +"\n"+
            "2 - Insertion : " + String.valueOf(count2) +"\n"+
            "3 - Select : " + String.valueOf(count3) +"\n"+
            "4 - Fusion : " + String.valueOf(count4) +"\n"+
            "le tri le plus rapide à donc été le tri " + arrSt[j] + " avec " + String.valueOf(ppv) + " Pour " + String.valueOf(itérations) + " itérations";
    }

public static void main (String[] args)  { 
    // Zone de Test 
    
    // Q 10 // initialise un tableau
    System.out.println("\nQuestion 10 :\n");
    System.out.println(initTab(1, 14, 10));
    
    // Q 11 // On affiche e tableau initialisé
    System.out.println("\nQuestion 11 :\n");
    System.out.println(affTab(initTab(0,32,5)));
    
    // Q 12 // on affiche le tableau et sa copie pour les comparer
    System.out.println("\nQuestion 12 :\n");
    int tab[] = initTab(1,13,12);
    System.out.println(affTab(tab));		 
    System.out.println(affTab(copyArr(tab)));
    
    // Q 13 // on affiche le tableau puis on le booleen indicant l'existance des parametres dans le tableau tab
    System.out.println("\nQuestion 13 :\n");
    System.out.println(affTab(tab));
    System.out.println(testExistance(tab, 4));
    System.out.println(testExistance(tab, 12));
    
    // Q 14 // on affiche le tableau puis le compteur correspond4nt aux occuence de n
    System.out.println("\nQuestion 14 :\n");
    System.out.println(affTab(tab));
    System.out.println(occurency(tab, 4));
    
    // Q 15 // On affiche le tableau puis son max et son min
    System.out.println("\nQuestion 15 :\n");
    System.out.println(affTab(tab));
    System.out.println(minMax(tab, 20, true));
    System.out.println(minMax(tab, 20, false));
    
    // Q 16 // On affiche tab puis moy et ecart type de tab
    System.out.println("\nQuestion 16 :\n");
    System.out.println(affTab(tab));
    System.out.println(moyenneEcartType(tab));
    
    // Q 17 // on affiche tab puis s'il est trié puis on trie tab et on reteste
    System.out.println("\nQuestion 17 :\n");
    System.out.println(affTab(tab));
    System.out.println(verifOrdre(tab));
    triInsertion(tab);
    System.out.println(affTab(tab));
    System.out.println(verifOrdre(tab));

    // Q 18 // on crée plusieurs tableaux qu'on affiche non triés puis triés
    System.out.println("\nQuestion 18 :\n");
    int arrUn[] = initTab(0, 20, 15);
    int arrDeux[] = initTab(0, 20, 15);
    int arrTrois[] = initTab(0, 20, 15);
    // tri bulle
    System.out.println("Tableau un : " + affTab(arrUn));
    triBulle(arrUn);
    System.out.println("tableau un trié avec le tri bulle : " + affTab(arrUn));
    // tri select
    System.out.println("Tableau deux : " + affTab(arrDeux));
    triSelect(arrDeux);
    System.out.println("tableau deux trié avec tri select : " + affTab(arrDeux));
    // tri insertion
    System.out.println("Tableau trois : " + affTab(arrTrois));
    triInsertion(arrTrois);
    System.out.println("Tableau trois trié avec tri insertion : " + affTab(arrTrois));

    // Q 19 // Factorielle et pgcd
    System.out.println("\nQuestion 19 :\n");
    //factorielle
    System.out.println(factorielle(1));
    System.out.println(factorielle(10));
    //pgcd
    System.out.println(pgcd(1,1));
    System.out.println(pgcd(10,80));

    // Q 20 // le triangle de pascal
    System.out.println("\nQuestion 20 :\n");
    System.out.println(pascoual(1, 1));
    System.out.println(pascoual(3, 3));
    System.out.println(pascoual(10, 3));

    // Q 21 // affiche tableau non trié puis trié 
    int arrFusion[] = initTab(0, 20, 15);
    System.out.println("\nQuestion 21 :\n");
    System.out.println(affTab(arrFusion));
    triFusion(arrFusion);
    System.out.println("Trié avec tri fusion : " + affTab(arrFusion));

    // Q 22 // affiche le résultat d'un test de rapidité
    System.out.println("\nQuestion 22 :\n");
    System.out.println(fatsest(30000, 200));
    }
}