package com.cepheid.cloud.skel.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.cepheid.cloud.skel.SkelApplication;
import com.cepheid.cloud.skel.model.*;

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

import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;
import io.swagger.annotations.Api;

//curl http:/localhost:9443/app/api/1.0/items/item/{id} get by Id
//curl http:/localhost:9443/app/api/1.0/items/item/{id} delete by id
//curl http:/localhost:9443/app/api/1.0/items get all items
//curl http:/localhost:9443/app/api/1.0/items  POST insert new items
//curl http:/localhost:9443/app/api/1.0/items  PUT update items
//curl http:/localhost:9443/app/api/1.0/items/item/count  get count of items
//curl http:/localhost:9443/app/api/1.0/items/itemName/{name} get item by name
//curl http:/localhost:9443/app/api/1.0/items/itemState/{state} get item by state


@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

  private final ItemRepository mItemRepository;
  private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

  @Autowired
  public ItemController(ItemRepository itemRepository) {
    mItemRepository = itemRepository;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public Collection<Item> getItems() {
	  logger.info("In getItem list API");
    return mItemRepository.findAll();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/item/{id}")
  public Item getItemsById(@PathParam(value = "id") Long id) throws NotFoundException{
	  logger.info("In getItemById API");
    return mItemRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Not found")));
  }
  
  @GET
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/item/count")
  public long getItemCount() {
	  logger.info("In itemCount API");
    return mItemRepository.count();
    
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/itemName/{name}")
  public Item getItemByName(@PathParam(value = "name") String name) {
	  logger.info("In getItemByName API");
    return mItemRepository.findByName(name);
    
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/itemState/{state}")
  public List<Item> getItemByState(@PathParam(value = "state") State state) {
	  logger.info("In getItemByState API");
    return mItemRepository.findAllByState(state);
    
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Item updateItems(@RequestBody Item it) {
	  logger.info("In updateItem API");
  return mItemRepository.save(it);
  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Item insertItems(@RequestBody Item it) {
	  logger.info("In insertItems API");
  return mItemRepository.save(it);
  }
  
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Path("/item/{mId}")
  public void deleteItemById(@PathParam(value = "mId") Long mId) {
	  logger.info("In  deleteItemById API");
	 mItemRepository.deleteById(mId);
   
  }
 
  
}
