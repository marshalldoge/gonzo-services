package com.nash.gonzoservices.AppUser;


import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/AppUser")
public class AppUserController {
	
    @Autowired
    AppUserService appUserService;


    @GetMapping
    AppUser getEspecificUser(@RequestParam Long idAppUser){
        return appUserService.findById(idAppUser);
    }


    @PostMapping("/sign-up")
    public ObjectResponse signUp(@RequestBody AppUser user) {
        System.out.println(user.toString());
        System.out.println(user.getUsername()+" - "+user.getPassword());
        ObjectResponse res = new ObjectResponse();
        try{
            user.setPassword(user.getPassword());
            appUserService.save(user);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }
    @PostMapping("/login")
    public ObjectResponse login(@RequestBody LoginRequest loginRequest) {
        ObjectResponse res = new ObjectResponse();
        try{
            AppUser user = appUserService.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
            if(user != null){
                res.setData(user);
            }else{
                res.setSuccess(false);
                res.setStatusMessage("There is no users with that username and password combination.");
            }
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }

}
