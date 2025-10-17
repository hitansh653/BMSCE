#include <stdio.h>
#define N 10
int front = -1, rear = -1, queue[N];
void insert()
{
    int num;
    printf("Enter the number to add to the queue: ");
    scanf("%d", &num);
    if (rear == N-1)
    {
        printf("\n OVERFLOW");
    }
    else if (front == -1 && rear == -1)
    {
        front = rear = 0;
    }
    else
    {
        rear++;
    }
    queue[rear] = num;
}

int deleteNum()
{
    int val;
    if (front == -1 || front > rear)
    {
        printf("\n UNDERFLOW");
        return -1;
    }
    else
    {
        val = queue[front];
        front++;
        if(front>rear)
        {
            front = rear = -1;
        }
        return val;
    }
}

void display()
{
    if (front == -1 || front>rear)
    {
        printf("\n QUEUE IS EMPTY");
    }
    else
    {
        for (int i = 0; i<N; i++)
        {
            printf("\t %d", queue[i]);
        }
    }
}

int main()
{
    int option, val;
    do
    {
        printf("\n\n MAIN MENU: ");
        printf("\n 1. Insert an element");
        printf("\n 2. Delete an element");
        printf("\n 3. Display the entire queue");
        printf("\n 4. EXIT");
        printf("\n Enter your option: ");
        scanf("%d", &option);
        switch(option)
        {
            case 1:
                insert();
                break;
            case 2:
                printf("\t %d", deleteNum());
                break;
            case 3:
                display();
                break;
        }
    }while (option != 4);
}
