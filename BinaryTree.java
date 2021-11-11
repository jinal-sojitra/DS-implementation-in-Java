import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author JINAL SOJITRA
 */
class Node{
    int data;
    Node left,right;
    
    Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}

class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node=node;
        this.state=state;
    }

}

public class BinaryTree {
    static void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+=node.left==null?".":node.left.data+"";
        str+=" <- "+node.data+ " -> ";
        str+=node.right==null?".":node.right.data+"";
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }
    
    static int size(Node node){
        if(node==null)
            return 0;
        int ls=size(node.left);
        int rs=size(node.right);
        int ts=ls+rs+1;
        return ts;
    
    }
    
    static int sum(Node node){
        if(node==null)
            return 0;
        int lsum=sum(node.left);
        int rsum=sum(node.right);
        int tsum=lsum+rsum+node.data;
        return tsum;
    
    }
    
    static int maxElement(Node node){
        if(node==null)
            return Integer.MIN_VALUE;
        int lmax=maxElement(node.left);
        int rmax=maxElement(node.right);
        int tmax=Math.max(node.data,Math.max(rmax, rmax));
        return tmax;
    
    }
    
    static int height(Node node){
        //node based
        if(node==null)
            return 0;
        int lheight=height(node.left);
        int rheight=height(node.right);
        int theight=Math.max(lheight, rheight)+1;
        return theight;
    
    }
    
    static void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
        
    }
    
    static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
        
    }
    
    static void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");     
    }
    
    static void levelOrder(Node node){
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int count=q.size();
            for(int i=0;i<count;i++){
            //remove, print, add
            node=q.remove();
            System.out.print(node.data+ " ");
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
            }
            System.out.println();
        }
        
    }
    
    static void inOrderArray(Node node,ArrayList<Integer> arr){
        if(node==null)
            return;
        inOrderArray(node.left,arr);
        arr.add(node.data);
        inOrderArray(node.right,arr); 
    }
    static boolean isBST(Node node){
        ArrayList<Integer> arr=new ArrayList<>();
        inOrderArray(node,arr);
        for(int i=1;i<arr.size();i++){
        if(arr.get(i)<arr.get(i-1))
            return false;
        }
        return true;
    }
    
    static void invertTree(Node node){
    if(node==null)
            return;
    Node temp=node.left;
    node.left=node.right;
    node.right=temp;
    invertTree(node.left);
    invertTree(node.right);
    }
    
    public static void main(String[] args){
    Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
    Node root=new Node(arr[0],null,null);
    Pair rtp=new Pair(root,1);
    Stack<Pair> st=new Stack<>();
    st.push(rtp);
    int ind=0;
    while(st.size()>0){
    Pair top=st.peek();
    if(top.state==1){
        ind++;
        if(arr[ind] !=null){
        top.node.left=new Node(arr[ind],null,null);
        //top.node.left=leftn;
        
        Pair leftp=new Pair(top.node.left,1);
        st.push(leftp);
        }
        else{
        top.node.left=null;
        }
        top.state++;
    }
    
    else if(top.state==2){
        ind++;
        if(arr[ind] !=null){
        top.node.right=new Node(arr[ind],null,null);
        
        Pair rightp=new Pair(top.node.right,1);
        st.push(rightp);
        }
        else{
        top.node.right=null;
        }
        top.state++;
    }
    
    else{
        st.pop();
    }
    
    }
    System.out.println("(Left Child <- Root ->Right Child) Structure: ");
    display(root);
    System.out.println();
    System.out.println("size: "+size(root));
    System.out.println();
    System.out.println("max Element: "+maxElement(root));
    System.out.println();
    System.out.println("height: "+height(root));
    System.out.println();
    System.out.println("sum: "+sum(root));
    System.out.println();
    System.out.println("preorder: ");
    preorder(root);
    System.out.println();
    System.out.println();
    System.out.println("inorder: ");
    inorder(root);
    System.out.println();
    System.out.println();
    System.out.println("postorder: ");
    postorder(root);
    System.out.println();
    System.out.println();
    System.out.println("Levelorder: ");
    levelOrder(root);
    System.out.println();
    System.out.println("isBST: "+isBST(root));
    invertTree(root);
    System.out.println();
    System.out.println("Level Order Traversal after inverting Tree:");
    levelOrder(root);
    }
}
