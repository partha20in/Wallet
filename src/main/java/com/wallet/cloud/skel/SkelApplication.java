package com.wallet.cloud.skel;

import java.math.BigDecimal;
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
import com.wallet.cloud.skel.controller.AccountController;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Gender;
import com.wallet.cloud.skel.model.Player;
import com.wallet.cloud.skel.repository.*;

@SpringBootApplication(scanBasePackageClasses = { AccountController.class, SkelApplication.class })
@EnableJpaRepositories(basePackageClasses = { AccountRepository.class, PlayerRepository.class })
public class SkelApplication {
	private static final Logger logger = LoggerFactory.getLogger(SkelApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SkelApplication.class, args);
	}

	Player player;
	Account acc;
	List<Account> accounts = new ArrayList<Account>();

	@Bean
	ApplicationRunner initItems(AccountRepository accountrepository, PlayerRepository playerrepository) {
		return args -> {

			Stream.of("100", "200").forEach(number -> {
				acc = new Account();
				acc.setAccountNumber(number);
				acc.setBalance(new BigDecimal(10000));
				accounts.add(acc);

				accountrepository.save(acc);

			});
			logger.info("Account info at start" + accounts);

			Stream.of("Player1", "Player2").forEach((name) -> {
				player = new Player();
				player.setName(name);
				player.setAge(18);
				player.setGender(Gender.MALE);
				if (name.equals("Player1")) {
					player.setAccount(accounts.get(0));
				} else {
					player.setAccount(accounts.get(1));
				}
				playerrepository.save(player);

			});

			accountrepository.findAll().forEach(System.out::println);
			playerrepository.findAll().forEach(System.out::println);

		};
	}

}
