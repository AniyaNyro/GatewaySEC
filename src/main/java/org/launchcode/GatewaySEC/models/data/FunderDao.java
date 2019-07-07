package org.launchcode.GatewaySEC.models.data;

import org.launchcode.GatewaySEC.models.Funder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface FunderDao extends CrudRepository<Funder, Integer> {
}
