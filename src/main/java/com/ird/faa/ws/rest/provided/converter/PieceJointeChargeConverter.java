package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeCharge;
import com.ird.faa.ws.rest.provided.vo.PieceJointeChargeVo;

@Component
public class PieceJointeChargeConverter extends AbstractConverter<PieceJointeCharge,PieceJointeChargeVo>{

        @Autowired
        private ChargeConverter chargeConverter ;
    private Boolean charge;

public  PieceJointeChargeConverter(){
init(true);
}

@Override
public PieceJointeCharge toItem(PieceJointeChargeVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeCharge item = new PieceJointeCharge();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getPath()))
        item.setPath(vo.getPath());
        if(StringUtil.isNotEmpty(vo.getDatePaiement()))
        item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getChargeVo()!=null && this.charge)
        item.setCharge(chargeConverter.toItem(vo.getChargeVo())) ;


return item;
}
}

@Override
public PieceJointeChargeVo toVo(PieceJointeCharge item) {
if (item == null) {
return null;
} else {
PieceJointeChargeVo vo = new PieceJointeChargeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getPath()))
        vo.setPath(item.getPath());

        if(item.getDatePaiement()!=null)
        vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getCharge()!=null && this.charge) {
        vo.setChargeVo(chargeConverter.toVo(item.getCharge())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    charge = value;
}


        public ChargeConverter getChargeConverter(){
        return this.chargeConverter;
        }
        public void setChargeConverter(ChargeConverter chargeConverter ){
        this.chargeConverter = chargeConverter;
        }

    public boolean  isCharge(){
    return this.charge;
    }
    public void  setCharge(boolean charge){
    this.charge = charge;
    }
















}
