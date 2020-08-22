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


@RunWith(SpringRunner.class)
public class AccountControllerTest extends TestBase {

  @Test
  public void testGetDescriptions() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/accounts");
    
    Collection<Account> desc = descriptionController.get(new GenericType<Collection<Account>>() {
    });

  }
  

//  @Test
//  public void testAddCreditsAccount() throws Exception {
//    Builder descriptionController = getBuilder("/app/api/1.0/accounts/credit/Player1/4000/1");
//    
//    Account acc=new Account("100",10000l);
//    Response description = descriptionController.put(Entity.json(acc));
//
//
//  }
//  
//  @Test
//  public void testDebitFromAccount() throws Exception {
//    Builder descriptionController = getBuilder("/app/api/1.0/accounts/debit/Player1/4000/1");
//    
//    Account acc=new Account("100",10000l);
//    Response description = descriptionController.put(Entity.json(acc));
//
//
//  }

  
  
}
