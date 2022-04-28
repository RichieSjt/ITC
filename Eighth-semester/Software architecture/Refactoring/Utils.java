import java.awt.Point;

public class Utils {
    private char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    // Checks if the word fits given its starting position and length
    public boolean wordFits(String orientation, Point position, int wordLength, int soupSize) {
        int startingAxis = orientation.equals("horizontal") ? position.x : position.y;

        return startingAxis + wordLength <= soupSize;
    }

    public void writeWordIntoSoup(char[][] letterSoup, String word, Point startingPosition, String orientation) {
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

    public void fillSoupBlankSpaces(char[][] letterSoup, int soupSize) {
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
        int randNum = (int) (Math.random() * 26);
        char letter = letters[randNum];
        return letter;
    }
}
