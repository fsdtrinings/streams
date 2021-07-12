package day4.streams;


class Computer 
{
	


	public void shareFile(String fileToBeShare)
	{
		// bluetooth is an Interface
		Bluetooth b = new Bluetooth() {
			
			@Override
			public int share(String file) {
				 // code to share file
				return fileToBeShare.length()+1515;
			}
		};
		int dataTransfer = b.share(fileToBeShare);
		System.out.println(dataTransfer);
		
	}
}


public class AnyInnerClassDemo {

	public static void main(String[] args) {
		
		Computer abc = new Computer();
		abc.shareFile("MyFile");
	}
}
