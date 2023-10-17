
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;


class VehicleTest {
    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор
     * instanceof).
     */
    @Test
    public void checkCarClass() {
        Car car = new Car("BMW", "M5", 2023);

        assertThat(car, instanceOf(Vehicle.class));

    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     */

    @Test
    public void checkCarWHeels() {
        Car car = new Car("BMW", "M5", 2023);

        assertEquals(4, car.getNumWheels());
    }

    /**
     * Проверить, что объект Motorcycle создается с 2-мя колесами.
     */

    @Test
    public void checkMotorcycleWHeels() {
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "KX250X", 2020);

        assertEquals(2, motorcycle.getNumWheels());
    }


    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void checkCarDriveSpeed() {
        Car car = new Car("BMW", "M5", 2023);
        car.testDrive();

        assertEquals(60, car.getSpeed());
    }

    /**
     * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void checkMotorcycleDriveSpeed() {
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "KX250X", 2020);
        motorcycle.testDrive();

        assertEquals(75, motorcycle.getSpeed());
    }
    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
     * останавливается (speed = 0).
     */
    @Test
    public void checkCarPark() {
        Car car = new Car("BMW", "M5", 2023);
        car.testDrive();
        car.park();

        assertEquals(0, car.getSpeed());
    }
    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).
     */
    @Test
    public void checkMotorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "KX250X", 2020);
        motorcycle.testDrive();
        motorcycle.park();

        assertEquals(0, motorcycle.getSpeed());
    }

}