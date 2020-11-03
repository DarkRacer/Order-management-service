package ru.neoflex.ec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ru.neoflex.ec.project.entity.OrderEntity;
import java.util.List;

@Component
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity save(OrderEntity order);

    List<OrderEntity> findByOrderId(Long id);

    void deleteByOrderId(Long id);

    @Modifying
    @Query(value = "select o.* from public.order o where o.customerId = :customerId and o.count between :sum1 and :sum2", nativeQuery = true)
    List<OrderEntity> findListBySum(@Param("customerId") Long customerId, @Param("sum1") double sum1, @Param("sum2") double sum2);

    @Modifying
    @Query(value = "select o.* from public.order o where o.productName like ':productName%'", nativeQuery = true)
    List<OrderEntity> findListByName(@Param("productName") String productName);
}
