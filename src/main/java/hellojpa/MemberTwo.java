package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 섹션 4 - 엔티티 매핑 - 필드와 컬럼 매핑
 */
// @Entity
public class MemberTwo {

    @Id
    private Long id;

    // nullable = false (not null) (잘씀)
    // unique = true (잘안씀 - 이름을 랜덤으로 만들어줘서) > @Table 속성에다가 넣어준다.
    // columnDefinition = "varchar(100) default 'EMPTY'" (직접지정)
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private int age;

    // EnumType.ORDINAL: enum 순서를 데이터베이스에 저장 (0,1,2,...)
    // EnumType.STRING: enum 이름을 데이터베이스에 저장 (USER, ADMIN, GUEST...)
    // EnumType.ORDINAL 이 기본인데 EnumType.ORDINAL 으로 사용하면 절대 안됨 enum 순서가 바뀔 수 있는 경우가 있기 때문에
    // 꼭 EnumType.STRING 항목을 넣어줄 것
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // JAVA LocalDate, LocalDateTime 은 그냥 쓰면 된다.
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob // CLOB
    private String description;

    @Transient // db 랑 상관없이 메모리에만 사용
    private int temp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
