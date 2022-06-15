package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatChargeChercheurService;

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
import com.ird.faa.bean.EtatCharge;
import com.ird.faa.ws.rest.provided.converter.EtatChargeConverter;
import com.ird.faa.ws.rest.provided.vo.EtatChargeVo;

@Api("Manages etatCharge services")
@RestController
@RequestMapping("api/chercheur/etatCharge")
public class EtatChargeRestChercheur {

@Autowired
private EtatChargeChercheurService etatChargeService;

@Autowired
private EtatChargeConverter etatChargeConverter;


            @ApiOperation("Updates the specified  etatCharge")
            @PutMapping("/")
            public  EtatChargeVo update(@RequestBody  EtatChargeVo  etatChargeVo){
            EtatCharge etatCharge = etatChargeConverter.toItem(etatChargeVo);
            etatCharge = etatChargeService.update(etatCharge);
            return etatChargeConverter.toVo(etatCharge);
            }

    @ApiOperation("Finds a list of all etatCharges")
    @GetMapping("/")
    public List<EtatChargeVo> findAll(){
        return etatChargeConverter.toVo(etatChargeService.findAll());
    }

    @ApiOperation("Finds a etatCharge with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatChargeVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatChargeConverter.toVo(etatChargeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatCharge by a specific criteria")
    @PostMapping("/search")
    public List<EtatChargeVo> findByCriteria(@RequestBody EtatChargeVo etatChargeVo){
        return etatChargeConverter.toVo(etatChargeService.findByCriteria(etatChargeVo));
        }

            @ApiOperation("Finds a etatCharge by id")
            @GetMapping("/id/{id}")
            public EtatChargeVo findById(@PathVariable Long id){
            return etatChargeConverter.toVo(etatChargeService.findById(id));
            }

            @ApiOperation("Saves the specified  etatCharge")
            @PostMapping("/")
            public EtatChargeVo save(@RequestBody EtatChargeVo etatChargeVo){
            EtatCharge etatCharge = etatChargeConverter.toItem(etatChargeVo);
            etatCharge = etatChargeService.save(etatCharge);
            return etatChargeConverter.toVo(etatCharge);
            }

            @ApiOperation("Delete the specified etatCharge")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatChargeVo etatChargeVo){
            EtatCharge etatCharge = etatChargeConverter.toItem(etatChargeVo);
            return etatChargeService.delete(etatCharge);
            }

            @ApiOperation("Deletes a etatCharge by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatChargeService.deleteById(id);
            }




            }
