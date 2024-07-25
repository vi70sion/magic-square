public class Main {
    public static void main(String[] args) {

//        Magiškas kvadratas
//        Parašykite programą, kuri sugeneruoja magišką kvadratą n x n dydžio (n yra nelyginis skaičius).
//        Magiškas kvadratas yra kvadratinė matrica, kurioje skaičiai nuo 1 iki n^2 išdėstyti taip, kad kiekvienos
//        eilutės, stulpelio ir pagrindinių įstrižainių sumos būtų vienodos.
//
//        Algoritmo aprašymas (Siamese method):
//        Pradėkite nuo vidurio viršutinės eilutės langelio.
//        Įrašykite 1.
//        Kiekvieną kitą skaičių įrašykite į langelį, esantį viena vieta į dešinę ir vieną vietą aukštyn nuo paskutinio įrašyto skaičiaus.
//        Jei tas langelis yra už kvadrato ribų, jį perkelkite į kitą kvadrato kraštą (apvyniojimas).
//        Jei langelis jau užimtas arba išeinate iš kvadrato ribų, eikite vieną vietą žemyn nuo paskutinio
//        įrašyto skaičiaus ir įrašykite ten.
//        Kartokite tol, kol užpildysite visus langelius.

        int n = 3; // kvadrato dydis, būtinai nelyginis skaičius
        int[][] square = new int[n][n];
        int row = 0;
        int column = n / 2; // Pradžioje einame į vidurį viršutinės eilutės langelį
        square[row][column] = 1;
        printSquare(square);
        for (int number = 2; number <= n * n; number++) {
            int newRow = (row - 1 + n) % n;
            int newColumn = (column + 1) % n;
            System.out.println();
            if (square[newRow][newColumn] != 0) { // užimtas
                newRow = (row + 1) % n; // viena žemyn
                newColumn = column; // stulpelis nekinta
            }
            square[newRow][newColumn] = number;
            printSquare(square);
            row = newRow;
            column = newColumn;
        }

    }

    public static void printSquare(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", square[i][j]);
            }
            System.out.println();
        }
        System.out.println("-".repeat(15));
    }
}