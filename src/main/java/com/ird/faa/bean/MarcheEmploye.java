package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "marche_employe")
public class MarcheEmploye    implements Archivable  {

@Id
    @SequenceGenerator(name="marche_employe_seq",sequenceName="marche_employe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="marche_employe_seq")
private Long id;

            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;

    @ManyToOne
    private Marche marche ;
    @ManyToOne
    private Employe employe ;


public MarcheEmploye(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Marche getMarche(){
            return this.marche;
            }
            public void setMarche(Marche marche){
            this.marche = marche;
            }
            public Employe getEmploye(){
            return this.employe;
            }
            public void setEmploye(Employe employe){
            this.employe = employe;
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
        MarcheEmploye marcheEmploye = (MarcheEmploye) o;
        return id != null && id.equals(marcheEmploye.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

