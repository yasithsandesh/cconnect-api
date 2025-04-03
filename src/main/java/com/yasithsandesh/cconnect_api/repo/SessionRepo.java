package com.yasithsandesh.cconnect_api.repo;

import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.entitiy.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface SessionRepo extends JpaRepository<Session,Long> {
    Session findByChannel(Channel channel);
}
