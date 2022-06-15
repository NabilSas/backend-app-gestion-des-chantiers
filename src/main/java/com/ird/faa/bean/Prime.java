package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "prime")
public class Prime   {

@Id
    @SequenceGenerator(name="prime_seq",sequenceName="prime_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="prime_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePrime ;

    @ManyToOne
    private Employe employe ;
    @ManyToOne
    private Lot lot ;


public Prime(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Employe getEmploye(){
            return this.employe;
            }
            public void setEmploye(Employe employe){
            this.employe = employe;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public Lot getLot(){
            return this.lot;
            }
            public void setLot(Lot lot){
            this.lot = lot;
            }
            public Date getDatePrime(){
            return this.datePrime;
            }
            public void setDatePrime(Date datePrime){
            this.datePrime = datePrime;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prime prime = (Prime) o;
        return id != null && id.equals(prime.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

