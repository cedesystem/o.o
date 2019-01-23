import java.util.Scanner;
public class Podziel_N_M {
    public static void main(String args[]) {
        Scanner DANE = new Scanner(System.in);
        int i=0,j = 0,d=0,r=0,s, k = 1,l=1, liczn, liczm;
        int n[] = new int[]; // tablica do obsługi liczby N
        int nt[]= new int[]; // tablica z ponumerowanymi rosnąco kolejnymi podzielnikami liczby N
        int m[] = new int[];// tablica do obsługi liczby M
        int mt[]= new int[]; // tablica z  ponumerowanymi rosnąco kolejnymi podzielnikami liczby M
        int wsp[]= new int[];//tablica do zapisania wspólnych podzielników liczb N i M
        int ws; // zmienna do zamiany miejscami w tablicy wsp - wybranie największego wsp.podziel.
        int u,w;// liczba podzielników odpowiednio dla N i M
        int b;//liczba kroków rozwiązań
        System.out.println("Podaj ilość powtórzeń obliczeń");
        b=DANE.nextInt();
       for(s=1;s<=b;s++) {
           System.out.println("Podaj liczbę N i M");
           liczn = DANE.nextInt();
           liczm = DANE.nextInt();

           do {i++;}
           while (liczn / Math.pow(10, i) > 1);
           k = i;
           System.out.println(k);        //licznik k ilu cyfrowa jest liczba N
           for (i = 0; i < k; i++) {
               n[i] = (int) (r / Math.pow(10, k - i - 1));
               r = r - (int) (n[i] * (Math.pow(10, k - i - 1)));
               System.out.print("n[" + i + "]= " + n[i] + ";");
               System.out.println();
           }
           i = 0; //obliczenie n[i]
           do {
               i++;
           } while ((liczm / Math.pow(10, i)) > 1);
           l = i;
           System.out.println(l);        //licznik l ilu cyfrowa jest liczba m
           for (i = 0; i < l; i++) {
               m[i] = (int) (d / Math.pow(10, l - i - 1));
               d = d - (int) (m[i] * (Math.pow(10, l - i - 1)));
               //System.out.print("m[" + i + "]= " + m[i] + ";"); //obliczenie m[i]
           }
           System.out.println("Podaje k=" + k + "; Podaje l=" + l);
           w = 0;
           u = 0;// w i u liczniki kolejnych podzielników
           for (i = 2; i <= liczn; i++) {
               r = liczn / i;
               if (r * i == liczn) {
                   n[i] = i;
                   u = u + 1;
                   n[u] = n[i];
               }
           }
           for (i = 1; i <= u; i++) {
               System.out.print("n[" + i + "]= " + n[i] + "; ");
           }
           System.out.println("\nTeraz m");
           for (i = 2; i <= liczm; i++) {
               d = liczm / i;
               if (d * i == liczm) {
                   m[i] = i;
                   w = w + 1;
                   m[w] = m[i];


                   System.out.println();
                   for (i = 1; i <= w; i++) {
                       System.out.print("m[" + i + "]= " + m[i] + "; ");
                   }
                   System.out.println();
                   //porównie podzielników
                   System.out.println("Liczby u i w  " + u + "//" + w);
                   for (i = 1; i <= w; i++) {
                       for (j = 1; j <= w; j++) {
                           if (n[i] == m[j]) {
                               wsp[i] = m[j];
                           } else {
                           }
                       }

                   }
                   for (i = 1; i <= w; i++) {
                       System.out.print("wsp[" + i + "]= " + wsp[i] + "; ");
                   }
                   System.out.println();
                   System.out.println("Największy wspólny podzielnik wsp, liczb N i M wynosi wsp =" + wsp[i]);
                   if (n[i] > n[i + 1]) {
                       ws = n[i];
                       n[i] = n[i + 1];
                       n[i] = ws;
                   }
               }
           }
       }
    }
}
