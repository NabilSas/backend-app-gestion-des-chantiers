package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;



import javax.persistence.*;



@Entity
@Table(name = "classe_comptable")
public class ClasseComptable   {

@Id
    @SequenceGenerator(name="classe_comptable_seq",sequenceName="classe_comptable_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="classe_comptable_seq")
private Long id;

            private Long code ;
            @Column(length = 500)
            private String libelle;


                @OneToMany(mappedBy = "classeComptable")
            private List<SousClasseComptable> sousClasseComptables ;

public ClasseComptable(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Long getCode(){
            return this.code;
            }
            public void setCode(Long code){
            this.code = code;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public List<SousClasseComptable> getSousClasseComptables(){
            return this.sousClasseComptables;
            }
            public void setSousClasseComptables(List<SousClasseComptable> sousClasseComptables){
            this.sousClasseComptables = sousClasseComptables;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasseComptable classeComptable = (ClasseComptable) o;
        return id != null && id.equals(classeComptable.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

