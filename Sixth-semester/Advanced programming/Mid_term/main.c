#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "buildfiles.h"
#include "readfiles.h"

int main(void) {
  char word[500] = "";

  printf("Word to search: ");
  scanf("%s", word);

  buildFiles();
  searchWordPositions(word);

  return 0;
}