#TODO: Lemmatize verbs and singularize nouns
#TODO: extract the sentence following the adverb "no"s

from pattern.es import parse, split
from pattern.es import tag
from pattern.en import pprint
#import nltk
import pandas as pd
import numpy as np
from PIL import Image
from wordcloud import WordCloud, STOPWORDS, ImageColorGenerator
import matplotlib.pyplot as plt
import networkx as net

## Example, cleaning data from excel
#df = pd.read_excel("Comentarios.xlsx", na_values={
#    "Materia": ["-", "n.a"],
#    "Evaluación": ["-1"]
#})

df = pd.read_excel("Comentarios.xlsx", na_values = ["-", "n.a"])

## Number of rows           ## Number of columns
#print(df.shape[0])         #print(df.shape[1])

## Read first two rows      ## Read a specific location
#print(df.iloc[0:2])        #print(df.iloc[0, 0])

## Read by specific tags
#print(df.loc["Materia"] == "Física")

## Reading columns
#print(df[fields])
#print(df[["Profesor"]])

teacherDict = {}
teacher_key = 0

for index, row in df.iterrows():

    teacher_name = row["Profesor"]
    teacher_course = row["Materia"]
    teacher_comment = row["Comentario"]
    teacher_rec = row["Rec"]

    teacher_data = {
        teacher_key: [teacher_name, teacher_course, teacher_comment, teacher_rec]
    }
    teacherDict.update(teacher_data)
    teacher_key += 1

low_rec_common = ""
high_rec_common = ""

for key in teacherDict:
    items = teacherDict[key]
    comment = items[2]
    commentArr = comment.split()

    #Extracting nouns(NN), verbs(VB), adjectives(JJ) and adverbs(RB)
    #from the original comment
    relevant_words = ""

    wordCounter = 0
    for word, pos in tag(comment):
        #print(word + " " + pos)
        if pos == "NN" or pos == "NNS" or pos == "VBN" or pos == "VB" or pos == "JJ" or pos == "RB" and word != "no":
            relevant_words += " " + word
        #If an adverb is the word "no", we want to know the next words to get a more complete sentence
        elif pos == "RB" and word == "no" :
            nextWord = commentArr[wordCounter+1]
            previousWord = commentArr[wordCounter-1]
        
            print("Word after 'no': " + word + " " + nextWord)
            print("Word before 'no': " + previousWord + " " + word)
            
            relevant_words += " " + word + " " + nextWord

        wordCounter += 1
        
    #print("Relevant: " + relevant_words)
    items.append(relevant_words)

    print("Cloud from: " + items[0])
    if items[3] < 5:
        print("Low rec, rec: " + str(items[3]))
        low_rec_common += relevant_words
    if items[3] >= 5:
        print("High rec, rec: " + str(items[3]))
        high_rec_common += relevant_words
        
    wordcloud = WordCloud(background_color="white").generate(relevant_words)
    plt.imshow(wordcloud, interpolation='bilinear')
    plt.axis("off")
    plt.show()

print("Cloud from: Low rec teachers")

wordcloud = WordCloud(background_color="white").generate(low_rec_common)
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis("off")
plt.show()

#tokens = [t for t in low_rec_common.split()]
#freq = nltk.FreqDist(tokens)
#freq.plot(20, cumulative=False)

print("Cloud from: High rec teachers")

wordcloud = WordCloud(background_color="white").generate(high_rec_common)
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis("off")
plt.show()

#graph = networkx.Graph()
#add_node()
#add_edge()