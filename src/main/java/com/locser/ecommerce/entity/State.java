package com.locser.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State {

    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
