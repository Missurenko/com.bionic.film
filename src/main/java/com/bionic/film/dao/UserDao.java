package com.bionic.film.dao;


import com.bionic.film.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

        User findByEmail(String email);

        User findById(long id);

        @Query("from User")
        List<User> hibernateQuery();

    }
