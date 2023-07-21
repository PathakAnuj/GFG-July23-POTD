//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


struct node
{
    int data;
    struct node* next;
    
    node(int x){
        data = x;
        next = NULL;
    }
    
};

/* Function to print linked list */
void printList(struct node *node)
{
    while (node != NULL)
    {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}


// } Driver Code Ends

/*
  Reverse a linked list
  The input list will have at least one element  
  Return the node which points to the head of the new LinkedList
  Node is defined as 
    struct node
    {
        int data;
        struct node* next;
    
        node(int x){
            data = x;
            next = NULL;
        }
    
    }*head;
*/

class Solution
{
    public:
    struct node* reverse(struct node* head, int k) {
    struct node* current = head;
    struct node* next = NULL;
    struct node* prevTail = NULL;
    struct node* newHead = NULL;
    int count = 0;

    // Get the count of nodes in the linked list
    int listSize = 0;
    while (current != NULL) {
        listSize++;
        current = current->next;
    }

    // Reset current to the head of the linked list
    current = head;

    // Iterate through the linked list and reverse groups of k nodes
    while (count < listSize) {
        int groupSize = k;
        struct node* prev = NULL;
        struct node* tail = current;

        while (groupSize > 0 && current != NULL) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
            groupSize--;
            count++;
        }

        // Update the head of the new linked list
        if (newHead == NULL) {
            newHead = prev;
        }

        // Connect the previous group's tail to the current group's head
        if (prevTail != NULL) {
            prevTail->next = prev;
        }

        // Save the tail of the current group to be used in the next iteration
        prevTail = tail;
    }

    return newHead;
}

};

//{ Driver Code Starts.

/* Drier program to test above function*/
int main(void)
{
    int t;
    cin>>t;
     
    while(t--)
    {
        struct node* head = NULL;
        struct node* temp = NULL;
        int n;
        cin >> n;
         
        for(int i=0 ; i<n ; i++)
        {
            int value;
            cin >> value;
            if(i == 0)
            {
                head = new node(value);
                temp = head;
            }
            else
            {
                temp->next = new node(value);
                temp = temp->next;
            }
        }
        
        int k;
        cin>>k;
        
        Solution ob;
        head = ob.reverse(head, k);
        printList(head);
    }
     
    return(0);
}


// } Driver Code Ends