package academy.learnprogramming;


public class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private char whoseTurn = 'X';


    public Game(String player1Type, String player2Type) {
        this.board = new Board();
        if ("user".equals(player1Type)) {
            this.player1 = new Player("user", 'X');
        } else if ("easy".equals(player1Type)) {
            this.player1 = new PcEasyMode('X');
        } else if ("normal".equals(player1Type)) {
            this.player1 = new PcNormalMode('X');
        } else {
            this.player1 = new PcHardMode('X');
        }

        if ("user".equals(player2Type)) {
            this.player2 = new Player("user", 'O');
        } else if ("easy".equals(player2Type)) {
            this.player2 = new PcEasyMode('O');
        } else if ("normal".equals(player2Type)){
            this.player2 = new PcNormalMode('O');
        } else {
            this.player2 = new PcHardMode('X');
        }

    }

    private void implementMove(char turn) {
        char [][] array = this.board.getGameBoard();
        if (this.whoseTurn == 'X') {
            array[3 - this.player1.getCoordinate2()][player1.getCoordinate1() - 1] = turn;
        } else {
            array[3 - player2.getCoordinate2()][player2.getCoordinate1() - 1] = turn;
        }
        this.board.setGameBoard(array);
    }

    private String state(char turn) {
        char [][] array = this.board.getGameBoard();
        int space = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == '\u0000') {
                    space++;
                }
            }
        }
        if (array[0][0] == turn && array[0][1] == turn && array[0][2] == turn) {
            return turn + " wins";
        } else if (array[1][0] == turn && array[1][1] == turn && array[1][2] == turn) {
            return turn + " wins";
        } else if (array[2][0] == turn && array[2][1] == turn && array[2][2] == turn) {
            return turn + " wins";
        } else if (array[0][0] == turn && array[1][0] == turn && array[2][0] == turn) {
            return turn + " wins";
        } else if (array[0][1] == turn && array[1][1] == turn && array[2][1] == turn) {
            return turn + " wins";
        } else if (array[0][2] == turn && array[1][2] == turn && array[2][2] == turn) {
            return turn + " wins";
        } else if (array[0][0] == turn && array[1][1] == turn && array[2][2] == turn) {
            return turn + " wins";
        } else if (array[0][2] == turn && array[1][1] == turn && array[2][0] == turn) {
            return turn + " wins";
        } else if (space == 0) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }


    public void newGame(java.util.Scanner scanner, java.util.Random random) {

        String result = "Game not finished";
        System.out.println(player1.getPlayerType());
        System.out.println(player2.getPlayerType());

        for (int i = 0; i < 9; i++) {
            this.board.printBoard();

            if (this.whoseTurn == 'X') {
                if ("user".equals(this.player1.getPlayerType())) {
                    do {
                        System.out.print("Enter the coordinates: ");
                        if (scanner.hasNextInt()) {
                            String input = scanner.nextLine();
                            input = input.replaceAll(" ", "");
                            this.player1.setCoordinate1(Integer.parseInt(input.substring(0, 1)));
                            this.player1.setCoordinate2(Integer.parseInt(input.substring(1, 2)));
                        } else {
                            System.out.println("You should enter numbers!");
                            scanner.nextLine();
                            continue;
                        }
                        if (this.player1.move(this.board.getGameBoard(), random)) {
                            implementMove(this.whoseTurn);
                            break;
                        }
                    } while (true);
                } else {
                    do {
                        if (this.player1.move(this.board.getGameBoard(), random)) {
                            implementMove(this.whoseTurn);
                            break;
                        }
                    } while (true);
                }
                result = state(this.whoseTurn);
                if (result.equals(whoseTurn + " wins") || result.equals("Draw")) {
                    break;
                }
                this.whoseTurn = 'O';
            } else {
                if ("user".equals(this.player2.getPlayerType())) {
                    do {
                        System.out.print("Enter the coordinates: ");
                        if (scanner.hasNextInt()) {
                            String input = scanner.nextLine();
                            input = input.replaceAll(" ", "");
                            this.player2.setCoordinate1(Integer.parseInt(input.substring(0, 1)));
                            this.player2.setCoordinate2(Integer.parseInt(input.substring(1, 2)));
                        } else {
                            System.out.println("You should enter numbers!");
                            scanner.nextLine();
                            continue;
                        }
                        if (this.player2.move(this.board.getGameBoard(), random)) {
                            implementMove(this.whoseTurn);
                            break;
                        }
                    } while (true);
                } else {
                    do {
                        if (this.player2.move(this.board.getGameBoard(), random)) {
                            implementMove(this.whoseTurn);
                            break;
                        }
                    } while (true);
                }
                result = state(this.whoseTurn);
                if (result.equals(whoseTurn + " wins") || result.equals("Draw")) {
                    break;
                }
                this.whoseTurn = 'X';
            }
        }
        this.board.printBoard();
        System.out.println(result);
    }
}