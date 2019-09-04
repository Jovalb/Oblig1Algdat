package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    public static void main(String[] args) {

        int [] a = {1,2,3,4,5};

        System.out.println(ombyttinger(a));

        System.out.println(Arrays.toString(a));

    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////

    /**
     *
     * @param a
     * Svar på teoretisk spørsmål i oppgaven:
     * 1:   Det blir flest ombyttinger hvis det første tallet er større enn det andre
     *      Dette fører til at de vil bytte plass hver gang det neste tallet er større
     * 2:   Det vil bli mindre ombytter om det største tallet ligger bakerst
     *      men det vil være ingen ombyttinger hvis tabellen er sortert.
     *
     * @return
     */
    public static int maks(int[] a) {
        if (a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen du har oppgitt er tom!");
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
            throw new java.util.NoSuchElementException("Tabellen du har oppgitt er tom!");
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
    public static int antallUlikeSortert(int[] a) {
        throw new NotImplementedException();
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
