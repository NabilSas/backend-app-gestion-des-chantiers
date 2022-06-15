package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "etat_lot")
public class EtatLot   {

@Id
    @SequenceGenerator(name="etat_lot_seq",sequenceName="etat_lot_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_lot_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            private Long code ;



public EtatLot(){
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatLot etatLot = (EtatLot) o;
        return id != null && id.equals(etatLot.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

