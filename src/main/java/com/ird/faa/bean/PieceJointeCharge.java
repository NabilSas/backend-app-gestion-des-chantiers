package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "piece_jointe_charge")
public class PieceJointeCharge    implements Archivable  {

@Id
    @SequenceGenerator(name="piece_jointe_charge_seq",sequenceName="piece_jointe_charge_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="piece_jointe_charge_seq")
private Long id;

            @Column(length = 500)
            private String path;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePaiement ;
            private BigDecimal montant ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;

    @ManyToOne
    private Charge charge ;


public PieceJointeCharge(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getPath(){
            return this.path;
            }
            public void setPath(String path){
            this.path = path;
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
            public Charge getCharge(){
            return this.charge;
            }
            public void setCharge(Charge charge){
            this.charge = charge;
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
        PieceJointeCharge pieceJointeCharge = (PieceJointeCharge) o;
        return id != null && id.equals(pieceJointeCharge.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

