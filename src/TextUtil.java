
public abstract class TextUtil {

	public static void alignText(String[] paragraphs, int lineLength, String option){
		String format;
		switch(option){
			case "L":
				format = "%-" + lineLength + "s";
				alignLeftRight(paragraphs, lineLength, format);
				break;
			case "C":
				format = "";
				break;
			case "J":
				format = "";
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

}
