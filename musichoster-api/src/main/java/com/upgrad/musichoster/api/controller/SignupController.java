package com.upgrad.musichoster.api.controller;


import com.upgrad.musichoster.service.business.SignupBusinessService;
import com.upgrad.musichoster.service.entity.UserEntity;
import com.upgrad.musichoster.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.upgrad.musichoster.api.model.*;
import java.util.UUID;

@RequestMapping("/")
public class SignupController {

    @Autowired
    private SignupBusinessService signupBusinessService;

    @RequestMapping(method = RequestMethod.POST, path = "/usersignup", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupUserResponse> userSignup(@RequestBody(required = false) final SignupUserRequest signupUserRequest)
            throws SignUpRestrictedException {

        final UserEntity userEntity = new UserEntity();
         
        userEntity.setFirstName(signupUserRequest.getFirstName());

        userEntity.setLastName(signupUserRequest.getLastName());

        userEntity.setUuid(UUID.randomUUID().toString());

        userEntity.setEmail(signupUserRequest.getEmailAddress());

        userEntity.setMobilePhone(signupUserRequest.getMobileNumber());

        userEntity.setPassword(signupUserRequest.getPassword());

        userEntity.setSalt("random");
        userEntity.setRole("administrator");

        final UserEntity createUserEntity = signupBusinessService.signup(userEntity);
        SignupUserResponse userResponse = new SignupUserResponse().id(createUserEntity.getUuid()).status("Thank you for registering. You are registered");
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);

    }
}
