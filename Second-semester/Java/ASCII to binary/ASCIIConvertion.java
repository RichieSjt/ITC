import java.util.Scanner;
import java.io.File;

public class ASCIIConvertion {
   public static void main (String args[]) throws Exception{
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter 0 for String to Binary or 1 for Binary to String: ");
      int n = sc.nextInt();

      System.out.print("\n");

      if(n == 0)
         StringToBinary();
      else
         BinaryToString();
      
      sc.close();
   }

   public static void StringToBinary() throws Exception{
      Scanner sc = new Scanner(System.in);
      String word; String[] ASCII; String[] Binary; String[] wordSplit;
      String result = "";

      System.out.print("Introduce a word, letter or sentence: ");
      word = sc.nextLine();

      wordSplit = word.split("");
      
      ASCII = readCharactersFile();
      Binary = readBinaryFile(); 
      
      for(int i = 0; i < wordSplit.length; i++){
         for(int j = 0; j < ASCII.length; j++){
            if(wordSplit[i].equals(ASCII[j])){
               result += Binary[j] + " ";
            }
         }
      }
      System.out.println("Text converted to binary: " + result);

      sc.close();
   }
   
   public static void BinaryToString() throws Exception{
      Scanner sc = new Scanner(System.in);
      String binaryInput; String[] ASCII; String[] Binary; String[] binarySplit;
      String result = "";

      System.out.print("Introduce the binary to be converted separated by spaces: ");
      binaryInput = sc.nextLine();

      binarySplit = binaryInput.split(" ");
      
      ASCII = readCharactersFile();
      Binary = readBinaryFile(); 
      
      for(int i = 0; i < binarySplit.length; i++){
         for(int j = 0; j < Binary.length; j++){
            if(binarySplit[i].equals(Binary[j])){
               result += ASCII[j];
            }
         }
      }
      System.out.println("Binary converted to text: " + result);

      sc.close();
   }

   public static String[] readCharactersFile() throws Exception{
      Scanner scASCII = new Scanner(new File("ascii.txt"));
      String content = "";
      String[]characters;

      while (scASCII.hasNext()) {
			content += scASCII.nextLine() + " ";
      }
      characters = content.split(" "); 

      scASCII.close();

      return characters; 
      
   }

   public static String[] readBinaryFile() throws Exception{
      Scanner scBinary = new Scanner(new File("binary.txt"));
      String content = "";
      String[]characters;

      while (scBinary.hasNext()) {
			content += scBinary.nextLine() + " ";
      }
      characters = content.split(" "); 

      scBinary.close();

      return characters; 
      
   }
}