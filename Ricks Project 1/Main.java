//Abhay Iyer AXI210015 RICKS PROJECT 1!
/***
 * Main Java class, will be used to go through the text file, map all the data in the text file to each of the respective flight IDs
 * Then we have a menu which will let the user type in Flgiht IDs to see the respective statistics
 * */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Main
{
  static  Map<String,Passenger> passengerData = new HashMap<>(); /**Will be used to map all the passengers to ID*/
   
    public static void ComputeData(String ID, boolean isCancelled, boolean didComplain){ //Method will be called at every line
   
        if(passengerData.containsKey(ID)){ //If we already have the passenger in our map, just compute the data
            passengerData.get(ID).addFlight(isCancelled);
            if(didComplain){
                
                passengerData.get(ID).setMM(!didComplain); //If passenger complained, set the mileage multiplier to false
                //passengerData.get(ID).complain = false;
                //System.out.println(passengerData.get(ID).hasMultiplier());
            }
            if(passengerData.get(ID).gcf() > 99 && passengerData.get(ID).getTier() != "Executive Platinum"){ //Check if passenger can move tiers
                passengerData.get(ID).PlatinumToExecutivePlatinum();
                
            }
            else if(passengerData.get(ID).gcf() > 49 && passengerData.get(ID).gcf() < 100 && passengerData.get(ID).getTier() != "Platinum"){//Check if passenger can move tiers
                passengerData.get(ID).GoldToPlatinum();
                
                
            }
            else if(passengerData.get(ID).gcf() > 24 && passengerData.get(ID).gcf() < 50  && passengerData.get(ID).getTier() != "Gold"){//Check if passenger can move tiers
                passengerData.get(ID).BaseToGold();
                
            }
        }
        else{
            Passenger x = new Passenger(); //If we dont have passenger in our map, create a new one and map it
            
            x.addFlight(isCancelled);
            if(didComplain){
                //System.out.println("In the loop");
                x.setMM(false);
            }
            passengerData.put(ID, x);
        }
        ///System.out.println(passengerData.get(ID).getTier());
    }
    public static void ReadFile(){ /**Read the file using a File type and a scanner, parse the string at every line, and call ComputeData() with the info we parsed*/
        try{
        File FlightData = new File("flight-data.txt");
        Scanner scanFile = new Scanner(FlightData);
         while (scanFile.hasNextLine()) {
        String data = scanFile.nextLine();
        String ID = data.substring(0, data.indexOf(" "));
        //System.out.println(ID);
        data = data.substring(data.indexOf(" ") + 1);
        boolean isCancelled;
        if(data.charAt(0) =='Y'){
            isCancelled = true;
            data = data.substring(data.indexOf(" ") + 1);
            if(data.charAt(0) == 'Y'){
                 ComputeData(ID, isCancelled, true);
               // System.out.println(isCancelled + " true");
            }
            else{
               ComputeData(ID, isCancelled, false);
              // System.out.println(isCancelled + " false");
            }
        }
        else{
            isCancelled = false;
            // System.out.println(isCancelled + " false");
            ComputeData(ID, isCancelled, false);
        }
        
         }
         } catch (FileNotFoundException e){
             System.out.println("No file found"); //If file isnt found throw exception
            e.printStackTrace();//clarify exception 
         }
      }
    
	public static void main(String[] args) {
		ReadFile();
		  for (Map.Entry<String,Passenger> MapElement : passengerData.entrySet()) { /**Iterate through the Map, to check if any passengers fit the criteria to be promoted to Mileage Multiplier class*/
		     if(MapElement.getValue().hasMultiplier() == true){
		        if(MapElement.getValue().getTier().equals("Platinum")){
		            MapElement.getValue().PlatinumToPlatinumPro();
		            MapElement.getValue().setMiles(MapElement.getValue().getMiles() * 2);
		        }
		        if(MapElement.getValue().getTier().equals("Executive Platinum")){
		            MapElement.getValue().ExecutivePlatinumToSuperExecutivePlatinum();
		            MapElement.getValue().setMiles(MapElement.getValue().getMiles() * 2);
		        }
		     }
            //String key = MapElement.getKey();
          //  System.out.println(key + " : " + MapElement.getValue().getTier());
        
        }
        /**
        Makeshift menu that lets the user check whatever Passenger ID that they want, and see their data, if the user enters an invalid ID
        the user is alerted, or if the user types -1, the program terminates.*/
        
          Scanner StringScanner = new Scanner(System.in); 
          System.out.println("Enter a Passenger ID, or -1 to Exit");
          int x = StringScanner.nextInt();
        if(x < 0){
            System.exit(0);
        }
          while(x > 0){
               
              if(!passengerData.containsKey(Integer.toString(x))){
                  System.out.println("Passenger not found, try again!");
                  System.out.println("Enter a Passenger ID, or -1 to Exit");
                x = StringScanner.nextInt();
              }
              else{
            System.out.println("Rewards Tier: " + passengerData.get(Integer.toString(x)).getTier() +" Total Miles: " + passengerData.get(Integer.toString(x)).getMiles() + " Total Cancellations: "+ passengerData.get(Integer.toString(x)).gcf() + " Mileage Multiplier? " +passengerData.get(Integer.toString(x)).hasMultiplier());
             System.out.println("Enter a Passenger ID, or -1 to Exit");
             x = StringScanner.nextInt();
           
            }
          }
           if(x < 0){
            System.exit(0);
             }
	}
}
