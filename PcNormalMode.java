package academy.learnprogramming;


public class PcNormalMode extends Player {

    public PcNormalMode(char turn) {
        super ("normal", turn);

    }

    @Override
    public boolean move(char[][] array, java.util.Random random) {
        char[][] tempArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tempArray[k][l] = array[k][l];
                    }
                }
                if (tempArray[i][j] != 'X' && tempArray[i][j] != 'O') {
                    tempArray[i][j] = super.getTurn();
                    if (checkForWin(tempArray)) {
                        super.setCoordinate1(j + 1);
                        super.setCoordinate2(3 - i);
                        return true;
                    }
                }
            }
        }
        char opponentTurn = 'X';
        if (super.getTurn() == 'X') {
            opponentTurn = 'O';
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tempArray[k][l] = array[k][l];
                    }
                }
                if (tempArray[i][j] != 'X' && tempArray[i][j] != 'O') {
                    tempArray[i][j] = opponentTurn;
                    if (checkForLoss(tempArray)) {
                        super.setCoordinate1(j + 1);
                        super.setCoordinate2(3 - i);
                        return true;
                    }
                }
            }
        }
        super.setCoordinate1(random.nextInt(4));
        super.setCoordinate2(random.nextInt(4));
        if (super.getCoordinate1() < 1 || super.getCoordinate1() > 3 || super.getCoordinate2() < 1 || super.getCoordinate2() > 3) {
            return false;
        } else if (array[3 - super.getCoordinate2()][super.getCoordinate1() - 1] == 'O' || array[3 - super.getCoordinate2()][super.getCoordinate1() - 1] == 'X') {
            return false;
        } else {
            System.out.println("Making move level \"normal\"");
            return true;
        }
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
}
