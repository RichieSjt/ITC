#include <stdio.h>
#include <string.h>

void removeLastChar(char *s){
  static char temp[500]; int i = 0;

  while (i < strlen(s)-1) {
    temp[i] = s[i];
    i++;
  }
  temp[i] = '\0';

  strcpy(s, temp);
}

int main(void) {

  char expression[500] = "", let[500] = "", sym[500] = "", res[500] = "";
  int test_cases = 0, i = 0, j = 0;

  scanf("%i", &test_cases);

  for(i = 0; i < test_cases; i++) {
    scanf("%s", expression);
    
    for(j = 0; j < strlen(expression);j++) {
      char c = expression[j];
      if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
        strncat(sym, &c, 1);
      }else if((int)c >= 97 && (int)c <= 122) {
        strncat(let, &c, 1);
      }else if(c == ')') {
        char last_letter = sym[strlen(sym)-1];
      
        strcat(let, &last_letter);
        strcat(res,let);
        
        removeLastChar(sym);
        memset(let, 0, strlen(let));
      }
    }
    strcat(res, sym);
    printf("%s\n", res);
    memset(res, 0, strlen(res));
  }
  return 0;
}