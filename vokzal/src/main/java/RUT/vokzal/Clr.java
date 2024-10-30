package RUT.vokzal;

import com.github.javafaker.Faker;
import RUT.vokzal.Entity.*;
import RUT.vokzal.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Component
public class Clr implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final TrainRepository trainRepository;
    private final PlatformRepository platformRepository;
    private final RouteRepository routeRepository;
    private final TripRepository tripRepository;
    private final VokzalRepository vokzalRepository;
    
    @SuppressWarnings("deprecation")
    private final Faker faker = new Faker(new Locale("ru"));

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public Clr(EmployeeRepository employeeRepository, TrainRepository trainRepository, 
               PlatformRepository platformRepository, RouteRepository routeRepository,
               TripRepository tripRepository, VokzalRepository vokzalRepository) {
        this.employeeRepository = employeeRepository;
        this.trainRepository = trainRepository;
        this.platformRepository = platformRepository;
        this.routeRepository = routeRepository;
        this.tripRepository = tripRepository;
        this.vokzalRepository = vokzalRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //clearDatabase();
        // generateTrains();
        // generatePlatforms();
        // generateEmployees();
        // generateVokzals();
        // generateRoutes();
        // generateTrips();
    }

    private void clearDatabase() {
        entityManager.createNativeQuery("TRUNCATE TABLE trip RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE route RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE employee RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE train RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE platform RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE vokzal RESTART IDENTITY CASCADE").executeUpdate();
    }
    
    private void generateTrains() {
        for (int i = 0; i < 5; i++) {
            Train train = new Train();
            train.setNumber(faker.number().numberBetween(1000, 9999));
            train.setType(faker.lorem().word());
            train.setModel(faker.lorem().word());
            train.setCapacity(faker.number().numberBetween(50, 300));
            train.setStatusTrain(StatusTrain.AT_STATION);
            trainRepository.create(train);
        }
    }
    
    private void generatePlatforms() {
        for (int i = 0; i < 3; i++) {
            Platform platform = new Platform();
            platform.setNumber(i + 1);
            platform.setType(faker.lorem().word());
            platform.setStatusPlatform(StatusPlatform.FREE);
            platformRepository.create(platform);
        }
    }
    
    private void generateEmployees() {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setPost(faker.job().position());
            employee.setLogin(faker.name().username());
            employee.setPassword(faker.internet().password());
            employee.setExperience(faker.number().numberBetween(1, 20));
            employee.settrainId(trainRepository.findAll().get(i % 5)); // Присваиваем train из существующих
            employeeRepository.create(employee);
        }
    }

    private void generateVokzals() {
        for (int i = 0; i < 2; i++) {
            Vokzal vokzal = new Vokzal();
            vokzal.setName(faker.company().name());
            vokzal.setCity(faker.address().city());
            vokzal.setCapacity(faker.number().numberBetween(200, 500));
            vokzalRepository.create(vokzal);
        }
    }
    
    private void generateRoutes() {
        for (int i = 0; i < 5; i++) {
            Route route = new Route();
            route.setTimeDep(LocalTime.of(faker.number().numberBetween(0, 23), faker.number().numberBetween(0, 59)));
            route.setTimeArr(LocalTime.of(faker.number().numberBetween(0, 23), faker.number().numberBetween(0, 59)));
            route.setDepPlId(platformRepository.findAll().get(i % 3));
            route.setArrPlId(platformRepository.findAll().get((i + 1) % 3));
            routeRepository.create(route);
        }
    }

    private void generateTrips() {
        for (int i = 0; i < 5; i++) {
            Trip trip = new Trip();
            trip.setDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
            trip.setTrain(trainRepository.findAll().get(i % 5));
            trip.setRoute(routeRepository.findAll().get(i % 5));
            trip.setStatusTrip(StatusTrip.SCHEDULED);
            trip.setDelayed(false);
            tripRepository.create(trip);
        }
    }
}
