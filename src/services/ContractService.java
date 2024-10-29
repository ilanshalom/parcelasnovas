package services;

import java.time.LocalDate;

import entities.Contract;
import entities.installment;

public class ContractService {
  private OnlinePaymentService onlinePaymentService;

public ContractService(OnlinePaymentService onlinePaymentService) {

	this.onlinePaymentService = onlinePaymentService;
}
  public void processContract(Contract contract, int months) {
	  double basiQuota = contract.getTotalValue() / months;
	  
	  for(int i=1; i <= months; i++) {
		  LocalDate dueDate = contract.getDate().plusMonths(i);
		  
		  double interest = onlinePaymentService.interest(basiQuota, i);
		  double fee =	onlinePaymentService.paymentFee(basiQuota + interest);
		  
		  double quota = basiQuota + interest + fee;
		  
		  contract.getInstallments().add(new installment(dueDate, quota)); 
	  } 
  }
}
