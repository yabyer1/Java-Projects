//Abhay Iyer AXI210015 RICKS PROJECT 1!

public class BaseTier implements Tier{ /**Basetier class will be used as a place holder class for all passengers who havent reached the next tier, class includes setters and getters, also some essential variables.*/
        /**
         * Miles will keep track of miles
         * Cancelled Flights keeps track of Cancelled Flights
         * Flights will keep track of all flights regardless of being CancelledFlights
         * MM keeps track if the mileage Multiplier is still applied
         * */
        
        
        private int miles = 0;
        private int CancelledFlights = 0;
        private int Flights = 0;
        public boolean MM = true;
        @Override 
        public void setMM(boolean x){ 
            MM = x;
        }
        @Override
      public  boolean getMM(){
            return MM;
        }
        @Override
          public  int getMiles(){
              return miles;
          }
            @Override
          public void setMiles(int newMiles){
              miles = newMiles;
          }
           @Override
          public void scf(int newscf){
              CancelledFlights = newscf;
          }
          
          @Override
        public  int gcf(){
            return CancelledFlights;
        }
        @Override
        public  int getFlights(){
            return Flights;
        }
        @Override
        public void setFlights(int x){
            Flights = x;
        }
       @Override
        public  void addFlight(boolean isCancelled){ /**AddFlight, and corresponding miles if it were cancelled*/
                CancelledFlights += (isCancelled) ? 1 : 0;
                if(isCancelled){
                     setMiles(miles + 1000);
                 }
                Flights++;
        }
    }