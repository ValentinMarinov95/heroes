package com.example.heroes.data.models;

import com.example.heroes.data.models.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private int level;
    @Column
    private int stamina;
    @Column
    private int strenght;
    @Column
    private int attack;
    @Column
    private int defence;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Hero_items",
            joinColumns = { @JoinColumn(name = "hero_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "user" , referencedColumnName = "id")
    private User user;
}

