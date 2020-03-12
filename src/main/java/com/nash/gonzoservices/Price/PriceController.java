package com.nash.gonzoservices.Price;

import com.nash.gonzoservices.AppUser.AppUser;
import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

    @Autowired
    PriceRepository priceRepository;

    @GetMapping
    public ObjectResponse getPrice() {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(priceRepository.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }
}
