package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.MarcheChercheurService;

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
import com.ird.faa.bean.Marche;
import com.ird.faa.ws.rest.provided.converter.MarcheConverter;
import com.ird.faa.ws.rest.provided.vo.MarcheVo;

@Api("Manages marche services")
@RestController
@RequestMapping("api/chercheur/marche")
public class MarcheRestChercheur {

@Autowired
private MarcheChercheurService marcheService;

@Autowired
private MarcheConverter marcheConverter;


            @ApiOperation("Updates the specified  marche")
            @PutMapping("/")
            public  MarcheVo update(@RequestBody  MarcheVo  marcheVo){
            Marche marche = marcheConverter.toItem(marcheVo);
            marche = marcheService.update(marche);
            return marcheConverter.toVo(marche);
            }

    @ApiOperation("Finds a list of all marches")
    @GetMapping("/")
    public List<MarcheVo> findAll(){
        return marcheConverter.toVo(marcheService.findAll());
    }

    @ApiOperation("Finds a marche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MarcheVo findByIdWithAssociatedList(@PathVariable Long id){
    return marcheConverter.toVo(marcheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search marche by a specific criteria")
    @PostMapping("/search")
    public List<MarcheVo> findByCriteria(@RequestBody MarcheVo marcheVo){
        return marcheConverter.toVo(marcheService.findByCriteria(marcheVo));
        }

            @ApiOperation("Finds a marche by id")
            @GetMapping("/id/{id}")
            public MarcheVo findById(@PathVariable Long id){
            return marcheConverter.toVo(marcheService.findById(id));
            }

            @ApiOperation("Saves the specified  marche")
            @PostMapping("/")
            public MarcheVo save(@RequestBody MarcheVo marcheVo){
            Marche marche = marcheConverter.toItem(marcheVo);
            marche = marcheService.save(marche);
            return marcheConverter.toVo(marche);
            }

            @ApiOperation("Delete the specified marche")
            @DeleteMapping("/")
            public int delete(@RequestBody MarcheVo marcheVo){
            Marche marche = marcheConverter.toItem(marcheVo);
            return marcheService.delete(marche);
            }

            @ApiOperation("Deletes a marche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return marcheService.deleteById(id);
            }
        @ApiOperation("find by maitreOuvrage ice")
        @GetMapping("/maitreOuvrage/ice/{ice}")
        public List<Marche> findByMaitreOuvrageIce(@PathVariable String ice){
        return marcheService.findByMaitreOuvrageIce(ice);
        }

        @ApiOperation("delete by maitreOuvrage ice")
        @DeleteMapping("/maitreOuvrage/ice/{ice}")
        public int deleteByMaitreOuvrageIce(@PathVariable String ice){
        return marcheService.deleteByMaitreOuvrageIce(ice);
        }

        @ApiOperation("find by maitreOuvrage id")
        @GetMapping("/maitreOuvrage/id/{id}")
        public List<Marche> findByMaitreOuvrageId(@PathVariable Long id){
        return marcheService.findByMaitreOuvrageId(id);
        }

        @ApiOperation("delete by maitreOuvrage id")
        @DeleteMapping("/maitreOuvrage/id/{id}")
        public int deleteByMaitreOuvrageId(@PathVariable Long id){
        return marcheService.deleteByMaitreOuvrageId(id);
        }

        @ApiOperation("find by etatMarche id")
        @GetMapping("/etatMarche/id/{id}")
        public List<Marche> findByEtatMarcheId(@PathVariable Long id){
        return marcheService.findByEtatMarcheId(id);
        }

        @ApiOperation("delete by etatMarche id")
        @DeleteMapping("/etatMarche/id/{id}")
        public int deleteByEtatMarcheId(@PathVariable Long id){
        return marcheService.deleteByEtatMarcheId(id);
        }





            }
