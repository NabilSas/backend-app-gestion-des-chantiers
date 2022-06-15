package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "paiement_marche")
public class PaiementMarche   {

@Id
    @SequenceGenerator(name="paiement_marche_seq",sequenceName="paiement_marche_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_marche_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            @Column(length = 500)
            private String libelle;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePaiement ;
            private BigDecimal montant ;

    @ManyToOne
    private TypePaiementMarche typePaiementMarche ;
    @ManyToOne
    private Marche marche ;


public PaiementMarche(){
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
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public Date getDatePaiement(){
            return this.datePaiement;
            }
            public void setDatePaiement(Date datePaiement){
            this.datePaiement = datePaiement;
            }
            public BigDecimal getMontant(){
            return this.montant;
            }
            public void setMontant(BigDecimal montant){
            this.montant = montant;
            }
            public TypePaiementMarche getTypePaiementMarche(){
            return this.typePaiementMarche;
            }
            public void setTypePaiementMarche(TypePaiementMarche typePaiementMarche){
            this.typePaiementMarche = typePaiementMarche;
            }
            public Marche getMarche(){
            return this.marche;
            }
            public void setMarche(Marche marche){
            this.marche = marche;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementMarche paiementMarche = (PaiementMarche) o;
        return id != null && id.equals(paiementMarche.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

