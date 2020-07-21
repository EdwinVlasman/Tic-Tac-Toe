package academy.learnprogramming;

public class Player{

    private String playerType;
    private int coordinate1;
    private int coordinate2;
    private char turn;

    public Player(String playerType, char turn) {
        this.playerType = playerType;
        this.turn = turn;
    }

    public int getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(int coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public int getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(int coordinate2) {
        this.coordinate2 = coordinate2;
    }

    public String getPlayerType() {
        return playerType;
    }

    public char getTurn() {
        return turn;
    }

    public boolean move(char[][] array, java.util.Random random) {

        if (this.coordinate1 < 1 || this.coordinate1 > 3 || this.coordinate2 < 1 || this.coordinate2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (array[3 - coordinate2][coordinate1 - 1] == 'O' || array[3 - this.coordinate2][this.coordinate1 - 1] == 'X') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            return true;
        }
    }
}