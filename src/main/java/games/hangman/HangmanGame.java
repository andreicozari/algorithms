package games.hangman;

import java.util.*;

public class HangmanGame {

    static  String [] allWords = {"java", "spring", "docker", "kubernetes", "google",
            "cloud", "data", "flow", "postgres", "node"};

    static int maxNumberOfTries = 10;

    static int tries = 0;

    static int totalGuessed = 0;

    static  Scanner scanner;

    static boolean  continueToPlay = true;

    static char [] wordToGuess;

    static boolean wordIsGuessed = false;

    static Map<GuessingChar, List<Integer>> guessingWordMap;

    public static void main(String[] args) {
        init();

        scanner = new Scanner(System.in);

        while (!wordIsGuessed && continueToPlay) {
            if (tries < maxNumberOfTries) {
                System.out.printf("\n You have %d tries left. \n", maxNumberOfTries - tries);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                GuessingChar guessingChar = new GuessingChar(input);

                if (guessingWordMap.containsKey(guessingChar)) {
                    guessingChar.setGuessed(true);
                    guessingWordMap.put(guessingChar, guessingWordMap.get(new GuessingChar(input)));
                    totalGuessed = totalGuessed +  guessingWordMap.get(guessingChar).size();
                }

                showCurrentState(wordToGuess);

                // check if word is guessed:
                if (totalGuessed == wordToGuess.length) {
                    wordIsGuessed = true;
                    System.out.println("\n You guessed it!");
                    askToContinue();
                }
            } else {
                System.out.println("\n Not guessed!");
                System.out.println(" \n The word was:" + String.valueOf(wordToGuess));
                askToContinue();
            }
        }
    }

    public static void init() {
        System.out.println(" \n All words: \n");
        for (String word: allWords) {
            System.out.printf(" \t " + word);
        }

        tries = 0;
        totalGuessed = 0;
        wordIsGuessed = false;
        continueToPlay = true;

        initCharsMapByPosition();
    }

    public static void initCharsMapByPosition() {

        // A HashMap to keep each character on what positions it appears in the word.
        // Could be the same letter in more positions:
        guessingWordMap = new HashMap<>();

        wordToGuess = getNextWordToGuess(allWords);

        // Populate the map:
        for (int i = 0; i < wordToGuess.length; i++) {
            Character charToGuess = Character.valueOf(wordToGuess[i]);
            GuessingChar guessingChar = new GuessingChar(charToGuess, false);

            if (guessingWordMap.get(guessingChar) != null) {
                List<Integer> existingPositions = guessingWordMap.get(guessingChar);
                existingPositions.add(i);
                guessingWordMap.put(guessingChar, existingPositions);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                guessingWordMap.put(guessingChar, newList);
            }
        }
    }

    public static char [] getNextWordToGuess(String [] allWords) {
        Random random = new Random();
        return allWords[random.nextInt(allWords.length)].toCharArray();
    }

    public static void showCurrentState(char [] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (guessingWordMap.containsKey(new GuessingChar(Character.valueOf(chars[i]), true))) {
                System.out.print(chars[i]);
            } else {
                System.out.print("-");
            }
        }
    }

    public static void askToContinue() {
        System.out.println("Do you want to continue game ? y/n: ");
        char wantToContinue = scanner.nextLine().charAt(0);

        if (wantToContinue == 'y') {
            // process next word:
            init();
        } else {
            continueToPlay = false;
        }
    }
}
