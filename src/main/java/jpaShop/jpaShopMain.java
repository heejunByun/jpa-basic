package jpaShop;

import jpaShop.domain.*;
import jpaShop.theoryTest.Child;
import jpaShop.theoryTest.Parent;

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

            Parent parent = new Parent();
            Child child1 = new Child();
            Child child2 = new Child();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getParent_id());
            findParent.getChildList().remove(0);
//            Child findChild = em.find(Child.class, child1.getChild_id());
//            em.remove(findChild);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 닫아줘야함 (내부적으로 커넥션을 물고 동작하기 떄문에)
        }
        emf.close();
    }

}
