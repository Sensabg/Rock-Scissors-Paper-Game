import java.util.Random;
import java.util.Scanner;

public class checking {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        System.out.println("Type 'end' or 'exit' to quit");

        int humanWins = 0;
        int botWins = 0;
        int draws = 0;

        while (true) {
            System.out.println("Pick up your weapon and fight!(Rock, Paper, Scissors)");
            System.out.print("Enter your choice: ");

            String humanChoice = getHumanChoice();

            if (humanChoice.equalsIgnoreCase("Game over")) {
                if (humanWins > botWins) {
                    System.out.println("Great job!");
                    System.out.println("You won the game!");
                    System.out.printf("Human wins %d : %d Bot wins", humanWins ,botWins);
                } else if (botWins > humanWins) {
                    System.out.println("Game over!");
                    System.out.println("You lost the game!");
                    System.out.printf("Human wins %d : %d Bot wins", humanWins ,botWins);
                } else {
                    System.out.println("The game ended in a draw!");
                    System.out.println("Rematch?");
                    System.out.printf("Human wins %d : %d Bot wins", humanWins ,botWins);
                }
                break;
            }

            String botChoice = getBotChoice();
            String result = checkWinner(humanChoice, botChoice);
            System.out.println(result);

            if (result.equals("You won the round!")) {
                humanWins++;
            } else if (result.equals("You lost the round!")) {
                botWins++;
            } else {
                draws++;
            }

            System.out.println("Human Wins: " + humanWins);
            System.out.println("Bot Wins: " + botWins);
            System.out.println("Draws: " + draws);
        }
    }

    private static String getBotChoice() {
        Random random = new Random();
        int botChoice = random.nextInt(3);
        String bot = "";

        switch (botChoice) {
            case 0:
                bot = ROCK;
                System.out.println("Bot chose: " + bot);
                break;
            case 1:
                bot = PAPER;
                System.out.println("Bot chose: " + bot);
                break;
            case 2:
                bot = SCISSORS;
                System.out.println("Bot chose: " + bot);
                break;
        }
        return bot;
    }

    private static String getHumanChoice() {
        Scanner scanner = new Scanner(System.in);
        String human;

        do {
            human = scanner.nextLine();

            if (human.equalsIgnoreCase("r") || human.equalsIgnoreCase("rock")) {
                human = ROCK;
                System.out.println("You chose: " + human);
            } else if (human.equalsIgnoreCase("p") || human.equalsIgnoreCase("paper")) {
                human = PAPER;
                System.out.println("You chose: " + human);
            } else if (human.equalsIgnoreCase("s") || human.equalsIgnoreCase("scissors")) {
                human = SCISSORS;
                System.out.println("You chose: " + human);
            } else if (human.equalsIgnoreCase("end") || human.equalsIgnoreCase("exit")) {
                return "Game over";
            } else {
                System.out.println("Invalid input. Try again...");
            }
        } while (!human.equalsIgnoreCase("rock") && !human.equalsIgnoreCase("paper") && !human.equalsIgnoreCase("scissors"));

        return human;
    }

    private static String checkWinner(String player, String bot) {
        if (player.equalsIgnoreCase(bot)) {
            return "Draw!";
        } else if (bot.equalsIgnoreCase(ROCK)) {
            return (player.equalsIgnoreCase(PAPER)) ? "You won the round!" : "You lost the round!";
        } else if (bot.equalsIgnoreCase(PAPER)) {
            return (player.equalsIgnoreCase(SCISSORS)) ? "You won the round!" : "You lost the round!";
        } else if (bot.equalsIgnoreCase(SCISSORS)) {
            return (player.equalsIgnoreCase(ROCK)) ? "You won the round!" : "You lost the round!";
        }
        return ""; // Satisfy the compiler :)
    }
}
