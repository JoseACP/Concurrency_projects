
class PlayerStrategy {
    
    public int[] computeMove(final char mark, final TicTacToe ticTacToe) {
        final char[][] table = ticTacToe.table();
        int[] coordinates = new int[0];
        for (int dia = 0; dia < 5; dia++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i + j == dia && table[i][j] == ' ') {
                        coordinates = new int[]{i,j};
                        return coordinates;
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }
    
}
