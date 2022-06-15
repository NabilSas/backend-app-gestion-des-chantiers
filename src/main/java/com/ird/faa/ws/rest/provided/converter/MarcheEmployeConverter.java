package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.MarcheEmploye;
import com.ird.faa.ws.rest.provided.vo.MarcheEmployeVo;

@Component
public class MarcheEmployeConverter extends AbstractConverter<MarcheEmploye,MarcheEmployeVo>{

        @Autowired
        private MarcheConverter marcheConverter ;
        @Autowired
        private EmployeConverter employeConverter ;
    private Boolean marche;
    private Boolean employe;

public  MarcheEmployeConverter(){
init(true);
}

@Override
public MarcheEmploye toItem(MarcheEmployeVo vo) {
if (vo == null) {
return null;
} else {
MarcheEmploye item = new MarcheEmploye();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getMarcheVo()!=null && this.marche)
        item.setMarche(marcheConverter.toItem(vo.getMarcheVo())) ;
    if(vo.getEmployeVo()!=null && this.employe)
        item.setEmploye(employeConverter.toItem(vo.getEmployeVo())) ;


return item;
}
}

@Override
public MarcheEmployeVo toVo(MarcheEmploye item) {
if (item == null) {
return null;
} else {
MarcheEmployeVo vo = new MarcheEmployeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getMarche()!=null && this.marche) {
        vo.setMarcheVo(marcheConverter.toVo(item.getMarche())) ;
    }
    if(item.getEmploye()!=null && this.employe) {
        vo.setEmployeVo(employeConverter.toVo(item.getEmploye())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    marche = value;
    employe = value;
}


        public MarcheConverter getMarcheConverter(){
        return this.marcheConverter;
        }
        public void setMarcheConverter(MarcheConverter marcheConverter ){
        this.marcheConverter = marcheConverter;
        }
        public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
        }
        public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
        }

    public boolean  isMarche(){
    return this.marche;
    }
    public void  setMarche(boolean marche){
    this.marche = marche;
    }
    public boolean  isEmploye(){
    return this.employe;
    }
    public void  setEmploye(boolean employe){
    this.employe = employe;
    }












}
