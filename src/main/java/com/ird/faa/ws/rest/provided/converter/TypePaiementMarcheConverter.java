package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypePaiementMarche;
import com.ird.faa.ws.rest.provided.vo.TypePaiementMarcheVo;

@Component
public class TypePaiementMarcheConverter extends AbstractConverter<TypePaiementMarche,TypePaiementMarcheVo>{


public  TypePaiementMarcheConverter(){
init(true);
}

@Override
public TypePaiementMarche toItem(TypePaiementMarcheVo vo) {
if (vo == null) {
return null;
} else {
TypePaiementMarche item = new TypePaiementMarche();
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
public TypePaiementMarcheVo toVo(TypePaiementMarche item) {
if (item == null) {
return null;
} else {
TypePaiementMarcheVo vo = new TypePaiementMarcheVo();
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
