package com.yasithsandesh.cconnect_api.repo;

import com.yasithsandesh.cconnect_api.entitiy.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
  List<Favorite> findByUserId(String userId);
}
