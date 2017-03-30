package org.synyx.campdemo.read.agileproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author  David Schilling - schilling@synyx.de
 */
public interface SprintRepository extends JpaRepository<Sprint, String> {
}
