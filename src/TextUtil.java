
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
				justifyText(paragraphs[0], lineLength);
				break;
			default:
				format = "%" + lineLength + "s";
				alignLeftRight(paragraphs, lineLength, format);
				break;
		}
	}
	
	private static void alignLeftRight(String[] paragraphs, int lineLength, String format){
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
		    	
		        int length = outStr.length();
		        int padding = lineLength / 2;//decide left and right padding
		        // extra character in case of String with even length
		        int extra = (length % 2 == 0) ? 1 : 0;
		        
		        
		        leftPadding = "%" + (padding - extra) + "s";
		        rightPadding = "%" + padding + "s";
		        format = leftPadding + "%s" + rightPadding;
		        
		    	outStr = String.format(format, "", outStr, "");
		    	System.out.println(outStr);
	    	}
		}
	}
	
	private static void justifyText(String text, int lineLength){
		int STR_LENGTH = lineLength;
	    int end=STR_LENGTH, extraSpacesPerWord=0, spillOverSpace=0;
	    String[] words;

	    while(end < text.length()) {

	        if(text.charAt(STR_LENGTH) == ' ') {
	            // Technically, this block is redundant
	            System.out.println (text.substring(0, STR_LENGTH));
	            text = text.substring(STR_LENGTH);
	            continue;
	        }

	        end = text.lastIndexOf(" ", STR_LENGTH);
	        words = text.substring(0, end).split(" ");
	        extraSpacesPerWord = (STR_LENGTH - end) / words.length;
	        spillOverSpace = STR_LENGTH - end + (extraSpacesPerWord * words.length);

	        for(String word: words) {
	            System.out.print(word + " ");
	            System.out.print((extraSpacesPerWord-- > 0) ? " ": "");
	            System.out.print((spillOverSpace-- > 0) ? " ": "");
	        }
	        System.out.print("\n");
	        text = text.substring(end+1);

	    }
	    System.out.println(text);
	}

}
