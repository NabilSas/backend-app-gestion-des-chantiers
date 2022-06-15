package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatMarche;
import com.ird.faa.ws.rest.provided.vo.EtatMarcheVo;

@Component
public class EtatMarcheConverter extends AbstractConverter<EtatMarche,EtatMarcheVo>{


public  EtatMarcheConverter(){
init(true);
}

@Override
public EtatMarche toItem(EtatMarcheVo vo) {
if (vo == null) {
return null;
} else {
EtatMarche item = new EtatMarche();
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
public EtatMarcheVo toVo(EtatMarche item) {
if (item == null) {
return null;
} else {
EtatMarcheVo vo = new EtatMarcheVo();
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
