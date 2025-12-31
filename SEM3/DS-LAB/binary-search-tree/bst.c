#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
    int value;
    struct Node *left, *right;
}Node;

Node* createTree(int value){
    Node *temp = (Node *)malloc(sizeof(Node));
    printf("Enter Data: ");
    scanf("%d", &temp->value);
    temp->left = temp->right = NULL;
    return temp;
}

void insert(Node* root, Node *temp){
    if(temp->value<root->value){
        if(root->left!=NULL){
            insert(root->left, temp);
        }
        else{
            root->left = temp;
        }
    }
    else if(temp->value>root->value){
        if(root->right != NULL){
            insert(root->right, temp);
        }
        else{
            root->right = temp;
        }
    }
}

void inorder(Node *root){
    if(root!=NULL){
        inorder(root->left);
        printf("%d", root->value);
        inorder(root->right);
    }
}

void preorder(Node *root){
    if(root!=NULL){
        printf("%d", root->value);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(Node *root){
    if(root!=NULL){
        postorder(root->left);
        postorder(root->right);
        printf("%d", root->value);
    }
}

Node* findMin(Node* root) {
    while (root->left != NULL)
        root = root->left;
    return root;
}

Node* deleteNode(Node* root, int key) {
    if (root == NULL)
        return root;

    if (key < root->value)
        root->left = deleteNode(root->left, key);
    else if (key > root->value)
        root->right = deleteNode(root->right, key);
    else {
        if (root->left == NULL) {
            Node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            Node* temp = root->left;
            free(root);
            return temp;
        }

        Node* temp = findMin(root->right);
        root->value = temp->value;
        root->right = deleteNode(root->right, temp->value);
    }
    return root;
}


int main(){
    Node *root = NULL;
    int choice;
    while(1){
        printf("\n1. Insert\n2. Inorder\n3. Preorder\n4. Postorder\n5. Delete Node\n6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch(choice){
            case 1:{
                Node *temp = createTree(0);
                if(root==NULL){
                    root = temp;
                }
                else{
                    insert(root, temp);
                }
                break;
            }
            case 2:{
                printf("Inorder Traversal: ");
                inorder(root);
                printf("\n");
                break;
            }
            case 3:{
                printf("Preorder Traversal: ");
                preorder(root);
                printf("\n");
                break;
            }
            case 4:{
                printf("Postorder Traversal: ");
                postorder(root);
                printf("\n");
                break;
            }
            case 5:{
                int key;
                printf("Enter value to delete: ");
                scanf("%d", &key);
                root = deleteNode(root, key);
                break;
            }
            case 6:{
                exit(0);
            }
            default:{
                printf("Invalid Choice!\n");
            }
        }
    }
    return 0;
}