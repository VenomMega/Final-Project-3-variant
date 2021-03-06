package com.javaeefinal.itse1908r.javaeefinal.RepositoryImpl;

import com.javaeefinal.itse1908r.javaeefinal.Models.Userdetail;
import com.javaeefinal.itse1908r.javaeefinal.EntityManager;
import com.javaeefinal.itse1908r.javaeefinal.Repositories.UserdetailRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserdetailRepositoryImpl implements UserdetailRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Userdetail> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Query query = entityManager.createQuery("SELECT u FROM Userdetail u");
            List<Userdetail> result = query.getResultList();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Userdetail findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT u FROM Userdetail u WHERE u.id = %d", id);
            Query query = entityManager.createQuery(sql);
            Userdetail result = (Userdetail) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Userdetail deleteById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Userdetail userdetail = entityManager.find(Userdetail.class, id);
            entityManager.remove(userdetail);
            return userdetail;
        } catch (NoResultException e){
            return null;
        }
    }
}
