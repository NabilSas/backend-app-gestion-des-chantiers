package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class ChargeVo {

    private String id ;
    private String montant ;
    private String libelle ;
    private String totalPaye ;
    private String description ;
    private String dateCharge ;
    private String pieceJointeCharges ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;


            private String montantMax ;
            private String montantMin ;
            private String totalPayeMax ;
            private String totalPayeMin ;
            private String dateChargeMax ;
            private String dateChargeMin ;
            private String pieceJointeChargesMax ;
            private String pieceJointeChargesMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private CompteComptableVo compteComptableVo ;
        private EtatChargeVo etatChargeVo ;
        private CategorieChargeVo categorieChargeVo ;
        private ProduitVo produitVo ;

    private List<PieceJointeChargeVo> pieceJointeChargesVo ;

    public ChargeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getMontant(){
        return this.montant;
        }

        public void setMontant(String montant){
        this.montant = montant;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public String getTotalPaye(){
        return this.totalPaye;
        }

        public void setTotalPaye(String totalPaye){
        this.totalPaye = totalPaye;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getDateCharge(){
        return this.dateCharge;
        }

        public void setDateCharge(String dateCharge){
        this.dateCharge = dateCharge;
        }
        public String getPieceJointeCharges(){
        return this.pieceJointeCharges;
        }

        public void setPieceJointeCharges(String pieceJointeCharges){
        this.pieceJointeCharges = pieceJointeCharges;
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

            public String getTotalPayeMax(){
            return this.totalPayeMax;
            }

            public String getTotalPayeMin(){
            return this.totalPayeMin;
            }

            public void setTotalPayeMax(String totalPayeMax){
            this.totalPayeMax = totalPayeMax;
            }

            public void setTotalPayeMin(String totalPayeMin){
            this.totalPayeMin = totalPayeMin;
            }

            public String getDateChargeMax(){
            return this.dateChargeMax;
            }

            public String getDateChargeMin(){
            return this.dateChargeMin;
            }

            public void setDateChargeMax(String dateChargeMax){
            this.dateChargeMax = dateChargeMax;
            }

            public void setDateChargeMin(String dateChargeMin){
            this.dateChargeMin = dateChargeMin;
            }

            public String getPieceJointeChargesMax(){
            return this.pieceJointeChargesMax;
            }

            public String getPieceJointeChargesMin(){
            return this.pieceJointeChargesMin;
            }

            public void setPieceJointeChargesMax(String pieceJointeChargesMax){
            this.pieceJointeChargesMax = pieceJointeChargesMax;
            }

            public void setPieceJointeChargesMin(String pieceJointeChargesMin){
            this.pieceJointeChargesMin = pieceJointeChargesMin;
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


        public CompteComptableVo getCompteComptableVo(){
        return this.compteComptableVo;
        }

        public void setCompteComptableVo(CompteComptableVo compteComptableVo){
        this.compteComptableVo = compteComptableVo;
        }
        public EtatChargeVo getEtatChargeVo(){
        return this.etatChargeVo;
        }

        public void setEtatChargeVo(EtatChargeVo etatChargeVo){
        this.etatChargeVo = etatChargeVo;
        }
        public CategorieChargeVo getCategorieChargeVo(){
        return this.categorieChargeVo;
        }

        public void setCategorieChargeVo(CategorieChargeVo categorieChargeVo){
        this.categorieChargeVo = categorieChargeVo;
        }
        public ProduitVo getProduitVo(){
        return this.produitVo;
        }

        public void setProduitVo(ProduitVo produitVo){
        this.produitVo = produitVo;
        }


        public List<PieceJointeChargeVo> getPieceJointeChargesVo(){
        return this.pieceJointeChargesVo;
        }

        public void setPieceJointeChargesVo(List<PieceJointeChargeVo> pieceJointeChargesVo){
            this.pieceJointeChargesVo = pieceJointeChargesVo;
            }

            }
