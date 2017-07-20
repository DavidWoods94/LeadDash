package leadDash.leadrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leadDash.model.Lead;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Integer> {

}
