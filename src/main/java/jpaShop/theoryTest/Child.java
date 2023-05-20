package jpaShop.theoryTest;

import javax.persistence.*;

@Entity
public class Child {

    @Id @GeneratedValue
    private Long child_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    public Long getChild_id() {
        return child_id;
    }

    public void setChild_id(Long child_id) {
        this.child_id = child_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
