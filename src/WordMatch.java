public class WordMatch {

    private String actualString;

    public WordMatch(String str) {
        actualString = str;
    }

    public int scoreGuess(String word) {
        if (word.equals("")) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (word.length() > actualString.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int occurences = 0;
        for (int i = 0; i < actualString.length() - word.length() + 1; i++) {
            if (actualString.substring(i, i + word.length()).equals(word)) {
                occurences++;
            }
        }
        return occurences * word.length() * word.length();
    }

    public String findBetterGuess(String word1, String word2) {
        int score1 = scoreGuess(word1);
        int score2 = scoreGuess(word2);
        if (score1 >= score2) {
            return word1;
        }
        return word2;
    }
}
