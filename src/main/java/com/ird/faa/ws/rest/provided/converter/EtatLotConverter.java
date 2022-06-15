package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatLot;
import com.ird.faa.ws.rest.provided.vo.EtatLotVo;

@Component
public class EtatLotConverter extends AbstractConverter<EtatLot,EtatLotVo>{


public  EtatLotConverter(){
init(true);
}

@Override
public EtatLot toItem(EtatLotVo vo) {
if (vo == null) {
return null;
} else {
EtatLot item = new EtatLot();
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
public EtatLotVo toVo(EtatLot item) {
if (item == null) {
return null;
} else {
EtatLotVo vo = new EtatLotVo();
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
