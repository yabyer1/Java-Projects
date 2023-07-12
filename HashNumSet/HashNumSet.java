import java.util.Objects;
import java.util.LinkedList;
import java.lang.*;
@SuppressWarnings({"unused", "unchecked"})
public class HashNumSet<E extends Number> implements NumSet<E>{
     int SpaceUsed = 0; //Keep track of what index we are on and have occupied, for size
    int totalSpace = 0; //Total space in array
     LinkedList<ListNode> [] x; //ListNode array which will be used
    @SuppressWarnings("rawtypes")
   // @SuppressWarnings("unchecked")
   public HashNumSet(int initialCapacity){ //Constructor which initializes our array with capacity parameter
    
        totalSpace = initialCapacity;
       
          x = new LinkedList[totalSpace];
        for(int i = 0; i < initialCapacity; i++){
            x[i] = new LinkedList<ListNode>();
        }
    }
      @SuppressWarnings("unchecked") //to prevent warning
    public boolean add(E e){
         Number g = (Number) e; //typecast to work
        if(Objects.isNull(g)) {
    throw new NullPointerException(); //check if null
  //  Block of code to handle errors
}
      
     if(contains((E) g)){ //If we already have the element then return false, so we maintian Hash Set property
          return false; 
       }
       int index = hash(g);
      
       LinkedList<ListNode> list = x[index];
       ListNode temp = new ListNode(g);
       list.addFirst(temp);
       /*
       if(x[index].get(0).next == null && x[index].get(0).getItem() == null){
           ListNode temp = new ListNode(g);
           x[index].add(temp);
       }
       else{
       while(runner.next != null){
           runner = runner.next;
       }
         ListNode temp = new ListNode(g);
         runner.next = temp;
    }
    */
     SpaceUsed++;
     if( (double) SpaceUsed / totalSpace > .75){ //If we are out of space make some more
                AddSpace();
            }
     return true;
    }
      @SuppressWarnings("unchecked") //to prevent warning
    private int hash(Number element){
        int elemen = element.intValue();
        int index = elemen % totalSpace;
        return index;
    }

    // return the size of the underlying array
    public int capacity(){
        return totalSpace;
    }
  @SuppressWarnings("unchecked") //to prevent warning
    // return true if given element e is in the set
    // throws NullPointerException if element e is null
    public boolean contains(E g){
    if(Objects.isNull(g)) {
    throw new NullPointerException();
  //  Block of code to handle errors
}
        Number e = (Number) g;
        int index = hash(e);
        LinkedList<ListNode> list = x[index];
        for(ListNode runner : list){
            if(runner.getItem().equals(e)){
                return true;
            }
           
        }
       return false;
    }
      @SuppressWarnings("rawtypes")
   //   @SuppressWarnings("unchecked") //to prevent warning
      public void AddSpace(){ //Method to add space by increasing size of array by 2
       totalSpace =  totalSpace * 2;
      LinkedList<ListNode>[] temp = new LinkedList[totalSpace];
        for(int i = 0; i < totalSpace; i++){
            temp[i] = new LinkedList<ListNode>();
        }
        for(int i = 0; i < x.length; i++){
            for(ListNode runner : x[i]){
                int newIndex = hash(runner.getItem());
                LinkedList<ListNode> list = temp[newIndex];
                list.addFirst(runner);
                /*
                ListNode ans = new ListNode(runner.getItem());
                   if(temp[newIndex].get(0).next == null && temp[newIndex].get(0).getItem() == null){
                 temp[newIndex].add(ans);
                }
       else{
           ListNode secondRunner = temp[newIndex].get(0);
       while(secondRunner.next != null){
           secondRunner = secondRunner.next;
       }
         runner.next = ans;
    }
         */      
            }
        }
        x = temp;
    }
    // remove an element e from the set if it exists in the set
    // return true if an element was removed (set changed)
    // throws NullPointerException if element e is null
      @SuppressWarnings("unchecked") //to prevent warning
    public boolean remove(E g){
           if(Objects.isNull(g)) {
    throw new NullPointerException();
  //  Block of code to handle errors
}
               Number e = (Number) g;
                if (contains((E) e)){
                    int index = hash(e);
                    LinkedList<ListNode> list = x[index]; 
                   ListNode runner2 = null;
                    for(ListNode runner1 : list){
                   if(runner1.getItem().equals(e)){
                       if(runner2 == null){
                          list.removeFirst();
                       }
                       else{
                      runner2.next = runner1.next;
                       }
                       SpaceUsed--;
                    return true;
                   }
                   runner2 = runner1;
                    }
                   
                }
                return false;
    }

  @SuppressWarnings("unchecked") //to prevent warning
    // return the set size (number of elements in set)
    public int size(){
        return SpaceUsed;
    }
}