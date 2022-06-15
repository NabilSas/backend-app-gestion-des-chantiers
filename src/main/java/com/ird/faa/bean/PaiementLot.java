package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "paiement_lot")
public class PaiementLot   {

@Id
    @SequenceGenerator(name="paiement_lot_seq",sequenceName="paiement_lot_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_lot_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            @Column(length = 500)
            private String libelle;
            private BigDecimal montant ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePaiement ;

    @ManyToOne
    private TypePaiementLot typePaiementLot ;
    @ManyToOne
    private Lot lot ;


public PaiementLot(){
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
            public BigDecimal getMontant(){
            return this.montant;
            }
            public void setMontant(BigDecimal montant){
            this.montant = montant;
            }
            public Date getDatePaiement(){
            return this.datePaiement;
            }
            public void setDatePaiement(Date datePaiement){
            this.datePaiement = datePaiement;
            }
            public TypePaiementLot getTypePaiementLot(){
            return this.typePaiementLot;
            }
            public void setTypePaiementLot(TypePaiementLot typePaiementLot){
            this.typePaiementLot = typePaiementLot;
            }
            public Lot getLot(){
            return this.lot;
            }
            public void setLot(Lot lot){
            this.lot = lot;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementLot paiementLot = (PaiementLot) o;
        return id != null && id.equals(paiementLot.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

