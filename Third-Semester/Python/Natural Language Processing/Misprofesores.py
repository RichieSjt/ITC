#Reference: https://likegeeks.com/es/tutorial-de-nlp-con-python-nltk/

import urllib.request
from bs4 import BeautifulSoup
from nltk.tokenize import word_tokenize, sent_tokenize
from nltk.corpus import stopwords
import nltk
import matplotlib

stop_words = set(stopwords.words("spanish"))

response = urllib.request.urlopen('https://www.misprofesores.com/profesores/Jorge-Yesua-Anistro-Jimenez_61068')
html = response.read()
soup = BeautifulSoup(html, "html5lib")
#print(soup.prettify()) #Prints the whole html
text = soup.get_text(strip=True)

tokens = [t for t in text.split()] #Obtaining all of the document tokens

freq = nltk.FreqDist(tokens) #Frequency of each of the tokens
 
for key,val in freq.items():
    print (str(key) + ':' + str(val))

freq.plot(20, cumulative=False)
