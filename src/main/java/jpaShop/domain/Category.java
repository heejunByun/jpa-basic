package jpaShop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // Self Mapping (부모)
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    // Self Mapping (자식)
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    // 중간테이블 Mapping
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns =  @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();
}
