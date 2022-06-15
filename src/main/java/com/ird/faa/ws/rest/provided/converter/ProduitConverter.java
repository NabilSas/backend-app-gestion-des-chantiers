package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Produit;
import com.ird.faa.ws.rest.provided.vo.ProduitVo;

@Component
public class ProduitConverter extends AbstractConverter<Produit,ProduitVo>{


public  ProduitConverter(){
init(true);
}

@Override
public Produit toItem(ProduitVo vo) {
if (vo == null) {
return null;
} else {
Produit item = new Produit();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toLong(vo.getMontant()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public ProduitVo toVo(Produit item) {
if (item == null) {
return null;
} else {
ProduitVo vo = new ProduitVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}











}
