package org.launchcode.GatewaySEC.models.data;


import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Integer> {

    public List<Student> findBySeo(SEO seo);
}
