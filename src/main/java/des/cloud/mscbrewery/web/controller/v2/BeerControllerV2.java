package des.cloud.mscbrewery.web.controller.v2;


import des.cloud.mscbrewery.services.v2.BeerServiceV2;
import des.cloud.mscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto) {
        System.out.println("BeerDTO : " + beerDto);
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname to URL
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDtoV2 beerDto) {

        System.out.println("BeerDTO : " + beerDto);
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }

}
