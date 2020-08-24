package com.wallet.cloud.skel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Gender;
import com.wallet.cloud.skel.model.Player;

@RunWith(SpringRunner.class)
public class PlayerControllerTest extends TestBase {

	@Test
	public void testGetAllPlayers() throws Exception {
		Builder playerController = getBuilder("/app/api/v1/players?number=0&size=4&sort=ASC");
		Response res = playerController.get();
		assertNotNull(res);
		assertEquals(200, res.getStatus());

	}

	@Test
	public void testInsertNewPlayer() throws Exception {
		Builder playerController = getBuilder("/app/api/v1/players");
		Account acc = new Account("100", new BigDecimal(10000));
		Player pl = new Player("Player1", Gender.MALE, 19, acc);
		Response player = playerController.post(Entity.json(pl));
		assertNotNull(player);
		assertEquals(200, player.getStatus());

	}

}
