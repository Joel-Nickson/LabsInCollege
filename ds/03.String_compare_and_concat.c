
#include <stdio.h>
void stringcat(char s1[],char s2[]){
  // concatinator
  int i=0,j=0;
  while(s1[i+1]!='\0'){
    ++i;
  }
  for(j=0; s2[j]!='\0'; ++j, ++i){
    s1[i]=s2[j];
  }
  s1[i]='\0';
  printf("Concatinated string: %s",s1);
}
void stringcom(char s1[],char s2[]){
  int i=0;
  while((s1[i]!='\0')||(s2[i]!='\0')){
    if((s1[i+1]=='\0')||(s2[i+1]=='\0')){
      printf("0 -->equal strings");
    }
    else if(s1[i]>s2[i]){
      printf("1 -->first string is greater than the second");
      break;
    }
    else if(s1[i]<s2[i]){
      printf("-1 -->first string is lesser than the second");
      break;
    }
    i++;
  }
  printf("(charcter value)\n");
}

int main(){
  //input
  int ans=1;
  printf("\nPress 1000 to exit or type in the next string you want to test\n\n");
  while(ans!=1000){
    printf("String 1: ");
    char s1[50];
    fgets(s1,50,stdin);
    printf("String 2: ");
    char s2[50];
    fgets(s2,50,stdin);
    //copy arry
    int i;
    char s3[50];
    for (i=0;s1[i]!='\0';++i){
      s3[i] = s1[i];
    }
    s3[i] = '\0';
    //string concatinator
    stringcat(s3,s2);
    //string comparer
    stringcom(s1,s2);
    scanf("%d",&ans);
  }
}