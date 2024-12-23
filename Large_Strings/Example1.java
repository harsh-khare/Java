package Large_Strings;

public class Example1 
{
    public static void main(String[] args) 
    {
        StringBuffer sb = new StringBuffer();
        sb.append("WeMakeDevs");
        sb.append(" is nice.");

        sb.insert(2, " Harsh ");
        System.out.println("\n" + sb.toString());
        
        sb.replace(1, 5, "Kushwaha");
        String str = sb.toString();
        System.out.println("\n" + str);

        sb.delete(1,5);
        System.out.println("\n" + sb.toString());

        sb.reverse();
        System.out.println("\n" + sb.toString());
    }    
}
