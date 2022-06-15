package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PaiementMarcheAdminService;

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
import com.ird.faa.bean.PaiementMarche;
import com.ird.faa.ws.rest.provided.converter.PaiementMarcheConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementMarcheVo;

@Api("Manages paiementMarche services")
@RestController
@RequestMapping("api/admin/paiementMarche")
public class PaiementMarcheRestAdmin {

@Autowired
private PaiementMarcheAdminService paiementMarcheService;

@Autowired
private PaiementMarcheConverter paiementMarcheConverter;


            @ApiOperation("Updates the specified  paiementMarche")
            @PutMapping("/")
            public  PaiementMarcheVo update(@RequestBody  PaiementMarcheVo  paiementMarcheVo){
            PaiementMarche paiementMarche = paiementMarcheConverter.toItem(paiementMarcheVo);
            paiementMarche = paiementMarcheService.update(paiementMarche);
            return paiementMarcheConverter.toVo(paiementMarche);
            }

    @ApiOperation("Finds a list of all paiementMarches")
    @GetMapping("/")
    public List<PaiementMarcheVo> findAll(){
        return paiementMarcheConverter.toVo(paiementMarcheService.findAll());
    }

    @ApiOperation("Finds a paiementMarche with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementMarcheVo findByIdWithAssociatedList(@PathVariable Long id){
    return paiementMarcheConverter.toVo(paiementMarcheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiementMarche by a specific criteria")
    @PostMapping("/search")
    public List<PaiementMarcheVo> findByCriteria(@RequestBody PaiementMarcheVo paiementMarcheVo){
        return paiementMarcheConverter.toVo(paiementMarcheService.findByCriteria(paiementMarcheVo));
        }

            @ApiOperation("Finds a paiementMarche by id")
            @GetMapping("/id/{id}")
            public PaiementMarcheVo findById(@PathVariable Long id){
            return paiementMarcheConverter.toVo(paiementMarcheService.findById(id));
            }

            @ApiOperation("Saves the specified  paiementMarche")
            @PostMapping("/")
            public PaiementMarcheVo save(@RequestBody PaiementMarcheVo paiementMarcheVo){
            PaiementMarche paiementMarche = paiementMarcheConverter.toItem(paiementMarcheVo);
            paiementMarche = paiementMarcheService.save(paiementMarche);
            return paiementMarcheConverter.toVo(paiementMarche);
            }

            @ApiOperation("Delete the specified paiementMarche")
            @DeleteMapping("/")
            public int delete(@RequestBody PaiementMarcheVo paiementMarcheVo){
            PaiementMarche paiementMarche = paiementMarcheConverter.toItem(paiementMarcheVo);
            return paiementMarcheService.delete(paiementMarche);
            }

            @ApiOperation("Deletes a paiementMarche by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paiementMarcheService.deleteById(id);
            }
        @ApiOperation("find by typePaiementMarche id")
        @GetMapping("/typePaiementMarche/id/{id}")
        public List<PaiementMarche> findByTypePaiementMarcheId(@PathVariable Long id){
        return paiementMarcheService.findByTypePaiementMarcheId(id);
        }

        @ApiOperation("delete by typePaiementMarche id")
        @DeleteMapping("/typePaiementMarche/id/{id}")
        public int deleteByTypePaiementMarcheId(@PathVariable Long id){
        return paiementMarcheService.deleteByTypePaiementMarcheId(id);
        }

        @ApiOperation("find by marche code")
        @GetMapping("/marche/code/{code}")
        public List<PaiementMarche> findByMarcheCode(@PathVariable Long code){
        return paiementMarcheService.findByMarcheCode(code);
        }

        @ApiOperation("delete by marche code")
        @DeleteMapping("/marche/code/{code}")
        public int deleteByMarcheCode(@PathVariable Long code){
        return paiementMarcheService.deleteByMarcheCode(code);
        }

        @ApiOperation("find by marche id")
        @GetMapping("/marche/id/{id}")
        public List<PaiementMarche> findByMarcheId(@PathVariable Long id){
        return paiementMarcheService.findByMarcheId(id);
        }

        @ApiOperation("delete by marche id")
        @DeleteMapping("/marche/id/{id}")
        public int deleteByMarcheId(@PathVariable Long id){
        return paiementMarcheService.deleteByMarcheId(id);
        }





            }
