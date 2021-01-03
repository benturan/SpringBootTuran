package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_UserRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_UsersService;

@Service
public class ETicaret_UsersServiceImpl implements ETicaret_UsersService {

	private final ETicaret_UserRepository eTicaret_UsersRepository;

	public ETicaret_UsersServiceImpl(ETicaret_UserRepository eTicaret_UserRepository) {
		this.eTicaret_UsersRepository = eTicaret_UserRepository;

	}

	@Override
	public ETicaret_Users save(ETicaret_Users eTicaret_Users) {
		ETicaret_Users eTicaret_Usersdb = eTicaret_UsersRepository.save(eTicaret_Users);
		return eTicaret_Usersdb;

	}

	public long getUserid(String email) {

		long id = eTicaret_UsersRepository.getUserid(email);

		return id;

	}

	public long getUserid2(String twitterusername) {
		long id = eTicaret_UsersRepository.getUserid2(twitterusername);
		return id;
	}

	public String getPassword(String email) {
		String password = eTicaret_UsersRepository.getPassword(email);
		return password;
	}

	public String getRole(String email) {
		String role = eTicaret_UsersRepository.getRole(email);
		return role;
	}
	
	public String getUserName(String email) {
		String userName = eTicaret_UsersRepository.getUserName(email);
		return userName;
	}

	@SuppressWarnings("unused")
	public int mobileLogin(String email, String password) {

		int UserId = 0;

		if (eTicaret_UsersRepository.mobileLogin(email, password) > 0) {
			UserId = Math.toIntExact(getUserid(email));

		}

		return UserId;
	}

	public ETicaret_Users userProfile(Long userId) {
		ETicaret_Users user = eTicaret_UsersRepository.getOne(userId);
		return user;
	}

	public ETicaret_Users updateProfile(ETicaret_Users eTicaret_Users) {

		ETicaret_Users userUpd = eTicaret_UsersRepository.saveAndFlush(eTicaret_Users);
		return userUpd;
	}

	@SuppressWarnings("unused")
	public String forgotPassword(String email) {

		String password;

		password = eTicaret_UsersRepository.forgotPassword(email);

		return password;
	}

	@SuppressWarnings("unused")
	public ETicaret_Users findByUserEmail(String useremail) {
		ETicaret_Users data = eTicaret_UsersRepository.findByUseremail(useremail);
		return data;
	}
	
	public List<ETicaret_Users> getAllUsers() {
		List<ETicaret_Users> userList = eTicaret_UsersRepository.findAll();
		return userList;
	}

}
