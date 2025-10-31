#include <stdio.h>
#define N 4

int queue[N], front = -1, rear = -1;

void insert() {
    int num;
    printf("\nEnter the number to be inserted into queue: ");
    scanf("%d", &num);

    if ((rear + 1) % N == front) {
        printf("\nOVERFLOW (Queue is full)");
        return;
    }

    if (front == -1)
    { // First element
        front = rear = 0;
        queue[rear] = num;
    }
    else
    {
        rear = (rear + 1) % N;
        queue[rear] = num;
    }


}

int deleteNum() {
    int val;

    if (front == -1) {
        printf("\nUNDERFLOW (Queue is empty)");
        return -1;
    }

    val = queue[front];

    if (front == rear) {
        front = rear = -1; // queue becomes empty
    } else {
        front = (front + 1) % N;
    }

    return val;
}

void display() {
    int i;

    if (front == -1) {
        printf("\nQUEUE IS EMPTY\n");
        return;
    }

    printf("\nQueue elements are:\n");

    i = front;
    while (1) {
        printf("%d\t", queue[i]);
        if (i == rear)
            break;
        i = (i + 1) % N;
    }

    printf("\n");
}

int main() {
    int val, option;

    do {
        printf("\n\nMAIN MENU: ");
        printf("\n1. Insert Element");
        printf("\n2. Delete Element");
        printf("\n3. Display Queue");
        printf("\n4. EXIT");
        printf("\nEnter your option: ");
        scanf("%d", &option);

        switch (option) {
            case 1:
                insert();
                break;

            case 2:
                val = deleteNum();
                if (val != -1)
                    printf("\nThe number deleted is: %d", val);
                break;

            case 3:
                display();
                break;

            case 4:
                printf("\nExiting program...\n");
                break;

            default:
                printf("\nInvalid option! Please try again.");
        }
    } while (option != 4);

    return 0;
}
