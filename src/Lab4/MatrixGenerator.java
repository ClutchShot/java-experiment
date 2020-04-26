package Lab4;

import java.util.Random;

public class MatrixGenerator {
    private double[][] martixA;
    private double[][] martixB;
    private int M;
    private int K;
    private int N;

    public MatrixGenerator(){
        Random random = new Random();

        M = random.nextInt(100) + 1;
        K = random.nextInt(100) + 1;
        N  = random.nextInt(100) + 1;
        martixA = new double[M][K];
        martixB = new double[K][N];


         for (int i = 0; i < M;i++){
             for (int j = 0; j < K ; j++) {
                 martixA[i][j] = random.nextDouble() * 10;
             }
         }

        for (int i = 0; i < K;i++){
            for (int j = 0; j < N ; j++) {
                martixB[i][j] = random.nextDouble() * 10;
            }
        }
    }

    public double getMartixA(int i, int j){
        return martixA[i][j];
    }

    public double getMartixB(int i, int j) {
        return martixB[i][j];
    }

    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public int getK() {
        return K;
    }

    void  printMatrixA(){
        for (int i = 0; i < M;i++){
            for (int j = 0; j < K ; j++) {
                System.out.print(martixA[i][j] + " ");

            }
            System.out.println(" ");
        }

        System.out.println(" ");
    }

    void  printMatrixB(){
        for (int i = 0; i < K;i++){
            for (int j = 0; j < N ; j++) {
                System.out.print( martixB[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
