package beatmycode;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class Minesweeper {

    public static final String MINE = "X";
    public static final int MINE_VALUE = -1;

    public static void main(String[] args) {
        String input = "BMC_TEST_INPUT_MAGIC";
        // String input =
        // "O O O O X O O O O O\nX X O O O O O O X O\nO O O O O O O O O O\nO O O O O O O O O O\nO O O O O X O O O O";

        String[][] field = stringToMatrix(input);

        for (int i = 0; i < field.length; i++) {
            String[] row = field[i];
            int columnCount = row.length;
            for (int j = 0; j < columnCount; j++) {
                int mineCounter = 0;
                if (!MINE.equals(row[j])) {
                    if (canBeCounted(field, i - 1, j))
                        mineCounter++;
                    if (canBeCounted(field, i - 1, j - 1))
                        mineCounter++;
                    if (canBeCounted(field, i - 1, j + 1))
                        mineCounter++;

                    if (canBeCounted(field, i, j - 1))
                        mineCounter++;
                    if (canBeCounted(field, i, j + 1))
                        mineCounter++;

                    if (canBeCounted(field, i + 1, j - 1))
                        mineCounter++;
                    if (canBeCounted(field, i + 1, j))
                        mineCounter++;
                    if (canBeCounted(field, i + 1, j + 1))
                        mineCounter++;
                    field[i][j] = String.valueOf(mineCounter);
                }
            }
        }

        System.out.println(matrixToString(field));

    }

    private static String[][] stringToMatrix(String field) {
        String[] rowArray = field.split("\n");
        int rows = rowArray.length;
        String[][] mineCounters = new String[rows][];


        for (int i = 0; i < rows; i++) {
            String row = rowArray[i];
            String[] cells = row.split(" ");
            int columns = cells.length;
            mineCounters[i] = new String[columns];
            for (int j = 0; j < columns; j++) {
                mineCounters[i][j] = cells[j];
            }
        }
        return mineCounters;
    }

    private static String matrixToString(String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            String[] line = matrix[i];
            for (int j = 0; j < line.length; j++) {
                sb.append(line[j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static boolean canBeCounted(String[][] field, int row, int column) {
        return (row >= 0 && column >= 0) && (row < field.length && column < field[row].length) && (MINE.equals(field[row][column]));
    }

}
