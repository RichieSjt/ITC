//javac -cp twitter4j-core-4.0.7.jar;. SentimentA.java
//java -cp twitter4j-core-4.0.7.jar;. SentimentA

import twitter4j.*;
import twitter4j.auth.*;
import java.util.Scanner;
import java.io.*;

public class SentimentA {
    public static void main(String[] args)throws Exception {
        String toSearch, newClassification, newKeyword;
        String[] classifiedMessage; 

		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("htrF7t0ZPMrOa5eaAvQSrryhk", "dpAAo4x6itUymbolNBjQAAkobwI9sM9jjIGc9JMg2gTnYxWNPc");
		AccessToken accessToken = new AccessToken("4813745316-l1kzew716QVYE24tLDnjfZFqXAEAK4mpD7azl2b",  "D82An2mek0qhJLyGfeJBGwNFCc6NexeYdZEFBHJZPJlcA");
        twitter.setOAuthAccessToken(accessToken);

        System.out.print("Word to search: ");
        toSearch = System.console().readLine();

		Query query = new Query(toSearch);
        QueryResult result = twitter.search(query);
        
		for (Status status : result.getTweets()) {
            classifiedMessage = classifyMessage(status.getText()).split(" ");
            
            String keyword = classifiedMessage.length > 1 ? classifiedMessage[1] : "none";
            
            if (classifiedMessage[0].equals("unknown")){
                System.out.println("\n----- UNCLASSIFIED TWEET -----");
                System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
                System.out.println("Classification: " + classifiedMessage[0]);
                System.out.println("Keyword: " + keyword);
                System.out.println("----- Press ENTER to skip -----");
                System.out.print("Enter a classification [positive, negative, neutral]: ");
                newClassification = System.console().readLine();
                System.out.print("Enter keyword(s) separated by space: ");
                newKeyword = System.console().readLine();
                storeKeyword(newClassification, newKeyword);
                System.out.print("\n");

            }else{
                System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
                System.out.println("Classification: " + classifiedMessage[0]);
                System.out.println("Keyword: " + keyword);
                System.out.print("\n");
            }
		}
    }

    public static String classifyMessage(String message) throws Exception{
        String clasification = "Empty";
        String[] separate = message.toLowerCase().split(" ");
        String[] positive; String[] negative; String[] neutral;

        Scanner sc1 = new Scanner(new File("positive.txt"));
		Scanner sc2 = new Scanner(new File("negative.txt"));
		Scanner sc3 = new Scanner(new File("neutral.txt"));

        String positiveContent = ""; String negativeContent = ""; String neutralContent =""; 

        while (sc1.hasNext()) {
			positiveContent += sc1.nextLine() + "\n";
        }
        while (sc2.hasNext()) {
			negativeContent += sc2.nextLine() + "\n";
        }
        while (sc3.hasNext()) {
			neutralContent += sc3.nextLine() + "\n";
        }

        positive = positiveContent.split("\n");
        negative = negativeContent.split("\n");
        neutral = neutralContent.split("\n");

        for (int i=0 ; i < separate.length ; i++){
            
            for (int y = 0; y < positive.length ; y++){
                if (separate[i].equals(positive[y])){
                    clasification = "positive";
                    clasification += " " + positive[y];
                }
            }
            for (int y = 0; y < negative.length ; y++){
                if (separate[i].equals(negative[y])){
                    clasification = "negative";
                    clasification += " " + negative[y];
                }
            }
            for (int y = 0; y < neutral.length ; y++){
                if (separate[i].equals(neutral[y])){
                    clasification = "neutral";
                    clasification += " " + neutral[y];
                }
            }
        }

        if (clasification.equals("Empty")){
            clasification = "unknown";
        }
        sc1.close();
        sc2.close();
        sc3.close();
        return clasification;
    }

    public static void storeKeyword(String classification, String keyword) throws Exception{
        
        String[] keywordSplit = keyword.toLowerCase().split(" ");
        Scanner sc1 = new Scanner(new File(classification + ".txt"));
        String content = "";
        String[] newContent;
        
        while (sc1.hasNext()){
            content += sc1.nextLine() + "\n";
        }
        for(String addKeywords: keywordSplit){
            content += addKeywords + "\n";
        }

        newContent = content.split("\n");

        FileWriter fw = new FileWriter(new File(classification + ".txt"));
        for(String x : newContent){
            fw.write(x + "\r\n");
        }
        sc1.close();
        fw.close();
    }
}
