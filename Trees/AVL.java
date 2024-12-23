package Trees;

import java.util.Scanner;

public class AVL
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

    AVL()
    {

    }

    public static void main(String[] args) 
    {
        AVL tree = new AVL();
        
        for(int i=0; i<1000; i++)
        {
            tree.insert(i);
        }

        System.out.println();
        System.out.println(tree.height(root));
        tree.display();
    }

    int height(Node node)
    {
        if(node == null)
        {
            return -1;
        }
        return node.height;
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
        return  rotate(node);
    }

    Node rotate(Node node)
    {
        if(height(node.left) - height(node.right) > 1)
        { // left heavy
            if(height(node.left.left) - height(node.left.right) > 0)
            { // left-left
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0)
            { // left-right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1)
        { // right heavy
            if(height(node.right.left) - height(node.right.right) < 0)
            { // right-right
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) < 0)
            { // right-left
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    Node rightRotate(Node p) 
    {
        Node c = p.left;
        Node t = c.right;
        
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        
        return c;
    }

    Node leftRotate(Node c)
    {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        
        return p;
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
}

