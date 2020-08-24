package com.wallet.cloud.skel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.cloud.skel.model.Account;

@RunWith(SpringRunner.class)
public class AccountControllerTest extends TestBase {

	@Test
	public void testGetAccounts() throws Exception {
		Builder descriptionController = getBuilder("/app/api/v1/accounts?number=0&size=4&sort=ASC");

		Response res = descriptionController.get();

		assertNotNull(res);
		assertEquals(200, res.getStatus());

	}

	@Test
	public void testAddCreditsAccount() throws Exception {
		Builder descriptionController = getBuilder("/app/api/v1/accounts/credit/Player1/4000/1");

		Account acc = new Account("100", new BigDecimal(4000));
		Response credit = descriptionController.put(Entity.json(acc));
		assertNotNull(credit);
		assertEquals(200, credit.getStatus());

	}

	@Test
	public void testDebitFromAccount() throws Exception {
		Builder descriptionController = getBuilder("/app/api/v1/accounts/debit/Player1/4000/1");

		Account acc = new Account("100", new BigDecimal(4000));
		Response debit = descriptionController.put(Entity.json(acc));
		assertNotNull(debit);
		assertEquals(200, debit.getStatus());

	}

}
