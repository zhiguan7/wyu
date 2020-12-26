package com.wyu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -7753024719265454181L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id; //用户ID

    @JsonIgnore
    @OneToOne(targetEntity = Institution.class,fetch=FetchType.LAZY)
    @JoinColumn(name="institution",referencedColumnName="institution_id",unique=true)
    private Institution institution; //机构

    @JsonIgnore
    @OneToOne(targetEntity = Factory.class,fetch=FetchType.LAZY)
    @JoinColumn(name="factory",referencedColumnName="factory_id",unique=true)
    private Factory factory; //工厂

    @Enumerated(EnumType.ORDINAL)
    private Role user_role; //用户角色

    @Enumerated(EnumType.ORDINAL)
    private State user_state; //用户状态

    @Enumerated(EnumType.ORDINAL)
    private Gender user_gender; //用户性别

    @Column(name = "user_name",nullable = false,length = 20)
    private String user_name; //用户名

    @Column(name = "user_password",nullable = false,length = 128)
    private String user_password; //用户密码

    @Column(name = "user_tel",length = 20)
    private String user_tel; //用户电话

    @Column(name = "user_address",length = 200)
    private String user_address; //用户地址

    @Column(name = "user_faces",length = 200)
    private String user_faces; //用户头像

    @Column(name = "user_email",length = 200)
    private String user_email; //用户邮箱

    @Column(name = "other",length = 200)
    private String other; //其他

    @JsonIgnore
    @OneToMany(targetEntity = Orders.class,mappedBy = "user",fetch=FetchType.LAZY)
    private List<Orders> orders;

    @JsonIgnore
    @OneToMany(targetEntity = Demand.class,mappedBy = "user",fetch=FetchType.LAZY)
    private List<Demand> demands;

    public enum Role {
        USER,
        ADMINISTRATORS,
        CUSTOMER_SERVICE,
        FACTORY,
        INSTITUTION;
    }

    public enum State {
        ACTIVE,
        CLOSE
    }

    public enum Gender {
        BOY,
        GIRL,
        OTHER
    }
}