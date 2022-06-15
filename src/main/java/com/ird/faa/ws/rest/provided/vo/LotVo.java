package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class LotVo {

    private String id ;
    private String libelle ;
    private String codeLot ;
    private String description ;
    private String montantHT ;
    private String montantTTC ;
    private String montantTVA ;
    private String dateDebut ;
    private String dureeTravaux ;
    private String dateDelivrance ;
    private String montantPaye ;


            private String codeLotMax ;
            private String codeLotMin ;
            private String montantHTMax ;
            private String montantHTMin ;
            private String montantTTCMax ;
            private String montantTTCMin ;
            private String montantTVAMax ;
            private String montantTVAMin ;
            private String dateDebutMax ;
            private String dateDebutMin ;
            private String dureeTravauxMax ;
            private String dureeTravauxMin ;
            private String dateDelivranceMax ;
            private String dateDelivranceMin ;
            private String montantPayeMax ;
            private String montantPayeMin ;

        private PaiementLotVo paiementLotVo ;
        private EtatLotVo etatLotVo ;
        private MarcheVo marcheVo ;

    private List<LotEmployeVo> lotEmployesVo ;

    public LotVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public String getCodeLot(){
        return this.codeLot;
        }

        public void setCodeLot(String codeLot){
        this.codeLot = codeLot;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getMontantHT(){
        return this.montantHT;
        }

        public void setMontantHT(String montantHT){
        this.montantHT = montantHT;
        }
        public String getMontantTTC(){
        return this.montantTTC;
        }

        public void setMontantTTC(String montantTTC){
        this.montantTTC = montantTTC;
        }
        public String getMontantTVA(){
        return this.montantTVA;
        }

        public void setMontantTVA(String montantTVA){
        this.montantTVA = montantTVA;
        }
        public String getDateDebut(){
        return this.dateDebut;
        }

        public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
        }
        public String getDureeTravaux(){
        return this.dureeTravaux;
        }

        public void setDureeTravaux(String dureeTravaux){
        this.dureeTravaux = dureeTravaux;
        }
        public String getDateDelivrance(){
        return this.dateDelivrance;
        }

        public void setDateDelivrance(String dateDelivrance){
        this.dateDelivrance = dateDelivrance;
        }
        public String getMontantPaye(){
        return this.montantPaye;
        }

        public void setMontantPaye(String montantPaye){
        this.montantPaye = montantPaye;
        }


            public String getCodeLotMax(){
            return this.codeLotMax;
            }

            public String getCodeLotMin(){
            return this.codeLotMin;
            }

            public void setCodeLotMax(String codeLotMax){
            this.codeLotMax = codeLotMax;
            }

            public void setCodeLotMin(String codeLotMin){
            this.codeLotMin = codeLotMin;
            }

            public String getMontantHTMax(){
            return this.montantHTMax;
            }

            public String getMontantHTMin(){
            return this.montantHTMin;
            }

            public void setMontantHTMax(String montantHTMax){
            this.montantHTMax = montantHTMax;
            }

            public void setMontantHTMin(String montantHTMin){
            this.montantHTMin = montantHTMin;
            }

            public String getMontantTTCMax(){
            return this.montantTTCMax;
            }

            public String getMontantTTCMin(){
            return this.montantTTCMin;
            }

            public void setMontantTTCMax(String montantTTCMax){
            this.montantTTCMax = montantTTCMax;
            }

            public void setMontantTTCMin(String montantTTCMin){
            this.montantTTCMin = montantTTCMin;
            }

            public String getMontantTVAMax(){
            return this.montantTVAMax;
            }

            public String getMontantTVAMin(){
            return this.montantTVAMin;
            }

            public void setMontantTVAMax(String montantTVAMax){
            this.montantTVAMax = montantTVAMax;
            }

            public void setMontantTVAMin(String montantTVAMin){
            this.montantTVAMin = montantTVAMin;
            }

            public String getDateDebutMax(){
            return this.dateDebutMax;
            }

            public String getDateDebutMin(){
            return this.dateDebutMin;
            }

            public void setDateDebutMax(String dateDebutMax){
            this.dateDebutMax = dateDebutMax;
            }

            public void setDateDebutMin(String dateDebutMin){
            this.dateDebutMin = dateDebutMin;
            }

            public String getDureeTravauxMax(){
            return this.dureeTravauxMax;
            }

            public String getDureeTravauxMin(){
            return this.dureeTravauxMin;
            }

            public void setDureeTravauxMax(String dureeTravauxMax){
            this.dureeTravauxMax = dureeTravauxMax;
            }

            public void setDureeTravauxMin(String dureeTravauxMin){
            this.dureeTravauxMin = dureeTravauxMin;
            }

            public String getDateDelivranceMax(){
            return this.dateDelivranceMax;
            }

            public String getDateDelivranceMin(){
            return this.dateDelivranceMin;
            }

            public void setDateDelivranceMax(String dateDelivranceMax){
            this.dateDelivranceMax = dateDelivranceMax;
            }

            public void setDateDelivranceMin(String dateDelivranceMin){
            this.dateDelivranceMin = dateDelivranceMin;
            }

            public String getMontantPayeMax(){
            return this.montantPayeMax;
            }

            public String getMontantPayeMin(){
            return this.montantPayeMin;
            }

            public void setMontantPayeMax(String montantPayeMax){
            this.montantPayeMax = montantPayeMax;
            }

            public void setMontantPayeMin(String montantPayeMin){
            this.montantPayeMin = montantPayeMin;
            }


        public PaiementLotVo getPaiementLotVo(){
        return this.paiementLotVo;
        }

        public void setPaiementLotVo(PaiementLotVo paiementLotVo){
        this.paiementLotVo = paiementLotVo;
        }
        public EtatLotVo getEtatLotVo(){
        return this.etatLotVo;
        }

        public void setEtatLotVo(EtatLotVo etatLotVo){
        this.etatLotVo = etatLotVo;
        }
        public MarcheVo getMarcheVo(){
        return this.marcheVo;
        }

        public void setMarcheVo(MarcheVo marcheVo){
        this.marcheVo = marcheVo;
        }


        public List<LotEmployeVo> getLotEmployesVo(){
        return this.lotEmployesVo;
        }

        public void setLotEmployesVo(List<LotEmployeVo> lotEmployesVo){
            this.lotEmployesVo = lotEmployesVo;
            }

            }
