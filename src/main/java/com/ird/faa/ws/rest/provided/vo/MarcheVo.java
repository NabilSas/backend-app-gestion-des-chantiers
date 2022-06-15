package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class MarcheVo {

    private String id ;
    private String libelle ;
    private String code ;
    private String montantHt ;
    private String montantTtc ;
    private String montantTva ;
    private String dateDebut ;
    private String dateFin ;
    private String montantPaye ;
    private String retenueGarantie ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;


            private String codeMax ;
            private String codeMin ;
            private String montantHtMax ;
            private String montantHtMin ;
            private String montantTtcMax ;
            private String montantTtcMin ;
            private String montantTvaMax ;
            private String montantTvaMin ;
            private String dateDebutMax ;
            private String dateDebutMin ;
            private String dateFinMax ;
            private String dateFinMin ;
            private String montantPayeMax ;
            private String montantPayeMin ;
            private String retenueGarantieMax ;
            private String retenueGarantieMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private MaitreOuvrageVo maitreOuvrageVo ;
        private EtatMarcheVo etatMarcheVo ;

    private List<PaiementMarcheVo> paiementMarchesVo ;
    private List<LotVo> lotsVo ;
    private List<MarcheEmployeVo> marcheEmployesVo ;

    public MarcheVo(){
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
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }
        public String getMontantHt(){
        return this.montantHt;
        }

        public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
        }
        public String getMontantTtc(){
        return this.montantTtc;
        }

        public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
        }
        public String getMontantTva(){
        return this.montantTva;
        }

        public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
        }
        public String getDateDebut(){
        return this.dateDebut;
        }

        public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
        }
        public String getDateFin(){
        return this.dateFin;
        }

        public void setDateFin(String dateFin){
        this.dateFin = dateFin;
        }
        public String getMontantPaye(){
        return this.montantPaye;
        }

        public void setMontantPaye(String montantPaye){
        this.montantPaye = montantPaye;
        }
        public String getRetenueGarantie(){
        return this.retenueGarantie;
        }

        public void setRetenueGarantie(String retenueGarantie){
        this.retenueGarantie = retenueGarantie;
        }
        public Boolean getArchive(){
        return this.archive;
        }

        public void setArchive(Boolean archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }


            public String getCodeMax(){
            return this.codeMax;
            }

            public String getCodeMin(){
            return this.codeMin;
            }

            public void setCodeMax(String codeMax){
            this.codeMax = codeMax;
            }

            public void setCodeMin(String codeMin){
            this.codeMin = codeMin;
            }

            public String getMontantHtMax(){
            return this.montantHtMax;
            }

            public String getMontantHtMin(){
            return this.montantHtMin;
            }

            public void setMontantHtMax(String montantHtMax){
            this.montantHtMax = montantHtMax;
            }

            public void setMontantHtMin(String montantHtMin){
            this.montantHtMin = montantHtMin;
            }

            public String getMontantTtcMax(){
            return this.montantTtcMax;
            }

            public String getMontantTtcMin(){
            return this.montantTtcMin;
            }

            public void setMontantTtcMax(String montantTtcMax){
            this.montantTtcMax = montantTtcMax;
            }

            public void setMontantTtcMin(String montantTtcMin){
            this.montantTtcMin = montantTtcMin;
            }

            public String getMontantTvaMax(){
            return this.montantTvaMax;
            }

            public String getMontantTvaMin(){
            return this.montantTvaMin;
            }

            public void setMontantTvaMax(String montantTvaMax){
            this.montantTvaMax = montantTvaMax;
            }

            public void setMontantTvaMin(String montantTvaMin){
            this.montantTvaMin = montantTvaMin;
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

            public String getDateFinMax(){
            return this.dateFinMax;
            }

            public String getDateFinMin(){
            return this.dateFinMin;
            }

            public void setDateFinMax(String dateFinMax){
            this.dateFinMax = dateFinMax;
            }

            public void setDateFinMin(String dateFinMin){
            this.dateFinMin = dateFinMin;
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

            public String getRetenueGarantieMax(){
            return this.retenueGarantieMax;
            }

            public String getRetenueGarantieMin(){
            return this.retenueGarantieMin;
            }

            public void setRetenueGarantieMax(String retenueGarantieMax){
            this.retenueGarantieMax = retenueGarantieMax;
            }

            public void setRetenueGarantieMin(String retenueGarantieMin){
            this.retenueGarantieMin = retenueGarantieMin;
            }

            public String getDateArchivageMax(){
            return this.dateArchivageMax;
            }

            public String getDateArchivageMin(){
            return this.dateArchivageMin;
            }

            public void setDateArchivageMax(String dateArchivageMax){
            this.dateArchivageMax = dateArchivageMax;
            }

            public void setDateArchivageMin(String dateArchivageMin){
            this.dateArchivageMin = dateArchivageMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }


        public MaitreOuvrageVo getMaitreOuvrageVo(){
        return this.maitreOuvrageVo;
        }

        public void setMaitreOuvrageVo(MaitreOuvrageVo maitreOuvrageVo){
        this.maitreOuvrageVo = maitreOuvrageVo;
        }
        public EtatMarcheVo getEtatMarcheVo(){
        return this.etatMarcheVo;
        }

        public void setEtatMarcheVo(EtatMarcheVo etatMarcheVo){
        this.etatMarcheVo = etatMarcheVo;
        }


        public List<PaiementMarcheVo> getPaiementMarchesVo(){
        return this.paiementMarchesVo;
        }

        public void setPaiementMarchesVo(List<PaiementMarcheVo> paiementMarchesVo){
            this.paiementMarchesVo = paiementMarchesVo;
            }

        public List<LotVo> getLotsVo(){
        return this.lotsVo;
        }

        public void setLotsVo(List<LotVo> lotsVo){
            this.lotsVo = lotsVo;
            }

        public List<MarcheEmployeVo> getMarcheEmployesVo(){
        return this.marcheEmployesVo;
        }

        public void setMarcheEmployesVo(List<MarcheEmployeVo> marcheEmployesVo){
            this.marcheEmployesVo = marcheEmployesVo;
            }

            }
