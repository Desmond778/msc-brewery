package des.cloud.mscbrewery.services.v2;

import des.cloud.mscbrewery.services.BeerService;
import des.cloud.mscbrewery.web.model.BeerDto;
import des.cloud.mscbrewery.web.model.v2.BeerDtoV2;
import des.cloud.mscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Another Beer")
                .beerStyle(BeerStyleEnum.CARLSBERG)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {

        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        // TODO add real implementation
    }

    @Override
    public void deleteBeer(UUID beerId) {
      log.debug("Delete beer object here...");
    }
}
