package Core.UserInterfaces;

import Core.Players.Player;

public class Message {

    public static final String askGameMode = "\nHi! please enter '1' to " +
            "play against the computer, '2' to see computer-vs-computer," +
            " or '3' for human-vs-human.\n";

    public static final String announceNumberNotValid =
            "\nNow, that's not a valid number, is it! Try again!\n";

    public static final String announceGameModeChoiceInvalid =
            "\nUhoh please make a valid game mode selection...\n";

    public final static String announceTie =
            "\nLooks like the game was a tie!\n";

    public final static String askRewatch =
        "\nThe game has drawn to a close. " +
                "Would you like to watch it back? Please enter: y or n.\n";

    public final static String askReplay =
        "\nOkay, so would you like to play another game?\n";

    public final static String askNewYOrN =
        "\nPlease enter either y or n.\n";

    public final static String askIfPlayAgain =
            "\nSo... Would you like to play again?\n";

    public final static String announceProgramOver =
        "\nOh how sad... you wish to leave me... goodbye!\n";

    public static String askSquareChoice(Player player) {
        return "\n" + player.getName() + " please select a free square.\n";
    }

    public static String announceSquareChoiceInvalid(Player player) {
        return "\nLooks like " + player.getName() + " made a boo-boo! " +
                "Please enter a valid number that hasn't already been picked.\n";
    }

    public static String announceSquareChoice(Player player) {
        return "\n" + player.getName() + " picked...\n";
    }

    public static String announceWinner(Player player) {
        return "\nCongratulations " + player.getName() + " - You're the winner!\n";
    }

}
