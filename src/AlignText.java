public class AlignText {

	public static void main(String[] args) {
		// If arguments are not valid then print usage message and terminate the program
		String option = checkArgs(args);
		
		// Align the text based on arguments from the user
		int lineLength = Integer.parseInt(args[1]);
		String[] paragraphs = FileUtil.readFile(args[0]);
		TextUtil.alignText(paragraphs, lineLength, option);
	}
	
	private static String checkArgs(String[] args){
		String option;
		// Check for missing arguments
		if(args.length < 2 || args.length > 3){
			System.out.println("usage: java AlignText file_name "
					+ "line_length <align_mode>");
			System.exit(0);
		}
		
		// Check if option is valid
		if(args.length == 3){
			if(!args[2].equals("L") && !args[2].equals("C") && !args[2].equals("J")){
				System.out.println("usage: java AlignText file_name "
						+ "line_length <align_mode>");
				System.exit(0);
			}
			option = args[2];
		}
		else{
			option = "";
		}
		
		return option;
	}

}
