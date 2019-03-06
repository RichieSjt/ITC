import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(TRIG,GPIO.OUT)
GPIO.setup(ECHO,GPIO.IN)

TRIG = 23
ECHO = 24
GPIO_PIR = 7
LEDFAR = 6
LED2 = 13
LED3 = 19
LEDCLOSE = 26

print ("PIR Module basic test (CTRL -C to exit)")
GPIO.setwarnings(False)
GPIO.setup(GPIO_PIR, GPIO.IN)
GPIO.setup(GPIOLED, GPIO.OUT)
try:

    print ("Calibrando PIR...")
    time.sleep(1)
	print ("  Listo")
     
	while True :
	    if GPIO.input(GPIO_PIR):
            print("Se detecta presencia")

            GPIO.output(TRIG, False)
            print ("Obteniendo distancia")
            time.sleep(2)

            GPIO.output(TRIG, True)
            time.sleep(0.00001)
            GPIO.output(TRIG, False)

            while GPIO.input(ECHO)==0:
                pulse_start = time.time()

            while GPIO.input(ECHO)==1:
                pulse_end = time.time()

            pulse_duration = pulse_end - pulse_start

            distance = pulse_duration * 17150

            distance = round(distance, 2)

            print ("Distancia:",distance,"cm")

            if (distance >= 0 and distance <= 25):
                GPIO.output(LEDFAR,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED2,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED3,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LEDCLOSE,GPIO.HIGH)
	            time.sleep(0.5)
            elif (distance > 25 and distance <= 50):
                GPIO.output(LEDFAR,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED2,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED3,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LEDCLOSE,GPIO.LOW)
	            time.sleep(0.5)
            elif (distance > 50 and distance <= 75):
                GPIO.output(LEDFAR,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED2,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED3,GPIO.LOW)
	            time.sleep(0.5)
                GPIO.output(LEDCLOSE,GPIO.LOW)
	            time.sleep(0.5)
            elif (distance > 75):
                GPIO.output(LEDFAR,GPIO.HIGH)
	            time.sleep(0.5)
                GPIO.output(LED2,GPIO.LOW)
	            time.sleep(0.5)
                GPIO.output(LED3,GPIO.LOW)
	            time.sleep(0.5)
                GPIO.output(LEDCLOSE,GPIO.LOW)
	            time.sleep(0.5)
            else:
                GPIO.output(LEDFAR,GPIO.LOW)
                time.sleep(0.5)
                GPIO.output(LED2,GPIO.LOW)
                time.sleep(0.5)
                GPIO.output(LED3,GPIO.LOW)
                time.sleep(0.5)
                GPIO.output(LEDCLOSE,GPIO.LOW)
                time.sleep(0.5)
	    else:
	        print ("No hay presencia")
	        GPIO.output(LEDFAR,GPIO.LOW)
	        time.sleep(0.5)
            GPIO.output(LED2,GPIO.LOW)
	        time.sleep(0.5)
            GPIO.output(LED3,GPIO.LOW)
	        time.sleep(0.5)
            GPIO.output(LEDCLOSE,GPIO.LOW)
	        time.sleep(0.5)

except KeyboardInterrupt:
	   print("  Salir")

GPIO.cleanup()