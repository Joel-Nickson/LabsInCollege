#include <stdio.h>

//palindrome
void stringpal(char s1[]){
  int i=0,c=0,j;
  while(s1[i+1]!='\0'){
    ++i;
  }
  --i;
  for(j=0;j<i;j++,i--){
    if(s1[i]!=s1[j]){
      c=1;break;
    }
  }
  if(c==0)
    printf("You have got a palindrome string;\n");
  else
    printf("Not a palindrome string;\n");
}
int main(){
  //input
  printf("\nPress 0 to exit or type in the next string you want to test\n");
  printf("\nString 1: ");
  int ans=1;
  while(ans!=0){
    char s1[50];
    fgets(s1,50,stdin);
    //string palindrome
    stringpal(s1);
    scanf("%d",&ans);
  }
}