package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import java.util.NoSuchElementException;

public class Oblig1 {


    private Oblig1() {
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
     * Her har jeg funnet ut at gjennomsnittlig antall ombyttinger vil bli n-h(n), altså
     * n minus det harmoniske tallet.
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
    static void mergeSort(int arr[], int v, int h) {
        if (v < h) {
            // Finner midtpunktet
            int m = (v + h) / 2;

            // Sorterer første halvdel, og andre halvdel av arrayet
            mergeSort(arr, v, m);
            mergeSort(arr, m + 1, h);

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
            mergeSort(a, 0, a.length - 1);
            return;
        }

        while (a[h] % 2 != 0 && h < a.length - 1) {
            h++;
            // Hvis tallet er partall flytter vi venstreindeksen ned et hakk
        }
        while (a[v] % 2 == 0 && v > 0) {
            v--;
        }

        mergeSort(a, 0, v);
        mergeSort(a, h, a.length - 1);

    }

    ///// Oppgave 5 //////////////////////////////////////
    //Fullført
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
        // Her har jeg brukt teknikken hvor vi bruker "toCharArray" i String klassen
        char[] c = new char[s.toCharArray().length + t.toCharArray().length];  // en tabell av rett størrelse
        int i = 0, j = 0, k = 0;                 // løkkevariabler

        while (i < s.toCharArray().length && j < t.toCharArray().length) {
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

        //hjelpevariabel som vil inneholde antall bokstaver i alle strengene sammenlagt og en teller "k" for chararray
        int antallChar = 0;
        int k = 0;

        for (String s1 : s) {
            antallChar += s1.length();
        }

        char[] a = new char[antallChar];


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < s.length; j++) {

                while (i >= s[j].length()) {
                    if (j < s.length - 1) {
                        j++;
                    } else {
                        break;
                    }
                }

                if (s[j].length() - 1 < i) {
                    break;
                }

                a[k++] = s[j].charAt(i);

            }

        }

        String b = new String(a);
        return b;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively quickSort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int[] indekssortering(int[] a) {
        int n = a.length;

        int[] index = new int[n];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        int[] sortertArray = new int[n];

        for (int i = 0; i < sortertArray.length; i++) {
            sortertArray[i] = a[i];
        }

        if (sortertArray.length == 1) {
            return index;
        }

        quickSort(sortertArray, 0, sortertArray.length - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] == sortertArray[i]) {
                    index[i] = j;
                }
            }

        }

        return index;

    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Tabellen du har lagt inn har færre enn 3 elementer!");
        }
        int min1Idx = 0;
        int min2Idx = 1;
        int min3Idx = 2;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min1) {
                min3 = min2;
                min3Idx = min2Idx;
                min2 = min1;
                min2Idx = min1Idx;
                min1 = a[i];
                min1Idx = i;
            } else if (a[i] < min2) {
                min3 = min2;
                min3Idx = min2Idx;
                min2 = a[i];
                min2Idx = i;
            } else if (a[i] < min3) {
                min3 = a[i];
                min3Idx = i;
            }
        }

        int[] resultat = {min1Idx, min2Idx, min3Idx};


        return resultat;


    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static void quickSortChar(char arr[], int v, int h) {
        int i = v;
        int j = h;
        char tmp;

        int pivot = (v + h) / 2;

        while (i <= j) {
            while (arr[i] < arr[pivot]) {
                i++;
            }
            while (arr[j] > arr[pivot]) {
                j--;
            }

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        if (v < j) {
            quickSortChar(arr, v, j);
        }
        if (i < h) {
            quickSortChar(arr, i, h);
        }
    }


    public static boolean inneholdt(String a, String b) {
        if (a.length() < 1) {
            return true;
        }
        char[] input = a.toCharArray();
        char[] mainString = b.toCharArray();

        quickSortChar(input, 0, input.length - 1);
        quickSortChar(mainString, 0, mainString.length - 1);

        int j = 0;

        for (int i = 0; i < mainString.length && j < input.length; i++) {
            if (mainString[i] == input[j]) {
                j++;
            }
        }

        if (j == input.length) {
            return true;
        } else {
            return false;
        }

    }

}  // Oblig1
