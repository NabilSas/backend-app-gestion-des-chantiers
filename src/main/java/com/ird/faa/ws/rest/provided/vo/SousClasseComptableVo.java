package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class SousClasseComptableVo {

    private String id ;
    private String code ;
    private String libelle ;


            private String codeMax ;
            private String codeMin ;

        private ClasseComptableVo classeComptableVo ;

    private List<CompteComptableVo> compteComptablesVo ;

    public SousClasseComptableVo(){
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


        public ClasseComptableVo getClasseComptableVo(){
        return this.classeComptableVo;
        }

        public void setClasseComptableVo(ClasseComptableVo classeComptableVo){
        this.classeComptableVo = classeComptableVo;
        }


        public List<CompteComptableVo> getCompteComptablesVo(){
        return this.compteComptablesVo;
        }

        public void setCompteComptablesVo(List<CompteComptableVo> compteComptablesVo){
            this.compteComptablesVo = compteComptablesVo;
            }

            }
