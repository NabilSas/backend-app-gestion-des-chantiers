package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "produit")
public class Produit   {

@Id
    @SequenceGenerator(name="produit_seq",sequenceName="produit_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="produit_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private Long montant ;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;



public Produit(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public Long getMontant(){
            return this.montant;
            }
            public void setMontant(Long montant){
            this.montant = montant;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id != null && id.equals(produit.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

