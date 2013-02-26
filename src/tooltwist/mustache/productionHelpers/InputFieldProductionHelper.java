package tooltwist.mustache.productionHelpers;

import java.util.Properties;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.XpcSecurity;

public class InputFieldProductionHelper extends WbdProductionHelper
{
	private static String AUTO_URL_PARAMETER_NAME = "myParam";
	private XData data = null;
	private String myValue;
	private String myAutoUrlParameter;
	private InputFieldProductionHelper cachedHelper;

	public InputFieldProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();

		// Use the same production helper for all similar widgets on this page.
		String cachedHelperName = "productionHelper." + this.getClass().getName();
		Object previousHelper = WbdSession.getTemporaryObjectValue(credentials, cachedHelperName);
		if (previousHelper != null)
		{
			this.cachedHelper = (InputFieldProductionHelper) previousHelper;
			return null;
		}
		else
		{
			this.cachedHelper = this;
			WbdSession.setTemporaryObjectValue(credentials, cachedHelperName, this);
		}

// Uncomment to use Automatic parameters
//		// Get automatic parameters from the session object (usually set by an interupt handler)
//		[[helper]].selectedLocation = WbdSession.getAutomaticUrlParameter(credentials, AUTO_URL_PARAMETER_NAME);

// Uncomment to get parameters passed here from the widget
//		// Get parameters passed to the production helper
//		[[helper]].someParameter = getParameter("someParameter");

		
// Uncomment to use XPC
//		// Select data using XPC
//		boolean OFFLINE_MODE = false;
//		if (OFFLINE_MODE)
//			data = dummyData();
//		else
//		{
//			// Select the data
//			Xpc xpc = ud.getXpc();
//			xpc.start(xpcName, "select");
//			xpc.attrib("someAttrib", value);
//			data = xpc.run();
//			
//			// Check the return type
//			if ( !data.getRootType().equals("select"))
//				throw new WbdException("Invalid data returned: unvalid xml root: " + data.getRootType());
//		}
//		
//		// Get a value from the XPC result
//		[[helper]].myValue = data.getText("/select/recordName/attributeName");

		
// Uncomment to use a navpoint URL
//		// Get a URL for a navpoint
//		String navpointId = getParameter("myNavpoint");
//		[[helper]].navpointUrl = RoutingUIM.navpointUrl(ud, navpointUrl, AutomaticUrlParametersMode.INSERT_AUTOMATIC_URL_PARAMETERS_NOW);

		
// Uncomment to call a web service
// (This will require commons-httpclient-x.x.jar to be included in the build path)
//		// Call a web service
//		HttpClient client = new HttpClient();
//		String url = "http://geocal10am.dyndns.org:10080/tenam/phone/FindDisplayCategoriesActive01/1";
//		PostMethod clientMethod = new PostMethod(url);
//		try {
//			// Send the request to the server
//			int status = client.executeMethod(clientMethod);
//			if (status == HttpStatus.SC_OK) {
//				String response = clientMethod.getResponseBodyAsString();
//				[[helper]].categories = new XData(response);
//			} else {
//				throw new WbdException("Unable to access web service: response code=" + status);
//			}
//        } catch (Exception ex) {
//			if ( !data.getRootType().equals("select"))
//					throw new WbdException("Invalid data returned: unvalid xml root: " + data.getRootType());
//        } finally {
//        	clientMethod.releaseConnection();
//        }
//        [[helper]].categories.sortElements("/*/*/category", "name", true);

		return null;
	}

//	private String dummyData()
//	{
//		return ""
//		+"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
//		+ "<findDisplayCategoriesResponse01>\n"
//		+ " <categories>\n"
//		+ "  <category id=\"1\"><version>0</version><name>GROCERY</name></category>\n"
//		+ "  <category id=\"2\"><version>0</version><name>FASHION</name></category>\n"
//		+ "  <category id=\"3\"><version>0</version><name>HEALTH</name></category>\n"
//		+ "  <category id=\"4\"><version>0</version><name>AUTO</name></category>\n"
//		+ "  <category id=\"6\"><version>0</version><name>LIFESTYLE</name></category>\n"
//		+ "  <category id=\"5\"><version>0</version><name>HOME STUFF</name></category>\n"
//		+ "  <category id=\"7\"><version>0</version><name>SALES</name></category>\n"
//		+ "  <category id=\"9\"><version>0</version><name>SERVICES</name></category>\n"
//		+ " </categories>\n"
//		+ "</findDisplayCategoriesResponse01>\n";
//	}

//	public XData getCategories()
//	{
//		return [[helper]].categories;
//	}

//	public String getMyProperty()
//	{
//		return [[helper]].myProperty;
//	}
}
