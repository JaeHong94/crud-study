package com.example.shoptest.domain.repository;

import com.example.shoptest.domain.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

//  Optional<ShopEntity> findById(Long id);

}
