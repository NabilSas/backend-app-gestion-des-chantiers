package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PaiementMarche;
import com.ird.faa.ws.rest.provided.vo.PaiementMarcheVo;

@Component
public class PaiementMarcheConverter extends AbstractConverter<PaiementMarche,PaiementMarcheVo>{

        @Autowired
        private MarcheConverter marcheConverter ;
        @Autowired
        private TypePaiementMarcheConverter typePaiementMarcheConverter ;
    private Boolean typePaiementMarche;
    private Boolean marche;

public  PaiementMarcheConverter(){
init(true);
}

@Override
public PaiementMarche toItem(PaiementMarcheVo vo) {
if (vo == null) {
return null;
} else {
PaiementMarche item = new PaiementMarche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDatePaiement()))
        item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
    if(vo.getTypePaiementMarcheVo()!=null && this.typePaiementMarche)
        item.setTypePaiementMarche(typePaiementMarcheConverter.toItem(vo.getTypePaiementMarcheVo())) ;
    if(vo.getMarcheVo()!=null && this.marche)
        item.setMarche(marcheConverter.toItem(vo.getMarcheVo())) ;


return item;
}
}

@Override
public PaiementMarcheVo toVo(PaiementMarche item) {
if (item == null) {
return null;
} else {
PaiementMarcheVo vo = new PaiementMarcheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getDatePaiement()!=null)
        vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

    if(item.getTypePaiementMarche()!=null && this.typePaiementMarche) {
        vo.setTypePaiementMarcheVo(typePaiementMarcheConverter.toVo(item.getTypePaiementMarche())) ;
    }
    if(item.getMarche()!=null && this.marche) {
        vo.setMarcheVo(marcheConverter.toVo(item.getMarche())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typePaiementMarche = value;
    marche = value;
}


        public MarcheConverter getMarcheConverter(){
        return this.marcheConverter;
        }
        public void setMarcheConverter(MarcheConverter marcheConverter ){
        this.marcheConverter = marcheConverter;
        }
        public TypePaiementMarcheConverter getTypePaiementMarcheConverter(){
        return this.typePaiementMarcheConverter;
        }
        public void setTypePaiementMarcheConverter(TypePaiementMarcheConverter typePaiementMarcheConverter ){
        this.typePaiementMarcheConverter = typePaiementMarcheConverter;
        }

    public boolean  isTypePaiementMarche(){
    return this.typePaiementMarche;
    }
    public void  setTypePaiementMarche(boolean typePaiementMarche){
    this.typePaiementMarche = typePaiementMarche;
    }
    public boolean  isMarche(){
    return this.marche;
    }
    public void  setMarche(boolean marche){
    this.marche = marche;
    }
















}
