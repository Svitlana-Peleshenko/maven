package com.epam.onlineUa;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.pages.AllMailsPage;

public class TestOnlineUa extends BasePage {

	private static final String LOGIN = "svitlana-peleshenko";
	private static final String MSG_TO = "svitlana-peleshenko@online.ua";
	private static final String PASSWD = "sunrise_1";
	private static final String SUBJ = "Message for me";
	private static final String MSG_BODY = "Hello!";

	@Test(description = "Send mail and check it")
	public void testOnlineUaSentAndReceiveEmail() throws InterruptedException {

		AllMailsPage mailPage = toFirstPage().doLogin(LOGIN, PASSWD).goToMail();

		Letter letter = new Letter(MSG_TO, SUBJ, MSG_BODY);

		List<Letter> lettersBefore = mailPage.getLetter();

		mailPage.goToNewMail().sendMail(letter).checkMail();

		List<Letter> lettersAfter = mailPage.getLetter();

		Assert.assertNotEquals(lettersBefore, lettersAfter);
		Assert.assertTrue(lettersAfter.contains(letter));
	}

	

}
