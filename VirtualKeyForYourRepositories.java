package com.lockedme.project.phase1;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class VirtualKeyForYourRepositories {

	static File folder = new File("C:\\Users\\ranga\\OneDrive\\Desktop\\root\\Java_Full_Stack_Developer\\Project1");
	// Just one scanner is used along the application
	static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
	// Get All files using a for loop
	public static void listAllFiles_Asc() {
		if(folder.isDirectory()){
			//System.out.println("The file check is correct");
			List<String> listFile = Arrays.asList(folder.list());
			Collections.sort(listFile);
			System.out.println("---------------------------------------");
			//System.out.println("Sorting by filename in ascending order");
			for(String s:listFile){
				System.out.println(s);
			}
			System.out.println("---------------------------------------");
		}
	}
	/*public static void getAllFiles_forLoop() {
		//System.out.println("---> getAllFiles_forLoop");
		//Name of files are stored in an array
		File[] listOfFiles = folder.listFiles();
		//We use an Arraylist to contain the list of files
		List<File> alListOfFiles = new ArrayList<File>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//Read the Arraylist using a for loop with the name of the files1
		try {
			for (int i = 0; i < alListOfFiles.size(); i++) {
				System.out.println(alListOfFiles.get(i));
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("Error: file not found");
		}
	}


	//Get all files using a while loop and a linkedlist

	public static void getAllFiles_while() {
		//System.out.println("---> getAllFiles_while");
		File[] listOfFiles = folder.listFiles();
		LinkedList<File> llListOfFiles = new LinkedList<File>();
		//Get the list into the linkedlist
		Collections.addAll(llListOfFiles, listOfFiles);
		int counter = 0;
		//Traverse the linkedlist
		while (llListOfFiles.size() > counter) {
			System.out.println(llListOfFiles.get(counter));
			counter++;
		}
	}


	// Get all the files using a for each loop

	public static void getAllFiles_forEachLoop() {
		//System.out.println("---> getAllFiles_forEachLoop");
		File[] listOfFiles = folder.listFiles();
		//Use a simplified loop
		for (File myFile : listOfFiles) {
			System.out.println(myFile.getName());
		}
	}


	//Get all the files using a lambda expression

	public static void getAllFiles_LambdaExpression() {
		//System.out.println("---> getAllFiles_LambdaExpression");
		File[] listOfFiles = folder.listFiles();
		List<File> alListOfFiles = new ArrayList<>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//The lambda expression get the file and prints it
		alListOfFiles.forEach((file) -> {
			System.out.println(file.getName());
		});
	}


	// Get all files using the enumeration interface

	public static void getAllFiles_EnumerationInterface() {
		//System.out.println("---> getAllFiles_EnumerationInterface");
		File[] listOfFiles = folder.listFiles();
		List<File> alListOfFiles = new ArrayList<>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//Use the interface to iterate through the list elements
		Enumeration<File> e = Collections.enumeration(alListOfFiles);
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().getName());
		}
	}


	// Return all files from directory

	public static void getAllFiles_Iterator() {
		//System.out.println("---> getAllFiles_Iterator");
		//Name of files are stored in an array
		File[] listOfFiles = folder.listFiles();
		//We use an Arraylist to contain the list of files
		List<File> alListOfFiles = new ArrayList<File>();
		Collections.addAll(alListOfFiles, listOfFiles);
		LinkedList<File> llListOfFiles = new LinkedList<>(alListOfFiles);
		//Read the Arraylist using an iterator with the name of the files
		try {
			Iterator<File> alListOfFilesIterator = llListOfFiles.iterator();
			while (alListOfFilesIterator.hasNext()) {
				System.out.println(alListOfFilesIterator.next());
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("Error: file not found");
		}
	}
	 */
	public static void deleteFile(Scanner scannerdelete) {
		try {
			//Read the name of the file to delete
			System.out.println("Write the name of the file you want to delete:");
			File fileToDelete = new File(folder + "//" +
					scannerdelete.nextLine());
			//On success
			if (fileToDelete.delete()) {
				PrintMessage("File deleted successfully.");
			} else {
				//On error
				PrintMessage("The mentioned file was not found. It may be deleted or the file was not found to delete");
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error deleting the file");
		}
	}

	/**
	 * Search for a specific file
	 */
	public static void searchFiles(Scanner scannerSearch) {
		try {
			//Name of the file to find
			System.out.println("Write the name of the file you want to find:");
			File fileTofind = new File(folder + "//" + scannerSearch.nextLine());
			// If the file exists
			if (fileTofind.exists()) {
				PrintMessage("File exists");
			} else {
				//If not a message is sent
				PrintMessage("File does not exist");
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error searching the file.");
		}
	}

	/**
	 * User creates a new file
	 *
	 * @param scannerCreate
	 */
	public static void createFile(Scanner scannerCreate) {
		//Writer object to use
		FileWriter writer = null;
		try {
			//Read the name of the file to create
			System.out.println("What is the name of your new file?");
			File newFile = new File(folder + "//" + scannerCreate.nextLine());
			writer = new FileWriter(newFile);
			//Read the contents of the file to create
			System.out.println("And the contents of your file are...");
			writer.write(scannerCreate.nextLine());
			writer.close();
			PrintMessage("File created successfully");
			//On error an exception is raised
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * The menu is painted on screen
	 */
	public static void menu() {
		System.out.println("\n");
		System.out.println("****************************************************");
		System.out.println("************* Welcome to LockedMe.com****************");
		System.out.println("****************************************************");
		System.out.println("************** Developed by Rangaraj************");
		System.out.println("****************************************************");
		System.out.println(" 1) Display all the files");
		System.out.println(" 2) Display menu for file operations");
		System.out.println(" 3) Exit from the Application "); 
		System.out.println("");
		System.out.println(" > Select an option...");
	}

	static void PrintMessage(String message) {
		System.out.println(" -----------------------------");
		System.out.println(" " + message);
		System.out.println(" -----------------------------");
	}

	public static void main(String[] args) {
		//Boolean to identify if the loop continues or not
		boolean bExit = false;
		// Option Selected
		Integer receivedInput = 0;
		// Exits when user selects option 5
		while (!bExit) {
			// The menu is painted on screen
			menu();
			try {
				// User input is read
				receivedInput = Integer.parseInt(scanner.nextLine());
				PrintMessage(" > Selected: " + receivedInput);
				// Choose the option selected by user
				switch (receivedInput) {
				case 1: {
					listAllFiles_Asc();
					break;
				}
				case 2:{
					boolean iExit = false;

					while (!iExit) {

						try {
							System.out.println("");
							System.out.println(" 1) Add a new file ");
							System.out.println(" 2) Delete an existing file ");
							System.out.println(" 3) Search a file ");
							System.out.println(" 4) Go to Main Menu "); 
							int givenInput = Integer.parseInt(scanner.nextLine());
							switch(givenInput) {
							case 1: {
								//User defines name and contents of a new file
								createFile(scanner);
								break;
							}
							case 2: {
								//User chooses a file to delete
								deleteFile(scanner);
								break;
							}
							case 3: {
								//Determine is a file exists
								searchFiles(scanner);
								break;
							}
							case 4: {
								System.out.println("\n ->Going to Main Menu");
								iExit = true;
								break;
							}
							default: {
								//On error the program ends
								iExit = true;
							}
							}
						}catch(NumberFormatException e) {
							PrintMessage("Please print only numbers");
						}
					}
					break;
				}
				case 3: {
					//Exit the program
					System.out.println("******Application Closed******");
					bExit = true;
					break;
				}
				default: {
					//On error the program ends
					bExit = true;
				}
				}
			}catch(NumberFormatException e){
				PrintMessage("Please print only numbers");
			}
		}
	}
}
