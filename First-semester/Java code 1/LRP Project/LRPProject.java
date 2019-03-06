import twitter4j.*;
import twitter4j.auth.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;

public class LRPProject{
	public static void main(String[] args) throws Exception{
		Twitter twitter = TwitterFactory.getSingleton(); 
		twitter.setOAuthConsumer("htrF7t0ZPMrOa5eaAvQSrryhk", "dpAAo4x6itUymbolNBjQAAkobwI9sM9jjIGc9JMg2gTnYxWNPc");
		AccessToken accessToken = new AccessToken("4813745316-l1kzew716QVYE24tLDnjfZFqXAEAK4mpD7azl2b",  "D82An2mek0qhJLyGfeJBGwNFCc6NexeYdZEFBHJZPJlcA");
		twitter.setOAuthAccessToken(accessToken);

		
		System.out.print("SEARCH: ");
		Query query = new Query(System.console().readLine());
				QueryResult result = twitter.search(query);		
		for (Status status : result.getTweets()) {
			String classifiedMessage = classifyMessage(status.getText());
			//String[] keywordsArray = showKeywords(status.getText());
			if (classifiedMessage.equals("Unknown")) {
				System.out.println("\n----- NON-CLASSIFIED TWEET -----");
				System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
				System.out.println("* Category: " + classifiedMessage);
				System.out.println("* Keyword(s): ");
				System.out.println("----- Press ENTER to skip -----");
				System.out.print("-- Enter a classification [positive, negative or neutral]: ");
				String newClassification = System.console().readLine();
				System.out.print("-- Enter keyword(s) separated by spaces: ");
				String newKeywords = System.console().readLine();
				storeKeywords(newKeywords, newClassification);
			}else {
				System.out.println("\n--------------------------------");
				System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
				System.out.println("* Category: " + classifiedMessage);
				System.out.println("* Keyword(s): ");
				/*for (int i=0; i<keywordsArray.length; i++) {
					System.out.printf("%-2s", keywordsArray[i]);
				}
				System.out.println();*/
			}
			//break;
		}
	}


	public static String classifyMessage(String message) throws Exception {
		String category = null;

		Scanner positiveTXT = new Scanner(new File("positive.txt"));
		Scanner negativeTXT = new Scanner(new File("negative.txt"));
		Scanner neutralTXT = new Scanner(new File("neutral.txt"));
		
		String positiveContent = "", negativeContent = "", neutralContent = "";

		while (positiveTXT.hasNext()) {
			positiveContent += positiveTXT.nextLine() + "\n";
		}
		while (negativeTXT.hasNext()) {
			negativeContent += negativeTXT.nextLine() + "\n";
		}
		while (neutralTXT.hasNext()) {
			neutralContent += neutralTXT.nextLine() + "\n";
		}

		String[] positiveList = positiveContent.split("\n");
		String[] negativeList = negativeContent.split("\n");
		String[] neutralList = neutralContent.split("\n");


		String[] textArray = message.toLowerCase().split(" ");
		int countPositive=0, countNegative=0, countNeutral=0;

		for (int i=0; i<textArray.length; i++) {
			for (int j=0; j<positiveList.length; j++) {
				if (textArray[i].equals(positiveList[j])) {
					countPositive++;
				}
			}
			for (int j=0; j<negativeList.length; j++) {
				if (textArray[i].equals(negativeList[j])) {
					countNegative++;
				}
			}
			for (int j=0; j<neutralList.length; j++) {
				if (textArray[i].equals(neutralList[j])) {
					countNeutral++;
				}
			}
		}


		if (countPositive>countNegative && countPositive>countNeutral) {
			category = "Positive";
		}else if (countNegative>countPositive && countNegative>countNeutral) {
			category = "Negative";
		}else if (countNeutral>countPositive && countNeutral>countNegative) {
			category = "Neutral";
		}else if (countPositive==0 && countNegative==0 && countNeutral==0) {
			category = "Unknown";
		}else {
			category = "Unknown";
		}

		positiveTXT.close();
		negativeTXT.close();
		neutralTXT.close();
		return category;
	}


	public static void storeKeywords(String keywords, String classification) throws Exception {
		Scanner scKeywords = new Scanner(keywords);
		Scanner scClassification = new Scanner(classification);

		while (scKeywords.hasNext() && scClassification.hasNext()) {
			Scanner scTXT = new Scanner(new File(classification + ".txt"));
			String content = "";

			while (scTXT.hasNext()) {
				content += scTXT.nextLine() + "\n";
			}

			String[] arrayKeywords = keywords.toLowerCase().split(" ");

			for (String word : arrayKeywords) {
				content += word + "\n";
			}

			String[] lines = content.split("\n");


			FileWriter fwKeywords = new FileWriter(new File(classification+".txt"));
			
        	for (String key : lines) {
				fwKeywords.write(key + "\r\n");
			}

			
			fwKeywords.close();
			scTXT.close();
			break;
		}
	}
}