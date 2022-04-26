package com.delala.maleda.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "nanny")
public class Nanny implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "exp_in_yrs")
    private Integer expInYrs;

    @Column(name = "available_date")
    private Date availableDate;

    @Column(name = "expected_salary")
    private Double expectedSalary;

    @Column(name = "preferred_language")
    private String preferredLanguage;

    @Column(name = "preferred_schedule")
    private String preferredSchedule;

    @Column(name = "preferred_city")
    private String preferredCity;

    @Column(name = "preferred_state")
    private String preferredState;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;
}
