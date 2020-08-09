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
//import com.wallet.cloud.skel.repository.ItemRepository;
import com.wallet.cloud.skel.service.AccountService;

import io.swagger.annotations.Api;


@Component
@Path("/api/1.0/accounts")
@Api()
public class AccountController {



  @Autowired
  private AccountService accser;
  private static final Logger logger = LoggerFactory.getLogger(AccountController.class);



  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
  public List<Account> getAccounts() {
	  logger.info("In getAccount list API");
	  
    return accser.getAllAccounts();
  }
  

  
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
  @Path("/credit/{name}/{amount}/{transactionId}")
  public Response<Account> addCreditsAccounts(@PathParam(value="name") String name,@PathParam(value="amount") Long amount,@PathParam(value="transactionId") Long transactionId)  {
  logger.info("In addCreditAccounts API");
  Account acc=accser.creditAccount(name,amount,transactionId);
  if(acc!=null) {
  return Response.ok();
  }
  return Response.exception();
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
  @Path("/debit/{name}/{amount}/{transactionId}")
  public Response<Account> debitAccounts(@PathParam(value="name") String name,@PathParam(value="amount") Long amount, @PathParam(value="transactionId") Long transactionId) {
  logger.info("In debitAccounts API");
  Account acc=accser.debitAccount(name,amount,transactionId);
  if(acc!=null) {
  return Response.ok();
  }
  return Response.exception();
  }
  

  
}
