public class Main
{
	public static void main(String[] args) {
		NumSet<Integer> numSet = new HashNumSet<>(10);
	
		numSet.add(210);
        numSet.add(90);
        numSet.add(95);
        numSet.add(170);
        numSet.add(171);
        numSet.remove(170);
    //    NumSet.contains(321);
	}
}
