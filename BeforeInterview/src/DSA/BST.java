package DSA; /**
 * Created by ARPIT JOHRI on 17-11-2016.
 */
import java.util.Stack;

class bstNode{
    int data;
    bstNode left;
    bstNode right;
}

public class BST {

    private static bstNode root;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {

        root = Insert(root,40);
        root = Insert(root,20);
        root = Insert(root,8);
        root = Insert(root,25);
        root = Insert(root,22);
        root = Insert(root,30);
        root = Insert(root,55);
        root = Insert(root,48);
        root = Insert(root,60);
        root = Insert(root,58);
        root = Insert(root,65);

//        allPathFromRootToLeaf(root);
//        Preorder(root);
//        System.out.println();
//        System.out.printf("%d\n",minElem(root.right));
//        System.out.printf("%d",maxElem(root));
        //root=Delete(root,15);
//        System.out.println(HeightBST(root));
        //Postorder(root);

    }

    /*
    To check if a tree is a Binary Search Tree or not, we can check its inorder Traversal
    if it comes out sorted(ascending) then its a valid BST else not !
     */

    private static void Inorder(bstNode root){
        if(root==null)
            return;
        Inorder(root.left);
        System.out.printf("%d ",root.data);
        Inorder(root.right);
    }
    private static void Preorder(bstNode root){
        if(root==null)
            return;
        System.out.printf("%d ",root.data);
        Preorder(root.left);
        Preorder(root.right);
    }
    private static void Postorder(bstNode root){
        if(root==null)
            return;
        Postorder(root.left);
        Postorder(root.right);
        System.out.printf("%d ",root.data);
    }

            /**Traversals End here*/

    private static int HeightBST(bstNode root){
        if(root==null)
            return -1;
        int left = HeightBST(root.left);
        int right = HeightBST(root.right);
        return Math.max(left,right)+1;
    }

    private static bstNode Insert(bstNode root,int data){

        if (root==null){
            bstNode newNode = new bstNode();
            newNode.data=data;
            newNode.left=newNode.right=null;
            root=newNode;
            return root;
        }

        if (data<=root.data){
            root.left=Insert(root.left,data);
        }
        else{
            root.right=Insert(root.right,data);
        }
        return root;
    }

    private static bstNode Search(bstNode root, int data){

        if(root.data==data){
            return root;
        }
        else if(data<=root.data){
            return Search(root.left,data);
        }
        else
            return Search(root.right,data);
    }

    private static int minElem(bstNode node) {

        int min = node.data;
        if(node.left != null) {
            min = Math.min(min, minElem(node.left));
        }
        if(node.right != null) {
            min = Math.min(min, minElem(node.right));
        }
        return min;
    }

    private static int maxElem(bstNode node) {
        int max = node.data;
        if(node.left != null) {
            max = Math.max(max, maxElem(node.left));
        }
        if(node.right != null) {
            max = Math.max(max, maxElem(node.right));
        }
        return max;
    }

    private static int min(bstNode node){
        if (node==null)
            return -1;
        else if(node.left==null)
            return node.data;
        return min(node.left);
    }
    private static int max(bstNode node){
        if (node==null)
            return -1;
        else if(node.right==null)
            return node.data;
        return max(node.right);
    }

    private static bstNode Delete(bstNode node, int data){

        if(node==null) return node;
        else if(data<node.data) node.left=Delete(node.left,data);
        else if(data>node.data) node.right=Delete(node.right,data);
        else{ //This means we have found the node to be deleted

            if(node.left==null&&node.right==null){ // both children are null
                node=null;
            }
            else if(node.left==null){ // left is null
                node=node.right;
            }
            else if(node.right==null){ // right is null
                node=node.left;
            }
            else{ // both children are not null
                /***either replace the node to be deleted with the max in left subtree or min in right subtree*/
                bstNode temp = Search(node,minElem(node.right));
                //bstNode temp = Search(node,maxElem(node.left));
                node.data=temp.data;
                Delete(node.right,temp.data);
                //Delete(node.left,temp.data); // delete the duplicate one in left or right subtree(as chosen)
            }

        }
        return node;
    }

    private static void allPathFromRootToLeaf(bstNode node){

        if (node==null)
            return;
        stack.push(node.data);
        allPathFromRootToLeaf(node.left);
        if (node.left==null && node.right==null){
            printStack();
        }
        allPathFromRootToLeaf(node.right);
        stack.pop();

    }

    private static void printStack() {
        for (int i = 0; i <stack.size(); i++) {
            System.out.printf(stack.get(i)+" ");
        }
        System.out.println();
    }


}
