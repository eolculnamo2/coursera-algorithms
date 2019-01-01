package Robert_Bertram.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	//Maps
    	Map testMap = new HashMap();
    	
    	int var = 3;
    	
    	testMap.put("test", "value");
    	testMap.put("test", var);
        System.out.println( testMap.get("test") );
        System.out.println( testMap );
    }
}
