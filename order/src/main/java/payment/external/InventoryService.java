package payment.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product", url = "${api.url.product}")
public interface InventoryService {
    @RequestMapping(method = RequestMethod.POST, path = "/inventories")
    public void decreaseStock(@RequestBody Inventory inventory);
}
