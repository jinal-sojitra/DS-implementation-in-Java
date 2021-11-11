import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

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

public class BinarySearchTree {
    static Node constructor(int[] a, int l, int h){
        if(l>h)
            return null;
        int mid=(l+h)/2;
        int data=a[mid];
        Node lc=constructor(a,l,mid-1);
        Node rc=constructor(a,mid+1,h);
        Node node=new Node(data,lc,rc);
        return node;
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
  
    static int sizeBST(Node node){
        if(node==null)
            return 0;
        int ls=sizeBST(node.left);
        int rs=sizeBST(node.right);
        int ts=ls+rs+1;
        return ts;
    
    }
    
    static int sumBST(Node node){
        if(node==null)
            return 0;
        int lsum=sumBST(node.left);
        int rsum=sumBST(node.right);
        int tsum=lsum+rsum+node.data;
        return tsum;
    
    }
    
    static int maxBST(Node node){
        //always in rightside
        if(node.right!=null){
            return maxBST(node.right);
        }
        else{
            return node.data;
        }
    }
    
    static int minBST(Node node){
        if(node.left!=null){
            return minBST(node.left);
        }
        else{
            return node.data;
        }
    }
    
    static boolean search(Node node,int data){
        //height of perfect bst
        if(node==null)
            return false;
        if(data>node.data)
            return search(node.right,data);
        else if(data<node.data)
            return search(node.left,data);
        else
            return true;
    }
    
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     int[] arr={41,53,18,72,63,38,71,79,47,54};
     Node root=constructor(arr,0,arr.length-1);
     System.out.println("Level Order Traversal: ");
     levelOrder(root);
     System.out.println();
     System.out.println("size: "+sizeBST(root));
     System.out.println();
     System.out.println("sum: "+sumBST(root));
     System.out.println();
     System.out.println("max: "+maxBST(root));
     System.out.println();
     System.out.println("min: "+minBST(root));
     System.out.println();
     System.out.print("Enter element you want to search: ");
     int s=sc.nextInt();
     System.out.println("found: "+search(root,s));
    }
}
