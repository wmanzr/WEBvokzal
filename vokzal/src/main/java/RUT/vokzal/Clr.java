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
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
    private final Random random = new Random();

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
        clearDatabase();

        int count = 40;

        generateTrains(count);
        generateVokzals();
        generatePlatforms();
        generateEmployees(count);
        generateRoutes(count);
        generateTrips(count);
    }

    private void clearDatabase() {
        entityManager.createNativeQuery("TRUNCATE TABLE trip RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE route RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE employee RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE train RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE platform RESTART IDENTITY CASCADE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE vokzal RESTART IDENTITY CASCADE").executeUpdate();
    }
    
    private void generateTrains(int count) {
        for (int i = 0; i < count; i++) {
            Train train = new Train();
            train.setNumber(faker.number().numberBetween(1000, 9999));
            train.setType(faker.lorem().word());
            train.setModel(faker.commerce().productName());
            train.setCapacity(faker.number().numberBetween(50, 300));
            train.setMaxSpeed(faker.number().numberBetween(80, 180));
            train.setStatusTrain(randomStatusTrain());
            trainRepository.create(train);
        }
    }

    private StatusTrain randomStatusTrain() {
        return StatusTrain.values()[random.nextInt(StatusTrain.values().length)];
    }

    private void generateVokzals() {
        for (int i = 0; i < 15; ) {
            Vokzal vokzal = new Vokzal();
            String name = faker.company().name();
    
            Long existingCount = entityManager.createQuery(
                    "SELECT COUNT(v) FROM Vokzal v WHERE v.name = :name", Long.class)
                    .setParameter("name", name)
                    .getSingleResult();
    
            if (existingCount == 0) {
                vokzal.setName(name);
                vokzal.setCity(faker.address().city());
                vokzal.setCapacity(faker.number().numberBetween(200, 500));
                vokzalRepository.create(vokzal);
                i++;
            }
        }
    }

    private void generatePlatforms() {
            List<Vokzal> vokzals = vokzalRepository.findAll();
            for (Vokzal vokzal : vokzals) {

                for (int platformNumber = 1; platformNumber <= 15; platformNumber++) {
                Platform platform = new Platform();
                platform.setNumber(platformNumber);
                platform.setType(faker.lorem().word());
                platform.setVokzalId(vokzal);
                platform.setStatusPlatform(randomStatusPlatform());
                platformRepository.create(platform);
            }
        }
    }

    private StatusPlatform randomStatusPlatform() {
        return StatusPlatform.values()[random.nextInt(StatusPlatform.values().length)];
    }
    
    private void generateEmployees(int count) {
        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            employee.setPost(faker.job().position());
            employee.setLogin(faker.name().username());
            employee.setPassword(faker.internet().password());
            employee.setExperience(faker.number().numberBetween(1, 20));
            employee.setTrainId(trainRepository.findAll().get(random.nextInt(count)));
            employeeRepository.create(employee);
        }
    }
    
    private void generateRoutes(int count) {
        for (int i = 0; i < count*4; i++) {
            Route route = new Route();
            route.setTimeDep(LocalTime.of(faker.number().numberBetween(0, 23), faker.number().numberBetween(0, 59)));
            route.setTimeArr(LocalTime.of(faker.number().numberBetween(0, 23), faker.number().numberBetween(0, 59)));
            route.setDepPlId(platformRepository.findAll().get(random.nextInt(15*15)));
            route.setArrPlId(platformRepository.findAll().get(random.nextInt(15*15)));
            routeRepository.create(route);
        }
    }

    private void generateTrips(int count) {
        for (int i = 0; i < 15*15; i++) {
            Trip trip = new Trip();
            trip.setDateDep(LocalDate.now().plusDays(faker.number().numberBetween(-7, 5)));
            trip.setDateArr(LocalDate.now().plusDays(faker.number().numberBetween(6, 23)));
            trip.setTrain(trainRepository.findAll().get(random.nextInt(count)));
            trip.setRoute(routeRepository.findAll().get(random.nextInt(count)));
            trip.setStatusTrip(randomStatusTrip());
            trip.setDelayed(random.nextBoolean());
            trip.setDelayTime(trip.isDelayed() ? LocalTime.of(faker.number().numberBetween(0, 0), faker.number().numberBetween(0, 59)) : null);
            tripRepository.create(trip);
        }
    }

    private StatusTrip randomStatusTrip() {
        return StatusTrip.values()[random.nextInt(StatusTrip.values().length)];
    }
}
