// CSI2110 Fall 2015 Laboratory 1.5: Algorithm Runtimes
// ==========================================================================
// (C)opyright:
//
//   Lachlan Plant
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: lplant (Lachlan Plant)
// Email:   lplan053@uottawa.ca
// ==========================================================================
// $Log: Unique2.java,v $
// Revision 1.0  2015/09/14 01:20:40  lplant
// ==========================================================================
import java.util.*;
public class Unique2{
	
	public static boolean unique2(int[] input){
		Arrays.sort(input);
		for(int i = 0; i < input.length-1; i++){
			if(input[i] == input[i+1]) 
				return false;
		}
		return true;
	}
	

}