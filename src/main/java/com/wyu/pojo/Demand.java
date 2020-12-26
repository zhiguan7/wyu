package com.wyu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "demand")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demand implements Serializable {

    private static final long serialVersionUID = -3448960583906275913L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long demand_id; //需求ID

    @Column(name = "demand_contacts",length = 20)
    private String demand_contacts; //联系人

    @Column(name = "tel",length = 20)
    private String tel; //联系电话

    @Column(name = "email",length = 200)
    private String email; //联系邮箱

    @Column(name = "quantity",length = 200)
    private String quantity; //样品数量

    @Column(name = "budget",length = 200)
    private String budget; //预算范围

    @Column(name = "cycle",length = 200)
    private String cycle; //完成周期

    @Column(name = "enclosure",length = 200)
    private String enclosure; //附件

    @Column(name = "describes",length = 2000)
    private String describes; //需求描述

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = true)
    private Date create_time; //创建时间

    @Column(name = "recommend",length = 200)
    private String recommend; //推荐机构(多家)

    @Column(name = "choice",length = 200)
    private String choice; //确认机构

    @Enumerated(EnumType.ORDINAL)
    private demandState demand_state; //需求的状态

    @Column(name = "demand_remarks",length = 200)
    private String demand_remarks; //订单备注

    @ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public enum demandState {
        ACTIVE,
        CLOSE
    }
}