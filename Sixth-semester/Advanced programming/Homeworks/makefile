# Estudiantes:
# Ricardo Juárez, Eduardo Herrera

flip: flip.o getopt.o
	gcc -s -o flip flip.o getopt.o
flip.getopt: getopt.c
	gcc -DBSD -DNDEBUG -O -c getopt.c
flip.o: flip.c flip.h
	gcc -DBSD -DNDEBUG -O -c flip.c
man: flip flip.1
	nroff -man flip.1 > flip.man
clean:
	rm*~ 