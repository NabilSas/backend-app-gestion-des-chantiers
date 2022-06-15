package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "lot")
public class Lot   {

@Id
    @SequenceGenerator(name="lot_seq",sequenceName="lot_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="lot_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            private Long codeLot ;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            private BigDecimal montantHT ;
            private BigDecimal montantTTC ;
            private BigDecimal montantTVA ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDebut ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dureeTravaux ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDelivrance ;
            private BigDecimal montantPaye ;

    @ManyToOne
    private PaiementLot paiementLot ;
    @ManyToOne
    private EtatLot etatLot ;
    @ManyToOne
    private Marche marche ;

                @OneToMany(mappedBy = "lot")
            private List<LotEmploye> lotEmployes ;

public Lot(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public Long getCodeLot(){
            return this.codeLot;
            }
            public void setCodeLot(Long codeLot){
            this.codeLot = codeLot;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public PaiementLot getPaiementLot(){
            return this.paiementLot;
            }
            public void setPaiementLot(PaiementLot paiementLot){
            this.paiementLot = paiementLot;
            }
            public BigDecimal getMontantHT(){
            return this.montantHT;
            }
            public void setMontantHT(BigDecimal montantHT){
            this.montantHT = montantHT;
            }
            public BigDecimal getMontantTTC(){
            return this.montantTTC;
            }
            public void setMontantTTC(BigDecimal montantTTC){
            this.montantTTC = montantTTC;
            }
            public BigDecimal getMontantTVA(){
            return this.montantTVA;
            }
            public void setMontantTVA(BigDecimal montantTVA){
            this.montantTVA = montantTVA;
            }
            public Date getDateDebut(){
            return this.dateDebut;
            }
            public void setDateDebut(Date dateDebut){
            this.dateDebut = dateDebut;
            }
            public Date getDureeTravaux(){
            return this.dureeTravaux;
            }
            public void setDureeTravaux(Date dureeTravaux){
            this.dureeTravaux = dureeTravaux;
            }
            public Date getDateDelivrance(){
            return this.dateDelivrance;
            }
            public void setDateDelivrance(Date dateDelivrance){
            this.dateDelivrance = dateDelivrance;
            }
            public BigDecimal getMontantPaye(){
            return this.montantPaye;
            }
            public void setMontantPaye(BigDecimal montantPaye){
            this.montantPaye = montantPaye;
            }
            public List<LotEmploye> getLotEmployes(){
            return this.lotEmployes;
            }
            public void setLotEmployes(List<LotEmploye> lotEmployes){
            this.lotEmployes = lotEmployes;
            }
            public EtatLot getEtatLot(){
            return this.etatLot;
            }
            public void setEtatLot(EtatLot etatLot){
            this.etatLot = etatLot;
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
        Lot lot = (Lot) o;
        return id != null && id.equals(lot.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

