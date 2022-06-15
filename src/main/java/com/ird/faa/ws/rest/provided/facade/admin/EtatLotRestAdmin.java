package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EtatLotAdminService;

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
import com.ird.faa.bean.EtatLot;
import com.ird.faa.ws.rest.provided.converter.EtatLotConverter;
import com.ird.faa.ws.rest.provided.vo.EtatLotVo;

@Api("Manages etatLot services")
@RestController
@RequestMapping("api/admin/etatLot")
public class EtatLotRestAdmin {

@Autowired
private EtatLotAdminService etatLotService;

@Autowired
private EtatLotConverter etatLotConverter;


            @ApiOperation("Updates the specified  etatLot")
            @PutMapping("/")
            public  EtatLotVo update(@RequestBody  EtatLotVo  etatLotVo){
            EtatLot etatLot = etatLotConverter.toItem(etatLotVo);
            etatLot = etatLotService.update(etatLot);
            return etatLotConverter.toVo(etatLot);
            }

    @ApiOperation("Finds a list of all etatLots")
    @GetMapping("/")
    public List<EtatLotVo> findAll(){
        return etatLotConverter.toVo(etatLotService.findAll());
    }

    @ApiOperation("Finds a etatLot with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatLotVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatLotConverter.toVo(etatLotService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatLot by a specific criteria")
    @PostMapping("/search")
    public List<EtatLotVo> findByCriteria(@RequestBody EtatLotVo etatLotVo){
        return etatLotConverter.toVo(etatLotService.findByCriteria(etatLotVo));
        }

            @ApiOperation("Finds a etatLot by id")
            @GetMapping("/id/{id}")
            public EtatLotVo findById(@PathVariable Long id){
            return etatLotConverter.toVo(etatLotService.findById(id));
            }

            @ApiOperation("Saves the specified  etatLot")
            @PostMapping("/")
            public EtatLotVo save(@RequestBody EtatLotVo etatLotVo){
            EtatLot etatLot = etatLotConverter.toItem(etatLotVo);
            etatLot = etatLotService.save(etatLot);
            return etatLotConverter.toVo(etatLot);
            }

            @ApiOperation("Delete the specified etatLot")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatLotVo etatLotVo){
            EtatLot etatLot = etatLotConverter.toItem(etatLotVo);
            return etatLotService.delete(etatLot);
            }

            @ApiOperation("Deletes a etatLot by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatLotService.deleteById(id);
            }




            }
