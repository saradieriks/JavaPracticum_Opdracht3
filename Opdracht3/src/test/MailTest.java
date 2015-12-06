package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datum.Datum;
import domain.Klant;
import domain.Item;
import domain.Mail;

public class MailTest {
	private Mail mail;
	private String eMail;
	private String boodschap;
	
	@Before
	public void setUp() throws Exception {
		mail= new Mail();
		eMail = "test@email.com";
		boodschap = "Hello World";
	}
	
	@Test
	public void test_StuurMail() {
		String expected = "MAIL IS VERSTUURD!  <TO:" +eMail+ "> " + "\n[Boodschap: "+ boodschap + "]";
		assertEquals(expected, mail.stuurMail(eMail, boodschap));
	}
	
	
	
}
