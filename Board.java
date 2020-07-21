package academy.learnprogramming;

public class Board {
    private char gameBoard[][];

    public Board() {
        this.gameBoard = new char[3][3];
    }

    public char[][] getGameBoard() {
        return gameBoard.clone();
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (this.gameBoard[i][j] == '\u0000') {
                    System.out.print("  ");
                } else {
                    System.out.print(this.gameBoard[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
