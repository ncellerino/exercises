package beatmycode;

/**
 * 83%
 * @author jorge.cellerino
 *
 */
public class TurtlePyramid {

    public static void main(String[] args) {
        //String input = "5\n1\n3\n2\n4";
        String input = "BMC_TEST_INPUT_MAGIC";
        String[] array = input.split("\n");

        int maxSeenTurtle = 0;
        int maxMisplacedTurtle = 0;

        for (int i = 0; i < array.length; i++) {
            int turtle = Integer.parseInt(array[i]);
            if (turtle < maxSeenTurtle) {
                if (turtle != i + 1 && turtle > maxMisplacedTurtle) {
                    maxMisplacedTurtle = turtle;
                }
            } else {
                maxSeenTurtle = turtle;
            }
        }
        
        for(int i = maxMisplacedTurtle; i > 0; i--){
            System.out.println(i);
        }
    }
}
