package games.hangman;

import java.util.Objects;

public class GuessingChar {

    public Character character;

    public boolean guessed;

    public GuessingChar(Character character, boolean guessed) {
        this.character = character;
        this.guessed = guessed;
    }

    public GuessingChar(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessingChar that = (GuessingChar) o;
        return guessed == that.guessed &&
                character.equals(that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, guessed);
    }
}
