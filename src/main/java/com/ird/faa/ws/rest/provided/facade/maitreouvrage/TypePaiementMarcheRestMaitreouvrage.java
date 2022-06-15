package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.TypePaiementMarcheMaitreouvrageService;

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
import com.ird.faa.bean.TypePaiementMarche;
import com.ird.faa.ws.rest.provided.converter.TypePaiementMarcheConverter;
import com.ird.faa.ws.rest.provided.vo.TypePaiementMarcheVo;

@Api("Manages typePaiementMarche services")
@RestController
@RequestMapping("api/maitreouvrage/typePaiementMarche")
public class TypePaiementMarcheRestMaitreouvrage {

@Autowired
private TypePaiementMarcheMaitreouvrageService typePaiementMarcheService;

@Autowired
private TypePaiementMarcheConverter typePaiementMarcheConverter;


            @ApiOperation("Updates the specified  typePaiementMarche")
            @PutMapping("/")
            public  TypePaiementMarcheVo update(@RequestBody  TypePaiementMarcheVo  typePaiementMarcheVo){
            TypePaiementMarche typePaiementMarche = typePaiementMarcheConverter.toItem(typePaiementMarcheVo);
            typePaiementMarche = typePaiementMarcheService.update(typePaiementMarche);
            return typePaiementMarcheConverter.toVo(typePaiementMarche);
            }

    @ApiOperation("Finds a list of all typePaiementMarches")
    @GetMapping("/")
    public List<TypePaiementMarcheVo> findAll(){
        return typePaiementMarcheConverter.toVo(typePaiementMarcheService.findAll());
    }

    @ApiOperation("Finds a typePaiementMarche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypePaiementMarcheVo findByIdWithAssociatedList(@PathVariable Long id){
    return typePaiementMarcheConverter.toVo(typePaiementMarcheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typePaiementMarche by a specific criteria")
    @PostMapping("/search")
    public List<TypePaiementMarcheVo> findByCriteria(@RequestBody TypePaiementMarcheVo typePaiementMarcheVo){
        return typePaiementMarcheConverter.toVo(typePaiementMarcheService.findByCriteria(typePaiementMarcheVo));
        }

            @ApiOperation("Finds a typePaiementMarche by id")
            @GetMapping("/id/{id}")
            public TypePaiementMarcheVo findById(@PathVariable Long id){
            return typePaiementMarcheConverter.toVo(typePaiementMarcheService.findById(id));
            }

            @ApiOperation("Saves the specified  typePaiementMarche")
            @PostMapping("/")
            public TypePaiementMarcheVo save(@RequestBody TypePaiementMarcheVo typePaiementMarcheVo){
            TypePaiementMarche typePaiementMarche = typePaiementMarcheConverter.toItem(typePaiementMarcheVo);
            typePaiementMarche = typePaiementMarcheService.save(typePaiementMarche);
            return typePaiementMarcheConverter.toVo(typePaiementMarche);
            }

            @ApiOperation("Delete the specified typePaiementMarche")
            @DeleteMapping("/")
            public int delete(@RequestBody TypePaiementMarcheVo typePaiementMarcheVo){
            TypePaiementMarche typePaiementMarche = typePaiementMarcheConverter.toItem(typePaiementMarcheVo);
            return typePaiementMarcheService.delete(typePaiementMarche);
            }

            @ApiOperation("Deletes a typePaiementMarche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typePaiementMarcheService.deleteById(id);
            }




            }
