from pattern.es import parse, split
from pattern.en import pprint
from pattern.en import ngrams
from pattern.en import tag
import pandas as pd
import numpy as np
from PIL import Image
from wordcloud import WordCloud, STOPWORDS, ImageColorGenerator
import matplotlib.pyplot as plt

## Example, cleaning data from excel
#df = pd.read_excel("Comentarios.xlsx", na_values={
#    "Materia": ["-", "n.a"],
#    "Evaluación": ["-1"]
#})

df = pd.read_excel("Comentarios.xlsx", na_values = ["-", "n.a"])


## Number of rows           ## Number o columns
#print(df.shape[0])         #print(df.shape[1])

## Read first two rows
#print(df.iloc[0:2])

## Read a specific location
#print(df.iloc[0, 0])

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

for key in teacherDict:
    items = teacherDict[key]
    comment = items[2]
    
    #Extracting nouns(NN), verbs(VB), adjectives(JJ) and adverbs(RB)
    #from the original comment
    relevant_words = ""
    for word, pos in tag(comment):
        print(word + " " + pos)
        if pos == "NN" or pos == "VB" or pos == "JJ" or pos == "RB":
            relevant_words += " " + word

    print("Relevant: " + relevant_words)

    wordcloud = WordCloud().generate(relevant_words)
    plt.imshow(wordcloud, interpolation='bilinear')
    plt.axis("off")
    plt.show()