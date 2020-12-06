package Java_Phase_1_Project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("00*********************LockedMe.COM**********************00");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println(" ");
		System.out.println("                                    Developer@Mandar Phondke");
		System.out.println(" ");
		System.out.println("---------------------Welcome to LockedMe.com----------------");
		System.out.println(" ");
		mainMenu();
		
	}
	private static void mainMenu() {
		System.out.println("MENU:");
		System.out.println("Choose from below options");
		System.out.println("------------------------------------");
		System.out.println("1.Display the Files from the Directory");
		System.out.println("2.Business Operations");
		System.out.println("3.Close the Application");
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		File Direct = new File("E:/Java Project");
		
		switch(a)
		{
			case 1 :
			readDirectory(Direct);
			returnMain();
			break;
			case 2 :
			businessOperation(Direct);
			break;
			case 3 :
			System.out.println(" " );
			System.out.println("--------------------------------------------------------------------------- " );
			System.out.println("Thanks for Visiting the Application,looking forward to see you again !!!");
			System.out.println("--------------------------------------------------------------------------- " );
			break;
			default :
			System.out.println("Invalid Option, Enter Valid Option from below Menu");
			System.out.println(" ");
			mainMenu();
			break;
					
		}
		input.close();
		
	}
	private static void businessOperation(File Direct) {
		System.out.println("2 - Business Operations:");
		System.out.println("Choose from below options");
		System.out.println("------------------------------------");
		System.out.println("1.Add a File in the Directory");
		System.out.println("2.Delete a File from the Directory");
		System.out.println("3.Search a File from the Directory");
		System.out.println("4.Return to the Main Menu");
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		switch(a)
		{
			case 1 :
			addFile(Direct);
			returnMenu(Direct);
			break;
			case 2 :
			deleteFile(Direct);
			returnMenu(Direct);
			break;
			case 3 :
			searchfile(Direct);
			returnMenu(Direct);
			break;
			case 4 :
			mainMenu();
			break;
			default :
			System.out.println("Invalid Option, Enter Valid Option from below Menu");
			System.out.println(" ");
			businessOperation(Direct);
			break;
					
		}
		input.close();
	}
	private static void returnMenu(File Direct) {
		System.out.println(" ");
		System.out.println("Press 1 to return to Previous Menu");
		System.out.println("Press 2 to return to Main Menu");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		switch(a)
		{
			case 1 :
			businessOperation(Direct);
			break;
			case 2 :
			mainMenu();
			break;			
			default :
			System.out.println("Invalid Option, Enter Valid Option from below Menu");
			System.out.println(" ");
			returnMenu(Direct);
			break;
				
		}

		input.close();
	}
	private static void returnMain() {
		System.out.println(" ");
		System.out.println("Press 1 to return to Menu");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		switch(a)
		{
			case 1 :
			mainMenu();
			break;			
			default :
			System.out.println("Invalid Option, Enter Valid Option from below Menu");
			System.out.println(" ");
			returnMain();
			break;
				
		}

		input.close();
	}
	private static void searchfile(File Dir) {
		//File Dir = new File("E:/Java Project");
		System.out.println("Enter the file name to be searched");
		Scanner filename = new Scanner(System.in);
		String filenm = filename.nextLine();
		filenm = filenm + ".txt";
		File[] FileNames = Dir.listFiles();
		boolean found = false;
		for (int i = 0; i < FileNames.length; i++){
			File Object = FileNames[i];
			String Temp = Object.getName();
			if (Temp.equals(filenm)){
	            	System.out.println("Search Results:");
	            	System.out.println("--------------------------");
	            	System.out.println("Successful Search - File found: " +Object.getName());
	            	found = true;
			}	
		}	
		if (found==false){
			System.out.println("Search Results:");
        	System.out.println("--------------------------");
        	System.out.println("File not Found");
		}
	}
	private static void deleteFile(File Dir) {
		
			System.out.println("Enter the file name to be deleted");
			Scanner filename = new Scanner(System.in);
			String filenm = filename.nextLine();
			filenm = filenm + ".txt";	
			File addfile = new File(Dir,filenm);	
			boolean b = addfile.delete();
            if(b==true)
            {
            	System.out.println("File deleted !!");
            }
            else
            {
            	System.out.println("File not deleted");
            }
	}
	private static void addFile(File Dir) {
		System.out.println("Enter the file name to be added");
		Scanner filename = new Scanner(System.in);
		String filenm = filename.nextLine();
		filenm = filenm + ".txt";
		try {
		File addfile = new File(Dir,filenm);	
		boolean b = addfile.createNewFile();
		if(b==true)
        {
        	System.out.println("File Successfully Added !!");
        }
        else
        {
        	System.out.println("File not added");
        }
		}
		catch (IOException e) {  
            e.printStackTrace();  
        } 
		
	}
	public static void readDirectory(File Direct){
		//File Direct = new File("E:/Java Project");
		File[] FileNames = Direct.listFiles();
		Arrays.sort(FileNames);
		for (File Object : FileNames){
			if (Object.isFile()){
				System.out.format("%n" +Object.getName());
			}
		}
	}
	
}
