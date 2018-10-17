package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    public void hhh123Test() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.setFlushMode(FlushModeType.AUTO);

        EventLog eventLog1 = new EventLog();
        eventLog1.setMessage("Foo1");
        entityManager.persist(eventLog1); // Persist Entity with non generated id

        EventLog eventLog2 = new EventLog();
        eventLog2.setMessage("Foo2");
        entityManager.persist(eventLog2); // Persist Entity with non generated id

        System.out.println("Persisted EventLogs");

        Comment comment = new Comment();
        comment.setMessage("Bar");
        entityManager.persist(comment);
        System.out.println("Persisted Comment");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
