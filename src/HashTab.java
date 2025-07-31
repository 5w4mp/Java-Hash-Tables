import java.util.LinkedList;
public class HashTab {
    private class Record {
        private Object key;
        private Object value;

        public Record() {
            this.key = null;
            this.value = null;
        }

        public Record(Object inKey, Object inData) {
            this.key = inKey;
            this.value = inData;
        }

        //Equality can be based on key alone because there can't be 2 records with the same key
        //in the table.
        public boolean equals(Object o) {
            if (o instanceof Record) {
                Record node = (Record) o;
                return this.key.equals(node.key);
            } else {
                return false;
            }
        }

        public String toString() {
            return "Key: [" + this.key + "] Value: [" + this.value + "]";
        }
        private int numElem;
        private LinkedList<Record> [] table;

        //constructor
        public void Hashtable(int realSize)
        {
            this.table = new LinkedList[realSize];
            this.numElem = 0;
        }
        private int hash(Object key)
        {
            // start with a base, just so that its not 0 for empty strings.
            int res = 42;

            String inputString = key.toString().toLowerCase();
            //System.out.pringln("hash string is: " +inputString+ "\n");

            char [] characters = inputString.toCharArray();
            for(int i = 0; i < characters.length; i++)
            {
                char currentChar = characters[i];
                int j = (int)currentChar;
                //Sys.out.println("j = " + j);
                res +=j;
            }
            return (res % this.table.length);
        }
        public void put(Object key, Object data)
        {
            boolean update = false;
            if(data == null || key == null)
            {
                System.err.println("ERROR: Either the key or the data is null. ");
                return;
            }

            // find out where in our array the new item goes.
            int pos = this.hash(key);
           // if nothing exists in this position, dreate a new linked list there.
            if(this.table[pos] == null){this.table[pos] = new LinkedList<Record>();}
            LinkedList<Record> theList = this.table[pos];
            // If we are trying to add duplicate keys, that means we like to update the value
            // associated with that existing key.
            // We first delete the existing mapping, then insert a new record for that key.
            if (  theList.contains(new Record(key, data)) )
            {
                theList.remove(new Record(key, data));
                update = true;
            }
            theList.add(new Record(key, data));
            if (!update)
            {
                this.numElem++;
            }
        }
        public void put(Object[] keys, Object [] inputData)
        {
            for (int i = 0; i < inputData.length; i++)
            {
                this.put(keys[i], inputData[i]);
            }
        }



    }



}

