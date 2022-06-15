package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;



    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "employe")
public class Employe   {

@Id
    @SequenceGenerator(name="employe_seq",sequenceName="employe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="employe_seq")
private Long id;

            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String numCouvertureMedicale;
            private BigDecimal salaireBrut ;
            private BigDecimal salaireNet ;

    @ManyToOne
    private CategorieEmploye categorieEmploye ;

                @OneToMany(mappedBy = "employe")
            private List<Prime> primes ;

public Employe(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
            }
            public String getPrenom(){
            return this.prenom;
            }
            public void setPrenom(String prenom){
            this.prenom = prenom;
            }
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public CategorieEmploye getCategorieEmploye(){
            return this.categorieEmploye;
            }
            public void setCategorieEmploye(CategorieEmploye categorieEmploye){
            this.categorieEmploye = categorieEmploye;
            }
            public String getNumCouvertureMedicale(){
            return this.numCouvertureMedicale;
            }
            public void setNumCouvertureMedicale(String numCouvertureMedicale){
            this.numCouvertureMedicale = numCouvertureMedicale;
            }
            public BigDecimal getSalaireBrut(){
            return this.salaireBrut;
            }
            public void setSalaireBrut(BigDecimal salaireBrut){
            this.salaireBrut = salaireBrut;
            }
            public BigDecimal getSalaireNet(){
            return this.salaireNet;
            }
            public void setSalaireNet(BigDecimal salaireNet){
            this.salaireNet = salaireNet;
            }
            public List<Prime> getPrimes(){
            return this.primes;
            }
            public void setPrimes(List<Prime> primes){
            this.primes = primes;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id != null && id.equals(employe.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

