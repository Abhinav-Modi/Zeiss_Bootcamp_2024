@Configuration
public class AppConfig {
   @Bean
   public IStartupMotor startupMotor() {
       return new StartupMotor();
   }

   @Bean
   public IFuelPump fuelPump() {
       return new FuelPump();
   }

   @Bean
   public IEngine engine(IStartupMotor startupMotor, IFuelPump fuelPump) {
       return new Engine(startupMotor, fuelPump);
   }

   @Bean
   public ITransmission transmission() {
       return new Transmission();
   }

   @Bean
   public Car car(IEngine engine, ITransmission transmission) {
       return new Car(engine, transmission);
   }
}

public class Main {
   public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       Car car = context.getBean(Car.class);
       car.start();
   }
}

class Engine implements IEngine {
   private IStartupMotor startupMotor;
   private IFuelPump fuelPump;

   public Engine(IStartupMotor startupMotor, IFuelPump fuelPump) {
       this.startupMotor = startupMotor;
       this.fuelPump = fuelPump;
   }

   @Override
   public void start() {
       startupMotor.startMotor();
       fuelPump.pumpFuel();
   }
}

class Transmission implements ITransmission {
   @Override
   public void changeGear() {
       // implementation
   }
}

class StartupMotor implements IStartupMotor {
   @Override
   public void startMotor() {
    // implementation
   }
}

class FuelPump implements IFuelPump {
   @Override
   public void pumpFuel() {
       // implementation
   }
}


class Car {
   private IEngine engine;
   private ITransmission transmission;

   public Car(IEngine engine, ITransmission transmission) {
       this.engine = engine;
       this.transmission = transmission;
   }

   public void start() {
       engine.start();
   }

   public void changeGear() {
       transmission.changeGear();
   }
}

interface IEngine {
   void start();
}

interface ITransmission {
   void changeGear(int gear);
}

interface IStartupMotor {
   void startMotor();
}

interface IFuelPump {
   void pumpFuel();
}
