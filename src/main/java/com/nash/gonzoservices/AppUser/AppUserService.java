package com.nash.gonzoservices.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public void save(AppUser appUser){
        appUserRepository.save(appUser);
    }

    public AppUser findById(Long idAppUser){
        return appUserRepository.findById(idAppUser).get();
    }


    public ArrayList<AppUser> findAll(){
        return (ArrayList<AppUser>) appUserRepository.findAll();
    }

    public HashMap<Long,AppUser> appUserHashMap(){
        HashMap<Long,AppUser> appUserHashMap = new HashMap<>();
        ArrayList<AppUser> appUsers = this.findAll();
        for(int i=0;i<appUsers.size();i++){
            appUserHashMap.put(appUsers.get(i).getId(),appUsers.get(i));
        }
        return appUserHashMap;
    }

    public AppUser findByUsernameAndPassword(String username,String password){
        return appUserRepository.findByUsernameAndPassword(username,password);
    }

}
