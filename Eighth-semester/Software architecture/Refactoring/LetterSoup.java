import java.awt.Point;

class LetterSoup {
    private int soupSize;
    private String[] words;
    private char letterSoup[][];
    private Utils utils = new Utils();

    public LetterSoup(int soupSize, String[] words) {
        this.soupSize = soupSize;
        this.words = words;
        this.letterSoup = new char[soupSize][soupSize];
        generateSoup();
    }

    private void generateSoup() {
        for(String word : words) {
            Point startingPosition = new Point();
            String orientation = "";

            if(word.length() > soupSize){
                System.out.println("One of the given words exceeds the length of the soup, please check your input.");
                return;
            }
            
            Boolean wordFits = false;
            // Generating random positions and orientations until we find one where the word fits
            while(!wordFits) {
                startingPosition = utils.randomPosition(soupSize);
                orientation = utils.randomOrientation();
                wordFits = utils.wordFits(orientation, startingPosition, word.length(), soupSize);
            }

            // Once a suitable starting position and orientation was found, we write the word into the soup
            utils.writeWordIntoSoup(letterSoup, word, startingPosition, orientation);
        }
        // After all the words have been written we fill the remaining blank spaces in the soup
        utils.fillSoupBlankSpaces(letterSoup, soupSize);
    }

    public void printSoup() {
        for (int j = 0; j < soupSize; j++) {
            for (int i = 0; i < soupSize; i++) {
                System.out.print(letterSoup[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}