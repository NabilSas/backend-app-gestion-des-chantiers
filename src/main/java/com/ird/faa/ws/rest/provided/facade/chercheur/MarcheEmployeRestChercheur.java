package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.MarcheEmployeChercheurService;

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
import com.ird.faa.bean.MarcheEmploye;
import com.ird.faa.ws.rest.provided.converter.MarcheEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.MarcheEmployeVo;

@Api("Manages marcheEmploye services")
@RestController
@RequestMapping("api/chercheur/marcheEmploye")
public class MarcheEmployeRestChercheur {

@Autowired
private MarcheEmployeChercheurService marcheEmployeService;

@Autowired
private MarcheEmployeConverter marcheEmployeConverter;


            @ApiOperation("Updates the specified  marcheEmploye")
            @PutMapping("/")
            public  MarcheEmployeVo update(@RequestBody  MarcheEmployeVo  marcheEmployeVo){
            MarcheEmploye marcheEmploye = marcheEmployeConverter.toItem(marcheEmployeVo);
            marcheEmploye = marcheEmployeService.update(marcheEmploye);
            return marcheEmployeConverter.toVo(marcheEmploye);
            }

    @ApiOperation("Finds a list of all marcheEmployes")
    @GetMapping("/")
    public List<MarcheEmployeVo> findAll(){
        return marcheEmployeConverter.toVo(marcheEmployeService.findAll());
    }

    @ApiOperation("Finds a marcheEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MarcheEmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return marcheEmployeConverter.toVo(marcheEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search marcheEmploye by a specific criteria")
    @PostMapping("/search")
    public List<MarcheEmployeVo> findByCriteria(@RequestBody MarcheEmployeVo marcheEmployeVo){
        return marcheEmployeConverter.toVo(marcheEmployeService.findByCriteria(marcheEmployeVo));
        }

            @ApiOperation("Finds a marcheEmploye by id")
            @GetMapping("/id/{id}")
            public MarcheEmployeVo findById(@PathVariable Long id){
            return marcheEmployeConverter.toVo(marcheEmployeService.findById(id));
            }

            @ApiOperation("Saves the specified  marcheEmploye")
            @PostMapping("/")
            public MarcheEmployeVo save(@RequestBody MarcheEmployeVo marcheEmployeVo){
            MarcheEmploye marcheEmploye = marcheEmployeConverter.toItem(marcheEmployeVo);
            marcheEmploye = marcheEmployeService.save(marcheEmploye);
            return marcheEmployeConverter.toVo(marcheEmploye);
            }

            @ApiOperation("Delete the specified marcheEmploye")
            @DeleteMapping("/")
            public int delete(@RequestBody MarcheEmployeVo marcheEmployeVo){
            MarcheEmploye marcheEmploye = marcheEmployeConverter.toItem(marcheEmployeVo);
            return marcheEmployeService.delete(marcheEmploye);
            }

            @ApiOperation("Deletes a marcheEmploye by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return marcheEmployeService.deleteById(id);
            }
        @ApiOperation("find by marche code")
        @GetMapping("/marche/code/{code}")
        public List<MarcheEmploye> findByMarcheCode(@PathVariable Long code){
        return marcheEmployeService.findByMarcheCode(code);
        }

        @ApiOperation("delete by marche code")
        @DeleteMapping("/marche/code/{code}")
        public int deleteByMarcheCode(@PathVariable Long code){
        return marcheEmployeService.deleteByMarcheCode(code);
        }

        @ApiOperation("find by marche id")
        @GetMapping("/marche/id/{id}")
        public List<MarcheEmploye> findByMarcheId(@PathVariable Long id){
        return marcheEmployeService.findByMarcheId(id);
        }

        @ApiOperation("delete by marche id")
        @DeleteMapping("/marche/id/{id}")
        public int deleteByMarcheId(@PathVariable Long id){
        return marcheEmployeService.deleteByMarcheId(id);
        }

        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<MarcheEmploye> findByEmployeId(@PathVariable Long id){
        return marcheEmployeService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return marcheEmployeService.deleteByEmployeId(id);
        }





            }
