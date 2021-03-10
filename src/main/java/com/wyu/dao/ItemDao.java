package com.wyu.dao;

import com.wyu.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {

    @Modifying
    @Transactional
    @Query("update Item i set i.item_state = :#{#state}, i.other = :#{#other} where i.item_id = :#{#id}")
    int changeState(@Param("id")long id, @Param("state") Item.Item_state state, @Param("other")long other);

    @Modifying
    @Transactional
    @Query( "update Item i set " +
            "i.price = case when :#{#item.price} is null then i.price else :#{#item.price} end , " +
            "i.discount = case when :#{#item.discount} is null then i.discount else :#{#item.discount} end , " +
            "i.category = case when :#{#item.category} is null then i.category else :#{#item.category} end , " +
            "i.item_address = case when :#{#item.item_address} is null then i.item_address else :#{#item.item_address} end , " +
            "i.item_name = case when :#{#item.item_name} is null then i.item_name else :#{#item.item_name} end , " +
            "i.item_target = case when :#{#item.item_target} is null then i.item_target else :#{#item.item_target} end , " +
            "i.item_remarks = case when :#{#item.item_remarks} is null then i.item_remarks else :#{#item.item_remarks} end , " +
            "i.other = :#{#item.other} where i.item_id = :#{#item.item_id}")
    int update(@Param("item") Item item);
}
