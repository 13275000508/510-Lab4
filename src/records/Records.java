package records;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords {

//create formatted object to write output directly to console & file
	static FileWriter fw = null;

	public Records() {
		try {
			fw = new FileWriter("bankrecords.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

        
		Records br = new Records();
		br.readData();
		// call functions to perform analytics
		AvgComp();     // analyze average income per gender
		femsComp();  // female count w. mort/savings accounts 
		malesComp(); // male counts per loc. w. car & 1 child 

		// *** close out file object ***//

		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	  public static void AvgComp() {

		Arrays.sort(robjs, new SexComparator());
		
		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
          
        int maleCt = 0, femCt = 0;
           double maleInc =0, femInc = 0;
        
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("FEMALE")) {
				++femCt;
				femInc += robjs[i].getIncome();
			}  
			else if (robjs[i].getSex().equals("MALE")) {
				++maleCt;
				maleInc += robjs[i].getIncome();
			}
		
		// display resulting averages to console and to file
		System.out.printf("Data analytic results:" );
		System.out.printf("\n");
		System.out.printf("\nAvg inc. for Females: $%.2f" , (femInc/femCt) );
		System.out.printf("\nAvg inc. for Males: $%.2f" , (maleInc/maleCt));
		System.out.printf("\n");

		try {
			fw.write("Avg inc. for Females: $" + String.format("%.2f",femInc/femCt) );
			fw.write("\n");  //create newline in file
			fw.write("Avg inc. for Males: $" + String.format("%.2f",maleInc/maleCt));
			fw.write("\n" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  public static void femsComp() {

          
        int  femCt1 = 0;
           
        
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES") && robjs[i].getSex().equals("FEMALE")) {
				femCt1++;	
			}  
			else  {
				
			}
		 
		System.out.printf("\nNumber of females with a mortgage and savings account:" + femCt1);
		System.out.printf("\n");
		try {
			fw.write("\nNumber of females with a mortgage and savings account: " + femCt1);
			fw.write("\n");  //create newline in file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	  public static void malesComp() {

			Arrays.sort(robjs, new LocationComparator());

	          
	        int maleInnercity = 0, maleRural = 0,maleSuburban = 0,maleTown = 0;
	  
	        
			for (int i = 0; i < robjs.length; i++)
				if (robjs[i].getSex().equals("MALE") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getCar().equals("YES")) {
					maleInnercity ++;
				}  
				else if (robjs[i].getSex().equals("MALE") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("RURAL") && robjs[i].getCar().equals("YES")) {
					maleRural ++;
				}
				else if (robjs[i].getSex().equals("MALE") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("SUBURBAN") && robjs[i].getCar().equals("YES")) {
					maleSuburban ++;
				}
				else if (robjs[i].getSex().equals("MALE") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("TOWN") && robjs[i].getCar().equals("YES")) {
					maleTown ++;
				}
			
				 
			// display results to console and to file
			 
			System.out.printf("\nInnercity region males with car & 1 child:" + maleInnercity);
			System.out.printf("\nRural region males with car & 1 child:" + maleRural);
			System.out.printf("\nSuburban region males with car & 1 child:" + maleSuburban);
			System.out.printf("\nTown region males with car & 1 child:" + maleTown);

			try {
				fw.write("\nInnercity region males with car & 1 child: " + maleInnercity);
				fw.write("\nRural region males with car & 1 child: " + maleRural);
				fw.write("\nSuburban region males with car & 1 child: " + maleSuburban);
				fw.write("\nTown region males with car & 1 child: " + maleTown);
				fw.write("\n" );
				fw.write("\n Xinyuan_Zhang 29/10/2022" );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}

