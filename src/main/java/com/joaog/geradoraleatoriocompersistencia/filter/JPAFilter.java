package com.joaog.geradoraleatoriocompersistencia.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "JPAFilter", urlPatterns = {"/*"})
public class JPAFilter implements Filter {

    private static final Logger logger = Logger.getLogger(JPAFilter.class.getName());
    private static EntityManagerFactory emf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            logger.info("Inicializando JPAFilter...");

            emf = Persistence.createEntityManagerFactory("RandomNumberPU");
            logger.info("EntityManagerFactory inicializado com sucesso");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inicializar EntityManagerFactory", e);
            throw new ServletException("Falha na inicialização da persistência", e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            // Inicia transação manualmente (RESOURCE_LOCAL) - Pois não estamos usando JTA (lidado pelo server Glassfish)
            em.getTransaction().begin();

            request.setAttribute("entityManager", em);

            chain.doFilter(request, response);

            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
        } catch (IOException | ServletException e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.log(Level.SEVERE, "Erro na transação JPA", e);
            throw new ServletException("Erro na transação JPA", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory finalizado");
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
