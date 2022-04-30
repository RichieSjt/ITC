import java.awt.Point;

public class LetterSoup {
    private int soupSize;
    private String[] words;
    private char letterSoup[][];

    public LetterSoup(int soupSize, String[] words) {
        this.soupSize = soupSize;
        this.words = words;
        this.letterSoup = new char[soupSize][soupSize];
    }

    public void generateSoup() {
        for (String word : words) {
            Point startingPosition = new Point();
            String orientation = "";

            if (word.length() > soupSize) {
                System.out.println("One of the given words exceeds the length of the soup, please check your input.");
                return;
            }

            Boolean wordFits = false;
            // Generating random positions and orientations until we find one where the word
            // fits
            while (!wordFits) {
                orientation = randomOrientation();
                startingPosition = randomPosition(soupSize);
                wordFits = wordFits(orientation, startingPosition, word.length());
            }

            // Once a suitable starting position and orientation was found, we write the
            // word into the soup
            writeWordIntoSoup(word, startingPosition, orientation);
        }
        // After all the words have been written we fill the remaining blank spaces in
        // the soup
        fillSoupBlankSpaces();
    }

    public void resetSoup() {
        for (int j = 0; j < soupSize; j++) {
            for (int i = 0; i < soupSize; i++) {
                letterSoup[i][j] = '\u0000';
            }
        }
    }

    // Checks if the word fits given its starting position and length
    public boolean wordFits(String orientation, Point position, int wordLength) {
        int startingAxis = orientation.equals("horizontal") ? position.x : position.y;

        return startingAxis + wordLength <= soupSize;
    }

    public void writeWordIntoSoup(String word, Point startingPosition, String orientation) {
        int j = 0;
        int x = startingPosition.x;
        int y = startingPosition.y;
        int endX = x + word.length();
        int endY = y + word.length();

        if (orientation.equals("horizontal")) {
            while (x < endX && j < word.length()) {
                letterSoup[x][y] = word.charAt(j);
                x++;
                j++;
            }
        } else {
            while (y < endY && j < word.length()) {
                letterSoup[x][y] = word.charAt(j);
                y++;
                j++;
            }
        }
    }

    public void fillSoupBlankSpaces() {
        for (int j = 0; j < soupSize; j++) {
            for (int i = 0; i < soupSize; i++) {
                if (letterSoup[i][j] == 0)
                    letterSoup[i][j] = randomLetter();
            }
        }
    }

    // Returns a random x and y position
    public Point randomPosition(int soupSize) {
        int x = (int)(Math.random() * soupSize);
        int y = (int)(Math.random() * soupSize);
        
        return new Point(x, y);
    }

    // Returns a random orientation (horizontal | vertical).
    public String randomOrientation() {
        int randNum = (int)(Math.random() * 2);
        return randNum == 0 ? "horizontal" : "vertical";
    }

    // Returns a random letter.
    public char randomLetter() {
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        int randNum = (int) (Math.random() * 26);
        char letter = letters[randNum];
        return letter;
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
