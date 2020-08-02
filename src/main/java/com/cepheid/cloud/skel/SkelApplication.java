package com.cepheid.cloud.skel;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cepheid.cloud.skel.controller.ItemController;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.model.State;
import com.cepheid.cloud.skel.repository.*;


@SpringBootApplication(scanBasePackageClasses = { ItemController.class, SkelApplication.class })
@EnableJpaRepositories(basePackageClasses = { ItemRepository.class,DescriptionRepository.class })
public class SkelApplication {
private static final Logger logger = LoggerFactory.getLogger(SkelApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(SkelApplication.class, args);
  }
  
  List<Description> descs=new ArrayList<Description>();
  List<Item> items=new ArrayList<Item>();
  Item item;
  Description desc;
  
  @Bean
  ApplicationRunner initItems(ItemRepository itemrepository,DescriptionRepository descriptionrepository) {
    return args -> {
    	
    	
      Stream.of("Lord of the rings", "Hobbit", "Silmarillion", "Unfinished Tales and The History of Middle-earth")
            .forEach(name -> {
        	item=new Item();
            item.setName(name);
            if(item.getName().equals("Hobbit"))
            {
            	item.setState(State.INVALID);
            }
            else {
            	item.setState(State.VALID); 
            }
            items.add(item);         
            itemrepository.save(item);
            
          });
      
 
      itemrepository.save(item);

    Stream.of("Action", "Adventure","Comedy","Thriller")
    .forEach((type) -> {
	  desc=new Description();
	  desc.setType(type);
      desc.setBudget(8888l);
      desc.setRelease_year(1991l);
      descs.add(desc);
    });
      desc.setItem(item);
      descs.get(0).setItem(item);
      itemrepository.save(item);
      for(Description desc:descs)
      descriptionrepository.save(desc);
 
    itemrepository.findAll().forEach(System.out::println);
    descriptionrepository.findAll().forEach(System.out::println);

    long total_budget=descs.stream().mapToLong(desc -> desc.getBudget()).sum();
    logger.info("Total budget at start :"+total_budget);
    		
  };
  }

}
