package Trees;

import java.util.Scanner;

public class BST 
{
    class Node
    {
        int val;
        int height;
        Node left;
        Node right;

        Node(int val)
        {
            this.val = val;
        } 
    }

    static Node root;

    BST()
    {

    }

    public static void main(String[] args) 
    {
        BST tree = new BST();
        int[] nums = {1, 2, 3, 4};
        // tree.populate(nums);
        // tree.display();
        System.out.println();
        // tree.inOrder(root);
        // tree.postOrder(root);

    }

    int height(Node node)
    {
        if(node == null)
        {
            return -1;
        }
        return node.height;
    }

    Node root()
    {
        return this.root;
    }

    boolean isEmpty()
    {
        return root==null;
    }

    public void insert(int value)
    {
        root = insert(value, root);
    }

    public void populate(int[] nums)
    {
        for(int i=0; i<nums.length; i++)
        {
            insert(nums[i]);
        }        
    }


    public Node insert(int value, Node node)
    {
        if(node==null)
        {
            return new Node(value);
        }

        if(value>node.val)
        {
            node.right = insert(value, node.right);
        }

        if(value<node.val)
        {
            node.left = insert(value, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return  node;
    }

    public void display()
    {
        display(root, "Root Node: ");
    }

    void display(Node node, String details)
    {
        if(node == null)
        return ;

        System.out.println(details + node.val);

        display(node.left, "Left child of "+node.val+" : ");
        display(node.right, "Right child of "+node.val+" : ");
    }

    public boolean balanced(Node node)
    {
        if(node == null)
        {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    void preOrder(Node node)
    {
        if(node == null)
        return;

        System.out.println(node.val);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node)
    {
        if(node == null)
        return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }


    public void postOrder(Node node)
    {
        if(node == null)
        return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    Node 
}

