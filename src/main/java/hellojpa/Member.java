package hellojpa;

import javax.persistence.*;

@Entity(name = "MEMBER_TEST")
@Table(name = "MEMBER_TEST")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)
public class Member {

    /**
     * JPA 기본적으로 내부적으로 리플렉션을 쓰기 때문에 동적으로 객체를 생성해야한다?
     * > 그래서 생성자를 만들라면 기본 생성자가 필요하다.
     */
    protected Member() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

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
}

