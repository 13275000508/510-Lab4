package records;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRecords extends Client{
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	
	//array of BankRecords objects
	protected static BankRecords robjs[] = new BankRecords[600]; 
	//arraylist to hold spreadsheet rows & columns
	static ArrayList<List<String>> array = new ArrayList<>();
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSave_act() {
		return save_act;
	}

	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	public String getCurrent_act() {
		return current_act;
	}

	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}


	 
	@Override
	public void readData() {
		BufferedReader br;
		try {
			
	     //initialize reader object and set file path to root of project
	     	     br = new BufferedReader(new FileReader (new File("bank-Detail.csv")));
				String line;

	        //read each record in csv file
				while ((line = br.readLine()) != null) {
	             //parse each record in csv file by a comma ( , )
	             //into a list stored in the arraylist-> Arrays
			           array.add(Arrays.asList(line.split(",")));
				}
				
				} catch (Exception e) {
					System.out.println("There was a problem loading the file");
				}
		 processData();  //call function for processing record data
	}

	@Override
	public void processData() {
		  //create index for array while iterating thru arraylist
		 int idx=0;

			//create for each loop to cycle thru arraylist of values 
			//and PASS that data into your record objects' setters 
		 
			for (List<String> rowData: array) {
			//initialize array of objects
			robjs[idx] = new BankRecords();
			//call setters below and populate them, item by item
			robjs[idx].setId(rowData.get(0)); //get 1st column
			robjs[idx].setAge(Integer.parseInt(rowData.get(1))); //get 2nd column
			robjs[idx].setSex(rowData.get(2));
			robjs[idx].setRegion(rowData.get(3));
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
			robjs[idx].setMarried(rowData.get(5));
			robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));
			robjs[idx].setCar(rowData.get(7));
			robjs[idx].setSave_act(rowData.get(8));
			robjs[idx].setCurrent_act(rowData.get(9));
			robjs[idx].setMortgage(rowData.get(10));
			robjs[idx].setPep(rowData.get(11));
			
			

	        /*continue processing arraylist item values into each array 
	object -> robjs[ ] by index*/
	         
	           
	            idx++;}
//			 printData();  //call function to print objects held in memory
		
	}

	@Override
	public void printData() {
		System.out.println("First 25 Bankrecords");
		System.out.println("ID\t\tAGE\t\tSEX\t\tREGION\t\t\tINCOME\t\t\tMORTGAGE");
		 for (int i=0;i<25;i++){
				
		    	String s=String.format("%s\t\t%d\t\t%s\t\t%-10s\t\t%-8.2f\t\t%s", robjs[i].getId(),
					robjs[i].getAge(),robjs[i].getSex(),robjs[i].getRegion(),robjs[i].getIncome(),robjs[i].getMortgage());
		    	System.out.println(s);
		    	
//		
		 }
	}

}
