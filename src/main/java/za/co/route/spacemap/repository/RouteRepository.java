package za.co.route.spacemap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.route.spacemap.models.PlanetRoute;

@Repository
public interface RouteRepository extends JpaRepository<PlanetRoute, Integer> {

}
