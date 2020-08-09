package com.wallet.cloud.skel.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.wallet.cloud.skel.SkelApplication;
import com.wallet.cloud.skel.model.*;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.TransactionRepository;
//import com.wallet.cloud.skel.repository.ItemRepository;
import com.wallet.cloud.skel.service.AccountService;
import com.wallet.cloud.skel.service.TransactionService;

import io.swagger.annotations.Api;


@Component
@Path("/api/1.0/transactions")
@Api()
public class TransactionController {

  @Autowired
  private TransactionService tservice;
  
  private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);


  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/transactionHistoryByAccountNumber/{accountnumber}")
  public List<Transaction> getTransactionByAccountNumber(@PathParam(value = "accountnumber") String accountnumber) {
	  logger.info("In getTransactionByAccountNumber API");
     return tservice.getAllTransactionsByAccountNumber(accountnumber);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/transactionHistoryByPlayerName/{playerName}")
  public List<Transaction> getTransactionByPlayerName(@PathParam(value = "playerName") String playerName) {
	  logger.info("In getTransactionByPlayerName API");
	  return tservice.getAllTransactionByPlayerName(playerName);
  }

 
  
}
