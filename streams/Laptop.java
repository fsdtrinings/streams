package day4.streams;

public class Laptop {

	public void dataSharing() {
		// approach 1
		Bluetooth bt1 = (String fileName) -> {
			return 100; // data transafer
		};
		int length = bt1.share("MyFile.txt");

		// approach 2
		Bluetooth bt2 = (fileName) -> {
			return 100; // data transafer
		};
		length = bt2.share("MyFile.txt");

		// approach 3
		Bluetooth bt3 = (fileName) ->  100; // data transafer
		length = bt3.share("MyFile.txt");
		
		// approach 4
		Bluetooth bt4 = fileName ->  100; // data transafer
		int x = bt4.share("MyFile.txt");
				
				

	}

}
