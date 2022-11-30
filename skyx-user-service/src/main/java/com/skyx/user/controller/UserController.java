package com.skyx.user.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyx.user.request.UserLoginRequest;
import com.skyx.user.request.UserRegistrationRequest;
import com.skyx.user.response.UserResponse;
import com.skyx.user.service.UserService;
import com.skyx.user.util.UserServiceConstants;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@Autowired
	UserServiceConstants userServiceConstants;
	
	org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public UserResponse userLogin(@RequestBody UserLoginRequest loginRequest) throws RuntimeException{
		LOGGER.info("UserController - userLogin() ---- Started!");
		UserResponse userDto = new UserResponse();
		try {
			userDto = userService.userLogin(loginRequest);
		}catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		LOGGER.info("UserController - userLogin() ---- finished!");
		return userDto;
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRegistrationRequest ur) throws RuntimeException{
		
		LOGGER.info("UserController - createUser() ---- Started!");
		UserResponse userResponse = new UserResponse();
		try {
			userResponse = userService.createUser(ur);
		}catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		LOGGER.info("UserController - createUser() ---- finished!");
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);	
	}
	
//	@GetMapping("/getUser{userId}")
//	public UserResponse userLogin(@PathVariable Long userId){
//		UserResponse userDto = new UserResponse();
//		try {
//			Optional<User> user = userRepo.findById(userId);
//			if(user.isPresent()) {
//					if(user.get().getLoginStatus() == USER_LOGIN_STATUS_ACTIVE) {
//						List<Card> cards = user.get().getCards();
//						List<Card> tempCard = new ArrayList<Card>();
//						for(Card card : cards) {
//							if(card.getStatus() == CARD_STATUS_ACTIVE) {
//								tempCard.add(card);
//							}
//						}
//						
//						userDto.setId(user.get().getId());
//						userDto.setName(user.get().getName());
//						userDto.setEmail(user.get().getEmail());
//						userDto.setPhone(user.get().getPhone());
//						userDto.setLoginStatus(user.get().getLoginStatus());
//						userDto.setCards(tempCard);
//						
//					}else {
//						throw new RuntimeException("Blocked User! Please Contact to Admin");
//					}
//				}
//		}catch(NoSuchElementException ex){
//			throw new NoSuchElementException("Invalid User! User is not registred");
//		}
//		return userDto;
//	}
	
	
}
