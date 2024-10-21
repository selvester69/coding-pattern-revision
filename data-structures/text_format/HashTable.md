
public class HashTable {

    class Node{
        String key;
        int value;
        Node next;
        Node(String key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node[] dataMap;
    int size = 7;
    
    public HashTable(){
        this.dataMap = new Node[this.size];
    }
    public Node[] getDataMap() {
        return this.dataMap;
    }
    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(this.dataMap[i] != null) {
                Node temp = this.dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key,value);
        if(this.dataMap[index]==null){
            this.dataMap[index] = newNode;
        }else {
            Node temp = this.dataMap[index];
            while(temp.next!=null){
                if(temp.key==key){ //if key matched with existing key update the value
                    temp.value = value;
                    break;
                }
                temp = temp.next;
            }
            //update the value to the last value.
            temp.next = newNode;
        }
    }

   public int get(String key){
        int index = hash(key);
        Node temp = this.dataMap[index];
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;    
    }

    public ArrayList<String> keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i=0;i<this.dataMap.length;i++){
            if(this.dataMap[i]!=null){
                Node temp = this.dataMap[i];
                while(temp!=null) {
                    allKeys.add(temp.key);
                    temp = temp.next;
                }
            }
        }
        return allKeys;
    }
    

}