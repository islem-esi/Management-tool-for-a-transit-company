package view.Parametres_View;

public class Util {

	// ********************* Les methodes ***********************//
	public static int OverInderSize(String str,int sizeMax,int sizeMin){
		if(str.length() > sizeMax)
			return 1;
		if(str.length() < sizeMin)
			return -1;
		return 0;
			
	}
	
	public static boolean isJustChar(String str){
		
		int i;
		
		if( str.length() == 0)
			return false;
		for(i = 0; i < str.length() ; i ++){
			if( Character.isDigit(str.charAt(i)))
					return false;
		}
		return true;
	}
	
	public static boolean isJustDigit(String str){

		int i;
		
		if( str.length() == 0)
			return false;
		for(i = 0; i < str.length() ; i ++){
			if( Character.isLetter(str.charAt(i)))
					return false;
		}
		return true;
	}

}
