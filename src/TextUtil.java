
public abstract class TextUtil {

	public static void alignText(String[] paragraphs, int lineLength, String option){
		switch(option){
			case "L": 
				System.out.println("L");
			    break;
			
			case "C": 
				System.out.println("C");
				break;
			
			case "J": 
				System.out.println("J");
				break;
					  
		    default :
		    	for(int i=0;i<paragraphs.length;i++){
		    		alignRight(paragraphs[i], lineLength);
		    	}
		    	break;
		}
	}
	
	public static void alignRight(String paragraph, int lineLength){
		paragraph = paragraph.trim();
    	String[] wordList = paragraph.split("\\s+");
    	String outStr;
    	String temp;
    	
    	int i = 0;
    	while(i < wordList.length){
    		outStr = "";
    		temp = "";
    		while((outStr.length() <= lineLength) && i < wordList.length){
	    		temp = outStr;
	    		outStr = outStr + " " + wordList[i];
	    		i++;
	    	}
	    	if(outStr.length() > lineLength){
	    		outStr = temp;
	    		i = i - 1;
	    	}
	    	
	    	String format = "%" + lineLength + "s";
	    	outStr = String.format(format, outStr);
	    	System.out.println(outStr);
    	}
	}

}
