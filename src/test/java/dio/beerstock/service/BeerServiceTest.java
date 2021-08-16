package dio.beerstock.service;

import dio.beerstock.builder.BeerDTOBuilder;
import dio.beerstock.dto.BeerDTO;
import dio.beerstock.entity.Beer;
import dio.beerstock.exception.BeerAlreadyRegisteredException;
import dio.beerstock.mapper.BeerMapper;
import dio.beerstock.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BeerServiceTest {

    private static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void createBeer() throws BeerAlreadyRegisteredException {
        BeerDTO beerDTO =  BeerDTOBuilder.builder().build().toBeerDTO();
        Beer beerSaved = beerMapper.toModel(beerDTO);

        Mockito.when(beerRepository.findByName(beerDTO.getName())).thenReturn(Optional.empty());
        Mockito.when(beerRepository.save(beerSaved)).thenReturn(beerSaved);

        BeerDTO beerDTOCreate = beerService.createBeer(beerDTO);

        assertEquals(beerDTO.getId(), beerDTOCreate.getId());
        assertEquals(beerDTO.getName(), beerDTOCreate.getName());


    }

    @Test
    void findByName() {
    }

    @Test
    void listAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void increment() {
    }
}