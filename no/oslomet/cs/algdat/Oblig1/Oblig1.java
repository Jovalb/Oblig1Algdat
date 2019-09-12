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
        int[] worst_case = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int[] best_case = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Worst Case: ");

        System.out.println(ombyttinger(worst_case));

        System.out.println(Arrays.toString(worst_case));

        System.out.println("Best Case:");

        System.out.println(ombyttinger(best_case));

        System.out.println(Arrays.toString(best_case));

        System.out.println("Average Case ut av 10 forskjellige arrays med 5 tall: ");

        System.out.println("Stokker om 10 arrays med tall fra 1 til 10...");

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];
        int[] arr4 = new int[10];
        int[] arr5 = new int[10];
        int[] arr6 = new int[10];
        int[] arr7 = new int[10];
        int[] arr8 = new int[10];
        int[] arr9 = new int[10];
        int[] arr10 = new int[10];

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


        System.out.println("Array nummer 1: " + Arrays.toString(arr1));
        System.out.println("Array nummer 2: " + Arrays.toString(arr2));
        System.out.println("Array nummer 3: " + Arrays.toString(arr3));
        System.out.println("Array nummer 4: " + Arrays.toString(arr4));
        System.out.println("Array nummer 5: " + Arrays.toString(arr5));
        System.out.println("Array nummer 6: " + Arrays.toString(arr6));
        System.out.println("Array nummer 7: " + Arrays.toString(arr7));
        System.out.println("Array nummer 8: " + Arrays.toString(arr8));
        System.out.println("Array nummer 9: " + Arrays.toString(arr9));
        System.out.println("Array nummer 10: " + Arrays.toString(arr10));

        System.out.println("Utfører ombytting på alle tabellene...");
        double antallArrays = 10;
        double sumAvOmbytter = ombyttinger(arr1) + ombyttinger(arr2) + ombyttinger(arr3)
                + ombyttinger(arr4) + ombyttinger(arr5) + ombyttinger(arr6) + ombyttinger(arr7)
                + ombyttinger(arr8) + ombyttinger(arr9) + ombyttinger(arr10);
        double gjennomsnitt = sumAvOmbytter / antallArrays;

        System.out.println("Alle ombytter lagt sammen = " + sumAvOmbytter);
        System.out.println("Gjennomsnitt ombytter av 10 forskjellige arrays med tall fra 1 til 10 = " + gjennomsnitt);


        //Oppgave 1

        //Oppgave 2 testing

        System.out.println("Oppgave 2 testing: ");
        System.out.println("Sortert array: ");

        int[] b = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};

        System.out.println(Arrays.toString(b));
        System.out.println(antallUlikeSortert(b));

        //Oppgave 2

        //Oppgave 3 testing

        System.out.println("Oppgave 3 testing: ");
        System.out.println("Usortert array : ");

        int[] c = {1, 2, 2, 2, 2, 2, 3};

        System.out.println(Arrays.toString(c));
        if (antallUlikeUsortert(c) != 3) System.out.println("Test");

        //Oppgave 4 testing
        System.out.println("Oppgave 4 testing: ");

        int[] d = {5, 3, 9, 1};
        // randPerm(d);

        System.out.println("Før delsortering: ");
        System.out.println(Arrays.toString(d));
        System.out.println("Etter delsortering: ");
        delsortering(d);
        System.out.println(Arrays.toString(d));

        //Oppgave 5 testing
        System.out.println("Oppgave 6 testing: ");

        char[] e = {'A', 'B', 'C', 'D', 'E', 'F'};
        System.out.println("k = 1");
        System.out.println("Før: " + Arrays.toString(e));
        rotasjon(e, 1);
        System.out.println("Etter: " + Arrays.toString(e));

        char[] f = {'A', 'B', 'C', 'D', 'E', 'F'};
        System.out.println("k = -1");
        System.out.println("Før: " + Arrays.toString(f));
        rotasjon(f, -5);
        System.out.println("Etter: " + Arrays.toString(f));

        // Oppgave 7 testing
        System.out.println("Oppgave 7 testing: ");

        String x = "",y = "DEFGH";
        System.out.println(flett(x,y));

    }

    private Oblig1() {
    }

    // TODO: Fjern randPerm() når testing er ferdig
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        Arrays.setAll(a, i -> i + 1); // Putter inn tall fra 1 til n i array

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    ///// Oppgave 1 //////////////////////////////////////

    /**
     * @param a
     * @return Svar på teoretisk spørsmål i oppgaven:
     * 1:   Det blir flest ombyttinger hvis tabellen er revers sortert
     * 2:   Det vil bli mindre ombytter om det største tallet ligger bakerst
     * men det vil være ingen ombyttinger hvis tabellen er sortert.
     * 3:   Hvis vi lager tilfeldig tabeller og kjører ombytting på den vil vi kunne
     * få gjennomsnittet om vi legger sammen alle ombyttingene og deler det på antall forsøk.
     * Etter å ha testet med 10 arrays med 10 tall fra 1 til 10 har jeg kommet frem til
     * at det er gjennomsnittlig 7 ombytter ut av 10 tilfeldig permuterte arrays.
     * Hvis vi skal bruke O notasjon vil den utføre byttet
     */
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen du har oppgitt er tom!");
        }

        int maksVerdiPosisjon = 0;

        for (int i = 1; i < a.length; i++) {
            //Sammenligner nåværende tall med maksverditallet
            if (a[i] > a[maksVerdiPosisjon]) {
                maksVerdiPosisjon = i;
                // Hvis nåværende maksverdi er større enn nåværende tall i loop
                // Så vil den bytte om
            } else if (a[maksVerdiPosisjon] > a[i]) {
                int temp = a[i];
                a[i] = a[maksVerdiPosisjon];
                a[maksVerdiPosisjon] = temp;
                maksVerdiPosisjon = i;
            }
        }

        return a[maksVerdiPosisjon];
    }

    public static int ombyttinger(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen du har oppgitt er tom!");
        }

        int maksVerdiPosisjon = 0;
        int antallOmbyttinger = 0;

        for (int i = 1; i < a.length; i++) {
            //Sammenligner nåværende tall med maksverditallet
            if (a[i] > a[maksVerdiPosisjon]) {
                maksVerdiPosisjon = i;
                // Hvis nåværende maksverdi er større enn nåværende tall i loop
                // Så vil den bytte om
            } else if (a[maksVerdiPosisjon] > a[i]) {
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

    //Fullført oppgave 2
    public static int antallUlikeSortert(int[] a) {
        //Her må vi starte telleren på en da det er minst ett tall som er unikt
        int antallUlike = 1;

        if (a.length == 0) {
            return 0;
        }

        for (int i = 0; i < a.length - 1; i++) {
            //Her så sjekker vi om første tallet i array enten er mindre eller lik tallet etter
            //Hvis det første ikke er mindre eller lik det andre tallet er ikke taballen sortert stigende
            if (!(a[i] <= a[i + 1])) {
                throw new IllegalStateException("Tabellen du har oppgitt er ikke sortert stigende!");
            } else if (a[i] != a[i + 1]) {
                antallUlike++;
            }
        }
        return antallUlike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    //Fullført oppgave 3
    public static int antallUlikeUsortert(int[] a) {

        int antallUlike = 1;
        int j = 0;

        if (a.length == 0) {
            return 0;
        }
        //Her har vi hovedloopen som vil lese gjennom alle tallene i tabellen
        //Variablen i vil øke når vi finner et likt tall eller at alle tall som er sjekket før er ulikt
        for (int i = 1; i < a.length; i++) {
            //Her bruker vi en ny for-loop som vil sammenligne alle tall som kommer før posisjon "i"
            for (j = 0; j < i; j++)
                //Her sjekker vi om vi får samme verdi, isåfall hopper vi ut av loopen og går til neste tall
                if (a[i] == a[j])
                    break;

            //Her vil vi hoppe ut av loopen og øke antallUlike hvis i treffer j
            if (i == j)
                antallUlike++;
        }
        return antallUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    // TODO: LØST OPPGAVEN VIA MERGESORT

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void merge(int arr[], int v, int m, int h) {
        // Finne størrelser av subarray
        int n1 = m - v + 1;
        int n2 = h - m;

        // Her lager vi de miderltidige arrayene for oddetall på venstre og partall på høyre
        int V[] = new int[n1];
        int H[] = new int[n2];

        // Kopierer tall fra original array inn i subarrays
        for (int i = 0; i < n1; ++i)
            V[i] = arr[v + i];
        for (int j = 0; j < n2; ++j)
            H[j] = arr[m + 1 + j];


        // Her merger vi subarrayaen så de kommer tilbake i original arrayet

        // Her setter vi opp initialindeksene for subarray 1 og 2
        int i = 0, j = 0;

        // Her setter vi opp initialindeksen for arrayet vi skal merge sammen
        int k = v;
        while (i < n1 && j < n2) {
            if (V[i] <= H[j]) {
                arr[k] = V[i];
                i++;
            } else {
                arr[k] = H[j];
                j++;
            }
            k++;
        }

        // Kopierer resten av tallene i venstrearrayet hvis det er noen tall igjen
        while (i < n1) {
            arr[k] = V[i];
            i++;
            k++;
        }

        // Kopierer resten av tallene i høyrearrayet hvis det er noen tall igjen
        while (j < n2) {
            arr[k] = H[j];
            j++;
            k++;
        }
    }

    // Hoved funksjon som sorterer arrayet vil være merge metoden
    static void sort(int arr[], int v, int h) {
        if (v < h) {
            // Finner midtpunktet
            int m = (v + h) / 2;

            // Sorterer første halvdel, og andre halvdel av arrayet
            sort(arr, v, m);
            sort(arr, m + 1, h);

            // Merger de sorterte arrayene
            merge(arr, v, m, h);
        }
    }


    public static void delsortering(int[] a) {
        int h = a.length - 1;
        int v = 0;
        int odd = 0;
        int par = 0;

        if (a.length == 0) {
            return;
        } else if (a.length == 1) {
            return;
        }


        //Har laget en metode som putter alle partall på høyre og oddetall på venstre
        while (v < h) {
            if (a[v] % 2 != 0 && v < h) {
                v++;
                odd++;
            } else if (a[h] % 2 == 0 && v < h) {
                h--;
                par++;
            } else if (v < h) {
                int temp = a[h];
                a[h] = a[v];
                a[v] = temp;
                v++;
                h--;
            }
        }

        if (v == 0 || h == 0) {
            sort(a, 0, a.length - 1);
            return;
        }

        while (a[h] % 2 != 0 && h < a.length - 1) {
            h++;
            // Hvis tallet er partall flytter vi venstreindeksen ned et hakk
        }
        while (a[v] % 2 == 0 && v > 0) {
            v--;
        }

        sort(a, 0, v);
        sort(a, h, a.length - 1);

        /*
        //if tester som sjekker om indeksene v og h stemmer
        if (v == 0 && h == 0){
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (a[j] < a[min_idx])
                        min_idx = j;

                // Swap the found minimum element with the first
                // element
                int temp = a[min_idx];
                a[min_idx] = a[i];
                a[i] = temp;
            }
        } else if (v > h){
            h++;
        }

        //if test som sjekker om variabelen hvor indeksene har truffet er partall eller oddetall
        //Hvis tallet er oddetall inkrementerer vi høyreindeksen
        if (a[h] % 2 != 0){
            h++;
        // Hvis tallet er partall flytter vi venstreindeksen ned et hakk
        } else if (a[v] % 2 == 0){
            v--;
        }

        //selection sort som sorterer partallene på høyresiden
        for (int i = h; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }

        //Selection sort som sorterer oddetallene på venstresiden
        for (int i = 0; i <= v; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j <= v; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }*/

    }

    ///// Oppgave 5 //////////////////////////////////////
    //Fullført via bubble sort metode
    public static void rotasjon(char[] a) {
        //Sjekker om det er 0 eller 1 element
        if (a.length == 0 || a.length == 1) {
            return;
        }

        //Utfører rotasjon én gang
        for (int i = 0; i < 1; i++) {
            for (int j = a.length - 1; j > 0; j--) {
                char temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }

    }

    ///// Oppgave 6 //////////////////////////////////////
    // FULLFØRT
    public static int gcd(int a, int b)  // Euklids algoritme
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n < 2) return;         // ingen rotasjon
        if ((k %= n) < 0) k += n;                     // motsatt vei?

        int s = gcd(n, k);                            // største felles divisor

        for (int e = 0; e < s; e++)                   // antall sykler
        {
            char verdi = a[e];                          // hjelpevariabel

            for (int i = e - k, j = e; i != e; i -= k)  // løkke
            {
                if (i < 0) i += n;                        // sjekker fortegnet til i
                a[j] = a[i];
                j = i;                       // kopierer og oppdaterer j
            }

            a[e + k] = verdi;                           // legger tilbake verdien
        }

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] c = new char[s.toCharArray().length + t.toCharArray().length];  // en tabell av rett størrelse
        int i = 0, j = 0, k = 0;                 // løkkevariabler

        while (i < s.toCharArray().length && j < t.toCharArray().length)
        {
            c[k++] = s.toCharArray()[i++];      // først en verdi fra s
            c[k++] = t.toCharArray()[j++];      // så en verdi fra t
        }
        // vi må ta med resten
        while (i < s.toCharArray().length) c[k++] = s.toCharArray()[i++];
        while (j < t.toCharArray().length) c[k++] = t.toCharArray()[j++];

        String d = new String(c);

        return d;
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
