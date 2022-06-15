package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TypePaiementLotChercheurService;

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
import com.ird.faa.bean.TypePaiementLot;
import com.ird.faa.ws.rest.provided.converter.TypePaiementLotConverter;
import com.ird.faa.ws.rest.provided.vo.TypePaiementLotVo;

@Api("Manages typePaiementLot services")
@RestController
@RequestMapping("api/chercheur/typePaiementLot")
public class TypePaiementLotRestChercheur {

@Autowired
private TypePaiementLotChercheurService typePaiementLotService;

@Autowired
private TypePaiementLotConverter typePaiementLotConverter;


            @ApiOperation("Updates the specified  typePaiementLot")
            @PutMapping("/")
            public  TypePaiementLotVo update(@RequestBody  TypePaiementLotVo  typePaiementLotVo){
            TypePaiementLot typePaiementLot = typePaiementLotConverter.toItem(typePaiementLotVo);
            typePaiementLot = typePaiementLotService.update(typePaiementLot);
            return typePaiementLotConverter.toVo(typePaiementLot);
            }

    @ApiOperation("Finds a list of all typePaiementLots")
    @GetMapping("/")
    public List<TypePaiementLotVo> findAll(){
        return typePaiementLotConverter.toVo(typePaiementLotService.findAll());
    }

    @ApiOperation("Finds a typePaiementLot with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypePaiementLotVo findByIdWithAssociatedList(@PathVariable Long id){
    return typePaiementLotConverter.toVo(typePaiementLotService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typePaiementLot by a specific criteria")
    @PostMapping("/search")
    public List<TypePaiementLotVo> findByCriteria(@RequestBody TypePaiementLotVo typePaiementLotVo){
        return typePaiementLotConverter.toVo(typePaiementLotService.findByCriteria(typePaiementLotVo));
        }

            @ApiOperation("Finds a typePaiementLot by id")
            @GetMapping("/id/{id}")
            public TypePaiementLotVo findById(@PathVariable Long id){
            return typePaiementLotConverter.toVo(typePaiementLotService.findById(id));
            }

            @ApiOperation("Saves the specified  typePaiementLot")
            @PostMapping("/")
            public TypePaiementLotVo save(@RequestBody TypePaiementLotVo typePaiementLotVo){
            TypePaiementLot typePaiementLot = typePaiementLotConverter.toItem(typePaiementLotVo);
            typePaiementLot = typePaiementLotService.save(typePaiementLot);
            return typePaiementLotConverter.toVo(typePaiementLot);
            }

            @ApiOperation("Delete the specified typePaiementLot")
            @DeleteMapping("/")
            public int delete(@RequestBody TypePaiementLotVo typePaiementLotVo){
            TypePaiementLot typePaiementLot = typePaiementLotConverter.toItem(typePaiementLotVo);
            return typePaiementLotService.delete(typePaiementLot);
            }

            @ApiOperation("Deletes a typePaiementLot by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typePaiementLotService.deleteById(id);
            }




            }
