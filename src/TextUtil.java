
public abstract class TextUtil {

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
	
	private static void alignLeftRight(String[] paragraphs, int lineLength, 
			String format){
		String paragraph;
		for(int i=0;i<paragraphs.length;i++){
			paragraph = paragraphs[i].trim();
	    	String[] wordList = paragraph.split("\\s+");
	    	String outStr;
	    	String temp;
	    	
	    	int j = 0;
	    	while(j < wordList.length){
	    		outStr = "";
	    		temp = "";
	    		while((outStr.length() <= lineLength) && j < wordList.length){
		    		temp = outStr;
		    		outStr = outStr + " " + wordList[j];
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
	
	private static void alignCenter(String[] paragraphs, int lineLength){
		String paragraph, leftPadding, rightPadding, format;
		String outStr;
    	String temp;
	    
		for(int i=0;i<paragraphs.length;i++){
			paragraph = paragraphs[i].trim();
	    	String[] wordList = paragraph.split("\\s+");
	    	
	    	int j = 0;
	    	while(j < wordList.length){
	    		outStr = "";
	    		temp = "";
	    		while((outStr.length() <= lineLength) && j < wordList.length){
		    		temp = outStr;
		    		outStr = outStr + " " + wordList[j];
		    		j++;
		    	}
		    	if(outStr.length() > lineLength){
		    		outStr = temp;
		    		j = j - 1;
		    	}
		    	
		    	// max space from left/right margin
		    	int maxPadding = 20;
		        int padding = maxPadding / 2;
		        // extra space at the start in case of String with odd space
		        int extra = (outStr.length() % 2 == 0) ? 1 : 0;
		        
		        leftPadding = "%" + padding + "s";
		        rightPadding = "%" + (padding - extra) + "s";
		        format = leftPadding + "%s" + rightPadding;
		        
		    	outStr = String.format(format, "", outStr, "");
		    	System.out.println(outStr);
	    	}
		}
	}
	
	private static void justifyText(String[] paragraphs, int lineLength){
	    int end=lineLength, extraSpacesPerWord=0, spillOverSpace=0;
	    String[] wordList;

	    for(int i=0;i<paragraphs.length;i++){
	    	while(end < paragraphs[i].length()) {
		        end = paragraphs[i].lastIndexOf(" ", lineLength);
		        wordList = paragraphs[i].substring(0, end).split(" ");
		        extraSpacesPerWord = (lineLength - end) / wordList.length;
		        spillOverSpace = lineLength - end + (extraSpacesPerWord * wordList.length);

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
