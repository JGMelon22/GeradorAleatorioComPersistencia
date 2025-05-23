package com.joaog.geradoraleatoriocompersistencia.controller;

import com.joaog.geradoraleatoriocompersistencia.model.NumeroAleatorio;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class NumeroAleatorioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer maxValue;
    private Integer generatedNumber;

    public String generateRandomNumber() {
        if (maxValue != null && maxValue > 0) {
            Random random = new Random();
            generatedNumber = random.nextInt(maxValue + 1);

            // Persiste os dados no banco 
            EntityManager em = (EntityManager) ((HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest())
                    .getAttribute("entityManager");

            NumeroAleatorio rn = new NumeroAleatorio();
            rn.setMaxValue(maxValue);
            rn.setGeneratedValue(generatedNumber);
            rn.setGenerationDate(new Date());

            em.persist(rn);

            return "result?faces-redirect=true"; // redireciona para a página de resultado após gerar o número aleatório
        }
        return null;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber(Integer generatedNumber) {
        this.generatedNumber = generatedNumber;
    }
}
