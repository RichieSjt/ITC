#TODO: Lemmatize verbs and singularize nouns
#TODO: extract the sentence following the adverb "no"s

from pattern.es import parse, split
from pattern.es import tag as word_tag
import pandas as pd
import numpy as np
from PIL import Image
from wordcloud import WordCloud, STOPWORDS, ImageColorGenerator
import matplotlib.pyplot as plt
import networkx as net

def generate_word_cloud(data):
    wordcloud = WordCloud(background_color="white").generate(data)
    plt.imshow(wordcloud, interpolation='bilinear')
    plt.axis("off")
    plt.show()

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

    #Lemmatizing the comment to generalize words
    lemmatized_comment = ""
    parsed_comment = parse(comment, tokenize = False, tags = False, relations = False, chunks = False, lemmata = True, tagset = None)
    for sentence in parsed_comment.split():
        for token, tag, lemma in sentence:
            lemmatized_comment += lemma + " "

    tagged_comment = word_tag(lemmatized_comment)

    #Extracting nouns(NN), verbs(VB), adjectives(JJ) and adverbs(RB)
    #from the original comment
    relevant_words = ""
    current_word_counter = 0
    for word, pos in tagged_comment:
        #print(word + " " + pos)
        if pos == "NN" or pos == "NNS" or pos == "VBN" or pos == "VB" or pos == "JJ" or pos == "RB" and word != "no":
            relevant_words += " " + word

        #If an adverb is the word "no", we recover the following word
        elif pos == "RB" and word == "no" :
            local_counter = current_word_counter + 1
            next_word = tagged_comment[local_counter][0]
            next_tag = tagged_comment[local_counter][1]

            #Searches for the next relevant word after "no"
            while(True):
                if(next_tag == "VB" or next_tag == "NN" or next_tag == "MD"):
                    break
                local_counter += 1
                next_tag = tagged_comment[local_counter][1]
                next_word = tagged_comment[local_counter][0]

            if(next_word == "ser" or next_word == "haber"):
                next_word = tagged_comment[local_counter][0] + "X" + tagged_comment[local_counter + 1][0]
                tagged_comment[local_counter + 1] = ["none", "none"]

            #The words from the extracted sentence should not be taken into account
            #in following iterations to avoid repetitions and noise generation
            tagged_comment[local_counter] = ["none", "none"]

            relevant_words += " " + word + "X" + next_word
        
            print("Next word: noX" + next_word + "------------------------------------")
        current_word_counter += 1
        
    #print("Relevant: " + relevant_words)
    items.append(relevant_words)

    print("Cloud from: " + items[0])
    if items[3] < 5:
        print("Low rec, rec: " + str(items[3]))
        low_rec_common += relevant_words
    if items[3] >= 5:
        print("High rec, rec: " + str(items[3]))
        high_rec_common += relevant_words
    
    generate_word_cloud(relevant_words)

#Bueno para recursar
#Es buena debatiendo pero
print("Cloud from: Low rec teachers")
generate_word_cloud(low_rec_common)

#tokens = [t for t in low_rec_common.split()]
#freq = nltk.FreqDist(tokens)
#freq.plot(20, cumulative=False)

print("Cloud from: High rec teachers")
generate_word_cloud(high_rec_common)

#graph = networkx.Graph()
#add_node()
#add_edge()