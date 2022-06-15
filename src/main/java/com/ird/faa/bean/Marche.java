package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "marche")
public class Marche    implements Archivable  {

@Id
    @SequenceGenerator(name="marche_seq",sequenceName="marche_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="marche_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            private Long code ;
            private BigDecimal montantHt ;
            private BigDecimal montantTtc ;
            private BigDecimal montantTva ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDebut ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateFin ;
            private BigDecimal montantPaye ;
            private BigDecimal retenueGarantie ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;

    @ManyToOne
    private MaitreOuvrage maitreOuvrage ;
    @ManyToOne
    private EtatMarche etatMarche ;

                @OneToMany(mappedBy = "marche")
            private List<PaiementMarche> paiementMarches ;
                @OneToMany(mappedBy = "marche")
            private List<Lot> lots ;
                @OneToMany(mappedBy = "marche")
            private List<MarcheEmploye> marcheEmployes ;

public Marche(){
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
            public Long getCode(){
            return this.code;
            }
            public void setCode(Long code){
            this.code = code;
            }
            public List<PaiementMarche> getPaiementMarches(){
            return this.paiementMarches;
            }
            public void setPaiementMarches(List<PaiementMarche> paiementMarches){
            this.paiementMarches = paiementMarches;
            }
            public List<Lot> getLots(){
            return this.lots;
            }
            public void setLots(List<Lot> lots){
            this.lots = lots;
            }
            public List<MarcheEmploye> getMarcheEmployes(){
            return this.marcheEmployes;
            }
            public void setMarcheEmployes(List<MarcheEmploye> marcheEmployes){
            this.marcheEmployes = marcheEmployes;
            }
            public BigDecimal getMontantHt(){
            return this.montantHt;
            }
            public void setMontantHt(BigDecimal montantHt){
            this.montantHt = montantHt;
            }
            public BigDecimal getMontantTtc(){
            return this.montantTtc;
            }
            public void setMontantTtc(BigDecimal montantTtc){
            this.montantTtc = montantTtc;
            }
            public BigDecimal getMontantTva(){
            return this.montantTva;
            }
            public void setMontantTva(BigDecimal montantTva){
            this.montantTva = montantTva;
            }
            public MaitreOuvrage getMaitreOuvrage(){
            return this.maitreOuvrage;
            }
            public void setMaitreOuvrage(MaitreOuvrage maitreOuvrage){
            this.maitreOuvrage = maitreOuvrage;
            }
            public Date getDateDebut(){
            return this.dateDebut;
            }
            public void setDateDebut(Date dateDebut){
            this.dateDebut = dateDebut;
            }
            public Date getDateFin(){
            return this.dateFin;
            }
            public void setDateFin(Date dateFin){
            this.dateFin = dateFin;
            }
            public BigDecimal getMontantPaye(){
            return this.montantPaye;
            }
            public void setMontantPaye(BigDecimal montantPaye){
            this.montantPaye = montantPaye;
            }
            public EtatMarche getEtatMarche(){
            return this.etatMarche;
            }
            public void setEtatMarche(EtatMarche etatMarche){
            this.etatMarche = etatMarche;
            }
            public BigDecimal getRetenueGarantie(){
            return this.retenueGarantie;
            }
            public void setRetenueGarantie(BigDecimal retenueGarantie){
            this.retenueGarantie = retenueGarantie;
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
        Marche marche = (Marche) o;
        return id != null && id.equals(marche.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

