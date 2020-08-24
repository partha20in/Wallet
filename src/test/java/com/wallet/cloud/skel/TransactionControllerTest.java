package com.wallet.cloud.skel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Optional;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.wallet.cloud.skel.model.Account;


@RunWith(SpringRunner.class)
public class TransactionControllerTest extends TestBase {

	@Test
	public void testGetTransactionHistoryByAccountNumber() throws Exception {
		Builder descriptionController = getBuilder("/app/api/v1/accounts/credit/Player1/4000/1");

		Account acc = new Account("100", new BigDecimal(4000));
		Response credit = descriptionController.put(Entity.json(acc));
		Builder transactionController = getBuilder("/app/api/v1/transactions/transactionhistorybyaccountnumber/100");

		Response desc = transactionController.get();
		assertNotNull(desc);
		assertEquals(200, desc.getStatus());

	}

	@Test
	public void testGetTransactionHistoryByPlayerName() throws Exception {
		Builder descriptionControllers = getBuilder("/app/api/v1/accounts/credit/Player1/4000/1");
		Account acc = new Account("100", new BigDecimal(4000));
		Response credit = descriptionControllers.put(Entity.json(acc));
		Builder transactionControllers = getBuilder("/app/api/v1/transactions/transactionhistorybyaccountnumber/100");
		Response desc = transactionControllers.get();
		assertNotNull(desc);
		assertEquals(200, desc.getStatus());
	}

}
