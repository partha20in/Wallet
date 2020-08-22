package com.wallet.cloud.skel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wallet.cloud.skel.service.AccountServiceImpl;

public class PageUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PageUtil.class);
	
	@SuppressWarnings("deprecation")
	protected static Pageable createPageRequest(int number, int size, String sort) {
		logger.info("In createPageRequest method");
		
		Sort sorting;

		if (sort.equalsIgnoreCase("ASC")) {
			sorting = new Sort(new Sort.Order(Direction.ASC, "id"));
		} else {
			sorting = new Sort(new Sort.Order(Direction.DESC, "id"));
		}
		Pageable pageables = new PageRequest(number, size, sorting);
		return pageables;
	}


}
