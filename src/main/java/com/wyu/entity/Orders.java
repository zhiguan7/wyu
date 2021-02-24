package com.wyu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "orders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

    private static final long serialVersionUID = 529520095361324324L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orders_id; //订单ID

    @ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
    @JoinColumn(name="user")
    private User user;

    @ManyToOne(targetEntity = Institution.class,fetch=FetchType.LAZY)
    @JoinColumn(name="institution")
    private Institution institution;

    @JsonIgnore
    @OneToMany(targetEntity = Orders_Item.class,mappedBy = "orders",fetch=FetchType.LAZY)
    private Set<Orders_Item> orders_items;

    @Column(name = "price",length = 20)
    private float price; //项目总价格(不包含杂项费用)

    @Column(name = "sundries",length = 20)
    private float sundries; //杂项收费

    @Column(name = "orders_remarks",length = 200)
    private String orders_remarks; //订单备注

    @Column(name = "type",length = 20)
    private String type; //交易类型

    @Enumerated(EnumType.ORDINAL)
    private Payment payment; //订单状态

    @Column(name = "create_time")
    private int create_time; //交易创建时间

    @Column(name = "pay_time")
    private int pay_time; //交易付款时间

    @Column(name = "completion_time")
    private int completion_time; //交易关闭时间

    @Column(name = "other",length = 200)
    private long other; //其他

    public enum Payment {
        CLOSE, //关闭订单
        UNPAID, //待支付
        PAID, //已支付
        FINISH //已完成
    }
}
