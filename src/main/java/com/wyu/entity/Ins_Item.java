package com.wyu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ins_item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ins_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Institution.class,fetch=FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne(targetEntity = Item.class,fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "other",length = 200)
    private long other;
}
