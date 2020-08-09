package com.wallet.cloud.skel.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.wallet.cloud.skel.model.*;
import com.wallet.cloud.skel.service.PlayerService;
import io.swagger.annotations.Api;



@Component
@Path("/api/1.0/players")
@Api()
public class PlayerController {


  
  private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

  @Autowired
  PlayerService ps;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
  public List<Player> getPlayers() {
	  logger.info("In getAccountlist API");
    return ps.getAllPlayerDetails();
  }
  

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
  public Response<Player> insertPlayers(@RequestBody Player pl) {
  logger.info("In insertPlayers API");
  Player pla=ps.insertNewPlayerDetails(pl);
  if(pla!=null) {
  return Response.ok();
  }
  return Response.badRequest();
  }
  

 
  
}