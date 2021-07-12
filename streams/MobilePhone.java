package day4.streams;

public class MobilePhone implements Bluetooth {

	public void doCalling()
	{
		System.out.println("Mobile Phone do Calling Called ");
	}
	
	@Override
	public int share(String file) {
		
		System.out.println(" Mobile Phone Bluetooth File Sharing Operation "+file);
		return 40;
	}

	
}
