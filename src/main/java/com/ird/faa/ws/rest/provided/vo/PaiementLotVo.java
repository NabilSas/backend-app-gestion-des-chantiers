package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class PaiementLotVo {

    private String id ;
    private String reference ;
    private String description ;
    private String libelle ;
    private String montant ;
    private String datePaiement ;


            private String montantMax ;
            private String montantMin ;
            private String datePaiementMax ;
            private String datePaiementMin ;

        private TypePaiementLotVo typePaiementLotVo ;
        private LotVo lotVo ;


    public PaiementLotVo(){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public String getMontant(){
        return this.montant;
        }

        public void setMontant(String montant){
        this.montant = montant;
        }
        public String getDatePaiement(){
        return this.datePaiement;
        }

        public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
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

            public String getDatePaiementMax(){
            return this.datePaiementMax;
            }

            public String getDatePaiementMin(){
            return this.datePaiementMin;
            }

            public void setDatePaiementMax(String datePaiementMax){
            this.datePaiementMax = datePaiementMax;
            }

            public void setDatePaiementMin(String datePaiementMin){
            this.datePaiementMin = datePaiementMin;
            }


        public TypePaiementLotVo getTypePaiementLotVo(){
        return this.typePaiementLotVo;
        }

        public void setTypePaiementLotVo(TypePaiementLotVo typePaiementLotVo){
        this.typePaiementLotVo = typePaiementLotVo;
        }
        public LotVo getLotVo(){
        return this.lotVo;
        }

        public void setLotVo(LotVo lotVo){
        this.lotVo = lotVo;
        }


            }
