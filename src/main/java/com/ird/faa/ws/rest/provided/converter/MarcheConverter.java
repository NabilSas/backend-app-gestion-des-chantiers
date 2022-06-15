package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Marche;
import com.ird.faa.ws.rest.provided.vo.MarcheVo;

@Component
public class MarcheConverter extends AbstractConverter<Marche,MarcheVo>{

        @Autowired
        private LotConverter lotConverter ;
        @Autowired
        private MarcheEmployeConverter marcheEmployeConverter ;
        @Autowired
        private EtatMarcheConverter etatMarcheConverter ;
        @Autowired
        private PaiementMarcheConverter paiementMarcheConverter ;
        @Autowired
        private MaitreOuvrageConverter maitreOuvrageConverter ;
    private Boolean maitreOuvrage;
    private Boolean etatMarche;
        private Boolean paiementMarches;
        private Boolean lots;
        private Boolean marcheEmployes;

public  MarcheConverter(){
init(true);
}

@Override
public Marche toItem(MarcheVo vo) {
if (vo == null) {
return null;
} else {
Marche item = new Marche();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(NumberUtil.toLong(vo.getCode()));
        if(StringUtil.isNotEmpty(vo.getMontantHt()))
        item.setMontantHt(NumberUtil.toBigDecimal(vo.getMontantHt()));
        if(StringUtil.isNotEmpty(vo.getMontantTtc()))
        item.setMontantTtc(NumberUtil.toBigDecimal(vo.getMontantTtc()));
        if(StringUtil.isNotEmpty(vo.getMontantTva()))
        item.setMontantTva(NumberUtil.toBigDecimal(vo.getMontantTva()));
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getDateFin()))
        item.setDateFin(DateUtil.parse(vo.getDateFin()));
        if(StringUtil.isNotEmpty(vo.getMontantPaye()))
        item.setMontantPaye(NumberUtil.toBigDecimal(vo.getMontantPaye()));
        if(StringUtil.isNotEmpty(vo.getRetenueGarantie()))
        item.setRetenueGarantie(NumberUtil.toBigDecimal(vo.getRetenueGarantie()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getMaitreOuvrageVo()!=null && this.maitreOuvrage)
        item.setMaitreOuvrage(maitreOuvrageConverter.toItem(vo.getMaitreOuvrageVo())) ;
    if(vo.getEtatMarcheVo()!=null && this.etatMarche)
        item.setEtatMarche(etatMarcheConverter.toItem(vo.getEtatMarcheVo())) ;

    if(ListUtil.isNotEmpty(vo.getPaiementMarchesVo()) && this.paiementMarches)
        item.setPaiementMarches(paiementMarcheConverter.toItem(vo.getPaiementMarchesVo()));
    if(ListUtil.isNotEmpty(vo.getLotsVo()) && this.lots)
        item.setLots(lotConverter.toItem(vo.getLotsVo()));
    if(ListUtil.isNotEmpty(vo.getMarcheEmployesVo()) && this.marcheEmployes)
        item.setMarcheEmployes(marcheEmployeConverter.toItem(vo.getMarcheEmployesVo()));

return item;
}
}

@Override
public MarcheVo toVo(Marche item) {
if (item == null) {
return null;
} else {
MarcheVo vo = new MarcheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getCode()!=null)
        vo.setCode(NumberUtil.toString(item.getCode()));

        if(item.getMontantHt()!=null)
        vo.setMontantHt(NumberUtil.toString(item.getMontantHt()));

        if(item.getMontantTtc()!=null)
        vo.setMontantTtc(NumberUtil.toString(item.getMontantTtc()));

        if(item.getMontantTva()!=null)
        vo.setMontantTva(NumberUtil.toString(item.getMontantTva()));

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(item.getDateFin()!=null)
        vo.setDateFin(DateUtil.formateDate(item.getDateFin()));
        if(item.getMontantPaye()!=null)
        vo.setMontantPaye(NumberUtil.toString(item.getMontantPaye()));

        if(item.getRetenueGarantie()!=null)
        vo.setRetenueGarantie(NumberUtil.toString(item.getRetenueGarantie()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getMaitreOuvrage()!=null && this.maitreOuvrage) {
        vo.setMaitreOuvrageVo(maitreOuvrageConverter.toVo(item.getMaitreOuvrage())) ;
    }
    if(item.getEtatMarche()!=null && this.etatMarche) {
        vo.setEtatMarcheVo(etatMarcheConverter.toVo(item.getEtatMarche())) ;
    }
        if(ListUtil.isNotEmpty(item.getPaiementMarches()) && this.paiementMarches){
        paiementMarcheConverter.init(true);
        paiementMarcheConverter.setMarche(false);
        vo.setPaiementMarchesVo(paiementMarcheConverter.toVo(item.getPaiementMarches()));
        paiementMarcheConverter.setMarche(true);
        }
        if(ListUtil.isNotEmpty(item.getLots()) && this.lots){
        lotConverter.init(true);
        lotConverter.setMarche(false);
        vo.setLotsVo(lotConverter.toVo(item.getLots()));
        lotConverter.setMarche(true);
        }
        if(ListUtil.isNotEmpty(item.getMarcheEmployes()) && this.marcheEmployes){
        marcheEmployeConverter.init(true);
        marcheEmployeConverter.setMarche(false);
        vo.setMarcheEmployesVo(marcheEmployeConverter.toVo(item.getMarcheEmployes()));
        marcheEmployeConverter.setMarche(true);
        }

return vo;
}
}

public void init(Boolean value) {
    maitreOuvrage = value;
    etatMarche = value;
        paiementMarches = value;
        lots = value;
        marcheEmployes = value;
}


        public LotConverter getLotConverter(){
        return this.lotConverter;
        }
        public void setLotConverter(LotConverter lotConverter ){
        this.lotConverter = lotConverter;
        }
        public MarcheEmployeConverter getMarcheEmployeConverter(){
        return this.marcheEmployeConverter;
        }
        public void setMarcheEmployeConverter(MarcheEmployeConverter marcheEmployeConverter ){
        this.marcheEmployeConverter = marcheEmployeConverter;
        }
        public EtatMarcheConverter getEtatMarcheConverter(){
        return this.etatMarcheConverter;
        }
        public void setEtatMarcheConverter(EtatMarcheConverter etatMarcheConverter ){
        this.etatMarcheConverter = etatMarcheConverter;
        }
        public PaiementMarcheConverter getPaiementMarcheConverter(){
        return this.paiementMarcheConverter;
        }
        public void setPaiementMarcheConverter(PaiementMarcheConverter paiementMarcheConverter ){
        this.paiementMarcheConverter = paiementMarcheConverter;
        }
        public MaitreOuvrageConverter getMaitreOuvrageConverter(){
        return this.maitreOuvrageConverter;
        }
        public void setMaitreOuvrageConverter(MaitreOuvrageConverter maitreOuvrageConverter ){
        this.maitreOuvrageConverter = maitreOuvrageConverter;
        }

    public boolean  isMaitreOuvrage(){
    return this.maitreOuvrage;
    }
    public void  setMaitreOuvrage(boolean maitreOuvrage){
    this.maitreOuvrage = maitreOuvrage;
    }
    public boolean  isEtatMarche(){
    return this.etatMarche;
    }
    public void  setEtatMarche(boolean etatMarche){
    this.etatMarche = etatMarche;
    }







        public Boolean  isPaiementMarches(){
        return this.paiementMarches ;
        }
        public void  setPaiementMarches(Boolean paiementMarches ){
        this.paiementMarches  = paiementMarches ;
        }



        public Boolean  isLots(){
        return this.lots ;
        }
        public void  setLots(Boolean lots ){
        this.lots  = lots ;
        }



        public Boolean  isMarcheEmployes(){
        return this.marcheEmployes ;
        }
        public void  setMarcheEmployes(Boolean marcheEmployes ){
        this.marcheEmployes  = marcheEmployes ;
        }


























}
