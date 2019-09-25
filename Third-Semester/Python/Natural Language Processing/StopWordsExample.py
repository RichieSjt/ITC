from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

example = "Hola, hoy es un buen dia. Me lo estoy pasando bien."
stop_words = set(stopwords.words("spanish"))

print(stop_words)