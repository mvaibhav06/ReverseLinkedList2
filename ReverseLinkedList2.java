public class ReverseLinkedList2 {


    class Solution {
        public LinkedList.Node reverseBetween(LinkedList.Node head, int m, int n) {
            if(m==n) return head;
            LinkedList.Node left = null;

            if(m!=1) {
                left = head;
                for (int i = 1; i < m - 1; i++) {
                    left = left.next;
                }
            }
            LinkedList.Node right = head;
            LinkedList.Node temp1 = null;
            for (int i=0; i<n; i++){
                if (i==n-1){
                    temp1 = right;
                }
                right = right.next;
            }
            // if m=1 then we need to reverse from first node
            // if right is null .... it means we need to reverse till the tail
//        System.out.println(temp.value);
            temp1.next = null;
            LinkedList.Node newHead = null;
            if(left!=null){
                newHead = left.next;
            }else{
                newHead = head;
            }
            // Reversing a list

            LinkedList.Node current = newHead;
            LinkedList.Node nextNode = current.next;
            LinkedList.Node temp = null;
            current.next = null;
//        1 2 3 4 5
            while (current!=null ){

                if (nextNode.next !=null){
                    temp = nextNode.next;
                }
                nextNode.next = current;

                if (temp!=null){
                    current = nextNode;
                    nextNode = temp;
                    temp = null;
                }else {
                    current = null;
                }
            }

            newHead = nextNode;

            if (left!=null){
                left.next = newHead;
            }else{
                head = newHead;
            }

            if(right==null) return head;
            LinkedList.Node tempNode = head;
            while (tempNode.next !=null){
                tempNode = tempNode.next;
            }
            tempNode.next = right;

            return head;
        }
    }

    public static void main(String[] args) {
        LinkedList mylist = new LinkedList(1);
        mylist.append(2);
        mylist.append(3);
        mylist.append(4);
        mylist.append(5);


    }
}
