package fh.prog.lab.it.gui;



import java.util.Observable;
import java.util.Vector;

public class CompanyCustomerList extends Observable{
	
	private Vector<CompanyCustomer> compList = new Vector<CompanyCustomer>();
	private static CompanyCustomerList uniqueInstance = null;
	
	
	public static CompanyCustomerList Instance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new CompanyCustomerList();
		return uniqueInstance;
	}
	
	public void addObserver(CompanyCustomerListView view)
	{
		super.addObserver(view);
	}
	
	public void insertCompany(CompanyCustomer comp)
	{
		super.setChanged(); 				// sets flag for Observer
		compList.addElement(comp);
		super.notifyObservers();			// notifies Observers with interface Observer
	}
	
	public CompanyCustomer getCompany(CompanyCustomer comp)
	{
		for(int i=0;i<compList.size();i++)
		{
			compList.get(i).getCompanyName();
			if(compList.get(i).getCompanyName() == comp.getCompanyName())
				return compList.get(i);
		}
		return null;
	}
	
	public void modifyPerson(int index)
	{
		super.setChanged();								// sets flag for Observer
		CompanyCustomer comp = compList.get(index);
		super.notifyObservers();							// notifies Observers with interface Observer
	}
	
	public Vector<CompanyCustomer> getCompList()
	{
		return this.compList;
	}
	
	public void testPrint()
	{
		System.out.println(""+ compList.get(0).getCompanyName());
	}
}
