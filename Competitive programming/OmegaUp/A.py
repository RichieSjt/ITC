numberOfLines = input()
coded_msg = ""
decoded_msg = ""

if(numberOfLines < 3 or numberOfLines > 20):
    pass
else:
    for i in range(0, numberOfLines):
        coded_msg += raw_input()

    for counter in range(15, len(coded_msg), 16):
        if(coded_msg[counter] == "X" and (coded_msg[counter-1] == "I" or coded_msg[counter-1] == "O")):
            pass
        else:
            decoded_msg += coded_msg[counter]
      
    if(len(decoded_msg) > 8):

        if(decoded_msg[0:8] == "CUADRADO"):
            number = ord(decoded_msg[8]) - 64
            for i in range(0, number):
                print("*" * 10 + "\n")

        elif(decoded_msg[0:8] == "PIRAMIDE"):
          number = ord(decoded_msg[8]) - 64
          space = number - 1
          star = 1
          for i in range(0, number):
            print((" " * space) + ("*" * star) + "\n")
            space -= 1
            star += 2

        elif(decoded_msg[0:9] == "TRIANGULO"):
          number = ord(decoded_msg[9]) - 64
          for i in range(0, number):
            print("*" * (i+1) + "\n")
      
    else:
        print(decoded_msg)