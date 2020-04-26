package Lab4;

public class Test {


    Test(){

    }

    public boolean equal(double[][]a, double[][]b){
        int sizea = a.length;
        int sizeb = b.length;

        if (sizea!=sizeb)
            return false;

        for (int i = 0; i < sizea ; i++) {
            if (a[i].length!=b[i].length)
                return false;
            else{
                for (int j = 0; j < a[i].length ; j++) {
                    if (a[i][j]!=b[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}
