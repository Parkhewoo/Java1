package ai0908;

public class ReturnArrayTest {
    public static double [] resultCalc(int n1, int n2){
        double[] resultArr = new double[4];
        resultArr[0] = n1 + n2;
        resultArr[1] = n1 - n2;
        resultArr[2] = n1 * n2;
        resultArr[3] = (double)n1 / n2;

        return resultArr;
    }

    public static void main(String[] args) {
        int n1 = 200;
        int n2 = 500;
        char[] op = {'+', '-', '*', '/'};

        double[] resultArr = resultCalc(n1, n2);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.printf("%d %c %d = %.1f\n", n1, op[i] ,n2,resultArr[i]);
        }
    }
}
