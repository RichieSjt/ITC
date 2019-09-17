print("PAEFBA \n" * 2)
x = 1
y = 22
print("x: " + str(x) + " y:" + str(y))
x, y = 12, 4
print("x: " + str(x) + " y:" + str(y))

print("Memory address of variable x: " + str(id(x)))

l = [34, 2, 9, 3, "hola", True]
l.append(23)
l.append(3)

print(l)

l.remove(True)
l.remove("hola")
l.sort()

print(l)

print("List length: " + str(len(l)))
l.append("Bruh")

word = "Bruh this is epic"
print(word)

print(word[0:4]) #Both of these expresions are equal
print(word[:4])

print(word[0:]) #When you dont complete the end index it puts the length of the string
print(word[0])
print(word[-1])

message = """ 
The triple quotes
can be used like
this
"""

print(message)

first_name = "Ricardo"
last_name = "Juarez"
# full = first_name + " " + last_name #Es posible concatenar de esta manera pero es mas eficiente de la siguiente
full = f"{first_name} {last_name}"
print(full)

#full = first_name + 2 No es posible concatenando de manera normal

full = f"{first_name} {2}"
print(full)

print(word.upper())
print(word.lower())
print(word.title())

example = "        UwU" 
print(example.strip()) #Removes blank spaces  
print(word.find("epic")) #Regresa el índice de inicio de la letra o palabra en el string
print(word.replace("Bruh", "Fokiu")) #Replaces strings or letters in a String
print("epic" in word)
print("epic" not in word)

###----Binary-----###

binary = 0b10101001 #Convierte el numero de binario a decimal
print(binary)

binary = 169
print(bin(binary))

###----Hexadecimal----###
hexa = 0x342f #Convierte el numero de hexadecimal a decimal
print(hexa)

hexa = 13359
print(hex(hexa))

