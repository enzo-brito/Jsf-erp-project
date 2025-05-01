package com.projetoJsf.erp.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.projetoJsf.erp.model.Usuario;

@ApplicationScoped
public class Usuarios {

    @Inject
    private EntityManager manager;
    
    
    public Usuario porEmail(String email) {
        try {
            return manager.createQuery("from Usuario where email = :email", Usuario.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void guardar(Usuario usuario) {
    	manager.persist(usuario);
    }
    
    public void remover(Usuario usuario) {
    	manager.remove(usuario);
    }
    
}

