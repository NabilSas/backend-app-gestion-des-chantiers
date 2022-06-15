package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Prime;
import com.ird.faa.ws.rest.provided.vo.PrimeVo;

@Component
public class PrimeConverter extends AbstractConverter<Prime,PrimeVo>{

        @Autowired
        private LotConverter lotConverter ;
        @Autowired
        private EmployeConverter employeConverter ;
    private Boolean employe;
    private Boolean lot;

public  PrimeConverter(){
init(true);
}

@Override
public Prime toItem(PrimeVo vo) {
if (vo == null) {
return null;
} else {
Prime item = new Prime();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDatePrime()))
        item.setDatePrime(DateUtil.parse(vo.getDatePrime()));
    if(vo.getEmployeVo()!=null && this.employe)
        item.setEmploye(employeConverter.toItem(vo.getEmployeVo())) ;
    if(vo.getLotVo()!=null && this.lot)
        item.setLot(lotConverter.toItem(vo.getLotVo())) ;


return item;
}
}

@Override
public PrimeVo toVo(Prime item) {
if (item == null) {
return null;
} else {
PrimeVo vo = new PrimeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDatePrime()!=null)
        vo.setDatePrime(DateUtil.formateDate(item.getDatePrime()));
    if(item.getEmploye()!=null && this.employe) {
        vo.setEmployeVo(employeConverter.toVo(item.getEmploye())) ;
    }
    if(item.getLot()!=null && this.lot) {
        vo.setLotVo(lotConverter.toVo(item.getLot())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    employe = value;
    lot = value;
}


        public LotConverter getLotConverter(){
        return this.lotConverter;
        }
        public void setLotConverter(LotConverter lotConverter ){
        this.lotConverter = lotConverter;
        }
        public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
        }
        public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
        }

    public boolean  isEmploye(){
    return this.employe;
    }
    public void  setEmploye(boolean employe){
    this.employe = employe;
    }
    public boolean  isLot(){
    return this.lot;
    }
    public void  setLot(boolean lot){
    this.lot = lot;
    }












}
