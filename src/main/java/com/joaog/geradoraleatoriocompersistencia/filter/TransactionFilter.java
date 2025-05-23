package com.joaog.geradoraleatoriocompersistencia.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/app/*")
public class TransactionFilter implements Filter {

    private static final Logger logger = Logger.getLogger(TransactionFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("TransactionFilter inicializado");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            logger.log(Level.SEVERE, "Erro na opera\u00e7\u00e3o: {0}", e.getMessage());
            throw new ServletException("Falha na operação: " + e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {
        logger.info("TransactionFilter finalizado");
    }
}
