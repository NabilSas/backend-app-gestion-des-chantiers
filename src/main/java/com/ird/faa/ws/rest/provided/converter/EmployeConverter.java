package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Employe;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;

@Component
public class EmployeConverter extends AbstractConverter<Employe,EmployeVo>{

        @Autowired
        private PrimeConverter primeConverter ;
        @Autowired
        private CategorieEmployeConverter categorieEmployeConverter ;
    private Boolean categorieEmploye;
        private Boolean primes;

public  EmployeConverter(){
init(true);
}

@Override
public Employe toItem(EmployeVo vo) {
if (vo == null) {
return null;
} else {
Employe item = new Employe();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getNumCouvertureMedicale()))
        item.setNumCouvertureMedicale(vo.getNumCouvertureMedicale());
        if(StringUtil.isNotEmpty(vo.getSalaireBrut()))
        item.setSalaireBrut(NumberUtil.toBigDecimal(vo.getSalaireBrut()));
        if(StringUtil.isNotEmpty(vo.getSalaireNet()))
        item.setSalaireNet(NumberUtil.toBigDecimal(vo.getSalaireNet()));
    if(vo.getCategorieEmployeVo()!=null && this.categorieEmploye)
        item.setCategorieEmploye(categorieEmployeConverter.toItem(vo.getCategorieEmployeVo())) ;

    if(ListUtil.isNotEmpty(vo.getPrimesVo()) && this.primes)
        item.setPrimes(primeConverter.toItem(vo.getPrimesVo()));

return item;
}
}

@Override
public EmployeVo toVo(Employe item) {
if (item == null) {
return null;
} else {
EmployeVo vo = new EmployeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getNumCouvertureMedicale()))
        vo.setNumCouvertureMedicale(item.getNumCouvertureMedicale());

        if(item.getSalaireBrut()!=null)
        vo.setSalaireBrut(NumberUtil.toString(item.getSalaireBrut()));

        if(item.getSalaireNet()!=null)
        vo.setSalaireNet(NumberUtil.toString(item.getSalaireNet()));

    if(item.getCategorieEmploye()!=null && this.categorieEmploye) {
        vo.setCategorieEmployeVo(categorieEmployeConverter.toVo(item.getCategorieEmploye())) ;
    }
        if(ListUtil.isNotEmpty(item.getPrimes()) && this.primes){
        primeConverter.init(true);
        primeConverter.setEmploye(false);
        vo.setPrimesVo(primeConverter.toVo(item.getPrimes()));
        primeConverter.setEmploye(true);
        }

return vo;
}
}

public void init(Boolean value) {
    categorieEmploye = value;
        primes = value;
}


        public PrimeConverter getPrimeConverter(){
        return this.primeConverter;
        }
        public void setPrimeConverter(PrimeConverter primeConverter ){
        this.primeConverter = primeConverter;
        }
        public CategorieEmployeConverter getCategorieEmployeConverter(){
        return this.categorieEmployeConverter;
        }
        public void setCategorieEmployeConverter(CategorieEmployeConverter categorieEmployeConverter ){
        this.categorieEmployeConverter = categorieEmployeConverter;
        }

    public boolean  isCategorieEmploye(){
    return this.categorieEmploye;
    }
    public void  setCategorieEmploye(boolean categorieEmploye){
    this.categorieEmploye = categorieEmploye;
    }

















        public Boolean  isPrimes(){
        return this.primes ;
        }
        public void  setPrimes(Boolean primes ){
        this.primes  = primes ;
        }


}
