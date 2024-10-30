package RUT.vokzal.Controller;

import RUT.vokzal.Service.TopVokzalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vokzals")
public class TopVokzalController {

    @Autowired
    private TopVokzalService topVokzalService;

    /**
     * Получение топ-5 вокзалов с наибольшим количеством отправлений за последнюю неделю.
     * @return Список вокзалов и количество их отправлений
     */
    @GetMapping("/top-departures")
    public List<Object[]> getTop5VokzalsByDepartures() {
        return topVokzalService.getTop5VokzalsByDepartures();
    }
}