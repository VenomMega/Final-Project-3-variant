package com.javaeefinal.itse1908r.javaeefinal.RepositoryImpl;

import com.javaeefinal.itse1908r.javaeefinal.Models.Terminal;
import com.javaeefinal.itse1908r.javaeefinal.Models.Servicepointstatus;
import com.javaeefinal.itse1908r.javaeefinal.EntityManager;
import com.javaeefinal.itse1908r.javaeefinal.Repositories.TerminalRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class TerminalRepositoryImpl implements TerminalRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Terminal> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Query query = entityManager.createQuery("SELECT s FROM Terminal s");
            List<Terminal> result = query.getResultList();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Terminal findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT s FROM Terminal s WHERE s.id = %d", id);
            Query query = entityManager.createQuery(sql);
            Terminal result = (Terminal) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Terminal changeTerminalStatusById(int id, int status) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Terminal terminal = entityManager.find(Terminal.class, id);
            Servicepointstatus servicepointstatus = entityManager.find(Servicepointstatus.class, terminal.getStatus().getId());
            terminal.setStatus(servicepointstatus);
            entityManager.persist(terminal);
            return terminal;
        } catch (NoResultException e){
            return null;
        }
    }
}
