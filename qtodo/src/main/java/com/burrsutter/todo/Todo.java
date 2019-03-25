package com.burrsutter.todo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
@Cacheable
public class Todo extends PanacheEntity {
    @Column(nullable=false)
    public String title;
    
    @Column(nullable=false)
    public Boolean completed = false;
    @Column(name ="todoorder")
    public Integer order;

    public Todo() {
        
    }
}    