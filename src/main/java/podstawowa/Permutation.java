package podstawowa;
import java.util.*;
public class Permutation {
    public static int[][] getGeneration(int[][] cells, int generations) {
        int[][] next = new int[cells[0].length][cells.length];
        int[][] curr = Arrays.copyOf(cells, cells.length);
        for (int i = 0; i < cells.length; i++){
            curr[i] = Arrays.copyOf(cells[i], cells[i].length);
        }
        while(generations-- > 0) {
            for (int row = 0; row < curr.length; row++) {
                for (int col = 0; col < curr[row].length; col++) {
                    int c = countN(curr, row, col);
                    switch (c) {
                        case 0:
                        case 1:
                            next[row][col] = 0;
                            break;
                        case 2:
                            next[row][col] = curr[row][col];
                            break;
                        case 3:
                            next[row][col] = curr[row][col] == 0 ? 1 : curr[row][col];
                            break;
                        default:
                            next[row][col] = 0;
                    }
                }
            }
            if (generations == 0) {
                return next;
            }
            int[][] temp = curr;
            curr = next;
            next = temp;
        }
        return next;
    }

    public static int countN(int[][] cells, int r, int c) {
        int [][] dirs = {{-1,-1},
                         {-1, 0},
                         {-1, 1},
                         { 0, 1},
                         { 1, 1},
                         { 1, 0},
                         { 1,-1},
                         { 0,-1}
                        };
        int rows = cells.length;
        int cols = cells[r].length;
        int count = 0;
        for (int[] dir: dirs){
            int ri = dir[0]+r;
            int ci = dir[1]+c;
            count += isValid(rows, cols, ri, ci) ? cells[ri][ci] : 0;
        }
        return count;
    }

    public static int[][] crop(int[][] cells){
        return new int [cells.length][cells[0].length];
    }

    public static boolean isValid(int rows, int cols, int r, int c){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static boolean regexTicTacToeWinChecker(String board) {
        return
            board.matches("XXX[XO-]{6}") ||
            board.matches("[XO-]{3}XXX[XO-]{3}") ||
            board.matches("[XO-]{6}XXX") ||
            board.matches("X[XO-]{2}X[XO-]{2}X[XO-]{2}") ||
            board.matches("[XO-]X[XO-][XO-]X[XO-][XO-]X[XO-]") ||
            board.matches("[XO-]{2}X[XO-]{2}X[XO-]{2}X") ||
            board.matches("X[XO-]{2}[XO-]X[XO-][XO-]{2}X") ||
            board.matches("[XO-]{2}X[XO-]X[XO-]X[XO-]{2}") ||
            board.matches("OOO[XO-]{6}") ||
            board.matches("[XO-]{3}OOO[XO-]{3}") ||
            board.matches("[XO-]{6}OOO") ||
            board.matches("O[XO-]{2}O[XO-]{2}O[XO-]{2}") ||
            board.matches("[XO-]O[XO-][XO-]O[XO-][XO-]O[XO-]") ||
            board.matches("[XO-]{2}O[XO-]{2}O[XO-]{2}O") ||
            board.matches("O[XO-]{2}[XO-]O[XO-][XO-]{2}O") ||
            board.matches("[XO-]{2}O[XO-]O[XO-]O[XO-]{2}");
    }

    public static void printArr(int[][] arr){
        for(int[] row: arr){
            for(int e: row){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] gliders =
                       {{1,0,0},
                        {0,1,1},
                        {1,1,0}};
        printArr(gliders);
        int[][] rez = Permutation.getGeneration(gliders, 3);
        printArr(rez);
    }
}
