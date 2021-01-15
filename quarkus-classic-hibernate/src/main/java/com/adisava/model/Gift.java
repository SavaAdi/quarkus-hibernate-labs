package com.adisava.model;

import javax.persistence.Entity;

@Entity
public class Gift extends BaseEntity{

    private static final long serialVersionUID = 3983596550328295546L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gift gift = (Gift) o;

        return getName().equals(gift.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
