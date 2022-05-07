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
      team.setName("teamName");
      member.setTeam(team);
      em.persist(team);
      em.persist(member);

      em.flush();
      em.clear();

      Member m = em.find(Member.class, member.getId());
      System.out.println("m = " + m.getTeam().getName());
      System.out.println("t = ");
      tx.commit();
    } catch( Exception ex){
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
