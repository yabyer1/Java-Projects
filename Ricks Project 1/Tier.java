 //Abhay Iyer AXI210015 RICKS PROJECT 1!

  public interface Tier { /**All basic info which will be replicated within the classes*/
        
        public abstract int getMiles(); /**Get Miles */
        public abstract void setMiles(int newMiles); /**Set Miles */
        public abstract int gcf(); /**getcancelledflights*/
        public abstract void scf(int newSCF); /** set the cancelled flights*/
        public abstract int getFlights(); /**Get the total flights */
        public abstract void addFlight(boolean isCancelled); /**Will be used to keep track fo both total fligthts as well as cancelled flights */
         public  abstract boolean getMM(); /**gets the Mileage Multiplier*/
         public abstract void setMM(boolean x); /**Sets the Mileage multiplier*/
        public abstract void setFlights(int x); /**Sets the total Flights*/
            
    
    }