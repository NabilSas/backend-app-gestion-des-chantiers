package com.ird.faa.service.maitreouvrage.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Lot;
        import com.ird.faa.bean.PaiementLot;
        import com.ird.faa.bean.EtatLot;
        import com.ird.faa.bean.Marche;
        import com.ird.faa.bean.LotEmploye;
import com.ird.faa.dao.LotDao;
import com.ird.faa.service.maitreouvrage.facade.LotMaitreouvrageService;
        import com.ird.faa.service.maitreouvrage.facade.MarcheMaitreouvrageService;
        import com.ird.faa.service.maitreouvrage.facade.EtatLotMaitreouvrageService;
        import com.ird.faa.service.maitreouvrage.facade.LotEmployeMaitreouvrageService;
        import com.ird.faa.service.maitreouvrage.facade.PaiementLotMaitreouvrageService;

import com.ird.faa.ws.rest.provided.vo.LotVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.LotEmploye;
        import com.ird.faa.service.maitreouvrage.facade.LotEmployeMaitreouvrageService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class LotMaitreouvrageServiceImpl extends AbstractServiceImpl<Lot> implements LotMaitreouvrageService {

@Autowired
private LotDao lotDao;

        @Autowired
        private MarcheMaitreouvrageService marcheService ;
        @Autowired
        private EtatLotMaitreouvrageService etatLotService ;
        @Autowired
        private LotEmployeMaitreouvrageService lotEmployeService ;
        @Autowired
        private PaiementLotMaitreouvrageService paiementLotService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Lot> findAll(){
        String query = "SELECT o FROM Lot o where 1=1 ";
        query+= " ORDER BY o.dateDelivrance";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Lot> findByPaiementLotReference(String reference){
        return lotDao.findByPaiementLotReference(reference);
        }

        @Override
        @Transactional
        public int deleteByPaiementLotReference(String reference){
        return lotDao.deleteByPaiementLotReference(reference);
        }

        @Override
        public List<Lot> findByPaiementLotId(Long id){
        return lotDao.findByPaiementLotId(id);
        }

        @Override
        @Transactional
        public int deleteByPaiementLotId(Long id){
        return lotDao.deleteByPaiementLotId(id);
        }

        @Override
        public List<Lot> findByEtatLotId(Long id){
        return lotDao.findByEtatLotId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatLotId(Long id){
        return lotDao.deleteByEtatLotId(id);
        }


        @Override
        public List<Lot> findByMarcheCode(Long code){
        return lotDao.findByMarcheCode(code);
        }

        @Override
        @Transactional
        public int deleteByMarcheCode(Long code){
        return lotDao.deleteByMarcheCode(code);
        }

        @Override
        public List<Lot> findByMarcheId(Long id){
        return lotDao.findByMarcheId(id);
        }

        @Override
        @Transactional
        public int deleteByMarcheId(Long id){
        return lotDao.deleteByMarcheId(id);
        }


@Override
public Lot findById(Long id){
if(id==null) return null;
return lotDao.getOne(id);
}

@Override
public Lot findByIdWithAssociatedList(Long id){
    Lot lot  = findById(id);
    findAssociatedLists(lot);
    return lot;
}

    private void findAssociatedLists(Lot lot){
    if(lot!=null && lot.getId() != null) {
            List<LotEmploye> lotEmployes = lotEmployeService.findByLotId(lot.getId());
            lot.setLotEmployes(lotEmployes);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            lotEmployeService.deleteByLotId(id);
    }
    }

    private void updateAssociatedLists(Lot lot){
    if(lot !=null && lot.getId() != null){
            List
            <List<LotEmploye>> resultLotEmployes= lotEmployeService.getToBeSavedAndToBeDeleted(lotEmployeService.findByLotId(lot.getId()),lot.getLotEmployes());
            lotEmployeService.delete(resultLotEmployes.get(1));
            associateLotEmploye(lot,resultLotEmployes.get(0));
            lotEmployeService.update(resultLotEmployes.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(lotDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
lotDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Lot update(Lot lot){
Lot foundedLot = findById(lot.getId());
if(foundedLot==null) return null;
else{
    updateAssociatedLists(lot);
return  lotDao.save(lot);
}
}

@Override
public Lot save (Lot lot){

    Lot result =null;


    findPaiementLot(lot);
    findEtatLot(lot);
    findMarche(lot);

    Lot savedLot = lotDao.save(lot);

        saveLotEmployes(savedLot,lot.getLotEmployes());
    result = savedLot;

    return result;
}

@Override
public List<Lot> save(List<Lot> lots){
List<Lot> list = new ArrayList<>();
for(Lot lot: lots){
list.add(save(lot));
}
return list;
}

        private List<LotEmploye> prepareLotEmployes(Lot lot,List<LotEmploye> lotEmployes){
        for(LotEmploye lotEmploye:lotEmployes ){
        lotEmploye.setLot(lot);
        }
        return lotEmployes;
        }


@Override
@Transactional
public int delete(Lot lot){
    if(lot.getId()==null) return -1;
    Lot foundedLot = findById(lot.getId());
    if(foundedLot==null) return -1;
lotDao.delete(foundedLot);
return 1;
}


public List<Lot> findByCriteria(LotVo lotVo){

String query = "SELECT o FROM Lot o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",lotVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",lotVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "codeLot","=",lotVo.getCodeLot());
            query += SearchUtil.addConstraint( "o", "description","LIKE",lotVo.getDescription());
            query += SearchUtil.addConstraint( "o", "montantHT","=",lotVo.getMontantHT());
            query += SearchUtil.addConstraint( "o", "montantTTC","=",lotVo.getMontantTTC());
            query += SearchUtil.addConstraint( "o", "montantTVA","=",lotVo.getMontantTVA());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",lotVo.getDateDebut());
        query += SearchUtil.addConstraintDate( "o", "dureeTravaux","=",lotVo.getDureeTravaux());
        query += SearchUtil.addConstraintDate( "o", "dateDelivrance","=",lotVo.getDateDelivrance());
            query += SearchUtil.addConstraint( "o", "montantPaye","=",lotVo.getMontantPaye());
            query += SearchUtil.addConstraintMinMax("o","codeLot",lotVo.getCodeLotMin(),lotVo.getCodeLotMax());
            query += SearchUtil.addConstraintMinMax("o","montantHT",lotVo.getMontantHTMin(),lotVo.getMontantHTMax());
            query += SearchUtil.addConstraintMinMax("o","montantTTC",lotVo.getMontantTTCMin(),lotVo.getMontantTTCMax());
            query += SearchUtil.addConstraintMinMax("o","montantTVA",lotVo.getMontantTVAMin(),lotVo.getMontantTVAMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",lotVo.getDateDebutMin(),lotVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dureeTravaux",lotVo.getDureeTravauxMin(),lotVo.getDureeTravauxMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDelivrance",lotVo.getDateDelivranceMin(),lotVo.getDateDelivranceMax());
            query += SearchUtil.addConstraintMinMax("o","montantPaye",lotVo.getMontantPayeMin(),lotVo.getMontantPayeMax());
    if(lotVo.getPaiementLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "paiementLot.id","=",lotVo.getPaiementLotVo().getId());
            query += SearchUtil.addConstraint( "o", "paiementLot.reference","LIKE",lotVo.getPaiementLotVo().getReference());
    }

    if(lotVo.getEtatLotVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatLot.id","=",lotVo.getEtatLotVo().getId());
    }

    if(lotVo.getMarcheVo()!=null){
        query += SearchUtil.addConstraint( "o", "marche.id","=",lotVo.getMarcheVo().getId());
            query += SearchUtil.addConstraint( "o", "marche.code","=",lotVo.getMarcheVo().getCode());
    }

    query+= " ORDER BY o.dateDelivrance";
return entityManager.createQuery(query).getResultList();
}
        private  void saveLotEmployes(Lot lot,List<LotEmploye> lotEmployes){

        if (ListUtil.isNotEmpty(lot.getLotEmployes())) {
        List<LotEmploye> savedLotEmployes = new ArrayList<>();
        lotEmployes.forEach(element -> {
        element.setLot(lot);
         lotEmployeService.save(element);
        });
        lot.setLotEmployes(savedLotEmployes);
        }
        }

    private void findPaiementLot(Lot lot){
        PaiementLot loadedPaiementLot =paiementLotService.findByIdOrReference(lot.getPaiementLot());

    if(loadedPaiementLot==null ) {
    return;
    }
    lot.setPaiementLot(loadedPaiementLot);
    }
    private void findEtatLot(Lot lot){
        EtatLot loadedEtatLot = null;
        if(lot.getEtatLot() != null && lot.getEtatLot().getId() !=null)
        loadedEtatLot =etatLotService.findById(lot.getEtatLot().getId());

    if(loadedEtatLot==null ) {
    return;
    }
    lot.setEtatLot(loadedEtatLot);
    }
    private void findMarche(Lot lot){
        Marche loadedMarche =marcheService.findByIdOrCode(lot.getMarche());

    if(loadedMarche==null ) {
    return;
    }
    lot.setMarche(loadedMarche);
    }

@Override
@Transactional
public void delete(List<Lot> lots){
if(ListUtil.isNotEmpty(lots)){
lots.forEach(e->lotDao.delete(e));
}
}
@Override
public void update(List<Lot> lots){
if(ListUtil.isNotEmpty(lots)){
lots.forEach(e->lotDao.save(e));
}
}

        private void associateLotEmploye(Lot lot, List<LotEmploye> lotEmploye) {
        if (ListUtil.isNotEmpty(lotEmploye)) {
        lotEmploye.forEach(e -> e.setLot(lot));
        }
        }




    }
