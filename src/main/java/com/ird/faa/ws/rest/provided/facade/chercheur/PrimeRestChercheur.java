package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PrimeChercheurService;

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
import com.ird.faa.bean.Prime;
import com.ird.faa.ws.rest.provided.converter.PrimeConverter;
import com.ird.faa.ws.rest.provided.vo.PrimeVo;

@Api("Manages prime services")
@RestController
@RequestMapping("api/chercheur/prime")
public class PrimeRestChercheur {

@Autowired
private PrimeChercheurService primeService;

@Autowired
private PrimeConverter primeConverter;


            @ApiOperation("Updates the specified  prime")
            @PutMapping("/")
            public  PrimeVo update(@RequestBody  PrimeVo  primeVo){
            Prime prime = primeConverter.toItem(primeVo);
            prime = primeService.update(prime);
            return primeConverter.toVo(prime);
            }

    @ApiOperation("Finds a list of all primes")
    @GetMapping("/")
    public List<PrimeVo> findAll(){
        return primeConverter.toVo(primeService.findAll());
    }

    @ApiOperation("Finds a prime with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PrimeVo findByIdWithAssociatedList(@PathVariable Long id){
    return primeConverter.toVo(primeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search prime by a specific criteria")
    @PostMapping("/search")
    public List<PrimeVo> findByCriteria(@RequestBody PrimeVo primeVo){
        return primeConverter.toVo(primeService.findByCriteria(primeVo));
        }

            @ApiOperation("Finds a prime by id")
            @GetMapping("/id/{id}")
            public PrimeVo findById(@PathVariable Long id){
            return primeConverter.toVo(primeService.findById(id));
            }

            @ApiOperation("Saves the specified  prime")
            @PostMapping("/")
            public PrimeVo save(@RequestBody PrimeVo primeVo){
            Prime prime = primeConverter.toItem(primeVo);
            prime = primeService.save(prime);
            return primeConverter.toVo(prime);
            }

            @ApiOperation("Delete the specified prime")
            @DeleteMapping("/")
            public int delete(@RequestBody PrimeVo primeVo){
            Prime prime = primeConverter.toItem(primeVo);
            return primeService.delete(prime);
            }

            @ApiOperation("Deletes a prime by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return primeService.deleteById(id);
            }
        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<Prime> findByEmployeId(@PathVariable Long id){
        return primeService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return primeService.deleteByEmployeId(id);
        }

        @ApiOperation("find by lot id")
        @GetMapping("/lot/id/{id}")
        public List<Prime> findByLotId(@PathVariable Long id){
        return primeService.findByLotId(id);
        }

        @ApiOperation("delete by lot id")
        @DeleteMapping("/lot/id/{id}")
        public int deleteByLotId(@PathVariable Long id){
        return primeService.deleteByLotId(id);
        }





            }
