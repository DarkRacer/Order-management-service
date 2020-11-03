package ru.neoflex.ec.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.ec.project.entity.OrderEntity;
import ru.neoflex.ec.project.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderEntity orderEntity){
        if(orderEntity.getOrderId() == null){
            em.persist(orderEntity);
        }
        else {
            em.merge(orderEntity);
        }
    }

    public void deleteByOrderId(Long orderId){
       orderRepository.deleteByOrderId(orderId);
    }

    public List<OrderEntity> findByOrderId(Long id) {
        return orderRepository.findByOrderId(id);
    }

    public List<OrderEntity> findListBySum(Long customerId, double sum1, double sum2){
        return orderRepository.findListBySum(customerId, sum1, sum2);
    }

    public List<OrderEntity> findListByName(String productName){
        return orderRepository.findListByName(productName);
    }
}