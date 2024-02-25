package com.CRUDproject.FullstackBackend.Repository;

import com.CRUDproject.FullstackBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
