package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EmployeAdminService;

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
import com.ird.faa.bean.Employe;
import com.ird.faa.ws.rest.provided.converter.EmployeConverter;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;

@Api("Manages employe services")
@RestController
@RequestMapping("api/admin/employe")
public class EmployeRestAdmin {

@Autowired
private EmployeAdminService employeService;

@Autowired
private EmployeConverter employeConverter;


            @ApiOperation("Updates the specified  employe")
            @PutMapping("/")
            public  EmployeVo update(@RequestBody  EmployeVo  employeVo){
            Employe employe = employeConverter.toItem(employeVo);
            employe = employeService.update(employe);
            return employeConverter.toVo(employe);
            }

    @ApiOperation("Finds a list of all employes")
    @GetMapping("/")
    public List<EmployeVo> findAll(){
        return employeConverter.toVo(employeService.findAll());
    }

    @ApiOperation("Finds a employe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return employeConverter.toVo(employeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search employe by a specific criteria")
    @PostMapping("/search")
    public List<EmployeVo> findByCriteria(@RequestBody EmployeVo employeVo){
        return employeConverter.toVo(employeService.findByCriteria(employeVo));
        }

            @ApiOperation("Finds a employe by id")
            @GetMapping("/id/{id}")
            public EmployeVo findById(@PathVariable Long id){
            return employeConverter.toVo(employeService.findById(id));
            }

            @ApiOperation("Saves the specified  employe")
            @PostMapping("/")
            public EmployeVo save(@RequestBody EmployeVo employeVo){
            Employe employe = employeConverter.toItem(employeVo);
            employe = employeService.save(employe);
            return employeConverter.toVo(employe);
            }

            @ApiOperation("Delete the specified employe")
            @DeleteMapping("/")
            public int delete(@RequestBody EmployeVo employeVo){
            Employe employe = employeConverter.toItem(employeVo);
            return employeService.delete(employe);
            }

            @ApiOperation("Deletes a employe by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return employeService.deleteById(id);
            }
        @ApiOperation("find by categorieEmploye code")
        @GetMapping("/categorieEmploye/code/{code}")
        public List<Employe> findByCategorieEmployeCode(@PathVariable String code){
        return employeService.findByCategorieEmployeCode(code);
        }

        @ApiOperation("delete by categorieEmploye code")
        @DeleteMapping("/categorieEmploye/code/{code}")
        public int deleteByCategorieEmployeCode(@PathVariable String code){
        return employeService.deleteByCategorieEmployeCode(code);
        }

        @ApiOperation("find by categorieEmploye id")
        @GetMapping("/categorieEmploye/id/{id}")
        public List<Employe> findByCategorieEmployeId(@PathVariable Long id){
        return employeService.findByCategorieEmployeId(id);
        }

        @ApiOperation("delete by categorieEmploye id")
        @DeleteMapping("/categorieEmploye/id/{id}")
        public int deleteByCategorieEmployeId(@PathVariable Long id){
        return employeService.deleteByCategorieEmployeId(id);
        }





            }
