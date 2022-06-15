package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.ChargeMaitreouvrageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.Charge;
import com.ird.faa.ws.rest.provided.converter.ChargeConverter;
import com.ird.faa.ws.rest.provided.vo.ChargeVo;

@Api("Manages charge services")
@RestController
@RequestMapping("api/maitreouvrage/charge")
public class ChargeRestMaitreouvrage {

@Autowired
private ChargeMaitreouvrageService chargeService;

@Autowired
private ChargeConverter chargeConverter;


            @ApiOperation("Updates the specified  charge")
            @PutMapping("/")
            public  ChargeVo update(@RequestBody  ChargeVo  chargeVo){
            Charge charge = chargeConverter.toItem(chargeVo);
            charge = chargeService.update(charge);
            return chargeConverter.toVo(charge);
            }

    @ApiOperation("Finds a list of all charges")
    @GetMapping("/")
    public List<ChargeVo> findAll(){
        return chargeConverter.toVo(chargeService.findAll());
    }

    @ApiOperation("Finds a charge with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ChargeVo findByIdWithAssociatedList(@PathVariable Long id){
    return chargeConverter.toVo(chargeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search charge by a specific criteria")
    @PostMapping("/search")
    public List<ChargeVo> findByCriteria(@RequestBody ChargeVo chargeVo){
        return chargeConverter.toVo(chargeService.findByCriteria(chargeVo));
        }

            @ApiOperation("Finds a charge by id")
            @GetMapping("/id/{id}")
            public ChargeVo findById(@PathVariable Long id){
            return chargeConverter.toVo(chargeService.findById(id));
            }

            @ApiOperation("Saves the specified  charge")
            @PostMapping("/")
            public ChargeVo save(@RequestBody ChargeVo chargeVo){
            Charge charge = chargeConverter.toItem(chargeVo);
            charge = chargeService.save(charge);
            return chargeConverter.toVo(charge);
            }

            @ApiOperation("Delete the specified charge")
            @DeleteMapping("/")
            public int delete(@RequestBody ChargeVo chargeVo){
            Charge charge = chargeConverter.toItem(chargeVo);
            return chargeService.delete(charge);
            }

            @ApiOperation("Deletes a charge by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return chargeService.deleteById(id);
            }
        @ApiOperation("find by compteComptable id")
        @GetMapping("/compteComptable/id/{id}")
        public List<Charge> findByCompteComptableId(@PathVariable Long id){
        return chargeService.findByCompteComptableId(id);
        }

        @ApiOperation("delete by compteComptable id")
        @DeleteMapping("/compteComptable/id/{id}")
        public int deleteByCompteComptableId(@PathVariable Long id){
        return chargeService.deleteByCompteComptableId(id);
        }

        @ApiOperation("find by etatCharge id")
        @GetMapping("/etatCharge/id/{id}")
        public List<Charge> findByEtatChargeId(@PathVariable Long id){
        return chargeService.findByEtatChargeId(id);
        }

        @ApiOperation("delete by etatCharge id")
        @DeleteMapping("/etatCharge/id/{id}")
        public int deleteByEtatChargeId(@PathVariable Long id){
        return chargeService.deleteByEtatChargeId(id);
        }

        @ApiOperation("find by categorieCharge id")
        @GetMapping("/categorieCharge/id/{id}")
        public List<Charge> findByCategorieChargeId(@PathVariable Long id){
        return chargeService.findByCategorieChargeId(id);
        }

        @ApiOperation("delete by categorieCharge id")
        @DeleteMapping("/categorieCharge/id/{id}")
        public int deleteByCategorieChargeId(@PathVariable Long id){
        return chargeService.deleteByCategorieChargeId(id);
        }

        @ApiOperation("find by produit reference")
        @GetMapping("/produit/reference/{reference}")
        public List<Charge> findByProduitReference(@PathVariable String reference){
        return chargeService.findByProduitReference(reference);
        }

        @ApiOperation("delete by produit reference")
        @DeleteMapping("/produit/reference/{reference}")
        public int deleteByProduitReference(@PathVariable String reference){
        return chargeService.deleteByProduitReference(reference);
        }

        @ApiOperation("find by produit id")
        @GetMapping("/produit/id/{id}")
        public List<Charge> findByProduitId(@PathVariable Long id){
        return chargeService.findByProduitId(id);
        }

        @ApiOperation("delete by produit id")
        @DeleteMapping("/produit/id/{id}")
        public int deleteByProduitId(@PathVariable Long id){
        return chargeService.deleteByProduitId(id);
        }





            @PutMapping("/archiver/")
            public ChargeVo archiver(@RequestBody ChargeVo chargeVo){
                Charge charge = chargeService.archiver(chargeConverter.toItem(chargeVo));
                return chargeConverter.toVo(charge);
                }

            @PutMapping("/desarchiver/")
            public ChargeVo desarchiver(@RequestBody ChargeVo chargeVo){
                Charge charge = chargeService.desarchiver(chargeConverter.toItem(chargeVo));
                return chargeConverter.toVo(charge);}
            }
