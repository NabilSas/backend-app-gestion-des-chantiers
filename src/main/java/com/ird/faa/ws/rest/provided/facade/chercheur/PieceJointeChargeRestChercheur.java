package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PieceJointeChargeChercheurService;

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
import com.ird.faa.bean.PieceJointeCharge;
import com.ird.faa.ws.rest.provided.converter.PieceJointeChargeConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeChargeVo;

@Api("Manages pieceJointeCharge services")
@RestController
@RequestMapping("api/chercheur/pieceJointeCharge")
public class PieceJointeChargeRestChercheur {

@Autowired
private PieceJointeChargeChercheurService pieceJointeChargeService;

@Autowired
private PieceJointeChargeConverter pieceJointeChargeConverter;


            @ApiOperation("Updates the specified  pieceJointeCharge")
            @PutMapping("/")
            public  PieceJointeChargeVo update(@RequestBody  PieceJointeChargeVo  pieceJointeChargeVo){
            PieceJointeCharge pieceJointeCharge = pieceJointeChargeConverter.toItem(pieceJointeChargeVo);
            pieceJointeCharge = pieceJointeChargeService.update(pieceJointeCharge);
            return pieceJointeChargeConverter.toVo(pieceJointeCharge);
            }

    @ApiOperation("Finds a list of all pieceJointeCharges")
    @GetMapping("/")
    public List<PieceJointeChargeVo> findAll(){
        return pieceJointeChargeConverter.toVo(pieceJointeChargeService.findAll());
    }

    @ApiOperation("Finds a pieceJointeCharge with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeChargeVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeChargeConverter.toVo(pieceJointeChargeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeCharge by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeChargeVo> findByCriteria(@RequestBody PieceJointeChargeVo pieceJointeChargeVo){
        return pieceJointeChargeConverter.toVo(pieceJointeChargeService.findByCriteria(pieceJointeChargeVo));
        }

            @ApiOperation("Finds a pieceJointeCharge by id")
            @GetMapping("/id/{id}")
            public PieceJointeChargeVo findById(@PathVariable Long id){
            return pieceJointeChargeConverter.toVo(pieceJointeChargeService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeCharge")
            @PostMapping("/")
            public PieceJointeChargeVo save(@RequestBody PieceJointeChargeVo pieceJointeChargeVo){
            PieceJointeCharge pieceJointeCharge = pieceJointeChargeConverter.toItem(pieceJointeChargeVo);
            pieceJointeCharge = pieceJointeChargeService.save(pieceJointeCharge);
            return pieceJointeChargeConverter.toVo(pieceJointeCharge);
            }

            @ApiOperation("Delete the specified pieceJointeCharge")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeChargeVo pieceJointeChargeVo){
            PieceJointeCharge pieceJointeCharge = pieceJointeChargeConverter.toItem(pieceJointeChargeVo);
            return pieceJointeChargeService.delete(pieceJointeCharge);
            }

            @ApiOperation("Deletes a pieceJointeCharge by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeChargeService.deleteById(id);
            }
        @ApiOperation("find by charge id")
        @GetMapping("/charge/id/{id}")
        public List<PieceJointeCharge> findByChargeId(@PathVariable Long id){
        return pieceJointeChargeService.findByChargeId(id);
        }

        @ApiOperation("delete by charge id")
        @DeleteMapping("/charge/id/{id}")
        public int deleteByChargeId(@PathVariable Long id){
        return pieceJointeChargeService.deleteByChargeId(id);
        }





            }
