public class Main {
    public static void main(String[] args) {
        String[] words = {"HELLO", "WORLD"};

        LetterSoupFacade letterSoup = new LetterSoupFacade(5, words);
        letterSoup.displaySoup();
        letterSoup.scrambleWords();
        letterSoup.displaySoup();
    }
}
