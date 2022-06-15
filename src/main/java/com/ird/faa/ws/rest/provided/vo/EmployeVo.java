package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.math.BigDecimal;

public class EmployeVo {

    private String id ;
    private String cin ;
    private String prenom ;
    private String nom ;
    private String numCouvertureMedicale ;
    private String salaireBrut ;
    private String salaireNet ;


            private String salaireBrutMax ;
            private String salaireBrutMin ;
            private String salaireNetMax ;
            private String salaireNetMin ;

        private CategorieEmployeVo categorieEmployeVo ;

    private List<PrimeVo> primesVo ;

    public EmployeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getNumCouvertureMedicale(){
        return this.numCouvertureMedicale;
        }

        public void setNumCouvertureMedicale(String numCouvertureMedicale){
        this.numCouvertureMedicale = numCouvertureMedicale;
        }
        public String getSalaireBrut(){
        return this.salaireBrut;
        }

        public void setSalaireBrut(String salaireBrut){
        this.salaireBrut = salaireBrut;
        }
        public String getSalaireNet(){
        return this.salaireNet;
        }

        public void setSalaireNet(String salaireNet){
        this.salaireNet = salaireNet;
        }


            public String getSalaireBrutMax(){
            return this.salaireBrutMax;
            }

            public String getSalaireBrutMin(){
            return this.salaireBrutMin;
            }

            public void setSalaireBrutMax(String salaireBrutMax){
            this.salaireBrutMax = salaireBrutMax;
            }

            public void setSalaireBrutMin(String salaireBrutMin){
            this.salaireBrutMin = salaireBrutMin;
            }

            public String getSalaireNetMax(){
            return this.salaireNetMax;
            }

            public String getSalaireNetMin(){
            return this.salaireNetMin;
            }

            public void setSalaireNetMax(String salaireNetMax){
            this.salaireNetMax = salaireNetMax;
            }

            public void setSalaireNetMin(String salaireNetMin){
            this.salaireNetMin = salaireNetMin;
            }


        public CategorieEmployeVo getCategorieEmployeVo(){
        return this.categorieEmployeVo;
        }

        public void setCategorieEmployeVo(CategorieEmployeVo categorieEmployeVo){
        this.categorieEmployeVo = categorieEmployeVo;
        }


        public List<PrimeVo> getPrimesVo(){
        return this.primesVo;
        }

        public void setPrimesVo(List<PrimeVo> primesVo){
            this.primesVo = primesVo;
            }

            }
