package com.bilgeadam.SpringBootTuran.service.impl;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Messages;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_MessagesRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_MessagesService;

@Service
public class ETicaret_MessagesServiceImpl implements ETicaret_MessagesService {

	private final ETicaret_MessagesRepository eTicaret_MessagesRepository;

	public ETicaret_MessagesServiceImpl(ETicaret_MessagesRepository eTicaret_MessagesRepository) {
		this.eTicaret_MessagesRepository = eTicaret_MessagesRepository;

	}

	@Override
	public ETicaret_Messages save(ETicaret_Messages eTicaret_Messages) {
		ETicaret_Messages eTicaret_Messagesdb = eTicaret_MessagesRepository.save(eTicaret_Messages);
		return eTicaret_Messagesdb;

	}

	public long getUserid(String email) {

		long id = eTicaret_MessagesRepository.getUserid(email);

		return id;

	}

	
	

}
