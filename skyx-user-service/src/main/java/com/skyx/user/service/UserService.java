package com.skyx.user.service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyx.user.entity.User;
import com.skyx.user.repo.RoleRepository;
import com.skyx.user.repo.StatusRepository;
import com.skyx.user.repo.UserRepository;
import com.skyx.user.request.UserLoginRequest;
import com.skyx.user.request.UserRegistrationRequest;
import com.skyx.user.response.UserResponse;
import com.skyx.user.util.UserServiceConstants;

@Service
public class UserService {

	
	public UserResponse userLogin(UserLoginRequest loginRequest) throws RuntimeException{
		LOGGER.info("UserService - userLogin() ---- STARTED");
		UserResponse userDto = new UserResponse();
		try {
			Optional<User> user = userRepo.findByUserId(loginRequest.getUserId());
			if(user.isPresent()) {
				if(user.get().getPassword().equals(loginRequest.getPassword())) {
					if(!user.get().getStatus().getStatus().equalsIgnoreCase(userServiceConstants.USER_STATUS_BLOCKED)){

						userDto.setFirstName(user.get().getFirstName());
						userDto.setLastName(user.get().getLastName());
						userDto.setEmail(user.get().getEmail());
						userDto.setPhone(user.get().getPhone());
						userDto.setUserId(user.get().getUserId());
						userDto.setStatus(user.get().getStatus().getStatus());
						userDto.setRole(user.get().getRole().getRoleName());
					}else {
						throw new RuntimeException("User is blocked! Please Contact to Admin");
					}
				}else {
					throw new RuntimeException("Invalid Password! Please enter correct Password" );
				}
			}else {
				throw new RuntimeException("Invalid User! User is not registred Yet");
			}
		}catch(NoSuchElementException ex){
			ex.printStackTrace();
			throw new NoSuchElementException("Invalid User! User is not registred Yet");
		}
		LOGGER.info("UserService - userLogin() ---- FINISHED");
		return userDto;
	}
	
	
	public UserResponse createUser(UserRegistrationRequest newUser) {
		LOGGER.info("UserService - userLogin() ---- STARTED");
		
		UserResponse userResponse = new UserResponse();
		try {
			Set<User> userList = new LinkedHashSet<>(userRepo.findAll());
//			if(!userList.contains(new User(newUser.getFirstName(),newUser.getLastName(),newUser.getUserId(),newUser.getPhone(),newUser.getEmail(),newUser.getPassword(),statusRepository.findById(newUser.getStatus()).get(),roleRepository.findById(newUser.getRole()).get(),LocalDateTime.now()))) {
			if(!userList.contains(new User(newUser.getFirstName(),newUser.getLastName(),newUser.getUserId(),newUser.getPhone(),newUser.getEmail(),newUser.getPassword(),statusRepository.findById(newUser.getStatus()).get(),roleRepository.findById(newUser.getRole()).get(),LocalDateTime.now()))) {
			User user = new User(
						newUser.getFirstName(),
						newUser.getLastName(),
						newUser.getUserId(),
						newUser.getPhone(),
						newUser.getEmail(),
						newUser.getPassword(),
						statusRepository.findById(newUser.getStatus()).get(),
						roleRepository.findById(newUser.getRole()).get(),
						LocalDateTime.now()
						);
				User savedUser = userRepo.save(user);
				userResponse.setFirstName(savedUser.getFirstName());
				userResponse.setLastName(savedUser.getLastName());
				userResponse.setUserId(savedUser.getUserId());
				userResponse.setEmail(savedUser.getEmail());
				userResponse.setPhone(savedUser.getPhone());
				userResponse.setStatus(savedUser.getStatus().getStatus());
				userResponse.setRole(savedUser.getRole().getRoleName());
				
				
			}else {
				throw new RuntimeException("Duplicate User! User with UserId: "+newUser.getUserId()+" is already Registred, Can not register again");
			}
			
		}catch(RuntimeException ex){
			ex.printStackTrace();
		}
		LOGGER.info("UserService - userLogin() ---- FINISHED");
		return userResponse;
	}
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserServiceConstants userServiceConstants;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	
}
