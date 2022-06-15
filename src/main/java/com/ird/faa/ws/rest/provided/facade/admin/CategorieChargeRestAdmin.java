package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.CategorieChargeAdminService;

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
import com.ird.faa.bean.CategorieCharge;
import com.ird.faa.ws.rest.provided.converter.CategorieChargeConverter;
import com.ird.faa.ws.rest.provided.vo.CategorieChargeVo;

@Api("Manages categorieCharge services")
@RestController
@RequestMapping("api/admin/categorieCharge")
public class CategorieChargeRestAdmin {

@Autowired
private CategorieChargeAdminService categorieChargeService;

@Autowired
private CategorieChargeConverter categorieChargeConverter;


            @ApiOperation("Updates the specified  categorieCharge")
            @PutMapping("/")
            public  CategorieChargeVo update(@RequestBody  CategorieChargeVo  categorieChargeVo){
            CategorieCharge categorieCharge = categorieChargeConverter.toItem(categorieChargeVo);
            categorieCharge = categorieChargeService.update(categorieCharge);
            return categorieChargeConverter.toVo(categorieCharge);
            }

    @ApiOperation("Finds a list of all categorieCharges")
    @GetMapping("/")
    public List<CategorieChargeVo> findAll(){
        return categorieChargeConverter.toVo(categorieChargeService.findAll());
    }

    @ApiOperation("Finds a categorieCharge with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategorieChargeVo findByIdWithAssociatedList(@PathVariable Long id){
    return categorieChargeConverter.toVo(categorieChargeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categorieCharge by a specific criteria")
    @PostMapping("/search")
    public List<CategorieChargeVo> findByCriteria(@RequestBody CategorieChargeVo categorieChargeVo){
        return categorieChargeConverter.toVo(categorieChargeService.findByCriteria(categorieChargeVo));
        }

            @ApiOperation("Finds a categorieCharge by id")
            @GetMapping("/id/{id}")
            public CategorieChargeVo findById(@PathVariable Long id){
            return categorieChargeConverter.toVo(categorieChargeService.findById(id));
            }

            @ApiOperation("Saves the specified  categorieCharge")
            @PostMapping("/")
            public CategorieChargeVo save(@RequestBody CategorieChargeVo categorieChargeVo){
            CategorieCharge categorieCharge = categorieChargeConverter.toItem(categorieChargeVo);
            categorieCharge = categorieChargeService.save(categorieCharge);
            return categorieChargeConverter.toVo(categorieCharge);
            }

            @ApiOperation("Delete the specified categorieCharge")
            @DeleteMapping("/")
            public int delete(@RequestBody CategorieChargeVo categorieChargeVo){
            CategorieCharge categorieCharge = categorieChargeConverter.toItem(categorieChargeVo);
            return categorieChargeService.delete(categorieCharge);
            }

            @ApiOperation("Deletes a categorieCharge by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return categorieChargeService.deleteById(id);
            }




            @PutMapping("/archiver/")
            public CategorieChargeVo archiver(@RequestBody CategorieChargeVo categorieChargeVo){
                CategorieCharge categorieCharge = categorieChargeService.archiver(categorieChargeConverter.toItem(categorieChargeVo));
                return categorieChargeConverter.toVo(categorieCharge);
                }

            @PutMapping("/desarchiver/")
            public CategorieChargeVo desarchiver(@RequestBody CategorieChargeVo categorieChargeVo){
                CategorieCharge categorieCharge = categorieChargeService.desarchiver(categorieChargeConverter.toItem(categorieChargeVo));
                return categorieChargeConverter.toVo(categorieCharge);}
            }
