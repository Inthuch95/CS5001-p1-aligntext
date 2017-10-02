
/**
 * This class handles text alignment for the AlignText program
 * 
 * @author Inthuch Therdchanakul 27/9/2017
 *
 */
public class TextUtil {

	/**
	 * This method calls appropriate text alignment method based on user input
	 * @param paragraphs The paragraphs from text file
	 * @param lineLength The line length specified by the user
	 * @param option align mode which is an optional command line argument.
	 *  It will be empty if the user did not specify one.
	 */
	public static void alignText(String[] paragraphs, int lineLength, String option){
		String format;
		switch(option){
			case "L":
				format = "%-" + lineLength + "s";
				alignLeftRight(paragraphs, lineLength, format);
				break;
			case "C":
				alignCenter(paragraphs, lineLength);
				break;
			case "J":
				justifyText(paragraphs, lineLength);
				break;
			default:
				// right-align text if third argument is not specified
				format = "%" + lineLength + "s";
				alignLeftRight(paragraphs, lineLength, format);
				break;
		}
	}
	
	/**
	 * This method left/right align text from the file
	 * @param paragraphs The paragraphs from text file
	 * @param lineLength The line length specified by the user
	 * @param format The format of text alignment. It can be left/right align
	 */
	public static void alignLeftRight(String[] paragraphs, int lineLength, 
			String format){
		String[] wordList;
		String paragraph;
		String outStr, temp;
		
		for(int i=0;i<paragraphs.length;i++){
			paragraph = paragraphs[i].trim();
	    	wordList = paragraph.split("\\s+");

	    	// concatenate strings until line length reached
	    	int j = 0;
	    	while(j < wordList.length){
	    		outStr = "";
	    		temp = "";
	    	
	    		while((outStr.length() <= lineLength) && j < wordList.length){
	    			temp = outStr;
		    		
					if(j == 0 || outStr.length() == 0){
						outStr = outStr + wordList[j];
					}
					else{
						outStr = outStr + " " + wordList[j];
					}
		    		j++;
		    	}
		    	if(outStr.length() > lineLength){
		    		outStr = temp;
		    		j = j - 1;
		    	}
		        outStr = String.format(format, outStr);
	    		System.out.println(outStr);
	    	}
		}
	}
	
	/**
	 * This method center-align text from the file. It will add an extra space to 
	 * the start of the line if there are an odd number of spaces.
	 * @param paragraphs The paragraphs from text file
	 * @param lineLength The line length specified by the user
	 */
	public static void alignCenter(String[] paragraphs, int lineLength){
		String[] wordList;
		String paragraph, format;
		String outStr;
    	String temp;
	    
		for(int i=0;i<paragraphs.length;i++){
			paragraph = paragraphs[i].trim();
	    	wordList = paragraph.split("\\s+");
	    	
	    	// concatenate strings until line length reached
	    	int j = 0;
	    	while(j < wordList.length){
	    		outStr = "";
	    		temp = "";
	    		while((outStr.length() <= lineLength) && j < wordList.length){
		    		temp = outStr;
		    		if(j == 0 || outStr.length() == 0){
						outStr = outStr + wordList[j];
					}
					else{
						outStr = outStr + " " + wordList[j];
					}
		    		j++;
		    	}
		    	if(outStr.length() > lineLength){
		    		outStr = temp;
		    		j = j - 1;
		    	}
		    	
		        // extra space at the start in case of String with odd space
		        if(outStr.length() % 2 == 0){
		        	outStr = " " + outStr;
		        }
		        int spaceRight = (lineLength - outStr.length())/2;
		        for(int k=0;k<spaceRight;k++){
		        	outStr +=  " ";
		        }
		        
		        format = "%" + lineLength + "s";
		    	outStr = String.format(format, outStr);
		    	System.out.println(outStr);
	    	}
		}
	}
	
	/**
	 * This method fully justify text from the file.
	 * @param paragraphs The paragraphs from text file
	 * @param lineLength The line length specified by the user
	 */
	public static void justifyText(String[] paragraphs, int lineLength){
	    int end = lineLength;
	    int extraSpacesPerWord = 0;
	    int spillOverSpace = 0;
	    String[] wordList;

	    for(int i=0;i<paragraphs.length;i++){
	    	while(end < paragraphs[i].length()) {
		        end = paragraphs[i].lastIndexOf(" ", lineLength);
		        wordList = paragraphs[i].substring(0, end).split(" ");
		        extraSpacesPerWord = (lineLength - end) / wordList.length;
		        spillOverSpace = lineLength - end + (extraSpacesPerWord * wordList.length);

		        // print the word out and add extra space as required
		        for(String word: wordList) {
		            System.out.print(word + " ");
		            System.out.print((extraSpacesPerWord-- > 0) ? " ": "");
		            System.out.print((spillOverSpace-- > 0) ? " ": "");
		        }
		        System.out.print("\n");
		        paragraphs[i] = paragraphs[i].substring(end+1);

		    }
		    System.out.println(paragraphs[i]);
	    }
	}

}
