package  com.ird.faa.ws.rest.provided.vo;


public class CompteComptableVo {

    private String id ;
    private String code ;
    private String libelle ;


            private String codeMax ;
            private String codeMin ;

        private SousClasseComptableVo sousClasseComptableVo ;


    public CompteComptableVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
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


        public SousClasseComptableVo getSousClasseComptableVo(){
        return this.sousClasseComptableVo;
        }

        public void setSousClasseComptableVo(SousClasseComptableVo sousClasseComptableVo){
        this.sousClasseComptableVo = sousClasseComptableVo;
        }


            }
