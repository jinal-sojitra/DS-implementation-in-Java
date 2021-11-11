import java.util.Scanner;
/**
 *
 * @author JINAL SOJITRA
 */
class Node{
    private int data;
    private Node next;
    public Node(){
      data=0;
      next=null;
    }

  public Node(int d,Node n){
      data=d;
      next=n;
  }

  public void setData(int d){
      data=d;
  }

  public void setNext(Node n){
      next=n;
  }

  public int getData(){
      return data;
  }

  public Node getNext(){
      return next;
  }

}

class LinkedList{
    private int size;
    private Node head;

    public LinkedList(){
        size=0;
        head=null;
    }

    public void insertAtFirst(int val){
        Node n=new Node();
        n.setData(val);
        n.setNext(head);
        head=n;
        size++;
    }

    public void insertAtLast(int val){
        Node n=new Node();
        n.setData(val);
        Node t=head;
        if(t==null)
            t=n;
        else{
            while(t.getNext()!=null)
                t=t.getNext();
            t.setNext(n);
        }
        size++;
    }

    public void insertAt(int pos,int val){
        if(pos==1)
            insertAtFirst(val);
        else if(pos==size+1)
            insertAtLast(val);
        else if(pos>1 && pos<=size){
            Node n=new Node(val,null);
            Node t=head;
            for(int i=1;i<pos-1;i++)
               t=t.getNext();
            n.setNext(t.getNext());
            t.setNext(n);

            size++;
        }
        else
            System.out.println("Insertion at this Position Not Possible!!!");

    }

    public void deleteAtFirst(){
        if(head==null)
            System.out.println("List is Empty!!");
        else{
            head=head.getNext();
            size--;
        }
    }

    public void deleteAtLast(){
        if(head==null)
            System.out.println("List is Empty!!");
        else if(size==1){
            head=null;
            size--;
        }
        else{
            Node t=head;
            for(int i=1;i<size-1;i++)
               t=t.getNext();
            t.setNext(null);
            size--;
        }
    }

    public void deletAtPosition(int pos){
        if(head==null)
            System.out.println("List is Empty!!");
        else if(pos>size ||pos<1)
            System.out.println("Invalid Position!!");
        else if(pos==size)
            deleteAtLast();
        else if(pos==1)
            deleteAtFirst();
        else{
            Node t,t1;
            t=head;
            for(int i=1;i<pos-1;i++)
              t=t.getNext();
            t1=t.getNext();
            t.setNext(t1.getNext());
            size--;
        }

    }

    public boolean isEmpty(){
        if(head==null)
            return true;
        else
            return false;
    }

    public int getListSize(){
        return size;
    }

    public void viewList(){
        Node t=head;
        if(isEmpty()){
            System.out.println("Linked list is Empty!!!");
        }
        else{
            t=head;
            while(t != null){
                System.out.println(t.getData()+" ");
                t=t.getNext();
            }
        }
    }

}
public class list {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        while(true){
            System.out.println("Enter Your Choice: ");
            System.out.print("1 : Add Item at Start\n2 : Add Item at Last\n3 : Add Item at Any Position\n");
            System.out.print("4 : Delete First Item\n5 : Delete Last Item\n6 : Delete at any Position\n7 : View List\n");
            int choice=sc.nextInt();
            int position;
            int val;
            switch(choice){
                case 1:
                    System.out.println("Enter value");
                    val=sc.nextInt();
                    list.insertAtFirst(val);
                    break;
                case 2:
                    System.out.println("Enter value");
                    val=sc.nextInt();
                    list.insertAtLast(val);
                    break;
                case 3:
                    System.out.println("Enter Position");
                    position=sc.nextInt();
                    System.out.println("Enter value");
                    val=sc.nextInt();
                    list.insertAt(val, position);
                    break;
                case 4:
                    list.deleteAtFirst();
                    break;
                case 5:
                    list.deleteAtLast();
                    break;
                case 6:
                    System.out.println("Enter Position");
                    position=sc.nextInt();
                    list.deletAtPosition(position);
                    break;
                case 7:
                    list.viewList();
                    break;
                default:
                    System.out.println("Invalid choice !!");
            }        
        }
    }  
}
