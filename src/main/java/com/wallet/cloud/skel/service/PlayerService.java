package com.wallet.cloud.skel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wallet.cloud.skel.model.Player;

public interface PlayerService {
	Page<Player> getAllPlayerDetails(Pageable pageable);

	Player insertNewPlayerDetails(Player pl);

}
