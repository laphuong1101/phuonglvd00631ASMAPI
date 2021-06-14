package com.example.hellospring.repository;

import com.example.hellospring.entity.Credential;
import com.example.hellospring.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {

}
