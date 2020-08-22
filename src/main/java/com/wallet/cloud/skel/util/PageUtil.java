package com.wallet.cloud.skel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wallet.cloud.skel.exception.InvalidParametersException;
import com.wallet.cloud.skel.service.AccountServiceImpl;

public class PageUtil {

	private static final Logger logger = LoggerFactory.getLogger(PageUtil.class);

	@SuppressWarnings("deprecation")
	protected static Pageable createPageRequest(int number, int size, String sort) {
		logger.debug("In createPageRequest method");

		Sort sorting;
		Pageable pageables = null;
		try {
			if (sort != null) {
				if (sort.equalsIgnoreCase("ASC")) {
					sorting = new Sort(new Sort.Order(Direction.ASC, "id"));
					pageables = new PageRequest(number, size, sorting);
				} else {
					sorting = new Sort(new Sort.Order(Direction.DESC, "id"));
					pageables = new PageRequest(number, size, sorting);
				}
			} else {
				throw new InvalidParametersException("Provide paging details");
			}
		} catch (InvalidParametersException e) {
			logger.error(e.getMessage());
		}
		
		return pageables;
	}

}
