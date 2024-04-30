package ua.com.kneu.course_admin_shop_np_2024.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.course_admin_shop_np_2024.entity.Order;
import ua.com.kneu.course_admin_shop_np_2024.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveNewOrderForClient(Order order){
        return orderRepository.save(order);
    }



}
