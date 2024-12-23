package Trees;

import java.util.*;
public class BinaryTree 
{
    private static class Node 
    {
        int val;
        Node left;
        Node right;

        Node(int val)
        {
            this.val = val;
        }

    }

    public BinaryTree()
    {

    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.prettyDisplay();

        System.out.println("\n"+tree.heightCal(root));
    }    

    public static Node root;

    public void populate(Scanner sc)
    {
        System.err.println("Enter the root node: ");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node)
    {
        System.out.println("Do you want to enter the value left of "+node.val+ " ?");
        boolean left = sc.nextBoolean();       

        if(left)
        {
            System.err.println("Enter the value left of : "+node.val);
            int val = sc.nextInt();
            node.left = new Node(val); 
            populate(sc, node.left);
        } 

        System.out.println("Do you want to enter the right of " +node.val+" ?");
        boolean right = sc.nextBoolean();       

        if(right)
        {
            System.err.println("Enter the value right of: " + node.val);
            int val = sc.nextInt();
            node.right = new Node(val); 
            populate(sc, node.right);
        } 

    }

    public void display()
    {
        display(this.root, "");
    }

    private void display(Node node, String indent)
    {
        if(node==null)
        {
            return ;
        }

        System.out.println(indent + node.val);

        display(node.left, indent+" ");
        display(node.right, indent+" ");
    }

    void prettyDisplay()
    {
        prettyDisplay(root, 0);
    }
    void prettyDisplay(Node node, int level)
    {
        if(node==null)
        {
            return;
        }

        prettyDisplay(node.right, level+1);

        if(level!=0)
        {
            for(int i=0; i<level-1; i++)
            {
                System.out.print("|\t");
            }
            System.err.println("|----->"+node.val);
        }
        else
        {
            System.err.println(node.val);
        }

        prettyDisplay(node.left, level+1);
    }

    int findNext(int val, Node root)
    {
        if(root == null)
        return -1;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int levelSize = q.size();        

            for(int i=0; i<levelSize; i++)
            {
                Node node = q.poll();
                if(node.val == val)
                    return q.poll().val;

                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.left);
            }
            
        }
        return -1;
    }

    int diameter = 0;
    int heightCal(Node node)
    {
        if(node==null)
        return 0;

        int left = heightCal(node.left);
        int right = heightCal(node.right);

        int dia = left + right + 1;
        diameter = Math.max(diameter, dia);
        
        return Math.max(left, right) + 1;
    }

    void reverseOddLevel(Node root)
    {
        if(root == null)
        return;

        Deque<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int currLevel = 0;
        }
    }
}

