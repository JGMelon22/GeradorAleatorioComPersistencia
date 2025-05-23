package com.joaog.geradoraleatoriocompersistencia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "random_number")
public class NumeroAleatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "max_value") // Nome modificado para evitar conflitos
    private Integer maxValue;

    @Column(name = "generated_value")
    private Integer generatedValue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "generation_date")
    private Date generationDate;

    public NumeroAleatorio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getGeneratedValue() {
        return generatedValue;
    }

    public void setGeneratedValue(Integer generatedValue) {
        this.generatedValue = generatedValue;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.maxValue);
        hash = 31 * hash + Objects.hashCode(this.generatedValue);
        hash = 31 * hash + Objects.hashCode(this.generationDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumeroAleatorio other = (NumeroAleatorio) obj;
        return true;
    }

}
