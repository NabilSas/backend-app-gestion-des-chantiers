package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class PrimeVo {

    private String id ;
    private String libelle ;
    private String description ;
    private String datePrime ;


            private String datePrimeMax ;
            private String datePrimeMin ;

        private EmployeVo employeVo ;
        private LotVo lotVo ;


    public PrimeVo(){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getDatePrime(){
        return this.datePrime;
        }

        public void setDatePrime(String datePrime){
        this.datePrime = datePrime;
        }


            public String getDatePrimeMax(){
            return this.datePrimeMax;
            }

            public String getDatePrimeMin(){
            return this.datePrimeMin;
            }

            public void setDatePrimeMax(String datePrimeMax){
            this.datePrimeMax = datePrimeMax;
            }

            public void setDatePrimeMin(String datePrimeMin){
            this.datePrimeMin = datePrimeMin;
            }


        public EmployeVo getEmployeVo(){
        return this.employeVo;
        }

        public void setEmployeVo(EmployeVo employeVo){
        this.employeVo = employeVo;
        }
        public LotVo getLotVo(){
        return this.lotVo;
        }

        public void setLotVo(LotVo lotVo){
        this.lotVo = lotVo;
        }


            }
