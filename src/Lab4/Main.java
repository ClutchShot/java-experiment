package Lab4;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MatrixGenerator matrixGenerator = new MatrixGenerator();
        GeneralMultiplication generalMultiplication = new GeneralMultiplication(matrixGenerator);
        MultiThreadMultiplication multiThreadMultiplication = new MultiThreadMultiplication(matrixGenerator);

        //Thread.sleep(1000*20);
        long start  = System.currentTimeMillis();
        System.out.println(start);
        generalMultiplication.Multiply();
        long finish = System.currentTimeMillis() - start;
        System.out.println("1- " + finish);

        Thread th1 = new Thread(multiThreadMultiplication.MultiplyTH1(),"th1");
        Thread th2 = new Thread(multiThreadMultiplication.MultiplyTH2(), "th2");
        start = System.currentTimeMillis();
        System.out.println(start);
        th1.start();
        th2.start();


        while (true){
            if ( !th1.isAlive() && !th2.isAlive()){
                finish = System.currentTimeMillis() - start;
                System.out.println("2- " + finish);
                Test test1 = new Test();
                assert test1.equal(generalMultiplication.getMartixResult(),multiThreadMultiplication.getMartixResult());
                break;
            }
        }


    }
}
