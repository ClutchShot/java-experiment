package Lab4;

public class MultiThreadMultiplication {
    private  double[][] martixResult;
    private int M;
    private  int N;
    private  int K;
    private MatrixGenerator m;
    private Runnable task1;
    private Runnable task2;

    MultiThreadMultiplication(MatrixGenerator m){
        M = m.getM();
        N = m.getN();
        K = m.getK();
        martixResult = new double[M][N];
        this.m = m;

    }

    public Runnable MultiplyTH1(){

        task1 = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < M;i+=2)
                    for (int j = 0; j < N; j++)
                        for (int k = 0; k < K; k++)
                            martixResult[i][j] += m.getMartixA(i,k) * m.getMartixB(k,j);

            }
        };
        return task1;
    }


    public  Runnable MultiplyTH2(){
        task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < M;i+=2)
                    for (int j = 0; j < N; j++)
                        for (int k = 0; k < K; k++)
                            martixResult[i][j] += m.getMartixA(i,k) * m.getMartixB(k,j);
            }
        };
        return  task2;
    }

    public double[][] getMartixResult() {
        return martixResult;
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

}
