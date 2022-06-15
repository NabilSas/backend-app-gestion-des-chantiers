package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Marche;
        import com.ird.faa.bean.MaitreOuvrage;
        import com.ird.faa.bean.EtatMarche;
        import com.ird.faa.bean.PaiementMarche;
        import com.ird.faa.bean.Lot;
        import com.ird.faa.bean.MarcheEmploye;
import com.ird.faa.dao.MarcheDao;
import com.ird.faa.service.chercheur.facade.MarcheChercheurService;
        import com.ird.faa.service.chercheur.facade.LotChercheurService;
        import com.ird.faa.service.chercheur.facade.MarcheEmployeChercheurService;
        import com.ird.faa.service.chercheur.facade.EtatMarcheChercheurService;
        import com.ird.faa.service.chercheur.facade.PaiementMarcheChercheurService;
        import com.ird.faa.service.chercheur.facade.MaitreOuvrageChercheurService;

import com.ird.faa.ws.rest.provided.vo.MarcheVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PaiementMarche;
        import com.ird.faa.service.chercheur.facade.PaiementMarcheChercheurService;
        import com.ird.faa.bean.Lot;
        import com.ird.faa.service.chercheur.facade.LotChercheurService;
        import com.ird.faa.bean.MarcheEmploye;
        import com.ird.faa.service.chercheur.facade.MarcheEmployeChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MarcheChercheurServiceImpl extends AbstractServiceImpl<Marche> implements MarcheChercheurService {

@Autowired
private MarcheDao marcheDao;

    @Autowired
    private ArchivableService<Marche> archivableService;
        @Autowired
        private LotChercheurService lotService ;
        @Autowired
        private MarcheEmployeChercheurService marcheEmployeService ;
        @Autowired
        private EtatMarcheChercheurService etatMarcheService ;
        @Autowired
        private PaiementMarcheChercheurService paiementMarcheService ;
        @Autowired
        private MaitreOuvrageChercheurService maitreOuvrageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Marche> findAll(){
    List<Marche> result= new ArrayList();
    result.addAll(findAllNonArchive());
    result.addAll(findAllByOwner());
    return result;
}

        @Override
        public List<Marche> findByMaitreOuvrageIce(String ice){
        return marcheDao.findByMaitreOuvrageIce(ice);
        }

        @Override
        @Transactional
        public int deleteByMaitreOuvrageIce(String ice){
        return marcheDao.deleteByMaitreOuvrageIce(ice);
        }

        @Override
        public List<Marche> findByMaitreOuvrageId(Long id){
        return marcheDao.findByMaitreOuvrageId(id);
        }

        @Override
        @Transactional
        public int deleteByMaitreOuvrageId(Long id){
        return marcheDao.deleteByMaitreOuvrageId(id);
        }

        @Override
        public List<Marche> findByEtatMarcheId(Long id){
        return marcheDao.findByEtatMarcheId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatMarcheId(Long id){
        return marcheDao.deleteByEtatMarcheId(id);
        }

    @Override
    public Marche findByCode(Long code){
    if( code==null) return null;
    return marcheDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(Long  code) {
    return marcheDao.deleteByCode(code);
    }
    @Override
    public Marche findByIdOrCode(Marche marche){
    Marche resultat=null;
    if(marche != null){
    if(StringUtil.isNotEmpty(marche.getId())){
    resultat= marcheDao.getOne(marche.getId());
    }else if(StringUtil.isNotEmpty(marche.getCode())) {
    resultat= marcheDao.findByCode(marche.getCode());
    }
    }
    return resultat;
    }

@Override
public Marche findById(Long id){
if(id==null) return null;
return marcheDao.getOne(id);
}

@Override
public Marche findByIdWithAssociatedList(Long id){
    Marche marche  = findById(id);
    findAssociatedLists(marche);
    return marche;
}

    private void findAssociatedLists(Marche marche){
    if(marche!=null && marche.getId() != null) {
            List<PaiementMarche> paiementMarches = paiementMarcheService.findByMarcheId(marche.getId());
            marche.setPaiementMarches(paiementMarches);
            List<Lot> lots = lotService.findByMarcheId(marche.getId());
            marche.setLots(lots);
            List<MarcheEmploye> marcheEmployes = marcheEmployeService.findByMarcheId(marche.getId());
            marche.setMarcheEmployes(marcheEmployes);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            paiementMarcheService.deleteByMarcheId(id);
            lotService.deleteByMarcheId(id);
            marcheEmployeService.deleteByMarcheId(id);
    }
    }

    private void updateAssociatedLists(Marche marche){
    if(marche !=null && marche.getId() != null){
            List
            <List<PaiementMarche>> resultPaiementMarches= paiementMarcheService.getToBeSavedAndToBeDeleted(paiementMarcheService.findByMarcheId(marche.getId()),marche.getPaiementMarches());
            paiementMarcheService.delete(resultPaiementMarches.get(1));
            associatePaiementMarche(marche,resultPaiementMarches.get(0));
            paiementMarcheService.update(resultPaiementMarches.get(0));

            List
            <List<Lot>> resultLots= lotService.getToBeSavedAndToBeDeleted(lotService.findByMarcheId(marche.getId()),marche.getLots());
            lotService.delete(resultLots.get(1));
            associateLot(marche,resultLots.get(0));
            lotService.update(resultLots.get(0));

            List
            <List<MarcheEmploye>> resultMarcheEmployes= marcheEmployeService.getToBeSavedAndToBeDeleted(marcheEmployeService.findByMarcheId(marche.getId()),marche.getMarcheEmployes());
            marcheEmployeService.delete(resultMarcheEmployes.get(1));
            associateMarcheEmploye(marche,resultMarcheEmployes.get(0));
            marcheEmployeService.update(resultMarcheEmployes.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(marcheDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
marcheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Marche update(Marche marche){
Marche foundedMarche = findById(marche.getId());
if(foundedMarche==null) return null;
else{
    archivableService.prepare(marche);
    updateAssociatedLists(marche);
return  marcheDao.save(marche);
}
}
    private void prepareSave(Marche marche){
        marche.setDateCreation(new Date());
        if(marche.getDateArchivage() == null)
        marche.setDateArchivage(new Date());
                    if(marche.getArchive() == null)
                marche.setArchive(false);




    }

@Override
public Marche save (Marche marche){
    prepareSave(marche);

    Marche result =null;
    Marche foundedMarche = findByCode(marche.getCode());
    if(foundedMarche == null){



    findMaitreOuvrage(marche);
    findEtatMarche(marche);

    Marche savedMarche = marcheDao.save(marche);

        savePaiementMarches(savedMarche,marche.getPaiementMarches());
        saveLots(savedMarche,marche.getLots());
        saveMarcheEmployes(savedMarche,marche.getMarcheEmployes());
    result = savedMarche;
    }

    return result;
}

@Override
public List<Marche> save(List<Marche> marches){
List<Marche> list = new ArrayList<>();
for(Marche marche: marches){
list.add(save(marche));
}
return list;
}

        private List<PaiementMarche> preparePaiementMarches(Marche marche,List<PaiementMarche> paiementMarches){
        for(PaiementMarche paiementMarche:paiementMarches ){
        paiementMarche.setMarche(marche);
        }
        return paiementMarches;
        }
        private List<Lot> prepareLots(Marche marche,List<Lot> lots){
        for(Lot lot:lots ){
        lot.setMarche(marche);
        }
        return lots;
        }
        private List<MarcheEmploye> prepareMarcheEmployes(Marche marche,List<MarcheEmploye> marcheEmployes){
        for(MarcheEmploye marcheEmploye:marcheEmployes ){
        marcheEmploye.setMarche(marche);
        }
        return marcheEmployes;
        }


@Override
@Transactional
public int delete(Marche marche){
    if(marche.getCode()==null) return -1;

    Marche foundedMarche = findByCode(marche.getCode());
    if(foundedMarche==null) return -1;
marcheDao.delete(foundedMarche);
return 1;
}


public List<Marche> findByCriteria(MarcheVo marcheVo){

String query = "SELECT o FROM Marche o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",marcheVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",marcheVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",marcheVo.getCode());
            query += SearchUtil.addConstraint( "o", "montantHt","=",marcheVo.getMontantHt());
            query += SearchUtil.addConstraint( "o", "montantTtc","=",marcheVo.getMontantTtc());
            query += SearchUtil.addConstraint( "o", "montantTva","=",marcheVo.getMontantTva());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",marcheVo.getDateDebut());
        query += SearchUtil.addConstraintDate( "o", "dateFin","=",marcheVo.getDateFin());
            query += SearchUtil.addConstraint( "o", "montantPaye","=",marcheVo.getMontantPaye());
            query += SearchUtil.addConstraint( "o", "retenueGarantie","=",marcheVo.getRetenueGarantie());
            query += SearchUtil.addConstraint( "o", "archive","=",marcheVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",marcheVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",marcheVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","code",marcheVo.getCodeMin(),marcheVo.getCodeMax());
            query += SearchUtil.addConstraintMinMax("o","montantHt",marcheVo.getMontantHtMin(),marcheVo.getMontantHtMax());
            query += SearchUtil.addConstraintMinMax("o","montantTtc",marcheVo.getMontantTtcMin(),marcheVo.getMontantTtcMax());
            query += SearchUtil.addConstraintMinMax("o","montantTva",marcheVo.getMontantTvaMin(),marcheVo.getMontantTvaMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",marcheVo.getDateDebutMin(),marcheVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFin",marcheVo.getDateFinMin(),marcheVo.getDateFinMax());
            query += SearchUtil.addConstraintMinMax("o","montantPaye",marcheVo.getMontantPayeMin(),marcheVo.getMontantPayeMax());
            query += SearchUtil.addConstraintMinMax("o","retenueGarantie",marcheVo.getRetenueGarantieMin(),marcheVo.getRetenueGarantieMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",marcheVo.getDateArchivageMin(),marcheVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",marcheVo.getDateCreationMin(),marcheVo.getDateCreationMax());
    if(marcheVo.getMaitreOuvrageVo()!=null){
        query += SearchUtil.addConstraint( "o", "maitreOuvrage.id","=",marcheVo.getMaitreOuvrageVo().getId());
            query += SearchUtil.addConstraint( "o", "maitreOuvrage.ice","LIKE",marcheVo.getMaitreOuvrageVo().getIce());
    }

    if(marcheVo.getEtatMarcheVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatMarche.id","=",marcheVo.getEtatMarcheVo().getId());
    }

    query+= " ORDER BY o.dateFin";
return entityManager.createQuery(query).getResultList();
}
        private  void savePaiementMarches(Marche marche,List<PaiementMarche> paiementMarches){

        if (ListUtil.isNotEmpty(marche.getPaiementMarches())) {
        List<PaiementMarche> savedPaiementMarches = new ArrayList<>();
        paiementMarches.forEach(element -> {
        element.setMarche(marche);
         paiementMarcheService.save(element);
        });
        marche.setPaiementMarches(savedPaiementMarches);
        }
        }
        private  void saveLots(Marche marche,List<Lot> lots){

        if (ListUtil.isNotEmpty(marche.getLots())) {
        List<Lot> savedLots = new ArrayList<>();
        lots.forEach(element -> {
        element.setMarche(marche);
         lotService.save(element);
        });
        marche.setLots(savedLots);
        }
        }
        private  void saveMarcheEmployes(Marche marche,List<MarcheEmploye> marcheEmployes){

        if (ListUtil.isNotEmpty(marche.getMarcheEmployes())) {
        List<MarcheEmploye> savedMarcheEmployes = new ArrayList<>();
        marcheEmployes.forEach(element -> {
        element.setMarche(marche);
         marcheEmployeService.save(element);
        });
        marche.setMarcheEmployes(savedMarcheEmployes);
        }
        }

    private void findMaitreOuvrage(Marche marche){
        MaitreOuvrage loadedMaitreOuvrage =maitreOuvrageService.findByIdOrIce(marche.getMaitreOuvrage());

    if(loadedMaitreOuvrage==null ) {
    return;
    }
    marche.setMaitreOuvrage(loadedMaitreOuvrage);
    }
    private void findEtatMarche(Marche marche){
        EtatMarche loadedEtatMarche = null;
        if(marche.getEtatMarche() != null && marche.getEtatMarche().getId() !=null)
        loadedEtatMarche =etatMarcheService.findById(marche.getEtatMarche().getId());

    if(loadedEtatMarche==null ) {
    return;
    }
    marche.setEtatMarche(loadedEtatMarche);
    }

@Override
@Transactional
public void delete(List<Marche> marches){
if(ListUtil.isNotEmpty(marches)){
marches.forEach(e->marcheDao.delete(e));
}
}
@Override
public void update(List<Marche> marches){
if(ListUtil.isNotEmpty(marches)){
marches.forEach(e->marcheDao.save(e));
}
}

        private void associatePaiementMarche(Marche marche, List<PaiementMarche> paiementMarche) {
        if (ListUtil.isNotEmpty(paiementMarche)) {
        paiementMarche.forEach(e -> e.setMarche(marche));
        }
        }
        private void associateLot(Marche marche, List<Lot> lot) {
        if (ListUtil.isNotEmpty(lot)) {
        lot.forEach(e -> e.setMarche(marche));
        }
        }
        private void associateMarcheEmploye(Marche marche, List<MarcheEmploye> marcheEmploye) {
        if (ListUtil.isNotEmpty(marcheEmploye)) {
        marcheEmploye.forEach(e -> e.setMarche(marche));
        }
        }



        public List<Marche> findAllNonArchive(){
        String query = "SELECT o FROM Marche o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.dateFin";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Marche> findAllByOwner(){
        List<Marche> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Marche o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.dateFin";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
