package credit.controller;

import credit.Paths;
import credit.core.service.PoolService;
import credit.model.PoolDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = Paths.POOL,
                produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "Pool endpoints",
     tags = "Pool")
public class PoolController extends AbstractRestController {

    private PoolService poolService;

    public PoolController(PoolService poolService) {
        this.poolService = poolService;
    }

    @ApiOperation(value = "getPool")
    @RequestMapping(value = "/{prefix}/{id}",
                    method = RequestMethod.GET)
    public ResponseEntity<PoolDto> getPool(
            @PathVariable("prefix")
            final String prefix,
            @PathVariable("id")
            final Long id) {

        PoolDto poolDto = poolService.getPool(prefix, id);

        if (poolDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(poolDto);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoolDto> createPool(
            @Valid
            @RequestBody
            final PoolDto poolDto) {
        PoolDto savedPoolDto = poolService.createPool(poolDto);
        return ResponseEntity.ok(savedPoolDto);
    }
}
