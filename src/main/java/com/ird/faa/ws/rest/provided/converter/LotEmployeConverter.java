package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.LotEmploye;
import com.ird.faa.ws.rest.provided.vo.LotEmployeVo;

@Component
public class LotEmployeConverter extends AbstractConverter<LotEmploye,LotEmployeVo>{

        @Autowired
        private LotConverter lotConverter ;
        @Autowired
        private EmployeConverter employeConverter ;
    private Boolean lot;
    private Boolean employe;

public  LotEmployeConverter(){
init(true);
}

@Override
public LotEmploye toItem(LotEmployeVo vo) {
if (vo == null) {
return null;
} else {
LotEmploye item = new LotEmploye();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getLotVo()!=null && this.lot)
        item.setLot(lotConverter.toItem(vo.getLotVo())) ;
    if(vo.getEmployeVo()!=null && this.employe)
        item.setEmploye(employeConverter.toItem(vo.getEmployeVo())) ;


return item;
}
}

@Override
public LotEmployeVo toVo(LotEmploye item) {
if (item == null) {
return null;
} else {
LotEmployeVo vo = new LotEmployeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getLot()!=null && this.lot) {
        vo.setLotVo(lotConverter.toVo(item.getLot())) ;
    }
    if(item.getEmploye()!=null && this.employe) {
        vo.setEmployeVo(employeConverter.toVo(item.getEmploye())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    lot = value;
    employe = value;
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

    public boolean  isLot(){
    return this.lot;
    }
    public void  setLot(boolean lot){
    this.lot = lot;
    }
    public boolean  isEmploye(){
    return this.employe;
    }
    public void  setEmploye(boolean employe){
    this.employe = employe;
    }






}
