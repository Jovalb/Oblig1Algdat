package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    // TODO: Fjern all slags test kode i denne filen som f.eks public static void main og alt innhold i den
    // TODO: Gjør ferdig oppgave 1 teori ang gjennomsnittspørsmålet

    public static void main(String[] args) {

        // Oppgve 1 testing
        int [] worst_case = {10,9,8,7,6,5,4,3,2,1};

        int [] best_case = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Worst Case: ");

        System.out.println(ombyttinger(worst_case));

        System.out.println(Arrays.toString(worst_case));

        System.out.println("Best Case:");

        System.out.println(ombyttinger(best_case));

        System.out.println(Arrays.toString(best_case));
        //Oppgave 1

        //Oppgave 2 testing

        int [] b = {3,3,4,5,5,6,7,7,7,8};

        System.out.println(Arrays.toString(b));
        System.out.println(antallUlikeSortert(b));

    }

    private Oblig1() {
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
