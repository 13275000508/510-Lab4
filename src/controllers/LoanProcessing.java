package controllers;

import java.sql.ResultSet;

import models.DaoModel;
import records.BankRecords;
import records.Records;
import views.LoanView;

public class LoanProcessing extends BankRecords{

	public static void main(String[] args) {
		BankRecords br = new BankRecords();
		br.readData();
		DaoModel dao = new DaoModel();
		dao.createTable();
		dao.insertRecords(robjs); // perform inserts
		ResultSet rs;
		rs = dao.retrieveRecords();
	new LoanView().runView(rs);
	
	System.out.println("Loan Analysis Report detailed data");
	  Records r= new Records();
		// call functions to perform analytics
		r.AvgComp();     // analyze average income per gender
		r.femsComp();  // female count w. mort/savings accounts 
		r.malesComp(); // male counts per loc. w. car & 1 child 

	}

}
