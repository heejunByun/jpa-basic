package jpaShop;

import jpaShop.domain.Member;
import jpaShop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaShopMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("memberA");
            member.changeTeam(team); // 둘 중 하나만
            // team.addMember(member); // 둘 중 하나만
            em.persist(member);

//            em.flush(); // db 강제 호출
//            em.clear(); // 영속성 컨테스트 초기화

            Team findTeam = em.find(Team.class, team.getId());
            System.out.println("findTeam.setName()); = " + findTeam.getName());
            List<Member> members = findTeam.getMembers();
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }

}
