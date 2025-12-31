#include <stdio.h>
#include <stdlib.h>

// Define the structure for an Employee Record
struct Record {
    int key;          // 4-digit Key
    char name[50];    // Employee Name
    int status;       // 0 = Empty, 1 = Occupied
};

// Function to insert a record into the Hash Table
void insert(struct Record *ht, int m, int key, char *name) {
    int index = key % m; // Hash Function: H(K) = K mod m
    int originalIndex = index;
    int i = 0;

    // Linear Probing: Check for collision
    // Loop continues if the current slot is occupied (status == 1)
    while (ht[index].status == 1) {
        
        // If the key already exists, we might want to update or reject.
        // For this simple example, we reject duplicates.
        if (ht[index].key == key) {
            printf("Duplicate key %d found. Insertion skipped.\n", key);
            return;
        }

        printf("Collision at index %d for key %d. Probing next...\n", index, key);
        
        // Linear Probing logic: (H(K) + i) mod m
        index = (index + 1) % m;
        
        // If we have traversed the whole table and came back to start, table is full
        if (index == originalIndex) {
            printf("Hash Table is full! Cannot insert key %d.\n", key);
            return;
        }
    }

    // Found an empty slot
    ht[index].key = key;
    // Copy string safely
    snprintf(ht[index].name, sizeof(ht[index].name), "%s", name);
    ht[index].status = 1; // Mark slot as occupied

    printf("Key %d inserted at address %d.\n", key, index);
}

void display(struct Record *ht, int m) {
    printf("\n--- Hash Table Contents ---\n");
    printf("Addr\tStatus\tKey\tName\n");
    printf("--------------------------------\n");
    for (int i = 0; i < m; i++) {
        if (ht[i].status == 1) {
            printf("%d\tOccupied\t%d\t%s\n", i, ht[i].key, ht[i].name);
        } else {
            printf("%d\tEmpty\t-\t-\n", i);
        }
    }
    printf("--------------------------------\n");
}

int main() {
    int m, n;

    printf("Enter the size of Hash Table (m): ");
    scanf("%d", &m);

    // Using calloc to allocate memory and initialize status to 0
    struct Record *ht = (struct Record *)calloc(m, sizeof(struct Record));

    if (ht == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    printf("Enter the number of employee records (N): ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int key;
        char name[50];
        
        printf("\nEnter details for Record %d:\n", i + 1);
        printf("Enter Key (4-digit): ");
        scanf("%d", &key);
        printf("Enter Name: ");
        scanf("%s", name);

        insert(ht, m, key, name);
    }

    display(ht, m);

    // Free allocated memory
    free(ht);

    return 0;
}