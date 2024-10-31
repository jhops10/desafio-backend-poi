package com.jhops10.poi.repository;

import com.jhops10.poi.entity.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    @Query("""
            SELECT p from PointOfInterest p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<PointOfInterest> findNearMe(@Param("xMin") long xMin,
                                     @Param("xMax")long xMax,
                                     @Param("yMin")long yMin,
                                     @Param("yMax")long yMax);
}
