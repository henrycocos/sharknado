package fh.prog.lab.it.gui;



public class CompanyCustomer {

	private String companyName;
	private String companyAddress;
	private String companyNumber;
	private String companyZIP;
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyZIP() {
		return companyZIP;
	}
	public void setCompanyZIP(String companyZIP) {
		this.companyZIP = companyZIP;
	}
	public void testPrint()
	{
		System.out.println(""+companyName);
	}
	
	
}

