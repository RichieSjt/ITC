from nltk.tokenize import word_tokenize, sent_tokenize

example = "Fugiat aliquip commodo tempor dolor veniam labore eiusmod consequat. Aliquip officia non aliqua eiusmod. Aute ea laborum cupidatat Lorem ex anim sint labore sunt aliquip consectetur. Culpa nostrud in do quis mollit exercitation laboris do. Adipisicing est commodo esse labore dolor laboris. Laboris voluptate cupidatat nisi non. Velit nulla est officia sunt."
#print(sent_tokenize(example))
#print(word_tokenize(example))
for i in sent_tokenize(example):
    print(i)
 