package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.SousClasseComptableAdminService;

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
import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.ws.rest.provided.converter.SousClasseComptableConverter;
import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;

@Api("Manages sousClasseComptable services")
@RestController
@RequestMapping("api/admin/sousClasseComptable")
public class SousClasseComptableRestAdmin {

@Autowired
private SousClasseComptableAdminService sousClasseComptableService;

@Autowired
private SousClasseComptableConverter sousClasseComptableConverter;


            @ApiOperation("Updates the specified  sousClasseComptable")
            @PutMapping("/")
            public  SousClasseComptableVo update(@RequestBody  SousClasseComptableVo  sousClasseComptableVo){
            SousClasseComptable sousClasseComptable = sousClasseComptableConverter.toItem(sousClasseComptableVo);
            sousClasseComptable = sousClasseComptableService.update(sousClasseComptable);
            return sousClasseComptableConverter.toVo(sousClasseComptable);
            }

    @ApiOperation("Finds a list of all sousClasseComptables")
    @GetMapping("/")
    public List<SousClasseComptableVo> findAll(){
        return sousClasseComptableConverter.toVo(sousClasseComptableService.findAll());
    }

    @ApiOperation("Finds a sousClasseComptable with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public SousClasseComptableVo findByIdWithAssociatedList(@PathVariable Long id){
    return sousClasseComptableConverter.toVo(sousClasseComptableService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search sousClasseComptable by a specific criteria")
    @PostMapping("/search")
    public List<SousClasseComptableVo> findByCriteria(@RequestBody SousClasseComptableVo sousClasseComptableVo){
        return sousClasseComptableConverter.toVo(sousClasseComptableService.findByCriteria(sousClasseComptableVo));
        }

            @ApiOperation("Finds a sousClasseComptable by id")
            @GetMapping("/id/{id}")
            public SousClasseComptableVo findById(@PathVariable Long id){
            return sousClasseComptableConverter.toVo(sousClasseComptableService.findById(id));
            }

            @ApiOperation("Saves the specified  sousClasseComptable")
            @PostMapping("/")
            public SousClasseComptableVo save(@RequestBody SousClasseComptableVo sousClasseComptableVo){
            SousClasseComptable sousClasseComptable = sousClasseComptableConverter.toItem(sousClasseComptableVo);
            sousClasseComptable = sousClasseComptableService.save(sousClasseComptable);
            return sousClasseComptableConverter.toVo(sousClasseComptable);
            }

            @ApiOperation("Delete the specified sousClasseComptable")
            @DeleteMapping("/")
            public int delete(@RequestBody SousClasseComptableVo sousClasseComptableVo){
            SousClasseComptable sousClasseComptable = sousClasseComptableConverter.toItem(sousClasseComptableVo);
            return sousClasseComptableService.delete(sousClasseComptable);
            }

            @ApiOperation("Deletes a sousClasseComptable by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return sousClasseComptableService.deleteById(id);
            }
        @ApiOperation("find by classeComptable id")
        @GetMapping("/classeComptable/id/{id}")
        public List<SousClasseComptable> findByClasseComptableId(@PathVariable Long id){
        return sousClasseComptableService.findByClasseComptableId(id);
        }

        @ApiOperation("delete by classeComptable id")
        @DeleteMapping("/classeComptable/id/{id}")
        public int deleteByClasseComptableId(@PathVariable Long id){
        return sousClasseComptableService.deleteByClasseComptableId(id);
        }





            }
