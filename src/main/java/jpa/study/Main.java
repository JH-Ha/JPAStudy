package jpa.study;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpa.study.model.Member;
import jpa.study.model.Team;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try{
      Member member = new Member();
      member.setName("test");

      Team team = new Team();
      member.setTeam(team);
      em.persist(team);
      em.persist(member);

      tx.commit();
    } catch( Exception ex){
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
