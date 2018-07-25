package TaxGUIFile;

class Tax {
    double grossIncome; // class member variables
    String state;
    int dependents;
   
    // First Constructor
    Tax (double grossIncome, String state, int dependents){
       this.grossIncome = grossIncome;  // instance variable initialization
       this.state = state;
       this.dependents=dependents;
    }

   // Second Constructor
    Tax (double grossIncome, int dependents){
       this(grossIncome, "NY", dependents); 
    }
    public double calcTax() {         
        double  stateTax=0;
        if (grossIncome < 30000) {
        	
        	switch(state) {
        	
        	case "New York": stateTax=grossIncome*0.2;
        	break;
        	case "New Jersey": stateTax = grossIncome*0.3;
        	break;
        	case "Florida": stateTax = grossIncome*0.4;
        	break;
        	case "California": stateTax = grossIncome*0.5;
        	break;
        	default: System.out.println("Wrong state!");
        	break;
        	
        	}
          
        }
        else{
        	
        	switch(state) {
        	
        	case "New York": stateTax = grossIncome * 0.6;
        	break;
        	case "New Jersey" : stateTax = grossIncome * 0.7;
        	break;
        	case "Florida" : stateTax = grossIncome*0.8;
        	break;
        	case "California": stateTax = grossIncome*0.9;
        	break;
        	default: System.out.println("Wrong state!");
        	break;
        	
        	
        	
        	
        	
        	}
          
        } 
          return stateTax;
  }
    
    
    
}
