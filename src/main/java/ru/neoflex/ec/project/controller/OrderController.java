package ru.neoflex.ec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.ec.project.entity.OrderEntity;
import ru.neoflex.ec.project.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody OrderEntity orderEntity){
        orderService.save(orderEntity);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        orderService.deleteByOrderId(id);
    }

    @GetMapping("/{id}}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> findById(@PathVariable Long id){
        return orderService.findByOrderId(id);
    }

    @GetMapping("/{productName}}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> findListByName(@PathVariable String productName){
        return orderService.findListByName(productName);
    }

    @GetMapping("/order?customerId={customerId}&sum1={sum1}&sum2={sum2}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> findListBySum(@PathVariable Long customerId, @PathVariable double sum1, @PathVariable double sum2){
        return orderService.findListBySum(customerId, sum1, sum2);
    }
}
