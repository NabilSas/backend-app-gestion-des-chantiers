package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypePaiementLot;
import com.ird.faa.ws.rest.provided.vo.TypePaiementLotVo;

@Component
public class TypePaiementLotConverter extends AbstractConverter<TypePaiementLot,TypePaiementLotVo>{


public  TypePaiementLotConverter(){
init(true);
}

@Override
public TypePaiementLot toItem(TypePaiementLotVo vo) {
if (vo == null) {
return null;
} else {
TypePaiementLot item = new TypePaiementLot();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(NumberUtil.toLong(vo.getCode()));


return item;
}
}

@Override
public TypePaiementLotVo toVo(TypePaiementLot item) {
if (item == null) {
return null;
} else {
TypePaiementLotVo vo = new TypePaiementLotVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getCode()!=null)
        vo.setCode(NumberUtil.toString(item.getCode()));


return vo;
}
}

public void init(Boolean value) {
}









}
