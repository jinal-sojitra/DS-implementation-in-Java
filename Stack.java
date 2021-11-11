import java.util.Scanner;

/**
 *
 * @author JINAL SOJITRA
 */

public class Stack_Operations {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of Stack");
        int n=sc.nextInt();
        int ch;
        Stack s=new Stack(n);
        do{
            System.out.println("Enter choice: 1 - push, 2 - pop, 3 - peek, 4 - Traverse ");
            ch=sc.nextInt();
	    switch(ch){
                case 1:{
                    s.push();
                    break;}
		case 2:{
                    s.pop();
                    break;}
		case 3:{
                    s.peek();
                    break;}
		case 4:{
                    s.show();
                    break;}	
                default:System.out.println("Invalid Choice");
	    }
	}
	while(ch!=0);       
  }
    
}

class Stack{
    Scanner sc=new Scanner(System.in);
    int[] st;
    Stack(int n){
       st=new int[n];
    }
    int top=-1;
    
    void push(){
        if(isFull()){
            System.out.println("Stack is Overflow!!");
        }
        else{   
            int data=sc.nextInt();
            st[++top]=data;
        }
    }
    
    void pop(){
        if(isEmpty()){
            System.out.println("Stack is Underflow!!");
        }
        else{
            int data=st[top];
            st[top]=0;
            top--;
            System.out.println("Poped element: "+data);
        }
    }
    
    void peek(){
        int data=st[top];
        System.out.println("Peek element is"+data);
    }
    void show(){
        for(int i:st)
            System.out.print(i+" ");
        System.out.println();
    }
    
    void size(){
        System.out.println(top-1);
    }
    
    boolean isEmpty(){
       return top==-1;
    }
    boolean isFull(){
       return top==st.length;
    }
    
}
