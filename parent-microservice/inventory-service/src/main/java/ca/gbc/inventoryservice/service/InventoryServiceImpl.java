package ca.gbc.inventoryservice.service;


import ca.gbc.inventoryservice.model.Inventory;
import ca.gbc.inventoryservice.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

        private final InventoryRepo inventoryRepo;

    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        //Return the result of the check for stock availability
        return inventoryRepo.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode,quantity);
    }




}
