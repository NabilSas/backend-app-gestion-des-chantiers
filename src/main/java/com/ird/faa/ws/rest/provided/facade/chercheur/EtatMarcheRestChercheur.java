package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatMarcheChercheurService;

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
import com.ird.faa.bean.EtatMarche;
import com.ird.faa.ws.rest.provided.converter.EtatMarcheConverter;
import com.ird.faa.ws.rest.provided.vo.EtatMarcheVo;

@Api("Manages etatMarche services")
@RestController
@RequestMapping("api/chercheur/etatMarche")
public class EtatMarcheRestChercheur {

@Autowired
private EtatMarcheChercheurService etatMarcheService;

@Autowired
private EtatMarcheConverter etatMarcheConverter;


            @ApiOperation("Updates the specified  etatMarche")
            @PutMapping("/")
            public  EtatMarcheVo update(@RequestBody  EtatMarcheVo  etatMarcheVo){
            EtatMarche etatMarche = etatMarcheConverter.toItem(etatMarcheVo);
            etatMarche = etatMarcheService.update(etatMarche);
            return etatMarcheConverter.toVo(etatMarche);
            }

    @ApiOperation("Finds a list of all etatMarches")
    @GetMapping("/")
    public List<EtatMarcheVo> findAll(){
        return etatMarcheConverter.toVo(etatMarcheService.findAll());
    }

    @ApiOperation("Finds a etatMarche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatMarcheVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatMarcheConverter.toVo(etatMarcheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatMarche by a specific criteria")
    @PostMapping("/search")
    public List<EtatMarcheVo> findByCriteria(@RequestBody EtatMarcheVo etatMarcheVo){
        return etatMarcheConverter.toVo(etatMarcheService.findByCriteria(etatMarcheVo));
        }

            @ApiOperation("Finds a etatMarche by id")
            @GetMapping("/id/{id}")
            public EtatMarcheVo findById(@PathVariable Long id){
            return etatMarcheConverter.toVo(etatMarcheService.findById(id));
            }

            @ApiOperation("Saves the specified  etatMarche")
            @PostMapping("/")
            public EtatMarcheVo save(@RequestBody EtatMarcheVo etatMarcheVo){
            EtatMarche etatMarche = etatMarcheConverter.toItem(etatMarcheVo);
            etatMarche = etatMarcheService.save(etatMarche);
            return etatMarcheConverter.toVo(etatMarche);
            }

            @ApiOperation("Delete the specified etatMarche")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatMarcheVo etatMarcheVo){
            EtatMarche etatMarche = etatMarcheConverter.toItem(etatMarcheVo);
            return etatMarcheService.delete(etatMarche);
            }

            @ApiOperation("Deletes a etatMarche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatMarcheService.deleteById(id);
            }




            }
