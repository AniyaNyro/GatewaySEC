package org.launchcode.GatewaySEC.models.data;

import org.launchcode.GatewaySEC.models.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PartnerDao extends CrudRepository<Partner, Integer> {

    public List<Partner> findByApproved (Boolean approved);

    public Partner findById(int partnerId);
}
