package  com.ird.faa.ws.rest.provided.vo;


public class LotEmployeVo {

    private String id ;



        private LotVo lotVo ;
        private EmployeVo employeVo ;


    public LotEmployeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public LotVo getLotVo(){
        return this.lotVo;
        }

        public void setLotVo(LotVo lotVo){
        this.lotVo = lotVo;
        }
        public EmployeVo getEmployeVo(){
        return this.employeVo;
        }

        public void setEmployeVo(EmployeVo employeVo){
        this.employeVo = employeVo;
        }


            }
