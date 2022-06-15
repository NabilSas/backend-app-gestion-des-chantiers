package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "lot_employe")
public class LotEmploye   {

@Id
    @SequenceGenerator(name="lot_employe_seq",sequenceName="lot_employe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="lot_employe_seq")
private Long id;


    @ManyToOne
    private Lot lot ;
    @ManyToOne
    private Employe employe ;


public LotEmploye(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Lot getLot(){
            return this.lot;
            }
            public void setLot(Lot lot){
            this.lot = lot;
            }
            public Employe getEmploye(){
            return this.employe;
            }
            public void setEmploye(Employe employe){
            this.employe = employe;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotEmploye lotEmploye = (LotEmploye) o;
        return id != null && id.equals(lotEmploye.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

