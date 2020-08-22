package com.wallet.cloud.skel.controller;

import java.math.BigDecimal;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wallet.cloud.skel.SkelApplication;
import com.wallet.cloud.skel.model.*;
import com.wallet.cloud.skel.repository.AccountRepository;
//import com.wallet.cloud.skel.repository.ItemRepository;
import com.wallet.cloud.skel.service.AccountServiceImpl;

import io.swagger.annotations.Api;

@Component
@Path("/api/v1/accounts")
@Api()
public class AccountController {

	@Autowired
	private AccountServiceImpl accser;
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Page<Account> getAccounts(@QueryParam(value = "number") int number, @QueryParam(value = "size") int size,
			@QueryParam(value = "sort") String sort) {

		logger.info("In getAccount list API");

		return accser.getAllAccounts(number, size, sort);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Path("/credit/{name}/{amount}/{transactionId}")
	public Response<Account> addCreditsAccounts(@PathParam(value = "name") String name,
			@PathParam(value = "amount") BigDecimal amount, @PathParam(value = "transactionId") Long transactionId) {
		logger.info("In addCreditAccounts API");
		Account acc = accser.creditAccount(name, amount, transactionId);
		if (acc != null) {
			return Response.ok();
		}
		return Response.exception();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Path("/debit/{name}/{amount}/{transactionId}")
	public Response<Account> debitAccounts(@PathParam(value = "name") String name,
			@PathParam(value = "amount") BigDecimal amount, @PathParam(value = "transactionId") Long transactionId) {
		logger.info("In debitAccounts API");
		Account acc = accser.debitAccount(name, amount, transactionId);
		if (acc != null) {
			return Response.ok();
		}
		return Response.exception();
	}

}
