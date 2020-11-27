package com.Repository;

import com.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,String> {

    List<Email> findAllByReceives(String receives);

    List<Email> findAllBySends(String email);
}
