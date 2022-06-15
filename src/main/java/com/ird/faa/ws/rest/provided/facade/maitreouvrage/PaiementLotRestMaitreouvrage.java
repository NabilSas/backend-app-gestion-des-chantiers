package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.PaiementLotMaitreouvrageService;

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
import com.ird.faa.bean.PaiementLot;
import com.ird.faa.ws.rest.provided.converter.PaiementLotConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementLotVo;

@Api("Manages paiementLot services")
@RestController
@RequestMapping("api/maitreouvrage/paiementLot")
public class PaiementLotRestMaitreouvrage {

@Autowired
private PaiementLotMaitreouvrageService paiementLotService;

@Autowired
private PaiementLotConverter paiementLotConverter;


            @ApiOperation("Updates the specified  paiementLot")
            @PutMapping("/")
            public  PaiementLotVo update(@RequestBody  PaiementLotVo  paiementLotVo){
            PaiementLot paiementLot = paiementLotConverter.toItem(paiementLotVo);
            paiementLot = paiementLotService.update(paiementLot);
            return paiementLotConverter.toVo(paiementLot);
            }

    @ApiOperation("Finds a list of all paiementLots")
    @GetMapping("/")
    public List<PaiementLotVo> findAll(){
        return paiementLotConverter.toVo(paiementLotService.findAll());
    }

    @ApiOperation("Finds a paiementLot with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementLotVo findByIdWithAssociatedList(@PathVariable Long id){
    return paiementLotConverter.toVo(paiementLotService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiementLot by a specific criteria")
    @PostMapping("/search")
    public List<PaiementLotVo> findByCriteria(@RequestBody PaiementLotVo paiementLotVo){
        return paiementLotConverter.toVo(paiementLotService.findByCriteria(paiementLotVo));
        }

            @ApiOperation("Finds a paiementLot by id")
            @GetMapping("/id/{id}")
            public PaiementLotVo findById(@PathVariable Long id){
            return paiementLotConverter.toVo(paiementLotService.findById(id));
            }

            @ApiOperation("Saves the specified  paiementLot")
            @PostMapping("/")
            public PaiementLotVo save(@RequestBody PaiementLotVo paiementLotVo){
            PaiementLot paiementLot = paiementLotConverter.toItem(paiementLotVo);
            paiementLot = paiementLotService.save(paiementLot);
            return paiementLotConverter.toVo(paiementLot);
            }

            @ApiOperation("Delete the specified paiementLot")
            @DeleteMapping("/")
            public int delete(@RequestBody PaiementLotVo paiementLotVo){
            PaiementLot paiementLot = paiementLotConverter.toItem(paiementLotVo);
            return paiementLotService.delete(paiementLot);
            }

            @ApiOperation("Deletes a paiementLot by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paiementLotService.deleteById(id);
            }
        @ApiOperation("find by typePaiementLot id")
        @GetMapping("/typePaiementLot/id/{id}")
        public List<PaiementLot> findByTypePaiementLotId(@PathVariable Long id){
        return paiementLotService.findByTypePaiementLotId(id);
        }

        @ApiOperation("delete by typePaiementLot id")
        @DeleteMapping("/typePaiementLot/id/{id}")
        public int deleteByTypePaiementLotId(@PathVariable Long id){
        return paiementLotService.deleteByTypePaiementLotId(id);
        }

        @ApiOperation("find by lot id")
        @GetMapping("/lot/id/{id}")
        public List<PaiementLot> findByLotId(@PathVariable Long id){
        return paiementLotService.findByLotId(id);
        }

        @ApiOperation("delete by lot id")
        @DeleteMapping("/lot/id/{id}")
        public int deleteByLotId(@PathVariable Long id){
        return paiementLotService.deleteByLotId(id);
        }





            }
