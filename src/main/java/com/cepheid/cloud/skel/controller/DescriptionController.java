package com.cepheid.cloud.skel.controller;

import java.util.Collection;
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

import com.cepheid.cloud.skel.SkelApplication;
import com.cepheid.cloud.skel.model.*;
import com.cepheid.cloud.skel.repository.DescriptionRepository;
import io.swagger.annotations.Api;


// curl http:/localhost:9443/app/api/1.0/descriptions/description/{id} getById
//curl http:/localhost:9443/app/api/1.0/descriptions/description/{id}  delete
//curl http:/localhost:9443/app/api/1.0/descriptions getAll 
//curl http:/localhost:9443/app/api/1.0/descriptions  update using PUT
//curl http:/localhost:9443/app/api/1.0/descriptions  insert using POST

@Component
@Path("/api/1.0/descriptions")
@Api()
public class DescriptionController {
	private static final Logger logger = LoggerFactory.getLogger(DescriptionController.class); 

	
  @Autowired
  private DescriptionRepository mDescriptionRepository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public Collection<Description> getDescriptions() {
	logger.info("In getAllDescriptions list API");
    return mDescriptionRepository.findAll();
  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Description postDescription(@RequestBody Description de) {
  logger.info("In postDescriptions  API");
  return mDescriptionRepository.save(de);
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Description updateDescription(@RequestBody Description de) {
  logger.info("In updateDescriptions  API");
  return mDescriptionRepository.save(de);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/description/{mId}")
  public Optional<Description> getDescriptionById(@PathParam(value = "mId") Long mId) throws NotFoundException {
   logger.info("In getDescriptionById  API");
   return Optional.ofNullable(mDescriptionRepository.findById(mId).orElseThrow(() -> new NotFoundException(String.format("Not found"))));
  }
  
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Path("/description/{mId}")
  public void deleteDescriptionById(@PathParam(value = "mId") Long mId) {
   logger.info("In deleteDescriptionById API");
   mDescriptionRepository.deleteById(mId);
   
  }
  
   
  
}
