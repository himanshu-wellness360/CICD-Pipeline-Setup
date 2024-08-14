package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
	
	/**
	 * This is a generic method to use properties data
	 * @param data
	 * @return
	 * @throws Exception
	 */

	public String getDataFromProperties(String data) throws Exception {
		
		FileInputStream fis = new FileInputStream(IconstantUtility.Propertiespath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(data);
		return value;
	}

}
