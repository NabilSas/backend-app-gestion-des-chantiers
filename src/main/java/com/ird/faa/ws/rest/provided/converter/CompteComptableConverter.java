package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CompteComptable;
import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;

@Component
public class CompteComptableConverter extends AbstractConverter<CompteComptable,CompteComptableVo>{

        @Autowired
        private SousClasseComptableConverter sousClasseComptableConverter ;
    private Boolean sousClasseComptable;

public  CompteComptableConverter(){
init(true);
}

@Override
public CompteComptable toItem(CompteComptableVo vo) {
if (vo == null) {
return null;
} else {
CompteComptable item = new CompteComptable();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(NumberUtil.toLong(vo.getCode()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getSousClasseComptableVo()!=null && this.sousClasseComptable)
        item.setSousClasseComptable(sousClasseComptableConverter.toItem(vo.getSousClasseComptableVo())) ;


return item;
}
}

@Override
public CompteComptableVo toVo(CompteComptable item) {
if (item == null) {
return null;
} else {
CompteComptableVo vo = new CompteComptableVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getCode()!=null)
        vo.setCode(NumberUtil.toString(item.getCode()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getSousClasseComptable()!=null && this.sousClasseComptable) {
        vo.setSousClasseComptableVo(sousClasseComptableConverter.toVo(item.getSousClasseComptable())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    sousClasseComptable = value;
}


        public SousClasseComptableConverter getSousClasseComptableConverter(){
        return this.sousClasseComptableConverter;
        }
        public void setSousClasseComptableConverter(SousClasseComptableConverter sousClasseComptableConverter ){
        this.sousClasseComptableConverter = sousClasseComptableConverter;
        }

    public boolean  isSousClasseComptable(){
    return this.sousClasseComptable;
    }
    public void  setSousClasseComptable(boolean sousClasseComptable){
    this.sousClasseComptable = sousClasseComptable;
    }








}
