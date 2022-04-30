class LetterSoupFacade {
    private LetterSoup letterSoup;

    public LetterSoupFacade(int soupSize, String[] words) {
        letterSoup = new LetterSoup(soupSize, words);
        letterSoup.generateSoup();
    }
    
    public void scrambleWords() {
        System.out.println("\nScrambling words...\n");
        letterSoup.resetSoup();
        letterSoup.generateSoup();
    }

    public void displaySoup() {
        System.out.println("\nGenerated soup:\n");
        letterSoup.printSoup();
    }
}