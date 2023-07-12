class Main{
    public static void main(String[] args){
        ArrayNumSet<Double> x = new ArrayNumSet<Double>(5);
          x.add(2.0);
          x.add(4.0);
          x.add(6.0);
          x.remove(6.0);
        System.out.println(x.size());
    }
}