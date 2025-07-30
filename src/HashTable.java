import java.util.*;
class HashTables
{
    public static void main(String[] args)
    {
        Hashtable<Integer, String> ssnTable = new Hashtable<>();
        Enumeration<Integer> ssns;
        int ssn;
        String name;

        //put is O(1)
        ssnTable.put(123456789, "Zara");
        ssnTable.put(234567890, "Zoey");
        ssnTable.put(345678901, "Tony");
        ssnTable.put(456789012, "Olive");
        ssnTable.put(567890123, "Zach");
        ssnTable.put(678901234, "Stranger");
        ssnTable.put(789012345, "Stranger2");
        ssnTable.put(890123456, "Stranger3");
        //displays all ssns in hash table.
        //.keys() gives us all of the keys in the list.
        //The order we recieve ssns is undefined.  Note it is different order.
        //get is O(1)
        ssns = ssnTable.keys();
        while(ssns.hasMoreElements())
        {
            ssn = (Integer) ssns.nextElement();
            System.out.println(ssn + ": " );
            ssnTable.get(ssn);
        }
    }
}
