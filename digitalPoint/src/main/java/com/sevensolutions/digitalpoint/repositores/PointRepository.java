package com.sevensolutions.digitalpoint.repositores;

import com.sevensolutions.digitalpoint.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Integer> {

    Optional<Point> findByWorkDay(Date workDay);
}
