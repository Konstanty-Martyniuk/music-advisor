import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int row = 0;
        int column = 0;
        int result = Integer.MIN_VALUE;

        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = scanner.nextInt();
                if (numbers[i][j] > result) {
                    result = numbers[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        System.out.println(row + " " + column);
    }
}