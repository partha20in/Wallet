package com.cepheid.cloud.skel;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.model.State;

@RunWith(SpringRunner.class)
public class DescriptionControllerTest extends TestBase {

  @Test
  public void testGetDescriptions() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    
    Collection<Description> desc = descriptionController.get(new GenericType<Collection<Description>>() {
    });

  }
  
  @Test
  public void testInsertDescription() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    Item i=new Item("The Game",State.VALID);
    Long id=(long) 1;
    Description d=new Description("Romantic",8987l,2006l,i);
    Response description = descriptionController.post(Entity.json(d));

  }
  
  @Test
  public void testUpdateDescription() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    Item i=new Item("The Game-1",State.INVALID);
    Long id=(long) 1;
    Description d=new Description("Romantic",8999l,2007l,i);
    Response description = descriptionController.put(Entity.json(d));


  }
  @Test
  public void testGetDescriptionById() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions/description/1");
    
    Description desc = descriptionController.get(new GenericType<Description>() {
    });

  }
  
  @Test
  public void testDeleteDescriptionById() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions/description/1");
    
    descriptionController.delete();

  }
  
  
}
