package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaPersistMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

/**
 * 영속성 컨테스트 - 1차 캐시
 */
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");
//
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            //em.find select 쿼리가 나가지 않는다 why? -> 1차 캐시
//            Member findMember = em.find(Member.class, 100L);
//            System.out.println("findMember id = " + findMember.getId());
//            System.out.println("findMember name = " + findMember.getName());

// ======================================================================================= //
//            Member findMember1 = em.find(Member.class, 100L); // select 실행
//            Member findMember2 = em.find(Member.class, 100L); // 1차 캐시

/**
 * 영속성 컨테스트 - 영속 엔티티의 동일성 보장
 */
//            Member findMember1 = em.find(Member.class, 100L); // select 실행
//            Member findMember2 = em.find(Member.class, 100L); // 1차 캐시
//            System.out.println("(findMember1 == findMember2) = " + (findMember1 == findMember2));

/**
 *
 * 영속성 컨테스트 - 트랜잭션을 지원하는 쓰기 지원
 */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=============================");
//            tx.commit();

/**
 * 영속성 컨테스트 - 변경감지
 */
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ"); // 데이터를 변경하면 알아서 update 해준다. Java Collection 과 동일하다.

/**
 * 영속성 컨테스트 - 삭제
 */
//            Member member = em.find(Member.class, 150L);
//            em.remove(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }
}
