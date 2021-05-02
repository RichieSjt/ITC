#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <signal.h>

int received = 0;

int busca(char **palabras, char * palabra, int inicio, int fin, int pid) {
  char *quien = pid == 0 ? "hijo" : "padre";
  int veces = 0;
  for(int i = inicio; i < fin; i++) {
    if(strcmp(palabra, palabras[i]) == 0) {
      veces++;
      //printf("el proceso %s encontró la palabra %s\n", quien, palabra);
      if(pid == 0) {
        // Enviando una señal desde el proceso hijo
        received = 1;
        kill(pid, SIGHUP);
      }else{
        printf("PADRE: he encontrado una palabra que coincide %s\n", palabra);
      }
    }
  }
  return veces;
}

void sighup(int signum) {
  if(received){
    printf("HIJO: he encontrado una palabra que coincide\n");
  }
  received = 0;
}

int main() {
  char *palabras[] = {"hola", "adios","no-se", "hola", "hola", "hola","aa", "hola"};
  int tamanio = sizeof(palabras)/sizeof(char*);
  int mitad = tamanio/2;

  signal(SIGHUP, sighup);

  int pid = fork();
  if(pid != 0) {
    // estamos en el proceso padre

    int n = busca(palabras, "hola", 0, mitad, pid);
    int status;
    wait(&status);
    printf("%x  %x\n", status, status >> 8);
    status = WEXITSTATUS(status);
    printf("El total de veces que se encontró la palabra fue %d\n", n + status);
  }
  else {
    // estamos en el proceso hijo
    int n = busca(palabras, "hola", mitad, tamanio, pid);
    exit(n);
  }
  
  return 0;
}