package academy.learnprogramming;

import java.util.ArrayList;

public class PcHardMode extends Player {

    public PcHardMode(char turn) {

        super("hard", turn);
    }


    public int minimax(char[][] board, char playerType, boolean activePlayer) {
        boolean currentPlayer;
        if (activePlayer) {
            currentPlayer = false;
        } else {
            currentPlayer = true;
        }
        ArrayList<MakeMove> makeMove = new ArrayList<MakeMove>();
        char opponent;
        if (playerType == 'X') {
            opponent = 'O';
        } else {
            opponent = 'X';
        }

        char[][] tempArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tempArray[k][l] = board[k][l];
                    }
                }
                if (tempArray[i][j] != 'X' && tempArray[i][j] != 'O') {
                    tempArray[i][j] = playerType;
                    MakeMove newMove = new MakeMove();
                    newMove.setCord1(j + 1);
                    newMove.setCord2(3 - i);
                    if (checkForWin(tempArray) && activePlayer) {
                        newMove.setScore(10);
                    } else if (checkForLoss(board) && !activePlayer) {
                        newMove.setScore(-10);
                    } else if (checkForDraw(board)) {
                        newMove.setScore(0);
                    } else {
                        newMove.setScore(minimax(tempArray, opponent, currentPlayer));
                    }
                    makeMove.add(newMove);
                }
            }
        }
        int score = 0;
        for (MakeMove move: makeMove) {
            if (activePlayer && move.getScore() > score) {
                score = move.getScore();
                super.setCoordinate1(move.getCord1());
                super.setCoordinate2(move.getCord2());
            } else if (!activePlayer && move.getScore() < score) {
                score = move.getScore();
            }
        }
        return score;
    }



    @Override
    public boolean move(char[][] array, java.util.Random random) {
        minimax(array, super.getTurn(), true);
        return true;
    }


    private boolean checkForWin(char[][] array) {

        if (array[0][0] == super.getTurn() && array[0][1] == super.getTurn() && array[0][2] == super.getTurn()) {
            return true;
        } else if (array[1][0] == super.getTurn() && array[1][1] == super.getTurn() && array[1][2] == super.getTurn()) {
            return true;
        } else if (array[2][0] == super.getTurn() && array[2][1] == super.getTurn() && array[2][2] == super.getTurn()) {
            return true;
        } else if (array[0][0] == super.getTurn() && array[1][0] == super.getTurn() && array[2][0] == super.getTurn()) {
            return true;
        } else if (array[0][1] == super.getTurn() && array[1][1] == super.getTurn() && array[2][1] == super.getTurn()) {
            return true;
        } else if (array[0][2] == super.getTurn() && array[1][2] == super.getTurn() && array[2][2] == super.getTurn()) {
            return true;
        } else if (array[0][0] == super.getTurn() && array[1][1] == super.getTurn() && array[2][2] == super.getTurn()) {
            return true;
        } else if (array[0][2] == super.getTurn() && array[1][1] == super.getTurn() && array[2][0] == super.getTurn()) {
            return true;
        }
        return false;
    }

    private boolean checkForLoss(char[][] array) {
        char opponentTurn = 'X';
        if (super.getTurn() == 'X') {
            opponentTurn = 'O';
        }
        if (array[0][0] == opponentTurn && array[0][1] == opponentTurn && array[0][2] == opponentTurn) {
            return true;
        } else if (array[1][0] == opponentTurn && array[1][1] == opponentTurn && array[1][2] == opponentTurn) {
            return true;
        } else if (array[2][0] == opponentTurn && array[2][1] == opponentTurn && array[2][2] == opponentTurn) {
            return true;
        } else if (array[0][0] == opponentTurn && array[1][0] == opponentTurn && array[2][0] == opponentTurn) {
            return true;
        } else if (array[0][1] == opponentTurn && array[1][1] == opponentTurn && array[2][1] == opponentTurn) {
            return true;
        } else if (array[0][2] == opponentTurn && array[1][2] == opponentTurn && array[2][2] == opponentTurn) {
            return true;
        } else if (array[0][0] == opponentTurn && array[1][1] == opponentTurn && array[2][2] == opponentTurn) {
            return true;
        } else if (array[0][2] == opponentTurn && array[1][1] == opponentTurn && array[2][0] == opponentTurn) {
            return true;
        }
        return false;
    }

    private boolean checkForDraw(char[][] array) {
        int space = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == '\u0000') {
                    space++;
                }
            }
        }
        if (space == 0) {
            return true;
        } else {
            return false;
        }
    }

    class MakeMove {
        private int cord1;
        private int cord2;
        private int score;

        public int getCord1() {
            return cord1;
        }

        public void setCord1(int cord1) {
            this.cord1 = cord1;
        }

        public int getCord2() {
            return cord2;
        }

        public void setCord2(int cord2) {
            this.cord2 = cord2;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}