from nltk.tokenize import sent_tokenize, word_tokenize

example = "Irure incididunt tempor officia quis nulla nisi excepteur do cupidatat ut. Aliquip adipisicing nisi ullamco voluptate aliqua veniam excepteur magna veniam sit cillum exercitation fugiat quis. Commodo ullamco sunt exercitation labore Lorem aliqua duis do ea ullamco et labore in. Voluptate deserunt culpa minim commodo veniam minim eiusmod. Veniam aliqua enim et dolore officia do id. Ad id officia ex deserunt excepteur cupidatat consectetur enim."
for i in sent_tokenize(example):
    print(i)