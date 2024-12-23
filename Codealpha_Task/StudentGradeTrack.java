package Codealpha_Task;
import java.util.*;

public class StudentGradeTrack 
{    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of students");
        int c=sc.nextInt();

        System.out.println("Enter the number of grades you want to enter per student");
        int sizeG = sc.nextInt();

        LL list = new LL();

        do
        {
            System.out.println("Enetr the position at which you want to enter the data in the list");
            int ind = sc.nextInt();

            if(ind-1>list.size)
            {
                System.out.println("Wrong position");
                break;
            }

            System.out.println("Enetr the rollno. of the student");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.println("Enetr the name of the student");
            String name = sc.nextLine();

            list.insert(ind, name, roll, sizeG);
            c--;
        }while(c>0);

        list.display();

    }

    static class LL
    {
        Node head;
        Node tail;
        int size;
    
        LL()
        {
            this.size = 0;
        }
    
        void insertFirst(String name, int roll, int sizeG)
        {
            Node newNode = new Node(name, roll, sizeG);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the grades");
            for(int i=0; i<sizeG; i++)
            {
                newNode.grades[i] = sc.nextInt();
            }

            newNode.next = head;
            head = newNode;
        
            if(tail ==  null)
                tail = head;
        
            size++;
        }
    
        void insertLast(String name, int roll, int sizeG)
        {
            if(tail == null)
            {
                insertFirst(name, roll, sizeG);
                return;
            }
        
            Node node = new Node(name, roll, sizeG);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the grades");
            for(int i=0; i<sizeG; i++)
            {
                node.grades[i] = sc.nextInt();
            }

            tail.next = node;
            tail = node;
            size++;
        }
    
        void insert(int ind, String name, int roll, int sizeG)
        {
            Node temp = head;
            Node node = new Node(name, roll, sizeG);
            int i=1;
            
            if(ind == 1)
            {
                insertFirst(name, roll, sizeG);
                return;
            }
            if(ind == size)
            {
                insertLast(name, roll, sizeG);
                return;
            }
            
            while(i<ind)
            {
                temp = temp.next;
                i++;
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the grades");
            for(int j=0; j<sizeG; j++)
            {
                node.grades[j] = sc.nextInt();
            }
            if(temp!=null)
            {
                node.next = temp.next;
                temp.next = node;
            }
            size++;
        }
        
        

    
        void deleteFirst()
        {
            head = head.next;
            if(head==null)
                tail = head;
            
            size--;
        }
    
        void deleteLast()
        {
            if(size<=1)
            {
                deleteFirst();
                return;
            }
            
            Node temp = ref(size-2);
            tail = temp;
            tail.next = null;
            size--;
        }

        Node ref(int ind)
        {
            Node temp = head;
            for(int i=0; i<ind; i++)
            {
                temp = temp.next;
            }
            return temp;
        }
    
        void display()
        {
            System.out.print("Name\tRollNo.\t");
            for(int i=0; i<head.grades.length; i++)
            {
                System.out.print("Grade"+(i+1)+"\t");
            }
            System.out.println("Max\tMin\tAvg");
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.name+"\t"+temp.roll+"\t");
                for(int j=0; j<temp.grades.length; j++)
                {
                    System.out.print(temp.grades[j]+"\t");
                }
                track(temp.grades);
                System.out.println();
                temp = temp.next;
            }
            System.out.println("No. of students in the list "+size);
        }

        void track(int[] grades)
        {
            int max=grades[0];
            int min=grades[0];
            int sum=grades[0];
            for(int i=1; i<grades.length; i++)
            {
                max = Math.max(max,grades[i]);
                min = Math.min(min,grades[i]);
                sum = sum + grades[i];
            }

            System.out.print(max+"\t"+min+"\t"+(double)(sum/grades.length));
        }
    
        public class Node
        {
            String name;
            int roll;
            int[] grades;
            Node next;

            Node(String name, int roll, int size)
            {
                this.name = name;
                this.roll = roll;
                this.grades = new int[size];
            }

            Node(String name, int roll, int size, Node next)
            {
                this.name = name;
                this.roll = roll;
                this.grades = new int[size];
                this.next = next;
            }
        }
    }
    
}
