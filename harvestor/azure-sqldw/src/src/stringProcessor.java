import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class stringProcessor {
	public static void main(String[] args) {
		
		String s="from%20azure_cosmosdb_database+where+qualifiedName%3Dtest%2testdb";
		System.out.println(encodeValue(s));
		
	}
	
	private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
