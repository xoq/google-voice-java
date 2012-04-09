package test.util;

import com.techventus.server.voice.util.SMSParser;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 
 * @author bFutral
 *
 */
public class SMSParserTest {
	//TestSMSParser
	private SMSParser testSMSParser;
	//Reflection Setup
	private Method pPNM;
	private static final String TEST_PARSE_PHONE_NUMBER = "parsePhoneNumber";
	@SuppressWarnings("rawtypes")
	private Class[] parsePhoneNumberParameterTypes;
	private Object[] parsePhoneNumberParameters;

	@Before
	public void setUp() throws NoSuchMethodException, SecurityException {
		//Instantiate testSMSParser
		testSMSParser = new SMSParser("test", "5030000000");
		//Reflect class/method
		parsePhoneNumberParameterTypes = new Class[1];
		parsePhoneNumberParameterTypes[0] = java.lang.String.class;
		pPNM = testSMSParser.getClass().getDeclaredMethod(
				TEST_PARSE_PHONE_NUMBER, parsePhoneNumberParameterTypes);
		pPNM.setAccessible(true);
		parsePhoneNumberParameters = new Object[1];
	}

	@Test
	public void testParsePhoneNumber() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
		parsePhoneNumberParameters[0] = "5035551212";
		final String test = (String) pPNM.invoke(testSMSParser,
				parsePhoneNumberParameters);
		Assert.assertEquals("+15035551212", test);
	}

}