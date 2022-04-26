package com.delala.maleda.Model;

import lombok.Data;
import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "house_rent")
public class HouseRent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "bedroom_type")
    private String bedroomType;

    @Column(name = "kitchen_type")
    private String kitchenType;

    @Column(name = "bathroom_type")
    private String bathroomType;

    @Column(name = "exit_type")
    private String exitType;

    @Column(name = "tenant_type")
    private String tenantType;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

}


