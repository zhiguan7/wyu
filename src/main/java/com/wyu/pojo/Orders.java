package com.wyu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
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
    @OneToMany(targetEntity = Item.class,mappedBy = "orders",fetch=FetchType.LAZY)
    private List<Item> items;

    @Column(name = "price",length = 20)
    private float price; //项目总价格(不包含杂项费用)

    @Column(name = "sundries",length = 20)
    private float sundries; //杂项收费

    @Column(name = "orders_remarks",length = 200)
    private String orders_remarks; //订单备注

    @Column(name = "type",length = 20)
    private String type; //交易类型

    @Enumerated(EnumType.ORDINAL)
    private Payment payment; //支付状态

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = true)
    private Date create_time; //交易创建时间

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pay_time", nullable = true)
    private Date pay_time; //交易付款时间

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "completion_time", nullable = true)
    private Date completion_time; //交易关闭时间

    public enum Payment {
        UNPAID,PAID
    }
}
