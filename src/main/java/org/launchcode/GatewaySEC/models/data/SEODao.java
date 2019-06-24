package org.launchcode.GatewaySEC.models.data;

import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.TeamM;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SEODao extends CrudRepository<SEO, Integer> {

    public List<SEO> findByTeamMs (TeamM teamM);
}
