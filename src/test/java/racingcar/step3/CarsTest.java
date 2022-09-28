package racingcar.step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@DisplayName("입력받은 자동차 대수만큼 자동차 생성")
	@Test
	void createCarsTest() {
		Cars cars = Cars.createCars(3);
		Car firstCar = cars.getCars().get(0);
		Car secondCar = cars.getCars().get(1);
		Car thirdCar = cars.getCars().get(2);

		assertAll(
			() -> assertThat(cars.getCarsCount()).isEqualTo(3),
			() -> assertThat(firstCar.getPosition()).isZero(),
			() -> assertThat(secondCar.getPosition()).isZero(),
			() -> assertThat(thirdCar.getPosition()).isZero()
		);
	}

	@DisplayName("자동차들 전진")
	@Test
	void moveCars() {
		Cars cars = Cars.createCars(3);
		Car firstCar = cars.getCars().get(0);
		Car secondCar = cars.getCars().get(1);
		Car thirdCar = cars.getCars().get(2);

		cars.move(() -> 5);

		assertAll(
			() -> assertThat(firstCar.getPosition()).isEqualTo(1),
			() -> assertThat(secondCar.getPosition()).isEqualTo(1),
			() -> assertThat(thirdCar.getPosition()).isEqualTo(1)
		);
	}

	@DisplayName("각 자동차들 전진 혹은 멈춤")
	@Test
	void moveEachCar() {
		Cars cars = Cars.createCars(3);
		Car firstCar = cars.getCars().get(0);
		Car secondCar = cars.getCars().get(1);
		Car thirdCar = cars.getCars().get(2);

		assertAll(
			() -> assertThat(firstCar.move(() -> 3)).isEqualTo(0),
			() -> assertThat(secondCar.move(() -> 4)).isEqualTo(1),
			() -> assertThat(thirdCar.move(() -> 9)).isEqualTo(1)
		);
	}
}
