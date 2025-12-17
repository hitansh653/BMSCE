#include <stdio.h>
#include <stdlib.h>
struct Node{
    struct Node *next, *prev;
    int data;
} *start = NULL;

struct Node* create_ll(struct Node* start){
    struct Node *newNode, *ptr;
    int num;
    printf("\nEnter -1 to end: ");
    printf("\nEnter a num: ");
    scanf("%d", &num);
    while(num != -1){
        if(start == NULL){
            newNode = (struct Node*)malloc(sizeof(struct Node));
            newNode->prev = NULL;
            newNode->next = NULL;
            newNode->data = num;
            start = newNode;
        }
        else{
            ptr = start;
            newNode = (struct Node*)malloc(sizeof(struct Node));
            newNode->data = num;
            while(ptr->next != NULL){
                ptr = ptr->next;
            }
            ptr->next = newNode;
            newNode->prev = ptr;
            newNode->next = NULL;
        }
        printf("\nEnter the data: ");
        scanf("%d", &num);
    }
    return start;
};

struct Node* display(struct Node* start){
    struct Node* ptr;
    ptr = start;
    while(ptr != NULL){
        printf("\t%d", ptr->data);
        ptr = ptr->next;
    }
    return start;
};

struct Node * insert_before(struct Node* start) {
    struct Node *ptr, *newNode;
    int num, val;
    printf("\nEnter the data: ");
    scanf("%d", &num);
    printf("\nEnter the value before which the data has to be inserted: ");
    scanf("%d", &val);

    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = num;
    ptr = start;

    if(start == NULL) {
        printf("List is empty.\n");
        return start;
    }

    while(ptr != NULL && ptr->data != val) {
        ptr = ptr->next;
    }

    if(ptr == NULL) {
        printf("Value not found in list.\n");
        free(newNode);
        return start;
    }

    if(ptr == start) {
        newNode->next = start;
        newNode->prev = NULL;
        start->prev = newNode;
        start = newNode;
    } else {
        newNode->next = ptr;
        newNode->prev = ptr->prev;
        ptr->prev->next = newNode;
        ptr->prev = newNode;
    }
    
    return start;
}

struct Node* delete(struct Node* start) {
    struct Node *ptr;
    int val;
    printf("\nEnter the value which must be deleted: ");
    scanf("%d", &val);
    
    ptr = start;

    while(ptr != NULL && ptr->data != val) {
        ptr = ptr->next;
    }

    if(ptr == NULL) {
        printf("\nValue not found.");
        return start;
    }


    if(ptr == start) {
        start = start->next;
        if(start != NULL) {
            start->prev = NULL;
        }
    }

    else if(ptr->next == NULL) {
        ptr->prev->next = NULL;
    }

    else {
        ptr->prev->next = ptr->next;
        ptr->next->prev = ptr->prev;
    }
    
    free(ptr);
    return start;
}
int main() {
    int option;

    while(1) {
        printf("\n\n***** MAIN MENU *****");
        printf("\n1. Create List");
        printf("\n2. Display List");
        printf("\n3. Insert Before a Value");
        printf("\n4. Delete a Value");
        printf("\n5. Exit");
        printf("\nEnter your option: ");
        scanf("%d", &option);

        switch(option) {
            case 1:
                start = create_ll(start);
                printf("\nList Created.");
                break;
            case 2:
                printf("\nCurrent List:\n");
                start = display(start);
                break;
            case 3:
                start = insert_before(start);
                break;
            case 4:
                start = delete(start);
                break;
            case 5:
                printf("\nExiting...");
                exit(0);
            default:
                printf("\nInvalid option! Please try again.");
        }
    }
    return 0;
}