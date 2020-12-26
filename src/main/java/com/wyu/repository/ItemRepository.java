package com.wyu.repository;

import com.wyu.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> { }
