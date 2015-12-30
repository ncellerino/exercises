package codility.lesson10.primeAndCompositeNumbers;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class MinPerimeterRectangle {

    public static void main(String args[]) {
        int N = 36;
        System.out.println(new MinPerimeterRectangle().solution(N));
    }

    public int solution(int N) {

        int i = 2;
        int minPerimeter = 2 * (1 + N);
        int currentPerimeter = 0;
        while (i * i <= N) {
            if (N % i == 0) {
                int B = N / i;
                currentPerimeter = 2 * (i + B);
                minPerimeter = Math.min(currentPerimeter, minPerimeter);
            }
            i++;
        }
        return minPerimeter;
    }
}
