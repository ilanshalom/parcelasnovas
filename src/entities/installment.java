package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class installment {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");
      private LocalDate date;
      private  double amount;
	
      public installment() {
    	 
	}

	public installment(LocalDate date, double amount) {
	
		this.date = date;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return  date.format(fmt) + " - " +String.format("%.2f", amount);
	}
      
	

}
