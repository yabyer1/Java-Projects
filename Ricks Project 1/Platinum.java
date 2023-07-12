//Abhay Iyer AXI210015 RICKS PROJECT 1!

 public  class Platinum implements Tier{ /**Platinum class will be used for passengers who qualify for platinum tier*/
               private int miles = 0;
        private int CancelledFlights = 0;
        private int Flights = 0;
          public boolean MM;
        @Override
        public void setMM(boolean bool){
            MM = bool;
        }
        
        @Override
         public boolean getMM(){
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
        public  void addFlight(boolean isCancelled){
                 CancelledFlights += (isCancelled) ? 1 : 0;
                 if(isCancelled){
                     setMiles(miles + 1000);
                 }
                Flights++;
        }
    }