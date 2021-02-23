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

    @Column(name = "other",length = 200)
    private long other; //其他

    @Enumerated(EnumType.ORDINAL)
    private Item_state item_state; //项目上架状态

    @JsonIgnore
    @OneToMany(targetEntity = Ins_Item.class,mappedBy = "item",fetch=FetchType.LAZY)
    private Set<Ins_Item> Ins_items;

    @JsonIgnore
    @OneToMany(targetEntity = Orders_Item.class,mappedBy = "item",fetch=FetchType.LAZY)
    private Set<Orders_Item> orders_items;

    public enum Item_state{
        ON,
        OFF
    }

}
