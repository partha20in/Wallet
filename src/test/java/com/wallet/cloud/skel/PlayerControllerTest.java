package com.wallet.cloud.skel;

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
    Builder playerController = getBuilder("/app/api/1.0/players");
    
    Collection<Player> player = playerController.get(new GenericType<Collection<Player>>() {
    });

  }
  
  @Test
  public void testInsertNewPlayer() throws Exception {
    Builder playerController = getBuilder("/app/api/1.0/players");
    Account acc=new Account("100",10000l);
    Player pl=new Player("Player1",Gender.MALE,19,acc);
    Response player = playerController.post(Entity.json(pl));

  }
  

  
}
