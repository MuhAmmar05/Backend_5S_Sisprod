package id.ac.astra.polytechnic.backend_5s_sisprod.repository;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Departemen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartemenRepository extends JpaRepository<Departemen, Integer> {

}
