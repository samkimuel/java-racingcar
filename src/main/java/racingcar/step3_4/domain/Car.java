package racingcar.step3_4.domain;

import java.util.Objects;
import racingcar.step3_4.strategy.ValueGenerator;

public class Car {

	private static final int INITIAL_POSITION = 0;
	private static final int MIN_MOVE_VALUE = 4;

	private final Name name;
	private int position;

	public Car(Name name) {
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	public int move(ValueGenerator valueGenerator) {
		if (valueGenerator.generate() >= MIN_MOVE_VALUE) {
			this.position++;
		}

		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return position == car.position && name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position;
	}
}
