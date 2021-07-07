package dio.DioTDDEstoqueCerveja.repository;

import dio.DioTDDEstoqueCerveja.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
