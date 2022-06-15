package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.CategorieEmployeMaitreouvrageService;

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
import com.ird.faa.bean.CategorieEmploye;
import com.ird.faa.ws.rest.provided.converter.CategorieEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.CategorieEmployeVo;

@Api("Manages categorieEmploye services")
@RestController
@RequestMapping("api/maitreouvrage/categorieEmploye")
public class CategorieEmployeRestMaitreouvrage {

@Autowired
private CategorieEmployeMaitreouvrageService categorieEmployeService;

@Autowired
private CategorieEmployeConverter categorieEmployeConverter;


            @ApiOperation("Updates the specified  categorieEmploye")
            @PutMapping("/")
            public  CategorieEmployeVo update(@RequestBody  CategorieEmployeVo  categorieEmployeVo){
            CategorieEmploye categorieEmploye = categorieEmployeConverter.toItem(categorieEmployeVo);
            categorieEmploye = categorieEmployeService.update(categorieEmploye);
            return categorieEmployeConverter.toVo(categorieEmploye);
            }

    @ApiOperation("Finds a list of all categorieEmployes")
    @GetMapping("/")
    public List<CategorieEmployeVo> findAll(){
        return categorieEmployeConverter.toVo(categorieEmployeService.findAll());
    }

    @ApiOperation("Finds a categorieEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategorieEmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return categorieEmployeConverter.toVo(categorieEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categorieEmploye by a specific criteria")
    @PostMapping("/search")
    public List<CategorieEmployeVo> findByCriteria(@RequestBody CategorieEmployeVo categorieEmployeVo){
        return categorieEmployeConverter.toVo(categorieEmployeService.findByCriteria(categorieEmployeVo));
        }

            @ApiOperation("Finds a categorieEmploye by id")
            @GetMapping("/id/{id}")
            public CategorieEmployeVo findById(@PathVariable Long id){
            return categorieEmployeConverter.toVo(categorieEmployeService.findById(id));
            }

            @ApiOperation("Saves the specified  categorieEmploye")
            @PostMapping("/")
            public CategorieEmployeVo save(@RequestBody CategorieEmployeVo categorieEmployeVo){
            CategorieEmploye categorieEmploye = categorieEmployeConverter.toItem(categorieEmployeVo);
            categorieEmploye = categorieEmployeService.save(categorieEmploye);
            return categorieEmployeConverter.toVo(categorieEmploye);
            }

            @ApiOperation("Delete the specified categorieEmploye")
            @DeleteMapping("/")
            public int delete(@RequestBody CategorieEmployeVo categorieEmployeVo){
            CategorieEmploye categorieEmploye = categorieEmployeConverter.toItem(categorieEmployeVo);
            return categorieEmployeService.delete(categorieEmploye);
            }

            @ApiOperation("Deletes a categorieEmploye by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return categorieEmployeService.deleteById(id);
            }




            }
