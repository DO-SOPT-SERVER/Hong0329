package com.server.dosopt.thirdseminar.ThirdSeminar.repository;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Category;
import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {

}