package com.wallet.cloud.skel.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Player;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.PlayerRepository;

@Service
public class PlayerService {

@Autowired
PlayerRepository playrepo;

@Autowired
AccountRepository accountRepo;

private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);

public List<Player> getAllPlayerDetails(){
return	playrepo.findAll();
}

public Player insertNewPlayerDetails(Player pl){
try {
logger.info("Inside insertNewPlayerDetails service");
Account a=new Account();
a.setBalance(pl.getAccount().getBalance());
a.setAccountNumber(pl.getAccount().getAccountNumber());

Player p= new Player(pl.getName(),pl.getGender(),pl.getAge(),a);
if(p!=null && a!=null) {
	accountRepo.save(a);
   return playrepo.save(p);
	
}
else {
	throw new Exception();
}

}
catch(Exception e) {
	
	logger.error("Duplicate AccountNumber or PlayerName");
}
return null;

}

}
