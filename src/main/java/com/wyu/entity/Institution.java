package com.wyu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "institution")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Institution implements Serializable {

    private static final long serialVersionUID = -63725199390581976L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long institution_id; //机构ID

    @Column(name = "institution_name",length = 200)
    private String institution_name; //机构名称

    @Column(name = "institution_address",length = 200)
    private String institution_address; //机构地址

    @Column(name = "institution_license",length = 200)
    private String institution_license; //营业执照

    @Column(name = "credentials",length = 200)
    private String credentials; //资质认定书

    @Column(name = "enclosure",length = 200)
    private String enclosure; //资质认定计量认证书附件

    @Column(name = "qualifications",length = 200)
    private String qualifications; //资质

    @Column(name = "contacts_id",length = 18)
    private String contacts_id; //身份证号

    @Column(name = "institution_info",length = 2000)
    private String institution_info; //机构信息

    @Column(name = "institution_pic",length = 200)
    private String institution_pic; //机构介绍图片

    @Column(name = "institution_contacts",length = 20)
    private String institution_contacts; //机构联系人

    @Column(name = "contacts_tel",length = 20)
    private String contacts_tel; //机构电话

    @Column(name = "institution_email",length = 200)
    private String institution_email; //机构邮箱

    @Column(name = "other",length = 200)
    private long other; //其他

    @Enumerated(EnumType.ORDINAL)
    private I_state i_state; //申请状态

    @JsonIgnore
    @OneToMany(targetEntity = Ins_Item.class,mappedBy = "institution",fetch=FetchType.LAZY)
    private Set<Ins_Item> ins_items;

    @JsonIgnore
    @OneToMany(targetEntity = Orders.class,mappedBy = "institution",fetch=FetchType.LAZY)
    private Set<Orders> orders;

    public enum I_state{
        APPLY,
        SUCCESS,
        FAIL
    }
}
