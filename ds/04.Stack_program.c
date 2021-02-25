#include <stdio.h>
 //inserting into a stack
int push(int n, int array[], int curr) {
  int i, val;
  if (curr < n) {
    printf("value to insert: ");
    scanf("%d", & val);
    array[curr] = val;
    curr++;
  } else
    printf("---Stack Overflow---\n");
  return curr;
}
//deleting an element from stack
int pop(int n, int array[], int curr) {
  if (curr > 0) {
    int num;
    curr--;
    //num=array[curr];
    printf("Top is poped");
  } else
    printf("---Stack Underflow---\n");
  return curr;
}
//displaying the stack elements
void display(int n, int array[], int curr) {
  int i;
  printf("Current Stack--> ");
  for (i = curr - 1; i > 0; i--) {
    printf("%d , ", array[i]);
  }
  printf("%d \n", array[i]);
}
int main() {
    int ans = 1;
    printf("Enter the total size of the Stack : ");
    int n;
    scanf("%d", & n);
    int array[100];
    int curr = 0;
    printf("\n**press** \n0 --> exit\n1 --> push \n2 --> pop , \n3 --> peek\n ** ** ** ** ** ** ** \n ");
      while (ans != 0) {
        printf("\nMenu ###: ");
        scanf("%d", & ans);
        switch (ans) {
        case 0:          break;
        case 1: curr = push(n, array, curr);
          				break;
        case 2: curr = pop(n, array, curr);
          				break;
        case 3: display(n, array, curr);
          				break;
        default: printf("$#*& Wrong Input &*#$");
        }
      }
      printf("\n*****************Exiting the stack****************");
    }