package com.wallet.cloud.skel;


import java.util.Optional;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.wallet.cloud.skel.model.Transaction;


@RunWith(SpringRunner.class)
public class TransactionControllerTest extends TestBase {


  @Test
  public void testGetTransactionHistoryByAccountNumber() throws Exception {
    Builder transactionController = getBuilder("/app/api/1.0/transactions/transactionHistoryByAccountNumber/100");
    
    Optional<Transaction> desc = Optional.empty();

  }
  
  @Test
  public void testGetTransactionHistoryByPlayerName() throws Exception {
    Builder transactionController = getBuilder("/app/api/1.0/transactions/transactionHistoryByPlayerName/Player1");
    
    Optional<Transaction> desc = Optional.empty();

  }
  

  
}
