package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PaiementLot;
import com.ird.faa.ws.rest.provided.vo.PaiementLotVo;

@Component
public class PaiementLotConverter extends AbstractConverter<PaiementLot,PaiementLotVo>{

        @Autowired
        private LotConverter lotConverter ;
        @Autowired
        private TypePaiementLotConverter typePaiementLotConverter ;
    private Boolean typePaiementLot;
    private Boolean lot;

public  PaiementLotConverter(){
init(true);
}

@Override
public PaiementLot toItem(PaiementLotVo vo) {
if (vo == null) {
return null;
} else {
PaiementLot item = new PaiementLot();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
        if(StringUtil.isNotEmpty(vo.getDatePaiement()))
        item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
    if(vo.getTypePaiementLotVo()!=null && this.typePaiementLot)
        item.setTypePaiementLot(typePaiementLotConverter.toItem(vo.getTypePaiementLotVo())) ;
    if(vo.getLotVo()!=null && this.lot)
        item.setLot(lotConverter.toItem(vo.getLotVo())) ;


return item;
}
}

@Override
public PaiementLotVo toVo(PaiementLot item) {
if (item == null) {
return null;
} else {
PaiementLotVo vo = new PaiementLotVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

        if(item.getDatePaiement()!=null)
        vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
    if(item.getTypePaiementLot()!=null && this.typePaiementLot) {
        vo.setTypePaiementLotVo(typePaiementLotConverter.toVo(item.getTypePaiementLot())) ;
    }
    if(item.getLot()!=null && this.lot) {
                lotConverter.setPaiementLot(false);
        vo.setLotVo(lotConverter.toVo(item.getLot())) ;
                lotConverter.setPaiementLot(true);
    }

return vo;
}
}

public void init(Boolean value) {
    typePaiementLot = value;
    lot = value;
}


        public LotConverter getLotConverter(){
        return this.lotConverter;
        }
        public void setLotConverter(LotConverter lotConverter ){
        this.lotConverter = lotConverter;
        }
        public TypePaiementLotConverter getTypePaiementLotConverter(){
        return this.typePaiementLotConverter;
        }
        public void setTypePaiementLotConverter(TypePaiementLotConverter typePaiementLotConverter ){
        this.typePaiementLotConverter = typePaiementLotConverter;
        }

    public boolean  isTypePaiementLot(){
    return this.typePaiementLot;
    }
    public void  setTypePaiementLot(boolean typePaiementLot){
    this.typePaiementLot = typePaiementLot;
    }
    public boolean  isLot(){
    return this.lot;
    }
    public void  setLot(boolean lot){
    this.lot = lot;
    }
















}
