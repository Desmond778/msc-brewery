package des.cloud.mscbrewery.services;

import des.cloud.mscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Lion Larger")
                .beerStyle("Sri Lankan")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // TODO add real implementation
    }

    @Override
    public void deleteBeer(UUID beerId) {
      log.debug("Delete beer object here...");
    }
}
