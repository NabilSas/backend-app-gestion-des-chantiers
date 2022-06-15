package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Charge;
import com.ird.faa.ws.rest.provided.vo.ChargeVo;

@Component
public class ChargeConverter extends AbstractConverter<Charge,ChargeVo>{

        @Autowired
        private CategorieChargeConverter categorieChargeConverter ;
        @Autowired
        private PieceJointeChargeConverter pieceJointeChargeConverter ;
        @Autowired
        private CompteComptableConverter compteComptableConverter ;
        @Autowired
        private EtatChargeConverter etatChargeConverter ;
        @Autowired
        private ProduitConverter produitConverter ;
    private Boolean compteComptable;
    private Boolean etatCharge;
    private Boolean categorieCharge;
    private Boolean produit;
        private Boolean pieceJointeCharges;

public  ChargeConverter(){
init(true);
}

@Override
public Charge toItem(ChargeVo vo) {
if (vo == null) {
return null;
} else {
Charge item = new Charge();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getTotalPaye()))
        item.setTotalPaye(NumberUtil.toBigDecimal(vo.getTotalPaye()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateCharge()))
        item.setDateCharge(DateUtil.parse(vo.getDateCharge()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getCompteComptableVo()!=null && this.compteComptable)
        item.setCompteComptable(compteComptableConverter.toItem(vo.getCompteComptableVo())) ;
    if(vo.getEtatChargeVo()!=null && this.etatCharge)
        item.setEtatCharge(etatChargeConverter.toItem(vo.getEtatChargeVo())) ;
    if(vo.getCategorieChargeVo()!=null && this.categorieCharge)
        item.setCategorieCharge(categorieChargeConverter.toItem(vo.getCategorieChargeVo())) ;
    if(vo.getProduitVo()!=null && this.produit)
        item.setProduit(produitConverter.toItem(vo.getProduitVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeChargesVo()) && this.pieceJointeCharges)
        item.setPieceJointeCharges(pieceJointeChargeConverter.toItem(vo.getPieceJointeChargesVo()));

return item;
}
}

@Override
public ChargeVo toVo(Charge item) {
if (item == null) {
return null;
} else {
ChargeVo vo = new ChargeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getTotalPaye()!=null)
        vo.setTotalPaye(NumberUtil.toString(item.getTotalPaye()));

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateCharge()!=null)
        vo.setDateCharge(DateUtil.formateDate(item.getDateCharge()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getCompteComptable()!=null && this.compteComptable) {
        vo.setCompteComptableVo(compteComptableConverter.toVo(item.getCompteComptable())) ;
    }
    if(item.getEtatCharge()!=null && this.etatCharge) {
        vo.setEtatChargeVo(etatChargeConverter.toVo(item.getEtatCharge())) ;
    }
    if(item.getCategorieCharge()!=null && this.categorieCharge) {
        vo.setCategorieChargeVo(categorieChargeConverter.toVo(item.getCategorieCharge())) ;
    }
    if(item.getProduit()!=null && this.produit) {
        vo.setProduitVo(produitConverter.toVo(item.getProduit())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeCharges()) && this.pieceJointeCharges){
        pieceJointeChargeConverter.init(true);
        pieceJointeChargeConverter.setCharge(false);
        vo.setPieceJointeChargesVo(pieceJointeChargeConverter.toVo(item.getPieceJointeCharges()));
        pieceJointeChargeConverter.setCharge(true);
        }

return vo;
}
}

public void init(Boolean value) {
    compteComptable = value;
    etatCharge = value;
    categorieCharge = value;
    produit = value;
        pieceJointeCharges = value;
}


        public CategorieChargeConverter getCategorieChargeConverter(){
        return this.categorieChargeConverter;
        }
        public void setCategorieChargeConverter(CategorieChargeConverter categorieChargeConverter ){
        this.categorieChargeConverter = categorieChargeConverter;
        }
        public PieceJointeChargeConverter getPieceJointeChargeConverter(){
        return this.pieceJointeChargeConverter;
        }
        public void setPieceJointeChargeConverter(PieceJointeChargeConverter pieceJointeChargeConverter ){
        this.pieceJointeChargeConverter = pieceJointeChargeConverter;
        }
        public CompteComptableConverter getCompteComptableConverter(){
        return this.compteComptableConverter;
        }
        public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter ){
        this.compteComptableConverter = compteComptableConverter;
        }
        public EtatChargeConverter getEtatChargeConverter(){
        return this.etatChargeConverter;
        }
        public void setEtatChargeConverter(EtatChargeConverter etatChargeConverter ){
        this.etatChargeConverter = etatChargeConverter;
        }
        public ProduitConverter getProduitConverter(){
        return this.produitConverter;
        }
        public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
        }

    public boolean  isCompteComptable(){
    return this.compteComptable;
    }
    public void  setCompteComptable(boolean compteComptable){
    this.compteComptable = compteComptable;
    }
    public boolean  isEtatCharge(){
    return this.etatCharge;
    }
    public void  setEtatCharge(boolean etatCharge){
    this.etatCharge = etatCharge;
    }
    public boolean  isCategorieCharge(){
    return this.categorieCharge;
    }
    public void  setCategorieCharge(boolean categorieCharge){
    this.categorieCharge = categorieCharge;
    }
    public boolean  isProduit(){
    return this.produit;
    }
    public void  setProduit(boolean produit){
    this.produit = produit;
    }



















        public Boolean  isPieceJointeCharges(){
        return this.pieceJointeCharges ;
        }
        public void  setPieceJointeCharges(Boolean pieceJointeCharges ){
        this.pieceJointeCharges  = pieceJointeCharges ;
        }










}
