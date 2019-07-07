package org.launchcode.GatewaySEC.models.data;


import org.launchcode.GatewaySEC.models.GradeLevel;
import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

    public List<Student> findBySeo(SEO seo);

    public List<Student> findAll();

    public List<Student> findByGrade(GradeLevel grade);
}
