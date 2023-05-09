package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaFlush {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // flush
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush(); // flush 강제 호출 (commit 시점에 insert 되지 않고 바로 db에 반영)
//            System.out.println("==========================");

            // 준영속 컨텍스트
            Member findMember = em.find(Member.class, 150L); // 1차 캐시에 없으니 값을 가져와서 영속 상태로 만든다
            findMember.setUsername("AAAA");
            em.detach(findMember); // 영속 상태의 findMember 를 준영속 상태로 만든다. 아무 관리를 하지 않기 때문에 update 가 실행되지 않는다. (직접 쓰지는 않는다.)
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }
}
