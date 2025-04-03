package com.yasithsandesh.cconnect_api.repo;

import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ChannelRepo  extends JpaRepository<Channel, Long> {
    List<Channel> findByUserId(String userId);
    List<Channel> findByServiceProfileAndYearAndMonthAndDay(ServiceProfile serviceProfile, int year, int month, int day);
    List<Channel> findByServiceProfile(ServiceProfile serviceProfile);
    List<Channel> findByUserIdOrderByDateDesc(String  userId);
}
