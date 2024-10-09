package com.sevensolutions.digitalpoint.repositores;

import com.sevensolutions.digitalpoint.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Integer> {

}
