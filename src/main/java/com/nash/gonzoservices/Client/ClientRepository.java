package com.nash.gonzoservices.Client;

import com.nash.gonzoservices.AppUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
