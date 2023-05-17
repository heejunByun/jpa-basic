package jpaShop;

import jpaShop.domain.Member;
import jpaShop.domain.Order;
import jpaShop.domain.OrderItem;
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
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }

}
