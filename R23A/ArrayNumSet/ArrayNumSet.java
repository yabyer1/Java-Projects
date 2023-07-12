import java.util.Objects;

public class ArrayNumSet<E extends Number> implements NumSet<E>{ // Arraynumset implements NumSet which uses the generic value E that extends the Number class
    int index = 0; //Keep track of what index we are on and have occupied, for size
    int totalSpace = 0; //Total space in array
   Number[] x; //Number array which will be used
    public ArrayNumSet(int initialCapacity){ //Constructor which initializes our array with capacity parameter
      x = new Number[initialCapacity];
        totalSpace = initialCapacity;
    }
    // add an element e to the set if it does not already exist in the set
    // return true if this set did not already contain the specified element
    // throws NullPointerException if element e is null
    @SuppressWarnings("unchecked") //to prevent warning
    public boolean add(E g){
        Number e = (Number) g; //typecast to work
        if(Objects.isNull(e)) {
    throw new NullPointerException(); //check if null
  //  Block of code to handle errors
}
      if(index == totalSpace){ //If we are out of space make some more
                AddSpace();
            }
     if(contains((E) e)){ //If we already have the element then return false, so we maintian Hash Set property
          return false; 
       }
            x[index] = e; 
            index++; //Add and go to next
            return true;
}
    public void AddSpace(){ //Method to add space by increasing size of array by 2
        totalSpace = totalSpace * 2;
        Number[] temp = new Number[totalSpace];
        for(int i = 0; i < index; i++){
            temp[i] = x[i];
        }
        x = temp;
    }
    // return the size of the underlying array
    public int capacity(){
        return totalSpace;
    }
    
    // return true if given element e is in the set
    // throws NullPointerException if element e is null
    public boolean contains(E g){
             if(Objects.isNull(g)) {
    throw new NullPointerException();
  //  Block of code to handle errors
}
        Number e = (Number) g;
            for(int i = 0; i < index; i++){ //Go through the occupied spots in array, and see if the parameter is in the array
                if(x[i].equals(e)){
                    return true;
                }
            }
  //  Block of code to try
      
      
  //  Block of code to handle errors

       return false;
    }
    
    // returns the element at the specified index in this list
    // throws IndexOutOfBoundsException is index is negative or >= size()
    @SuppressWarnings("unchecked")
    public E get(int i ){
        if(i < 0 || i >= index){
            throw new IndexOutOfBoundsException();
        }
        else{
            return (E) x[i]; //Return the item at index, typecasted to E
        }
    }

    // remove an element e from the set if it exists in the set
    // return true if an element was removed (set changed)
    // throws NullPointerException if element e is null
  @SuppressWarnings("unchecked")
    public boolean remove(E g){ //Remove the item if it is within the array, if removed, make sure to decrease size used, and the index we are at. 
             if(Objects.isNull(g)) {
    throw new NullPointerException();
  //  Block of code to handle errors
}
        Number e = (Number) g;
                if (contains( (E) e)){
                    int j = 0;
                    Number[] temp = new Number[totalSpace - 1];
                    for(int i = 0; i < index; i++){
                        if(x[i].equals(e)){
                            continue;
                        }
                        temp[j++] = x[i];
                    }
                    x = temp;
                   // totalSpace--;
                    index--;
                    return true;
                }
                else{
                    return false;
                }
            }


    
    // return the set size (number of elements in set)
    public int size() {return index;}
}