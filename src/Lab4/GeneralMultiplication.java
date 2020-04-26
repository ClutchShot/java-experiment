package Lab4;


public class GeneralMultiplication {
    private double[][] martixResult;
    private int M;
    private int N;
    private  int K;
    private MatrixGenerator m;

    GeneralMultiplication(MatrixGenerator m){
        M = m.getM();
        N = m.getN();
        K = m.getK();
        martixResult = new double[M][N];
        this.m = m;

    }


    public void Multiply(){
        for (int i = 0; i < M;i++){
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    martixResult[i][j] += m.getMartixA(i,k) * m.getMartixB(k,j);
                }
            }
        }
    }

    public void  printResult(){
        System.out.println("\n\n");
        for (int i = 0; i < M;i++){
            for (int j = 0; j < N; j++) {
                System.out.print(martixResult[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public double[][] getMartixResult() {
        return martixResult;
    }
}
