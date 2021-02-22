package com.wyu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders_item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Orders.class,fetch=FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne(targetEntity = Item.class,fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "other",length = 200)
    private long other;
}
