//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends




/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node reverse(Node head){
        Node curr = head, prev = null, nextNode = curr.next;
        while(true){
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            if(curr != null) nextNode = curr.next;
            else break;
        }
        return prev;
    }
    Node compute(Node head)
    {
        // return reverse(head);
        Node temp = reverse(head), temp1 = temp, res = temp;
        temp = temp.next;
        while(temp != null){
            if(temp.data >= temp1.data){
                temp1.next = temp;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        temp1.next = null;
        return reverse(res);
    }
}
   