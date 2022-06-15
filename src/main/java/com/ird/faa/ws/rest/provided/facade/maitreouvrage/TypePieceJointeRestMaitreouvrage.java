package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.TypePieceJointeMaitreouvrageService;

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
import com.ird.faa.bean.TypePieceJointe;
import com.ird.faa.ws.rest.provided.converter.TypePieceJointeConverter;
import com.ird.faa.ws.rest.provided.vo.TypePieceJointeVo;

@Api("Manages typePieceJointe services")
@RestController
@RequestMapping("api/maitreouvrage/typePieceJointe")
public class TypePieceJointeRestMaitreouvrage {

@Autowired
private TypePieceJointeMaitreouvrageService typePieceJointeService;

@Autowired
private TypePieceJointeConverter typePieceJointeConverter;


            @ApiOperation("Updates the specified  typePieceJointe")
            @PutMapping("/")
            public  TypePieceJointeVo update(@RequestBody  TypePieceJointeVo  typePieceJointeVo){
            TypePieceJointe typePieceJointe = typePieceJointeConverter.toItem(typePieceJointeVo);
            typePieceJointe = typePieceJointeService.update(typePieceJointe);
            return typePieceJointeConverter.toVo(typePieceJointe);
            }

    @ApiOperation("Finds a list of all typePieceJointes")
    @GetMapping("/")
    public List<TypePieceJointeVo> findAll(){
        return typePieceJointeConverter.toVo(typePieceJointeService.findAll());
    }

    @ApiOperation("Finds a typePieceJointe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypePieceJointeVo findByIdWithAssociatedList(@PathVariable Long id){
    return typePieceJointeConverter.toVo(typePieceJointeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typePieceJointe by a specific criteria")
    @PostMapping("/search")
    public List<TypePieceJointeVo> findByCriteria(@RequestBody TypePieceJointeVo typePieceJointeVo){
        return typePieceJointeConverter.toVo(typePieceJointeService.findByCriteria(typePieceJointeVo));
        }

            @ApiOperation("Finds a typePieceJointe by id")
            @GetMapping("/id/{id}")
            public TypePieceJointeVo findById(@PathVariable Long id){
            return typePieceJointeConverter.toVo(typePieceJointeService.findById(id));
            }

            @ApiOperation("Saves the specified  typePieceJointe")
            @PostMapping("/")
            public TypePieceJointeVo save(@RequestBody TypePieceJointeVo typePieceJointeVo){
            TypePieceJointe typePieceJointe = typePieceJointeConverter.toItem(typePieceJointeVo);
            typePieceJointe = typePieceJointeService.save(typePieceJointe);
            return typePieceJointeConverter.toVo(typePieceJointe);
            }

            @ApiOperation("Delete the specified typePieceJointe")
            @DeleteMapping("/")
            public int delete(@RequestBody TypePieceJointeVo typePieceJointeVo){
            TypePieceJointe typePieceJointe = typePieceJointeConverter.toItem(typePieceJointeVo);
            return typePieceJointeService.delete(typePieceJointe);
            }

            @ApiOperation("Deletes a typePieceJointe by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typePieceJointeService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public TypePieceJointeVo archiver(@RequestBody TypePieceJointeVo typePieceJointeVo){
                TypePieceJointe typePieceJointe = typePieceJointeService.archiver(typePieceJointeConverter.toItem(typePieceJointeVo));
                return typePieceJointeConverter.toVo(typePieceJointe);
                }

            @PutMapping("/desarchiver/")
            public TypePieceJointeVo desarchiver(@RequestBody TypePieceJointeVo typePieceJointeVo){
                TypePieceJointe typePieceJointe = typePieceJointeService.desarchiver(typePieceJointeConverter.toItem(typePieceJointeVo));
                return typePieceJointeConverter.toVo(typePieceJointe);}
            }
