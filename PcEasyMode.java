package academy.learnprogramming;


public class PcEasyMode extends Player {

    public PcEasyMode(char turn) {
        super ("easy", turn);

    }

    @Override
    public boolean move(char[][] array, java.util.Random random) {

        super.setCoordinate1(random.nextInt(4));
        super.setCoordinate2(random.nextInt(4));
        if (super.getCoordinate1() < 1 || super.getCoordinate1() > 3 || super.getCoordinate2() < 1 || super.getCoordinate2() > 3) {
            return false;
        } else if (array[3 - super.getCoordinate2()][super.getCoordinate1() - 1] == 'O' || array[3 - super.getCoordinate2()][super.getCoordinate1() - 1] == 'X') {
            return false;
        } else {
            System.out.println("Making move level \"easy\"");
            return true;
        }
    }
}