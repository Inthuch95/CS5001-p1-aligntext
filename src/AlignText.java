/**
 * <p>AlignText program reads in a number of paragraph from of text from a file and 
 * aligns the text based on the specified line length.The program will perform 
 * right-align by default.</p>
 * Available "align mode" are:<br>
 * L - Left-align text from the file <br>
 * C - Centre-align text from the file <br>
 * J - Fully justify text from the file<br>
 * Usage: java AlignText file_name line_length [align mode]
 *  
 * @author Inthuch Therdchanakul 27/9/2017
 *
 */
public class AlignText {

	public static void main(String[] args) {
		// if arguments are not valid then print usage message and terminate the program
		String option = checkArgs(args);
		
		// align the text based on arguments from the user
		int lineLength = Integer.parseInt(args[1]);
		String[] paragraphs = FileUtil.readFile(args[0]);
		TextUtil.alignText(paragraphs, lineLength, option);
	}
	
	/**
	 * This method is used to verify the command line arguments from the user.
	 * It will show usage message to the user if it detects invalid an argument.
	 * @param args Command line arguments
	 * @return String This returns the third command line argument if it is valid.
	 * It will return an empty string if the user did not specify the third argument. 
	 */
	public static String checkArgs(String[] args){
		String option;
		// check for missing arguments
		if(args.length < 2 || args.length > 3){
			System.out.println("usage: java AlignText file_name "
					+ "line_length <align_mode>");
			System.exit(0);
		}
		
		// check if option is valid when user enter third argument
		if(args.length == 3){
			if(!args[2].equals("L") && !args[2].equals("C") && !args[2].equals("J")){
				System.out.println("usage: java AlignText file_name "
						+ "line_length <align_mode>");
				System.exit(0);
			}
			option = args[2];
		}
		// use empty option if there's no third argument
		else{
			option = "";
		}
		
		return option;
	}

}
