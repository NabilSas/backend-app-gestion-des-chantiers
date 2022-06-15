package  com.ird.faa.ws.rest.provided.vo;


public class ProduitVo {

    private String id ;
    private String reference ;
    private String montant ;
    private String description ;


            private String montantMax ;
            private String montantMin ;



    public ProduitVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getReference(){
        return this.reference;
        }

        public void setReference(String reference){
        this.reference = reference;
        }
        public String getMontant(){
        return this.montant;
        }

        public void setMontant(String montant){
        this.montant = montant;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }


            public String getMontantMax(){
            return this.montantMax;
            }

            public String getMontantMin(){
            return this.montantMin;
            }

            public void setMontantMax(String montantMax){
            this.montantMax = montantMax;
            }

            public void setMontantMin(String montantMin){
            this.montantMin = montantMin;
            }




            }
