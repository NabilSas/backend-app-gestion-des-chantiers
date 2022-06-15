package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "categorie_employe")
public class CategorieEmploye   {

@Id
    @SequenceGenerator(name="categorie_employe_seq",sequenceName="categorie_employe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_employe_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            @Column(length = 500)
            private String code;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;



public CategorieEmploye(){
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
            public String getCode(){
            return this.code;
            }
            public void setCode(String code){
            this.code = code;
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
        CategorieEmploye categorieEmploye = (CategorieEmploye) o;
        return id != null && id.equals(categorieEmploye.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

