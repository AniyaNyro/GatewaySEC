package org.launchcode.GatewaySEC.models.data;


import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.TeamM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TeamDao extends CrudRepository<TeamM, Integer> {

    public List<TeamM> findAll();

}
