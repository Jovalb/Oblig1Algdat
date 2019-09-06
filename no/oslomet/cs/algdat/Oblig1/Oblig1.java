package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {

    // TODO: Fjern all slags test kode i denne filen som f.eks public static void main og alt innhold i den
    // TODO: Gjør ferdig oppgave 1 teori ang gjennomsnittspørsmålet

    public static void main(String[] args) {

        // Oppgve 1 testing
        System.out.println("Oppgave 1 testing: ");
        int [] worst_case = {10,9,8,7,6,5,4,3,2,1};

        int [] best_case = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Worst Case: ");

        System.out.println(ombyttinger(worst_case));

        System.out.println(Arrays.toString(worst_case));

        System.out.println("Best Case:");

        System.out.println(ombyttinger(best_case));

        System.out.println(Arrays.toString(best_case));

        System.out.println("Average Case ut av 10 forskjellige arrays med 5 tall: ");

        System.out.println("Stokker om 10 arrays med tall fra 1 til 10...");

        int [] arr1 = new int [10];
        int [] arr2 = new int [10];
        int [] arr3 = new int [10];
        int [] arr4 = new int [10];
        int [] arr5 = new int [10];
        int [] arr6 = new int [10];
        int [] arr7 = new int [10];
        int [] arr8 = new int [10];
        int [] arr9 = new int [10];
        int [] arr10 = new int [10];

        randPerm(arr1);
        randPerm(arr2);
        randPerm(arr3);
        randPerm(arr4);
        randPerm(arr5);
        randPerm(arr6);
        randPerm(arr7);
        randPerm(arr8);
        randPerm(arr9);
        randPerm(arr10);


        System.out.println("Array nummer 1: "+Arrays.toString(arr1));
        System.out.println("Array nummer 2: "+Arrays.toString(arr2));
        System.out.println("Array nummer 3: "+Arrays.toString(arr3));
        System.out.println("Array nummer 4: "+Arrays.toString(arr4));
        System.out.println("Array nummer 5: "+Arrays.toString(arr5));
        System.out.println("Array nummer 6: "+Arrays.toString(arr6));
        System.out.println("Array nummer 7: "+Arrays.toString(arr7));
        System.out.println("Array nummer 8: "+Arrays.toString(arr8));
        System.out.println("Array nummer 9: "+Arrays.toString(arr9));
        System.out.println("Array nummer 10: "+Arrays.toString(arr10));

        System.out.println("Utfører ombytting på alle tabellene...");
        double antallArrays = 10;
        double sumAvOmbytter = ombyttinger(arr1)+ombyttinger(arr2)+ombyttinger(arr3)
                +ombyttinger(arr4)+ombyttinger(arr5)+ombyttinger(arr6)+ombyttinger(arr7)
                +ombyttinger(arr8)+ombyttinger(arr9)+ombyttinger(arr10);
        double gjennomsnitt = sumAvOmbytter/antallArrays;

        System.out.println("Alle ombytter lagt sammen = "+sumAvOmbytter);
        System.out.println("Gjennomsnitt ombytter av 10 forskjellige arrays med tall fra 1 til 10 = "+gjennomsnitt);


        //Oppgave 1

        //Oppgave 2 testing

        System.out.println("Oppgave 2 testing: ");

        int [] b = {3,3,4,5,5,6,7,7,7,8};

        System.out.println(Arrays.toString(b));
        System.out.println(antallUlikeSortert(b));

    }

    private Oblig1() {
    }

    // TODO: Fjern randPerm() og bytt() når testing er ferdig
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        Arrays.setAll(a,i -> i+1); // Putter inn tall fra 1 til n i array

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    ///// Oppgave 1 //////////////////////////////////////

    /**
     *
     * @param a
     * @return
     *
     * Svar på teoretisk spørsmål i oppgaven:
     * 1:   Det blir flest ombyttinger hvis tabellen er revers sortert
     * 2:   Det vil bli mindre ombytter om det største tallet ligger bakerst
     *      men det vil være ingen ombyttinger hvis tabellen er sortert.
     * 3:   Hvis vi lager tilfeldig tabeller og kjører ombytting på den vil vi kunne
     *      få gjennomsnittet om vi legger sammen alle ombyttingene og deler det på antall forsøk.
     *      Etter å ha testet med 10 arrays med 10 tall fra 1 til 10 har jeg kommet frem til
     *      at det er gjennomsnittlig 7 ombytter ut av 10 tilfeldig permuterte arrays.
     *
     */
    public static int maks(int[] a) {
        if (a.length < 1){
            throw new NoSuchElementException("Tabellen du har oppgitt er tom!");
        }

        int maksVerdiPosisjon = 0;

        for (int i = 1; i < a.length; i++){
            //Sammenligner nåværende tall med maksverditallet
            if (a[i] > a[maksVerdiPosisjon]){
                maksVerdiPosisjon = i;
                // Hvis nåværende maksverdi er større enn nåværende tall i loop
                // Så vil den bytte om
            }else if (a[maksVerdiPosisjon] > a[i]){
                int temp = a[i];
                a[i] = a[maksVerdiPosisjon];
                a[maksVerdiPosisjon] = temp;
                maksVerdiPosisjon = i;
            }
        }

        return a[maksVerdiPosisjon];
    }

    public static int ombyttinger(int[] a) {
        if (a.length < 1){
            throw new NoSuchElementException("Tabellen du har oppgitt er tom!");
        }

        int maksVerdiPosisjon = 0;
        int antallOmbyttinger = 0;

        for (int i = 1; i < a.length; i++){
            //Sammenligner nåværende tall med maksverditallet
            if (a[i] > a[maksVerdiPosisjon]){
                maksVerdiPosisjon = i;
                // Hvis nåværende maksverdi er større enn nåværende tall i loop
                // Så vil den bytte om
            }else if (a[maksVerdiPosisjon] > a[i]){
                int temp = a[i];
                a[i] = a[maksVerdiPosisjon];
                //Her teller vi opp antall ombyttinger
                antallOmbyttinger++;
                a[maksVerdiPosisjon] = temp;
                maksVerdiPosisjon = i;
            }
        }
        return antallOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////

    /**
     *
     * @param a
     * @return
     *
     * Fullført oppgaven og kjørt test og den fungerer
     */
    public static int antallUlikeSortert(int[] a) {
        //Her må vi starte telleren på en da det er minst ett tall som er unikt
        int antallUlike = 1;

        if (a.length == 0){
            return 0;
        }

        for (int i = 0; i < a.length-1; i++){
            //Her så sjekker vi om første tallet i array enten er mindre eller lik tallet etter
            //Hvis det første ikke er mindre eller lik det andre tallet er ikke taballen sortert stigende
            if(!(a[i] <= a[i+1])){
                throw new IllegalStateException("Tabellen du har oppgitt er ikke sortert stigende!");
            }else if (a[i] != a[i+1]){
                antallUlike++;
            }
        }
        return antallUlike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
