package  com.ird.faa.ws.rest.provided.facade.maitreouvrage;

import com.ird.faa.service.maitreouvrage.facade.MaitreOuvrageMaitreouvrageService;

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
import com.ird.faa.bean.MaitreOuvrage;
import com.ird.faa.ws.rest.provided.converter.MaitreOuvrageConverter;
import com.ird.faa.ws.rest.provided.vo.MaitreOuvrageVo;

@Api("Manages maitreOuvrage services")
@RestController
@RequestMapping("api/maitreouvrage/maitreOuvrage")
public class MaitreOuvrageRestMaitreouvrage {

@Autowired
private MaitreOuvrageMaitreouvrageService maitreOuvrageService;

@Autowired
private MaitreOuvrageConverter maitreOuvrageConverter;


            @ApiOperation("Updates the specified  maitreOuvrage")
            @PutMapping("/")
            public  MaitreOuvrageVo update(@RequestBody  MaitreOuvrageVo  maitreOuvrageVo){
            MaitreOuvrage maitreOuvrage = maitreOuvrageConverter.toItem(maitreOuvrageVo);
            maitreOuvrage = maitreOuvrageService.update(maitreOuvrage);
            return maitreOuvrageConverter.toVo(maitreOuvrage);
            }

    @ApiOperation("Finds a list of all maitreOuvrages")
    @GetMapping("/")
    public List<MaitreOuvrageVo> findAll(){
        return maitreOuvrageConverter.toVo(maitreOuvrageService.findAll());
    }

    @ApiOperation("Finds a maitreOuvrage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MaitreOuvrageVo findByIdWithAssociatedList(@PathVariable Long id){
    return maitreOuvrageConverter.toVo(maitreOuvrageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search maitreOuvrage by a specific criteria")
    @PostMapping("/search")
    public List<MaitreOuvrageVo> findByCriteria(@RequestBody MaitreOuvrageVo maitreOuvrageVo){
        return maitreOuvrageConverter.toVo(maitreOuvrageService.findByCriteria(maitreOuvrageVo));
        }

            @ApiOperation("Finds a maitreOuvrage by id")
            @GetMapping("/id/{id}")
            public MaitreOuvrageVo findById(@PathVariable Long id){
            return maitreOuvrageConverter.toVo(maitreOuvrageService.findById(id));
            }

            @ApiOperation("Saves the specified  maitreOuvrage")
            @PostMapping("/")
            public MaitreOuvrageVo save(@RequestBody MaitreOuvrageVo maitreOuvrageVo){
            MaitreOuvrage maitreOuvrage = maitreOuvrageConverter.toItem(maitreOuvrageVo);
            maitreOuvrage = maitreOuvrageService.save(maitreOuvrage);
            return maitreOuvrageConverter.toVo(maitreOuvrage);
            }

            @ApiOperation("Delete the specified maitreOuvrage")
            @DeleteMapping("/")
            public int delete(@RequestBody MaitreOuvrageVo maitreOuvrageVo){
            MaitreOuvrage maitreOuvrage = maitreOuvrageConverter.toItem(maitreOuvrageVo);
            return maitreOuvrageService.delete(maitreOuvrage);
            }

            @ApiOperation("Deletes a maitreOuvrage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return maitreOuvrageService.deleteById(id);
            }




            }
