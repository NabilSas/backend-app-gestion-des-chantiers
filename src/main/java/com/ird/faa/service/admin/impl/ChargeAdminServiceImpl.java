package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Charge;
        import com.ird.faa.bean.CompteComptable;
        import com.ird.faa.bean.EtatCharge;
        import com.ird.faa.bean.CategorieCharge;
        import com.ird.faa.bean.Produit;
        import com.ird.faa.bean.PieceJointeCharge;
import com.ird.faa.dao.ChargeDao;
import com.ird.faa.service.admin.facade.ChargeAdminService;
        import com.ird.faa.service.admin.facade.CategorieChargeAdminService;
        import com.ird.faa.service.admin.facade.PieceJointeChargeAdminService;
        import com.ird.faa.service.admin.facade.CompteComptableAdminService;
        import com.ird.faa.service.admin.facade.EtatChargeAdminService;
        import com.ird.faa.service.admin.facade.ProduitAdminService;

import com.ird.faa.ws.rest.provided.vo.ChargeVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeCharge;
        import com.ird.faa.service.admin.facade.PieceJointeChargeAdminService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ChargeAdminServiceImpl extends AbstractServiceImpl<Charge> implements ChargeAdminService {

@Autowired
private ChargeDao chargeDao;

    @Autowired
    private ArchivableService<Charge> archivableService;
        @Autowired
        private CategorieChargeAdminService categorieChargeService ;
        @Autowired
        private PieceJointeChargeAdminService pieceJointeChargeService ;
        @Autowired
        private CompteComptableAdminService compteComptableService ;
        @Autowired
        private EtatChargeAdminService etatChargeService ;
        @Autowired
        private ProduitAdminService produitService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Charge> findAll(){
        String query = "SELECT o FROM Charge o where 1=1 ";
        query+= " ORDER BY o.dateCharge";
        return entityManager.createQuery(query).getResultList();
}
        @Override
        public List<Charge> findByCompteComptableId(Long id){
        return chargeDao.findByCompteComptableId(id);
        }

        @Override
        @Transactional
        public int deleteByCompteComptableId(Long id){
        return chargeDao.deleteByCompteComptableId(id);
        }

        @Override
        public List<Charge> findByEtatChargeId(Long id){
        return chargeDao.findByEtatChargeId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatChargeId(Long id){
        return chargeDao.deleteByEtatChargeId(id);
        }

        @Override
        public List<Charge> findByCategorieChargeId(Long id){
        return chargeDao.findByCategorieChargeId(id);
        }

        @Override
        @Transactional
        public int deleteByCategorieChargeId(Long id){
        return chargeDao.deleteByCategorieChargeId(id);
        }


        @Override
        public List<Charge> findByProduitReference(String reference){
        return chargeDao.findByProduitReference(reference);
        }

        @Override
        @Transactional
        public int deleteByProduitReference(String reference){
        return chargeDao.deleteByProduitReference(reference);
        }

        @Override
        public List<Charge> findByProduitId(Long id){
        return chargeDao.findByProduitId(id);
        }

        @Override
        @Transactional
        public int deleteByProduitId(Long id){
        return chargeDao.deleteByProduitId(id);
        }


@Override
public Charge findById(Long id){
if(id==null) return null;
return chargeDao.getOne(id);
}

@Override
public Charge findByIdWithAssociatedList(Long id){
    Charge charge  = findById(id);
    findAssociatedLists(charge);
    return charge;
}
    @Override
    public Charge archiver(Charge charge) {
    if (charge.getArchive() == null) {
    charge.setArchive(false);
    }
    charge.setArchive(true);
    charge.setDateArchivage(new Date());
    chargeDao.save(charge);
    return charge;

    }

    @Override
    public Charge desarchiver(Charge charge) {
    if (charge.getArchive() == null) {
    charge.setArchive(false);
    }
    charge.setArchive(false);
    chargeDao.save(charge);
    return charge;
    }


    private void findAssociatedLists(Charge charge){
    if(charge!=null && charge.getId() != null) {
            List<PieceJointeCharge> pieceJointeCharges = pieceJointeChargeService.findByChargeId(charge.getId());
            charge.setPieceJointeCharges(pieceJointeCharges);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeChargeService.deleteByChargeId(id);
    }
    }

    private void updateAssociatedLists(Charge charge){
    if(charge !=null && charge.getId() != null){
            List
            <List<PieceJointeCharge>> resultPieceJointeCharges= pieceJointeChargeService.getToBeSavedAndToBeDeleted(pieceJointeChargeService.findByChargeId(charge.getId()),charge.getPieceJointeCharges());
            pieceJointeChargeService.delete(resultPieceJointeCharges.get(1));
            associatePieceJointeCharge(charge,resultPieceJointeCharges.get(0));
            pieceJointeChargeService.update(resultPieceJointeCharges.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(chargeDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
chargeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Charge update(Charge charge){
Charge foundedCharge = findById(charge.getId());
if(foundedCharge==null) return null;
else{
    archivableService.prepare(charge);
    updateAssociatedLists(charge);
return  chargeDao.save(charge);
}
}
    private void prepareSave(Charge charge){
        charge.setDateCreation(new Date());
        if(charge.getDateArchivage() == null)
        charge.setDateArchivage(new Date());
                    if(charge.getArchive() == null)
                charge.setArchive(false);




    }

@Override
public Charge save (Charge charge){
    prepareSave(charge);

    Charge result =null;


    findCompteComptable(charge);
    findEtatCharge(charge);
    findCategorieCharge(charge);
    findProduit(charge);

    Charge savedCharge = chargeDao.save(charge);

        savePieceJointeCharges(savedCharge,charge.getPieceJointeCharges());
    result = savedCharge;

    return result;
}

@Override
public List<Charge> save(List<Charge> charges){
List<Charge> list = new ArrayList<>();
for(Charge charge: charges){
list.add(save(charge));
}
return list;
}

        private List<PieceJointeCharge> preparePieceJointeCharges(Charge charge,List<PieceJointeCharge> pieceJointeCharges){
        for(PieceJointeCharge pieceJointeCharge:pieceJointeCharges ){
        pieceJointeCharge.setCharge(charge);
        }
        return pieceJointeCharges;
        }


@Override
@Transactional
public int delete(Charge charge){
    if(charge.getId()==null) return -1;
    Charge foundedCharge = findById(charge.getId());
    if(foundedCharge==null) return -1;
chargeDao.delete(foundedCharge);
return 1;
}


public List<Charge> findByCriteria(ChargeVo chargeVo){

String query = "SELECT o FROM Charge o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",chargeVo.getId());
            query += SearchUtil.addConstraint( "o", "montant","=",chargeVo.getMontant());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",chargeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "totalPaye","=",chargeVo.getTotalPaye());
            query += SearchUtil.addConstraint( "o", "description","LIKE",chargeVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateCharge","=",chargeVo.getDateCharge());
            query += SearchUtil.addConstraint( "o", "pieceJointeCharges","=",chargeVo.getPieceJointeCharges());
            query += SearchUtil.addConstraint( "o", "archive","=",chargeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",chargeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",chargeVo.getDateCreation());
            query += SearchUtil.addConstraintMinMax("o","montant",chargeVo.getMontantMin(),chargeVo.getMontantMax());
            query += SearchUtil.addConstraintMinMax("o","totalPaye",chargeVo.getTotalPayeMin(),chargeVo.getTotalPayeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCharge",chargeVo.getDateChargeMin(),chargeVo.getDateChargeMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeCharges",chargeVo.getPieceJointeChargesMin(),chargeVo.getPieceJointeChargesMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",chargeVo.getDateArchivageMin(),chargeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",chargeVo.getDateCreationMin(),chargeVo.getDateCreationMax());
    if(chargeVo.getCompteComptableVo()!=null){
        query += SearchUtil.addConstraint( "o", "compteComptable.id","=",chargeVo.getCompteComptableVo().getId());
    }

    if(chargeVo.getEtatChargeVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatCharge.id","=",chargeVo.getEtatChargeVo().getId());
    }

    if(chargeVo.getCategorieChargeVo()!=null){
        query += SearchUtil.addConstraint( "o", "categorieCharge.id","=",chargeVo.getCategorieChargeVo().getId());
    }

    if(chargeVo.getProduitVo()!=null){
        query += SearchUtil.addConstraint( "o", "produit.id","=",chargeVo.getProduitVo().getId());
            query += SearchUtil.addConstraint( "o", "produit.reference","LIKE",chargeVo.getProduitVo().getReference());
    }

    query+= " ORDER BY o.dateCharge";
return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeCharges(Charge charge,List<PieceJointeCharge> pieceJointeCharges){

        if (ListUtil.isNotEmpty(charge.getPieceJointeCharges())) {
        List<PieceJointeCharge> savedPieceJointeCharges = new ArrayList<>();
        pieceJointeCharges.forEach(element -> {
        element.setCharge(charge);
         pieceJointeChargeService.save(element);
        });
        charge.setPieceJointeCharges(savedPieceJointeCharges);
        }
        }

    private void findCompteComptable(Charge charge){
        CompteComptable loadedCompteComptable = null;
        if(charge.getCompteComptable() != null && charge.getCompteComptable().getId() !=null)
        loadedCompteComptable =compteComptableService.findById(charge.getCompteComptable().getId());

    if(loadedCompteComptable==null ) {
    return;
    }
    charge.setCompteComptable(loadedCompteComptable);
    }
    private void findEtatCharge(Charge charge){
        EtatCharge loadedEtatCharge = null;
        if(charge.getEtatCharge() != null && charge.getEtatCharge().getId() !=null)
        loadedEtatCharge =etatChargeService.findById(charge.getEtatCharge().getId());

    if(loadedEtatCharge==null ) {
    return;
    }
    charge.setEtatCharge(loadedEtatCharge);
    }
    private void findCategorieCharge(Charge charge){
        CategorieCharge loadedCategorieCharge = null;
        if(charge.getCategorieCharge() != null && charge.getCategorieCharge().getId() !=null)
        loadedCategorieCharge =categorieChargeService.findById(charge.getCategorieCharge().getId());

    if(loadedCategorieCharge==null ) {
    return;
    }
    charge.setCategorieCharge(loadedCategorieCharge);
    }
    private void findProduit(Charge charge){
        Produit loadedProduit =produitService.findByIdOrReference(charge.getProduit());

    if(loadedProduit==null ) {
    return;
    }
    charge.setProduit(loadedProduit);
    }

@Override
@Transactional
public void delete(List<Charge> charges){
if(ListUtil.isNotEmpty(charges)){
charges.forEach(e->chargeDao.delete(e));
}
}
@Override
public void update(List<Charge> charges){
if(ListUtil.isNotEmpty(charges)){
charges.forEach(e->chargeDao.save(e));
}
}

        private void associatePieceJointeCharge(Charge charge, List<PieceJointeCharge> pieceJointeCharge) {
        if (ListUtil.isNotEmpty(pieceJointeCharge)) {
        pieceJointeCharge.forEach(e -> e.setCharge(charge));
        }
        }




    }
