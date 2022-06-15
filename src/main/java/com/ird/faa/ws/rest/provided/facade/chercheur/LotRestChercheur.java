package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.LotChercheurService;

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
import com.ird.faa.bean.Lot;
import com.ird.faa.ws.rest.provided.converter.LotConverter;
import com.ird.faa.ws.rest.provided.vo.LotVo;

@Api("Manages lot services")
@RestController
@RequestMapping("api/chercheur/lot")
public class LotRestChercheur {

@Autowired
private LotChercheurService lotService;

@Autowired
private LotConverter lotConverter;


            @ApiOperation("Updates the specified  lot")
            @PutMapping("/")
            public  LotVo update(@RequestBody  LotVo  lotVo){
            Lot lot = lotConverter.toItem(lotVo);
            lot = lotService.update(lot);
            return lotConverter.toVo(lot);
            }

    @ApiOperation("Finds a list of all lots")
    @GetMapping("/")
    public List<LotVo> findAll(){
        return lotConverter.toVo(lotService.findAll());
    }

    @ApiOperation("Finds a lot with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public LotVo findByIdWithAssociatedList(@PathVariable Long id){
    return lotConverter.toVo(lotService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search lot by a specific criteria")
    @PostMapping("/search")
    public List<LotVo> findByCriteria(@RequestBody LotVo lotVo){
        return lotConverter.toVo(lotService.findByCriteria(lotVo));
        }

            @ApiOperation("Finds a lot by id")
            @GetMapping("/id/{id}")
            public LotVo findById(@PathVariable Long id){
            return lotConverter.toVo(lotService.findById(id));
            }

            @ApiOperation("Saves the specified  lot")
            @PostMapping("/")
            public LotVo save(@RequestBody LotVo lotVo){
            Lot lot = lotConverter.toItem(lotVo);
            lot = lotService.save(lot);
            return lotConverter.toVo(lot);
            }

            @ApiOperation("Delete the specified lot")
            @DeleteMapping("/")
            public int delete(@RequestBody LotVo lotVo){
            Lot lot = lotConverter.toItem(lotVo);
            return lotService.delete(lot);
            }

            @ApiOperation("Deletes a lot by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return lotService.deleteById(id);
            }
        @ApiOperation("find by paiementLot reference")
        @GetMapping("/paiementLot/reference/{reference}")
        public List<Lot> findByPaiementLotReference(@PathVariable String reference){
        return lotService.findByPaiementLotReference(reference);
        }

        @ApiOperation("delete by paiementLot reference")
        @DeleteMapping("/paiementLot/reference/{reference}")
        public int deleteByPaiementLotReference(@PathVariable String reference){
        return lotService.deleteByPaiementLotReference(reference);
        }

        @ApiOperation("find by paiementLot id")
        @GetMapping("/paiementLot/id/{id}")
        public List<Lot> findByPaiementLotId(@PathVariable Long id){
        return lotService.findByPaiementLotId(id);
        }

        @ApiOperation("delete by paiementLot id")
        @DeleteMapping("/paiementLot/id/{id}")
        public int deleteByPaiementLotId(@PathVariable Long id){
        return lotService.deleteByPaiementLotId(id);
        }

        @ApiOperation("find by etatLot id")
        @GetMapping("/etatLot/id/{id}")
        public List<Lot> findByEtatLotId(@PathVariable Long id){
        return lotService.findByEtatLotId(id);
        }

        @ApiOperation("delete by etatLot id")
        @DeleteMapping("/etatLot/id/{id}")
        public int deleteByEtatLotId(@PathVariable Long id){
        return lotService.deleteByEtatLotId(id);
        }

        @ApiOperation("find by marche code")
        @GetMapping("/marche/code/{code}")
        public List<Lot> findByMarcheCode(@PathVariable Long code){
        return lotService.findByMarcheCode(code);
        }

        @ApiOperation("delete by marche code")
        @DeleteMapping("/marche/code/{code}")
        public int deleteByMarcheCode(@PathVariable Long code){
        return lotService.deleteByMarcheCode(code);
        }

        @ApiOperation("find by marche id")
        @GetMapping("/marche/id/{id}")
        public List<Lot> findByMarcheId(@PathVariable Long id){
        return lotService.findByMarcheId(id);
        }

        @ApiOperation("delete by marche id")
        @DeleteMapping("/marche/id/{id}")
        public int deleteByMarcheId(@PathVariable Long id){
        return lotService.deleteByMarcheId(id);
        }





            }
