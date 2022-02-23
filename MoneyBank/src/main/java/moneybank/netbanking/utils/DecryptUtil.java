package moneybank.netbanking.utils;
import org.apache.commons.codec.binary.Base64;
import java.util.Arrays;

public class DecryptUtil {
public static String decode(String base64Str)	{

	  byte[] byteArray = Base64.decodeBase64(base64Str.getBytes());
	  // Print the decoded array

	  System.out.println(Arrays.toString(byteArray));
	 

	  // Print the decoded string 

	  String decodedString = new String(byteArray);

	  System.out.println(base64Str + " = " + decodedString);
	  
	  return decodedString;
}

public static void main(String argv[]) {
	
	System.out.println(decode("MTIzNDU2")); 
	
}

}
