package matrix;

public class MatrixRotation {
    public static void main(String[] argv) {
        int m = 6;
        int[][] arr = new int[m][m];
        fillMatrix(arr);
        printArray(arr);
        counterClockwiseRotate(arr);
        printArray(arr);
    }

    private static void counterClockwiseRotate(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][len - 1 - i];
                arr[j][len - 1 - i] = arr[len - 1 - i][len - 1 - j];
                arr[len - 1 - i][len - 1 - j] = arr[len - 1 - j][i];
                arr[len - 1 - j][i] = tmp;
            }
        }
    }

    private static void clockwiseRotate(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = len - 1 - i; j > i; j--) {
                int tmp = arr[i][j];
                arr[i][j] = arr[len - 1 - j][i];
                arr[len - 1 - j][i] = arr[len - i - 1][len  - 1 - j];
                arr[len - 1 - i][len - 1 - j] = arr[j][len - 1 - i];
                arr[j][len - 1 - i] = tmp;
            }
        }
    }


    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    private static void fillMatrix(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = len * i + j;
            }
        }
    }
}
