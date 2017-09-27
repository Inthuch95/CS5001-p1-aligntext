public class AlignText {

	public static void main(String[] args) {
		// if arguments are not valid then print usage message and terminate the program
		String option = checkArgs(args);
		
		// align the text based on arguments from the user
		int lineLength = Integer.parseInt(args[1]);
		String[] paragraphs = FileUtil.readFile(args[0]);
		TextUtil.alignText(paragraphs, lineLength, option);
	}
	
	private static String checkArgs(String[] args){
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
