package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;

@Component
public class SousClasseComptableConverter extends AbstractConverter<SousClasseComptable,SousClasseComptableVo>{

        @Autowired
        private ClasseComptableConverter classeComptableConverter ;
        @Autowired
        private CompteComptableConverter compteComptableConverter ;
    private Boolean classeComptable;
        private Boolean compteComptables;

public  SousClasseComptableConverter(){
init(true);
}

@Override
public SousClasseComptable toItem(SousClasseComptableVo vo) {
if (vo == null) {
return null;
} else {
SousClasseComptable item = new SousClasseComptable();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(NumberUtil.toLong(vo.getCode()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getClasseComptableVo()!=null && this.classeComptable)
        item.setClasseComptable(classeComptableConverter.toItem(vo.getClasseComptableVo())) ;

    if(ListUtil.isNotEmpty(vo.getCompteComptablesVo()) && this.compteComptables)
        item.setCompteComptables(compteComptableConverter.toItem(vo.getCompteComptablesVo()));

return item;
}
}

@Override
public SousClasseComptableVo toVo(SousClasseComptable item) {
if (item == null) {
return null;
} else {
SousClasseComptableVo vo = new SousClasseComptableVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getCode()!=null)
        vo.setCode(NumberUtil.toString(item.getCode()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getClasseComptable()!=null && this.classeComptable) {
        vo.setClasseComptableVo(classeComptableConverter.toVo(item.getClasseComptable())) ;
    }
        if(ListUtil.isNotEmpty(item.getCompteComptables()) && this.compteComptables){
        compteComptableConverter.init(true);
        compteComptableConverter.setSousClasseComptable(false);
        vo.setCompteComptablesVo(compteComptableConverter.toVo(item.getCompteComptables()));
        compteComptableConverter.setSousClasseComptable(true);
        }

return vo;
}
}

public void init(Boolean value) {
    classeComptable = value;
        compteComptables = value;
}


        public ClasseComptableConverter getClasseComptableConverter(){
        return this.classeComptableConverter;
        }
        public void setClasseComptableConverter(ClasseComptableConverter classeComptableConverter ){
        this.classeComptableConverter = classeComptableConverter;
        }
        public CompteComptableConverter getCompteComptableConverter(){
        return this.compteComptableConverter;
        }
        public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter ){
        this.compteComptableConverter = compteComptableConverter;
        }

    public boolean  isClasseComptable(){
    return this.classeComptable;
    }
    public void  setClasseComptable(boolean classeComptable){
    this.classeComptable = classeComptable;
    }









        public Boolean  isCompteComptables(){
        return this.compteComptables ;
        }
        public void  setCompteComptables(Boolean compteComptables ){
        this.compteComptables  = compteComptables ;
        }


}
