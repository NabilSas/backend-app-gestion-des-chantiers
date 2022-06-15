package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.LotEmployeChercheurService;

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
import com.ird.faa.bean.LotEmploye;
import com.ird.faa.ws.rest.provided.converter.LotEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.LotEmployeVo;

@Api("Manages lotEmploye services")
@RestController
@RequestMapping("api/chercheur/lotEmploye")
public class LotEmployeRestChercheur {

@Autowired
private LotEmployeChercheurService lotEmployeService;

@Autowired
private LotEmployeConverter lotEmployeConverter;


            @ApiOperation("Updates the specified  lotEmploye")
            @PutMapping("/")
            public  LotEmployeVo update(@RequestBody  LotEmployeVo  lotEmployeVo){
            LotEmploye lotEmploye = lotEmployeConverter.toItem(lotEmployeVo);
            lotEmploye = lotEmployeService.update(lotEmploye);
            return lotEmployeConverter.toVo(lotEmploye);
            }

    @ApiOperation("Finds a list of all lotEmployes")
    @GetMapping("/")
    public List<LotEmployeVo> findAll(){
        return lotEmployeConverter.toVo(lotEmployeService.findAll());
    }

    @ApiOperation("Finds a lotEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public LotEmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return lotEmployeConverter.toVo(lotEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search lotEmploye by a specific criteria")
    @PostMapping("/search")
    public List<LotEmployeVo> findByCriteria(@RequestBody LotEmployeVo lotEmployeVo){
        return lotEmployeConverter.toVo(lotEmployeService.findByCriteria(lotEmployeVo));
        }

            @ApiOperation("Finds a lotEmploye by id")
            @GetMapping("/id/{id}")
            public LotEmployeVo findById(@PathVariable Long id){
            return lotEmployeConverter.toVo(lotEmployeService.findById(id));
            }

            @ApiOperation("Saves the specified  lotEmploye")
            @PostMapping("/")
            public LotEmployeVo save(@RequestBody LotEmployeVo lotEmployeVo){
            LotEmploye lotEmploye = lotEmployeConverter.toItem(lotEmployeVo);
            lotEmploye = lotEmployeService.save(lotEmploye);
            return lotEmployeConverter.toVo(lotEmploye);
            }

            @ApiOperation("Delete the specified lotEmploye")
            @DeleteMapping("/")
            public int delete(@RequestBody LotEmployeVo lotEmployeVo){
            LotEmploye lotEmploye = lotEmployeConverter.toItem(lotEmployeVo);
            return lotEmployeService.delete(lotEmploye);
            }

            @ApiOperation("Deletes a lotEmploye by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return lotEmployeService.deleteById(id);
            }
        @ApiOperation("find by lot id")
        @GetMapping("/lot/id/{id}")
        public List<LotEmploye> findByLotId(@PathVariable Long id){
        return lotEmployeService.findByLotId(id);
        }

        @ApiOperation("delete by lot id")
        @DeleteMapping("/lot/id/{id}")
        public int deleteByLotId(@PathVariable Long id){
        return lotEmployeService.deleteByLotId(id);
        }

        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<LotEmploye> findByEmployeId(@PathVariable Long id){
        return lotEmployeService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return lotEmployeService.deleteByEmployeId(id);
        }





            }
