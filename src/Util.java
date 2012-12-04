import java.util.ArrayList;

public class Util {
	public static String Join(ArrayList<String> coll, String delimiter)
	{
	    if (coll.isEmpty())
		return "";
	 
	    StringBuilder sb = new StringBuilder();
	 
	    for (String x : coll)
		sb.append(x + delimiter);
	 
	    sb.delete(sb.length()-delimiter.length(), sb.length());
	 
	    return sb.toString();
	}

	public static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i=0; i < b.length; i++) {
			result +=
		    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		}
		return result;
	}
}
