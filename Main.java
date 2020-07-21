package academy.learnprogramming;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        String playerX;
        String playerO;
        String command;

        do {
            System.out.print("Input command: ");
            command = scanner.nextLine();
            String[] arguments = command.split("\\s+");

            if ("exit".equals(command)) {
                break;
            } else if (arguments.length != 3 || !"start".equals(arguments[0])) {
                System.out.println("Bad parameters!");
                continue;
            }

            playerX = arguments[1];
            playerO = arguments[2];

            if (playerX == null || playerO == null) {
                System.out.println("Bad parameters!");
                continue;
            }

            Game game = new Game(playerX, playerO);
            game.newGame(scanner, random);
            System.out.println();
        } while (true);
    }
}




