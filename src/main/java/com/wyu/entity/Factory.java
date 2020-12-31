package com.wyu.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factory")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factory implements Serializable {

    private static final long serialVersionUID = -7172614110595956553L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long factory_id; //工厂ID

    @Column(name = "factory_license",length = 200)
    private String factory_license; //营业执照

    @Column(name = "factory_contacts",length = 20)
    private String factory_contacts; //工厂联系人

    @Column(name = "contacts_tel",length = 20)
    private String contacts_tel; //联系人电话

    @Column(name = "factory_email",length = 200)
    private String factory_email; //工厂邮箱

    @Column(name = "contacts_id",length = 18)
    private String contacts_id; //身份证号

    @Column(name = "factory_address",length = 200)
    private String factory_address; //工厂地址

    @Column(name = "factory_name",length = 200)
    private String factory_name; //工厂名称

    @Column(name = "factory_info",length = 2000)
    private String factory_info; //工厂信息

    @Column(name = "factory_pic",length = 200)
    private String factory_pic; //工厂介绍图片

    @Enumerated(EnumType.ORDINAL)
    private F_state f_state; //申请状态

    @Column(name = "other",length = 200,unique=true)
    private String other; //其他

    public enum F_state{
        APPLY,
        SUCCESS,
        FAIL
    }
}
