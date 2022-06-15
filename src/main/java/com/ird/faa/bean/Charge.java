package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "charge")
public class Charge    implements Archivable  {

@Id
    @SequenceGenerator(name="charge_seq",sequenceName="charge_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="charge_seq")
private Long id;

            private BigDecimal montant ;
            @Column(length = 500)
            private String libelle;
            private BigDecimal totalPaye ;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCharge ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;

    @ManyToOne
    private CompteComptable compteComptable ;
    @ManyToOne
    private EtatCharge etatCharge ;
    @ManyToOne
    private CategorieCharge categorieCharge ;
    @ManyToOne
    private Produit produit ;

                @OneToMany(mappedBy = "charge")
            private List<PieceJointeCharge> pieceJointeCharges ;

public Charge(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public BigDecimal getMontant(){
            return this.montant;
            }
            public void setMontant(BigDecimal montant){
            this.montant = montant;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public CompteComptable getCompteComptable(){
            return this.compteComptable;
            }
            public void setCompteComptable(CompteComptable compteComptable){
            this.compteComptable = compteComptable;
            }
            public EtatCharge getEtatCharge(){
            return this.etatCharge;
            }
            public void setEtatCharge(EtatCharge etatCharge){
            this.etatCharge = etatCharge;
            }
            public CategorieCharge getCategorieCharge(){
            return this.categorieCharge;
            }
            public void setCategorieCharge(CategorieCharge categorieCharge){
            this.categorieCharge = categorieCharge;
            }
            public BigDecimal getTotalPaye(){
            return this.totalPaye;
            }
            public void setTotalPaye(BigDecimal totalPaye){
            this.totalPaye = totalPaye;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public Date getDateCharge(){
            return this.dateCharge;
            }
            public void setDateCharge(Date dateCharge){
            this.dateCharge = dateCharge;
            }
            public List<PieceJointeCharge> getPieceJointeCharges(){
            return this.pieceJointeCharges;
            }
            public void setPieceJointeCharges(List<PieceJointeCharge> pieceJointeCharges){
            this.pieceJointeCharges = pieceJointeCharges;
            }
            public Produit getProduit(){
            return this.produit;
            }
            public void setProduit(Produit produit){
            this.produit = produit;
            }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return id != null && id.equals(charge.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

