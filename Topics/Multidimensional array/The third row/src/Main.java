class ArrayOperations {
    public static void printTheThirdRow(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                if (i == 2) {
                    System.out.print(twoDimArray[i][j] + " ");
                }
            }
        }

    }
}