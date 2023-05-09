package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("유진");
//            em.persist(member);

            // update 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("변희준입니다.");

            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // JPQL
            // 객체를 대상으로 쿼리를 작성한다. (테이블 대상 X)
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1) // 페이징 시작
//                    .setMaxResults(10) // 페이징 끝
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

/**
 * 기본 키 매핑
 */

            Member member1 = new Member();
            // member.setId("ID_A");
            member1.setUsername("HelloA");

            Member member2 = new Member();
            // member.setId("ID_A");
            member2.setUsername("HelloB");

            Member member3 = new Member();
            // member.setId("ID_A");
            member3.setUsername("HelloC");

            System.out.println("=====================");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("=====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }
}
