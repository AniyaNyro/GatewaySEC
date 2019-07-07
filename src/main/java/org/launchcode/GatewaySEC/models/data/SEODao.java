package org.launchcode.GatewaySEC.models.data;

import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.Student;
import org.launchcode.GatewaySEC.models.TeamM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public interface SEODao extends CrudRepository<SEO, Integer> {

    public ArrayList<SEO> seos = new ArrayList<>();

    public List<TeamM> findByTeamMs(TeamM teamM);

    public List<SEO> findByApproved(Boolean approved);

    public SEO findById(int seoId);



}