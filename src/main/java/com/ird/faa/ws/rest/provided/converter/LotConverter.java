package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Lot;
import com.ird.faa.ws.rest.provided.vo.LotVo;

@Component
public class LotConverter extends AbstractConverter<Lot,LotVo>{

        @Autowired
        private MarcheConverter marcheConverter ;
        @Autowired
        private EtatLotConverter etatLotConverter ;
        @Autowired
        private LotEmployeConverter lotEmployeConverter ;
        @Autowired
        private PaiementLotConverter paiementLotConverter ;
    private Boolean paiementLot;
    private Boolean etatLot;
    private Boolean marche;
        private Boolean lotEmployes;

public  LotConverter(){
init(true);
}

@Override
public Lot toItem(LotVo vo) {
if (vo == null) {
return null;
} else {
Lot item = new Lot();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCodeLot()))
        item.setCodeLot(NumberUtil.toLong(vo.getCodeLot()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getMontantHT()))
        item.setMontantHT(NumberUtil.toBigDecimal(vo.getMontantHT()));
        if(StringUtil.isNotEmpty(vo.getMontantTTC()))
        item.setMontantTTC(NumberUtil.toBigDecimal(vo.getMontantTTC()));
        if(StringUtil.isNotEmpty(vo.getMontantTVA()))
        item.setMontantTVA(NumberUtil.toBigDecimal(vo.getMontantTVA()));
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getDureeTravaux()))
        item.setDureeTravaux(DateUtil.parse(vo.getDureeTravaux()));
        if(StringUtil.isNotEmpty(vo.getDateDelivrance()))
        item.setDateDelivrance(DateUtil.parse(vo.getDateDelivrance()));
        if(StringUtil.isNotEmpty(vo.getMontantPaye()))
        item.setMontantPaye(NumberUtil.toBigDecimal(vo.getMontantPaye()));
    if(vo.getPaiementLotVo()!=null && this.paiementLot)
        item.setPaiementLot(paiementLotConverter.toItem(vo.getPaiementLotVo())) ;
    if(vo.getEtatLotVo()!=null && this.etatLot)
        item.setEtatLot(etatLotConverter.toItem(vo.getEtatLotVo())) ;
    if(vo.getMarcheVo()!=null && this.marche)
        item.setMarche(marcheConverter.toItem(vo.getMarcheVo())) ;

    if(ListUtil.isNotEmpty(vo.getLotEmployesVo()) && this.lotEmployes)
        item.setLotEmployes(lotEmployeConverter.toItem(vo.getLotEmployesVo()));

return item;
}
}

@Override
public LotVo toVo(Lot item) {
if (item == null) {
return null;
} else {
LotVo vo = new LotVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getCodeLot()!=null)
        vo.setCodeLot(NumberUtil.toString(item.getCodeLot()));

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getMontantHT()!=null)
        vo.setMontantHT(NumberUtil.toString(item.getMontantHT()));

        if(item.getMontantTTC()!=null)
        vo.setMontantTTC(NumberUtil.toString(item.getMontantTTC()));

        if(item.getMontantTVA()!=null)
        vo.setMontantTVA(NumberUtil.toString(item.getMontantTVA()));

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(item.getDureeTravaux()!=null)
        vo.setDureeTravaux(DateUtil.formateDate(item.getDureeTravaux()));
        if(item.getDateDelivrance()!=null)
        vo.setDateDelivrance(DateUtil.formateDate(item.getDateDelivrance()));
        if(item.getMontantPaye()!=null)
        vo.setMontantPaye(NumberUtil.toString(item.getMontantPaye()));

    if(item.getPaiementLot()!=null && this.paiementLot) {
                paiementLotConverter.setLot(false);
        vo.setPaiementLotVo(paiementLotConverter.toVo(item.getPaiementLot())) ;
                paiementLotConverter.setLot(true);
    }
    if(item.getEtatLot()!=null && this.etatLot) {
        vo.setEtatLotVo(etatLotConverter.toVo(item.getEtatLot())) ;
    }
    if(item.getMarche()!=null && this.marche) {
        vo.setMarcheVo(marcheConverter.toVo(item.getMarche())) ;
    }
        if(ListUtil.isNotEmpty(item.getLotEmployes()) && this.lotEmployes){
        lotEmployeConverter.init(true);
        lotEmployeConverter.setLot(false);
        vo.setLotEmployesVo(lotEmployeConverter.toVo(item.getLotEmployes()));
        lotEmployeConverter.setLot(true);
        }

return vo;
}
}

public void init(Boolean value) {
    paiementLot = value;
    etatLot = value;
    marche = value;
        lotEmployes = value;
}


        public MarcheConverter getMarcheConverter(){
        return this.marcheConverter;
        }
        public void setMarcheConverter(MarcheConverter marcheConverter ){
        this.marcheConverter = marcheConverter;
        }
        public EtatLotConverter getEtatLotConverter(){
        return this.etatLotConverter;
        }
        public void setEtatLotConverter(EtatLotConverter etatLotConverter ){
        this.etatLotConverter = etatLotConverter;
        }
        public LotEmployeConverter getLotEmployeConverter(){
        return this.lotEmployeConverter;
        }
        public void setLotEmployeConverter(LotEmployeConverter lotEmployeConverter ){
        this.lotEmployeConverter = lotEmployeConverter;
        }
        public PaiementLotConverter getPaiementLotConverter(){
        return this.paiementLotConverter;
        }
        public void setPaiementLotConverter(PaiementLotConverter paiementLotConverter ){
        this.paiementLotConverter = paiementLotConverter;
        }

    public boolean  isPaiementLot(){
    return this.paiementLot;
    }
    public void  setPaiementLot(boolean paiementLot){
    this.paiementLot = paiementLot;
    }
    public boolean  isEtatLot(){
    return this.etatLot;
    }
    public void  setEtatLot(boolean etatLot){
    this.etatLot = etatLot;
    }
    public boolean  isMarche(){
    return this.marche;
    }
    public void  setMarche(boolean marche){
    this.marche = marche;
    }

























        public Boolean  isLotEmployes(){
        return this.lotEmployes ;
        }
        public void  setLotEmployes(Boolean lotEmployes ){
        this.lotEmployes  = lotEmployes ;
        }






}
