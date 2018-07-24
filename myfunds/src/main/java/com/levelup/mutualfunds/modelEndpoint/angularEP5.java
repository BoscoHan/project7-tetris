package com.levelup.mutualfunds.modelEndpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levelup.mutualfunds.modelservice.ObjectService;
import com.levelup.mutualfunds.rest.BankRestApi;
import com.levelup.myfunds.Allocation.allocation;
@Path("/user")
public class angularEP5 {

	public String Frankie_ID = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_e8ec148b-e09c-4e79-8c02-b7dfd5aed06d";
	public String Frankie_DDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_46d45c9c-18f0-41f4-86eb-491a15e4fac1";
	public String Frankie_SDA = "c9ed522e-13a6-4272-a7f3-2b6dd79b33bc_edab1b18-7403-4085-ad8d-0d58b43ebeb2";
	BankRestApi apiObj = new BankRestApi();
	ObjectService service = new ObjectService();
	//USE FOR WHATEVER LATER...
	@Path("/customerName")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomerName() throws Exception {
		ObjectService service = new ObjectService();
		return service.getCustomerByID(Frankie_ID);	
	}
	@Path("/customerAge")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomerAge() throws Exception {
		ObjectService service = new ObjectService();
		return String.valueOf(service.getCustomerAge(Frankie_ID));	
	}
	
	@Path("/transfer")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doTransfer() throws Exception {
		
		ObjectService oS = new ObjectService();
		BankRestApi api = new BankRestApi();
		
		int age = Integer.parseInt(oS.returnAttribute(api.getCustomer(Frankie_ID), "age"));
		Double SDABalance = oS.currentSDABalance();
		Double DDABalance = oS.currentDDABalance();
		Double totalTransactionAmmount = oS.addAllAmmounts("currencyAmount");
		
		allocation allocationTD = new allocation(age, SDABalance);
		double transferred = allocationTD.runAllocation(DDABalance, totalTransactionAmmount);
		return Double.toString(transferred);
	}
}
