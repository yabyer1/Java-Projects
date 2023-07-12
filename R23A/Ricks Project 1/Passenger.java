//Abhay Iyer AXI210015 RICKS PROJECT 1!

public  class Passenger{ /**Passenger class will be used to keep track of essential characteristics of every passenger*/
        private Tier tier = new BaseTier(); /**Every passenger starts of at the base tier */
        private String tierstring = "Base";
        
        public void BaseToGold(){ /**Conversion methods to convert a passenger from one tier to the next, once they meet the criteria*/
        Tier newTier = new Gold();
        this.setTier("Gold");
        newTier.setMM(tier.getMM());
        newTier.setMiles(tier.getMiles());
        newTier.scf(tier.gcf());
        newTier.setFlights(tier.getFlights());
        this.tier = newTier;
        }
        public void GoldToPlatinum(){
        Tier newTier = new Platinum();
        this.setTier("Platinum");
        newTier.setMM(tier.getMM());
        newTier.setMiles(tier.getMiles());
        newTier.scf(tier.gcf());
        newTier.setFlights(tier.getFlights());
        this.tier = newTier;
        }
         public void PlatinumToExecutivePlatinum(){
        Tier newTier = new ExecutivePlatinum();
        this.setTier("Executive Platinum");
        newTier.setMM(tier.getMM());
        newTier.setMiles(tier.getMiles());
        newTier.scf(tier.gcf());
        newTier.setFlights(tier.getFlights());
        this.tier = newTier;
        }
        public void PlatinumToPlatinumPro(){
        Tier newTier = new PlatinumPro();
        this.setTier("Platinum Pro");
        newTier.setMM(tier.getMM());
        newTier.setMiles(tier.getMiles());
        newTier.scf(tier.gcf());
        newTier.setFlights(tier.getFlights());
        this.tier = newTier;
        }
         public void ExecutivePlatinumToSuperExecutivePlatinum(){
        Tier newTier = new SuperExecutivePlatinum();
        this.setTier("Super Executive Platinum");
        newTier.setMM(tier.getMM());
        newTier.setMiles(tier.getMiles());
        newTier.scf(tier.gcf());
        newTier.setFlights(tier.getFlights());
        this.tier = newTier;
        }
        public String getTier(){ /**Setters and getters used to keep track of relevant info*/
            return tierstring;
        }
        public void setTier(String x){
            tierstring = x;
        }
        public int getMiles(){
            return tier.getMiles();
        }
        public void setMiles(int newMiles){
          tier.setMiles(newMiles);
        }
        public int gcf(){
            return tier.gcf();
        }
        public boolean hasMultiplier(){
            return tier.getMM();
        }
        public  void addFlight(boolean isCancelled){
                tier.addFlight(isCancelled);
        }
        public  int getFlights(){
            return tier.getFlights();
        }
        public void setMM(boolean y){
            tier.setMM(y);
        }
    }