package com.yasithsandesh.cconnect_api.repo;

import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ServiceProfileRepo extends JpaRepository<ServiceProfile, Long> {
    boolean existsByCounsellerId(String id);
    ServiceProfile findByCounsellerId(String id);
}
