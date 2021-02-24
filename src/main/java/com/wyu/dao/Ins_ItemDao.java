package com.wyu.dao;

import com.wyu.entity.Ins_Item;
import com.wyu.entity.Institution;
import com.wyu.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Ins_ItemDao extends JpaRepository<Ins_Item,Long> {

    @Query("select i.id from Ins_Item i where i.item = ?1 and i.institution = ?2")
    boolean findByIns(Item item,Institution institution);
}
