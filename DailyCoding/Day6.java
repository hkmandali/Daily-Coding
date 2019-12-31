package DailyCoding;

import java.util.HashMap;
// one of the best questions I have done till now
/*
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.
 */
public class Day6 {
    class Node{
        int data;
        int xor_ptr; // we maintain the address as integers
        int mem_address; // this is used in the hashmap to iterate through the list as we dont have pointers
    }

    Node Head = null;
    static HashMap<Integer,Node> addrtoNode = new HashMap<>(); // this map stores the address versus Node data
    // as we don't have the address concept in java , we need to store the address versus data mapping , we can do this in hashmap
    // i.e similar to cpp , we store the data at each address in a hashmap as we cant store the node using address directly
    static int address_counter=1; //this plays a major role as this the info reg the address of each node
    void add(int element)
    {
        Node newNode = new Node();
        if(Head == null)
        {
            newNode.data = element;
            newNode.xor_ptr = 0;
            newNode.mem_address = address_counter;
            this.Head = newNode;
        }
        else
        {
            Node current = Head;
            Node prev = null;
            Node next;
            while(current != null)
            {
                int next_address = current.xor_ptr ^ (prev == null ? 0 : prev.mem_address);
                prev = current;
                current = addrtoNode.getOrDefault(next_address, null);
            }

            newNode.data = element;
            newNode.xor_ptr = 0 ^ prev.mem_address;
            newNode.mem_address = address_counter;

            prev.xor_ptr = address_counter ^ prev.xor_ptr;
        }
        System.out.println("inseritng "+address_counter +"    "+newNode.data);
        addrtoNode.put(address_counter,newNode);
        address_counter++;
        return;
    }

    void traversal()
    {
        Node current = this.Head;
        Node prev = null;
        Node next;
        while(current != null)
        {
            System.out.println(current.data+" ");

            int next_addr =  current.xor_ptr ^ (prev == null ? 0: prev.mem_address);
            System.out.println("current xor ptr is  "+current.xor_ptr+"  prev mem adrress is  "+(prev == null ? 0: prev.mem_address)+"   next is  "+next_addr);
            next =  addrtoNode.getOrDefault(next_addr,null);
            prev = current;
            current =next;
        }
    }

    public static void main(String[] args)
    {
        Day6 obj =new Day6();
        obj.add(1);
        obj.add(5);
        obj.add(6);
        obj.add(46);
        obj.add(43);

        obj.traversal();


        Day6 obj2 =new Day6();
        obj2.add(11);
        obj2.add(51);
        obj2.add(61);
        obj2.add(416);
        obj2.add(413);

        obj2.traversal();
    }
}
