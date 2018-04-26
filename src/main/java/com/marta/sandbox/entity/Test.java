package com.marta.sandbox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Test extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 63)
    private String name;

    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long testAutoIncrement;

    public Test() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTestAutoIncrement() {
        return testAutoIncrement;
    }

    public void setTestAutoIncrement(Long testAutoIncrement) {
        this.testAutoIncrement = testAutoIncrement;
    }
}
