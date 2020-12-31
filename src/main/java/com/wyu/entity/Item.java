package com.wyu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 4836395418421067837L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long item_id; //项目ID

    @Column(name = "price")
    private int price; //单价

    @Column(name = "discount")
    private float discount; //折扣

    @Column(name = "category",length = 200)
    private String category; //类别

    @Column(name = "item_address",length = 200)
    private String item_address; //场所

    @Column(name = "item_name",length = 200)
    private String item_name; //项目名称

    @Column(name = "item_target",length = 200)
    private String item_target; //检测对象

    @Column(name = "item_remarks",length = 2000)
    private String item_remarks; //备注

    @Enumerated(EnumType.ORDINAL)
    private Item_state item_state; //项目上架状态

    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "ins_item"
            ,joinColumns = @JoinColumn(name = "item_id",referencedColumnName = "item_id")
            ,inverseJoinColumns = @JoinColumn(name = "institution_id",referencedColumnName = "institution_id"))
    private Set<Institution> institutions;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="orders_id",nullable = false)
    private Orders orders;

    public enum Item_state{
        ON,
        OFF
    }

}
